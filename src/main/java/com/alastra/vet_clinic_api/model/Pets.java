package com.alastra.vet_clinic_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pets")
public class Pets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    private String name;

    @Column(name = "gender")
    @JsonProperty("gender")
    private String gender;

    @Column(name = "birthdate")
    @JsonProperty("birthdate")
    private LocalDate birthDate;

    @Column(name = "color")
    @JsonProperty("color")
    private String color;

    //many to one relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerid", nullable = false)
    @JsonIgnore
    private Owners owners;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speciesid", nullable = false)
    @JsonIgnore
    private Species species;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "breedid", nullable = false)
    @JsonIgnore
    private Breeds breeds;

    //constructors
    public Pets() {
    }

    public Pets(String name, String gender, LocalDate birthDate, String color) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.color = color;
    }

    //getters and setters
    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Helper methods for JSON output
    @JsonProperty("ownerid")
    public Long getOwnerId() {
        return owners != null ? owners.getId() : null;
    }

    @JsonProperty("speciesid")
    public Long getSpeciesId() {
        return species != null ? species.getId() : null;
    }

    @JsonProperty("breedid")
    public Long getBreedId() {
        return breeds != null ? breeds.getId() : null;
    }

}
