package com.alastra.vet_clinic_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medicalhistories")
public class MedicalHistories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "condition", nullable = false)
    @JsonProperty("condition")
    private String condition;

    @Column(name = "notes", nullable = false)
    @JsonProperty("notes")
    private String notes;

    @Column(name = "startdate", nullable = false, unique = true)
    @JsonProperty("startdate")
    private LocalDate startDate;

    @Column(name = "enddate", nullable = false, unique = true)
    @JsonProperty("enddate")
    private LocalDate endDate;

    //many to one
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petid", nullable = false)
    @JsonIgnore
    private Pets pets;

    public MedicalHistories() {}

    public MedicalHistories(String condition, String notes, LocalDate startDate, LocalDate endDate) {
        this.condition = condition;
        this.notes = notes;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // Helper methods for JSON output
    @JsonProperty("petid")
    public Long getPetId() {
        return pets != null ? pets.getId() : null;
    }

}
