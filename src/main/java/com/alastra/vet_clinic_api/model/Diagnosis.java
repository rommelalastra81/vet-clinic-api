package com.alastra.vet_clinic_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "description", nullable = false)
    @JsonProperty("description")
    private String description;

    @Column(name = "severity", nullable = false)
    @JsonProperty("severity")
    private String severity;

    //many-to-one relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitid", nullable = false)
    @JsonIgnore
    private Visits visits;

    public Diagnosis() {}

    public Diagnosis(String description, String severity) {
        this.description = description;
        this.severity = severity;
    }

    //getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    // Helper methods for JSON output
    @JsonProperty("visitid")
    public Long getVisitId() {
        return visits != null ? visits.getId() : null;
    }
}
