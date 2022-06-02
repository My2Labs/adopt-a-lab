package com.adoptalab.adoptalab.labadoption;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import lombok.Data;

@Entity
@Data
@Table(name = "some_table")
public class labadoption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Name")
    private String name;
}