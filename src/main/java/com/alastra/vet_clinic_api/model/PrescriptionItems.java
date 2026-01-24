package com.alastra.vet_clinic_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prescriptionitems")
public class PrescriptionItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "dosage", nullable = false)
    @JsonProperty("dosage")
    private String dosage;

    //many-to-one relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prescriptionid", nullable = false)
    @JsonIgnore
    private Prescriptions prescriptions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicationid", nullable = false)
    @JsonIgnore
    private Medications medications;

    //constructors
    public PrescriptionItems() {}

    public PrescriptionItems(String dosage) {
        this.dosage = dosage;
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
    
    // Helper methods for JSON output
    @JsonProperty("prescriptionid")
    public Long getPrescriptionId() {
        return prescriptions != null ? prescriptions.getId() : null;
    }

    @JsonProperty("medicationid")
    public Long getMedicationId() {
        return medications != null ? medications.getId() : null;
    }
}
