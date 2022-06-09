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
@Table(name = "puppies")
public class LabAdoption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "breed")
    private String breed;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private String age;

    @Column(name = "location_city")
    private String city;

    @Column(name = "location_state")
    private String state;

    @Column(name = "image_url")
    private String imageUrl;
}