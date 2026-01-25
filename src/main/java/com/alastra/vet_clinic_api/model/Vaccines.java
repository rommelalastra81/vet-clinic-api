package com.alastra.vet_clinic_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vaccines")
public class Vaccines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    private String name;

    @Column(name = "requiredintervalmonths", nullable = false)
    @JsonProperty("requiredintervalmonths")
    private Integer requiredIntervalMonths;

    //many-to-one relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speciesid")
    @JsonIgnore
    private Species species;

    //one-to-many relationship
    @OneToMany(mappedBy = "vaccines", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Vaccinations> vaccinations = new ArrayList<>();

    //constructors
    public Vaccines() {}

    public Vaccines(String name, Integer requiredIntervalMonths) {
        this.name = name;
        this.requiredIntervalMonths = requiredIntervalMonths;
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

    public Integer getRequiredIntervalMonths() {
        return requiredIntervalMonths;
    }

    public void setRequiredIntervalMonths(Integer requiredIntervalMonths) {
        this.requiredIntervalMonths = requiredIntervalMonths;
    }

    //one-to-many relationship getter and setter
    public List<Vaccinations> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(List<Vaccinations> vaccinations) {
        this.vaccinations = vaccinations;
    }

    // Helper methods for JSON output
    @JsonProperty("speciesid")
    public Long getSpeciesId() {
        return species != null ? species.getId() : null;
    }

}
