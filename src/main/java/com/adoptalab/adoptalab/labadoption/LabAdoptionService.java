package com.adoptalab.adoptalab.labadoption;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabAdoptionService {
    @Autowired
    private LabAdoptionRepository labadoptionRepository;

    public Iterable<LabAdoption> list() {
        return labadoptionRepository.findAll();
    }

    public Iterable<LabAdoption> search() {
        return labadoptionRepository.findAll();
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