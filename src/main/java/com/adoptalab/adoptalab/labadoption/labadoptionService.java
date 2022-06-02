package com.adoptalab.adoptalab.labadoption;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class labadoptionService {
    @Autowired
    private labadoptionRepository labadoptionRepository;

    public Iterable<labadoption> list() {
        return labadoptionRepository.findAll();
    }

    public Optional<labadoption> findById(Long id) {
        return labadoptionRepository.findById(id);
    }

    public labadoption create(labadoption labadoption) {
        return labadoptionRepository.save(labadoption);
    }

    public Optional<labadoption> update(labadoption labadoption) {
        Optional<labadoption> foundResource = labadoptionRepository.findById(labadoption.getId());
        if (foundResource.isPresent()) {
            labadoption updatedLabAdoption = foundResource.get();
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