package com.alastra.vet_clinic_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "species")
public class Breeds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    private String name;

    //one to many
    //pets
    @OneToMany(mappedBy = "breeds", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Pets> pets = new ArrayList<>();

    //many to one
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speciesid", nullable = false)
    @JsonIgnore
    private Species species;

    //constructors
    public Breeds () {

    }

    public Breeds(String name) {
        this.name = name;
    }

    //getters and setters
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

    //relationship getters and setters
    public List<Pets> getPets() {
        return pets;
    }

    public void setPets(List<Pets> pets) {
        this.pets = pets;
    }

    // Helper methods for JSON output
    @JsonProperty("specieid")
    public Long getSpeciesId() {
        return species != null ? species.getId() : null;
    }

}
