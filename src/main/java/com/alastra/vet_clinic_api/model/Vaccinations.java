package com.alastra.vet_clinic_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vaccinations")
public class Vaccinations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "vaccinationdate", nullable = false)
    @JsonProperty("vaccinationdate")
    private LocalDate vaccinationDate;

    @Column(name = "nextduedate", nullable = false)
    @JsonProperty("nextduedate")
    private LocalDate nextDueDate;

    // many to one
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnore
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petid", nullable = false)
    @JsonIgnore
    private Pets pets;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vaccineid", nullable = false)
    @JsonIgnore
    private Vaccines vaccines;

    //constructors
    public Vaccinations() {}

    public Vaccinations(LocalDate vaccinationDate, LocalDate nextDueDate) {
        this.vaccinationDate = vaccinationDate;
        this.nextDueDate = nextDueDate;
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public LocalDate getNextDueDate() {
        return nextDueDate;
    }

    public void setNextDueDate(LocalDate nextDueDate) {
        this.nextDueDate = nextDueDate;
    }

    // Helper methods for JSON output
    @JsonProperty("userid")
    public Long getUserId() {
        return users != null ? users.getId() : null;
    }

    @JsonProperty("petid")
    public Long getPetId() {
        return pets != null ? pets.getId() : null;
    }

    @JsonProperty("vaccineid")
    public Long getVaccineId() {
        return vaccines != null ? vaccines.getId() : null;
    }
}
