package com.adoptalab.adoptalab.labadoption;

import java.util.Map;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("api/adoption")
public class labadoptionController {
    @Autowired
    private labadoptionService labadoptionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Iterable<labadoption>> list() {
        Iterable<labadoption> labadoptions = labadoptionService.list();
        return createHashPlural(labadoptions);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, labadoption> read(@PathVariable Long id) {
        labadoption labadoption = labadoptionService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with that ID"));
        return createHashSingular(labadoption);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, labadoption> create(@Validated @RequestBody labadoption labadoption) {
        labadoption createdResource = labadoptionService.create(labadoption);
        return createHashSingular(createdResource);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, labadoption> update(@RequestBody labadoption labadoption, @PathVariable Long id) {
        labadoption updatedResource = labadoptionService
                .update(labadoption)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with that ID"));
        return createHashSingular(updatedResource);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        labadoptionService.deleteById(id);
    }

    private Map<String, labadoption> createHashSingular(labadoption labadoption) {
        Map<String, labadoption> response = new HashMap<String, labadoption>();
        response.put("labadoption", labadoption);
        return response;
    }

    private Map<String, Iterable<labadoption>> createHashPlural(Iterable<labadoption> labadoptions) {
        Map<String, Iterable<labadoption>> response = new HashMap<String, Iterable<labadoption>>();
        response.put("labadoptions", labadoptions);
        return response;
    }
}