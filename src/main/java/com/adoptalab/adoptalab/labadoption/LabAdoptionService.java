package com.adoptalab.adoptalab.labadoption;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
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

  // public Map<String, Iterable<LabAdoption>> search(String searchTerm) {
  // Iterable<LabAdoption> adoptions = labAdoptionRepository.findAll();
  // List<LabAdoption> labAdoptions = new ArrayList<LabAdoption>();
  // adoptions.forEach(labAdoptions::add);

  // List<LabAdoption> filteredAdoptions =
  // labAdoptions.stream().filter(labadoption -> {
  // String labname = labadoption.getName().toLowerCase();
  // String search = searchTerm.toLowerCase();
  // System.out.println(labadoption.getName());
  // return labname.matches("(.*)" + search + "(.*)");
  // }).collect(Collectors.toList());

  // return createHashPlural(filteredAdoptions);
  // }

  public Map<String, Iterable<LabAdoption>> search(String searchTerm) {
    Iterable<LabAdoption> adoptions = labAdoptionRepository.findAll();
    List<LabAdoption> labAdoptions = new ArrayList<LabAdoption>();
    adoptions.forEach(labAdoptions::add);

    List<LabAdoption> filteredAdoptions = labAdoptions.stream().filter(labadoption -> {
      String labname = labadoption.getName().toLowerCase();
      String statename = labadoption.getState().toLowerCase();
      String cityname = labadoption.getCity().toLowerCase();
      return statename.matches(searchTerm.toLowerCase()) || labname.matches(searchTerm.toLowerCase())
          || cityname.matches(searchTerm.toLowerCase());

    }).collect(Collectors.toList());

    return createHashPlural(filteredAdoptions);
  }

  private Map<String, Iterable<LabAdoption>> createHashPlural(List<LabAdoption> filteredAdoptions) {
    Map<String, Iterable<LabAdoption>> response = new HashMap<String, Iterable<LabAdoption>>();
    response.put("labadoptions", filteredAdoptions);
    return response;
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