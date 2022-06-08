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
    private LabAdoptionRepository labadoptionRepository;

    public Iterable<LabAdoption> list() {
        return labadoptionRepository.findAll();

    }

    public Map<String, Iterable<LabAdoption>> search(String searchTerm) {
        Iterable<LabAdoption> adoptions = labadoptionRepository.findAll();
        List<LabAdoption> labadoptions = new ArrayList<LabAdoption>();
        adoptions.forEach(labadoptions::add);

        List<LabAdoption> filteredAdoptions = labadoptions.stream().filter(labadoption -> {
            return labadoption.getName().equals(searchTerm);
        }).collect(Collectors.toList());

        return createHashPlural(filteredAdoptions);
    }

    private Map<String, Iterable<LabAdoption>> createHashPlural(List<LabAdoption> filteredAdoptions) {
        return null;
    }

    public Optional<LabAdoption> findById(Long id) {
        return labadoptionRepository.findById(id);
    }

    public LabAdoption create(LabAdoption labadoption) {
        return labadoptionRepository.save(labadoption);
    }

    public Optional<LabAdoption> update(LabAdoption labadoption) {
        Optional<LabAdoption> foundResource = labadoptionRepository.findById(labadoption.getId());
        if (foundResource.isPresent()) {
            LabAdoption updatedLabAdoption = foundResource.get();
            updatedLabAdoption.setName(labadoption.getName());
            labadoptionRepository.save(updatedLabAdoption);
            return Optional.of(updatedLabAdoption);
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        labadoptionRepository.deleteById(id);
    }
}