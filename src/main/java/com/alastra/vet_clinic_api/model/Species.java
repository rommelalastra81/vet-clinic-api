package com.alastra.vet_clinic_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "species")
public class Species {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    private String name;

    //one to many relationships
    //pets
    //breeds
    //vaccine
     @OneToMany(mappedBy = "species", cascade = CascadeType.ALL, orphanRemoval = true)
     @JsonIgnore
     private List<Pets> pets = new ArrayList<>();

    @OneToMany(mappedBy = "species", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Breeds> breeds = new ArrayList<>();

    //uncomment after these models created
    //@OneToMany(mappedBy = "species", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JsonIgnore
    //private List<Vaccinations> vaccinations = new ArrayList<>();

    //constructors
    public Species() {

    }

    public Species(String name) {
        this.name = name;
    }

    //getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //relationship getter and setter
    //pets
    //breeds
    //vaccine

     public List<Pets> getPets() {
     return pets;
     }

     public void setPets(List<Pets> pets) {
     this.pets = pets;
     }


     public List<Breeds> getBreeds() {
     return breeds;
     }

     public void setBreeds(List<Breeds> breeds) {
     this.breeds = breeds;
     }

    // uncomment after created these models
    // public List<Vaccinations> getVaccinations() {
    // return vaccinations;
    // }
    //
    // public void setVaccinations(List<Vaccinations> vaccinations) {
    // this.vaccinations = vaccinations;
    // }
}
