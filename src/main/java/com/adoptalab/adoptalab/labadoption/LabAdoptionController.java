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
    private LabAdoptionService labAdoptionService;

    // @GetMapping("/search")
    // @ResponseStatus(HttpStatus.OK)
    // public Map<String, Iterable<LabAdoption>> search(@RequestParam String search)
    // {

    // System.out.println(search);
    // return createHashPlural(labAdoptionService.search(search));
    // }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Iterable<LabAdoption>> search(@RequestParam String search) {

        System.out.println(search);
        return labAdoptionService.search(search);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Iterable<LabAdoption>> list() {
        Iterable<LabAdoption> labAdoptions = labAdoptionService.list();
        return createHashPlural(labAdoptions);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, LabAdoption> read(@PathVariable Long id) {
        LabAdoption labadoption = labAdoptionService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No labrador with that ID"));
        return createHashSingular(labadoption);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, LabAdoption> create(@Validated @RequestBody LabAdoption labAdoption) {
        LabAdoption createdResource = labAdoptionService.create(labAdoption);
        return createHashSingular(createdResource);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, LabAdoption> update(@RequestBody LabAdoption labAdoption,
            @PathVariable Long id) {
        LabAdoption updatedResource = labAdoptionService
                .update(labAdoption)
                .orElseThrow(() -> new ResourceNotFoundException("No labrador with that ID"));
        return createHashSingular(updatedResource);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        labAdoptionService.deleteById(id);
    }

    private Map<String, LabAdoption> createHashSingular(LabAdoption labAdoption) {
        Map<String, LabAdoption> response = new HashMap<String, LabAdoption>();
        response.put("labadoption", labAdoption);
        return response;
    }

    private Map<String, Iterable<LabAdoption>> createHashPlural(Iterable<LabAdoption> labAdoptions) {
        Map<String, Iterable<LabAdoption>> response = new HashMap<String, Iterable<LabAdoption>>();
        response.put("labadoptions", labAdoptions);
        return response;
    }
}