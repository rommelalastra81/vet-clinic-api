package com.alastra.vet_clinic_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "visits")
public class Visits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "visitdate", nullable = false)
    @JsonProperty("visitdate")
    private LocalDate visitDate;

    @Column(name = "weight", nullable = false)
    @JsonProperty("weight")
    private String weight;

    @Column(name = "temperature", nullable = false)
    @JsonProperty("temperature")
    private String temperature;

    @Column(name = "notes", nullable = false)
    @JsonProperty("notes")
    private String notes;

    //many to one
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attendingveterinarianid", nullable = false)
    @JsonIgnore
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petid", nullable = false)
    @JsonIgnore
    private Pets pets;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointmentid", nullable = true)
    @JsonIgnore
    private Appointments appointments;


    //one to many
    //diagnosis
    //treatments
    //prescription
    //invoices
    @OneToMany(mappedBy = "visits", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Diagnosis> diagnosis = new ArrayList<>();

    @OneToMany(mappedBy = "visits", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Treatments> treatments = new ArrayList<>();

    @OneToMany(mappedBy = "visits", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Prescriptions> prescriptions = new ArrayList<>();

    @OneToMany(mappedBy = "visits", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Invoices> invoices = new ArrayList<>();

    // Constructors
    public Visits() {
    }

    public Visits(LocalDate visitDate, String weight, String temperature, String notes) {
        this.visitDate = visitDate;
        this.weight = weight;
        this.temperature = temperature;
        this.notes = notes;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // Relationship getters and setters
    public List<Diagnosis> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(List<Diagnosis> diagnosis) {
        this.diagnosis = diagnosis;
    }

    public List<Treatments> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatments> treatments) {
        this.treatments = treatments;
    }

    public List<Prescriptions> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescriptions> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public List<Invoices> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoices> invoices) {
        this.invoices = invoices;
    }

    // Helper methods for JSON output
    @JsonProperty("userid")
    public Long getUserId() {
        return users != null ? users.getId() : null;
    }

    @JsonProperty("speciesid")
    public Long getPetId() {
        return pets != null ? pets.getId() : null;
    }

    @JsonProperty("appointmentid")
    public Long getAppointmentId() {
        return appointments != null ? appointments.getId() : null;
    }
}
