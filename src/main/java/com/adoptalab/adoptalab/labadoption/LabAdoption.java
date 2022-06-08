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

    @Column(name = "Name")
    private String name;

    @Column(name = "Breed")
    private String breed;

    @Column(name = "Sex")
    private String sex;

    @Column(name = "Age")
    private String age;

    @Column(name = "locationcity")
    private String city;

    @Column(name = "locationstate")
    private String state;

    @Column(name = "imageurl")
    private String imageUrl;
}