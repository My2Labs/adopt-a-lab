package com.adoptalab.adoptalab.labadoption;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface labadoptionRepository extends CrudRepository<labadoption, Long> {
}