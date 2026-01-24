package com.alastra.vet_clinic_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prescriptions")
public class Prescriptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "issuedate", nullable = false)
    @JsonProperty("issuedate")
    private LocalDate issueDate;

    @Column(name = "notes", nullable = false)
    @JsonProperty("notes")
    private String notes;

    //many-to-one relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitid", nullable = false)
    @JsonIgnore
    private Visits visits;

    //one-to-many relationship
    @OneToMany(mappedBy = "prescriptionitems", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<PrescriptionItems> prescriptionItems = new ArrayList<>();

    //constructors
    public Prescriptions() {}

    public Prescriptions(LocalDate issueDate, String notes) {
        this.issueDate = issueDate;
        this.notes = notes;
    }

    //getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // Relationship getters and setters
    public List<PrescriptionItems> getPrescriptionItems() {
        return prescriptionItems;
    }

    public void setPrescriptionItems(List<PrescriptionItems> prescriptionItems) {
        this.prescriptionItems  =  prescriptionItems;
    }

    // Helper methods for JSON output
    @JsonProperty("visitid")
    public Long getVisitId() {
        return visits != null ? visits.getId() : null;
    }

}
