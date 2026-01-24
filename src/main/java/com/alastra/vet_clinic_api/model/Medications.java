package com.alastra.vet_clinic_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medications")
public class Medications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    private String name;

    @Column(name = "dosageform", nullable = false)
    @JsonProperty("dosageform")
    private String dosageForm;

    @Column(name = "strength", nullable = false)
    @JsonProperty("strength")
    private String strength;

    @Column(name = "manufacturer", nullable = false)
    @JsonProperty("manufacturer")
    private String manufacturer;

    //one-to-many relationships
    @OneToMany(mappedBy = "medications", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<PrescriptionItems> prescriptionItems = new ArrayList<>();

    // constructors
    public Medications() {
    }

    public Medications(String name, String dosageForm, String strength, String manufacturer) {
        this.name = name;
        this.dosageForm = dosageForm;
        this.strength = strength;
        this.manufacturer = manufacturer;
    }

    //getter and setters
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

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    // Relationship getters and setters
    public List<PrescriptionItems> getPrescriptionItems() {
        return prescriptionItems;
    }

    public void setPrescriptionItems(List<PrescriptionItems> prescriptionItems) {
        this.prescriptionItems = prescriptionItems;
    }
}
