package com.adoptalab.adoptalab.labadoption;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabAdoptionService {
  @Autowired
  private LabAdoptionRepository labAdoptionRepository;

  public Iterable<LabAdoption> list() {
    return labAdoptionRepository.findAll();

  }

  public Map<String, Iterable<LabAdoption>> search(String searchTerm) {
    Iterable<LabAdoption> adoptions = labAdoptionRepository.findAll();
    List<LabAdoption> labAdoptions = new ArrayList<LabAdoption>();
    adoptions.forEach(labAdoptions::add);

    List<LabAdoption> filteredAdoptions = labAdoptions.stream().filter(labadoption -> {
      System.out.println(labadoption.getName());
      return labadoption.getName().equals(searchTerm);
    }).collect(Collectors.toList());

    return createHashPlural(filteredAdoptions);
  }

  private Map<String, Iterable<LabAdoption>> createHashPlural(List<LabAdoption> filteredAdoptions) {
    return null;
  }

  public Optional<LabAdoption> findById(Long id) {
    return labAdoptionRepository.findById(id);
  }

  public LabAdoption create(LabAdoption labadoption) {
    return labAdoptionRepository.save(labadoption);
  }

  public Optional<LabAdoption> update(LabAdoption labadoption) {
    Optional<LabAdoption> foundResource = labAdoptionRepository.findById(labadoption.getId());
    if (foundResource.isPresent()) {
      LabAdoption updatedLabAdoption = foundResource.get();
      updatedLabAdoption.setName(labadoption.getName());
      labAdoptionRepository.save(updatedLabAdoption);
      return Optional.of(updatedLabAdoption);
    } else {
      return Optional.empty();
    }
  }

  public void deleteById(Long id) {
    labAdoptionRepository.deleteById(id);
  }
}