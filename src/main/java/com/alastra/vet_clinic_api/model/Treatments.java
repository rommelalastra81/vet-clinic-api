package com.alastra.vet_clinic_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "treatments")
public class Treatments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "treatmentname", nullable = false)
    @JsonProperty("treatmentname")
    private String treatmentName;

    @Column(name = "cost", nullable = false)
    @JsonProperty("cost")
    private String cost;

    @Column(name = "notes", nullable = false)
    @JsonProperty("notes")
    private String notes;

    //many-to-one relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitid", nullable = false)
    @JsonIgnore
    private Visits visits;

    //constructors
    public Treatments() {}

    public Treatments(String treatmentName, String cost, String notes) {
        this.treatmentName = treatmentName;
        this.cost = cost;
        this.notes = notes;
    }

    //getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // Helper methods for JSON output
    @JsonProperty("visitid")
    public Long getVisitId() {
        return visits != null ? visits.getId() : null;
    }
}
