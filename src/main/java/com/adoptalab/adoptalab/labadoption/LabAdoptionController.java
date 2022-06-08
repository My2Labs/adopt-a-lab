package com.adoptalab.adoptalab.labadoption;

import java.util.Map;
import java.util.HashMap;
import com.adoptalab.adoptalab.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("labadoptions")
public class LabAdoptionController {
    @Autowired
    private LabAdoptionService labadoptionService;

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Iterable<LabAdoption>> search(@RequestParam String search) {
        return createHashPlural(labadoptionService.search());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Iterable<LabAdoption>> list() {
        Iterable<LabAdoption> labadoptions = labadoptionService.list();
        return createHashPlural(labadoptions);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, LabAdoption> read(@PathVariable Long id) {
        LabAdoption labadoption = labadoptionService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No labrador with that ID"));
        return createHashSingular(labadoption);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, LabAdoption> create(@Validated @RequestBody LabAdoption labadoption) {
        LabAdoption createdResource = labadoptionService.create(labadoption);
        return createHashSingular(createdResource);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, LabAdoption> update(@RequestBody LabAdoption labadoption, @PathVariable Long id) {
        LabAdoption updatedResource = labadoptionService
                .update(labadoption)
                .orElseThrow(() -> new ResourceNotFoundException("No labrador with that ID"));
        return createHashSingular(updatedResource);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        labadoptionService.deleteById(id);
    }

    private Map<String, LabAdoption> createHashSingular(LabAdoption labadoption) {
        Map<String, LabAdoption> response = new HashMap<String, LabAdoption>();
        response.put("labadoption", labadoption);
        return response;
    }

    private Map<String, Iterable<LabAdoption>> createHashPlural(Iterable<LabAdoption> labadoptions) {
        Map<String, Iterable<LabAdoption>> response = new HashMap<String, Iterable<LabAdoption>>();
        response.put("labadoptions", labadoptions);
        return response;
    }
}