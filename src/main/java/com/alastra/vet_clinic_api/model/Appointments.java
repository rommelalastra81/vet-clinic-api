package com.alastra.vet_clinic_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "appointments")
public class Appointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "appointmentdate", nullable = false)
    @JsonProperty("appointmentdate")
    private LocalDate appointmentDate;

    @Column(name = "appointmenttime", nullable = false)
    @JsonProperty("appointmenttime")
    private LocalTime appointmentTime;

    @Column(name = "reason", nullable = false)
    @JsonProperty("reason")
    private String reason;

    @Column(name = "status", nullable = false)
    @JsonProperty("status")
    private String status;

    //many to one
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petid", nullable = false)
    @JsonIgnore
    private Pets pets;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnore
    private Users users;

    //one to many
    @OneToMany(mappedBy = "appointments", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Visits> visits = new ArrayList<>();

    public Appointments() {}

    public Appointments(LocalDate appointmentDate, LocalTime appointmentTime, String reason, String status) {
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.reason = reason;
        this.status = status;
    }

    //getter and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //one-to-many relationship getter and setter
    public List<Visits> getVisits() {
        return visits;
    }

    public void setVisits(List<Visits> visits) {
        this.visits = visits;
    }

    @JsonProperty("petid")
    public Long getPetId() {
        return pets != null ? pets.getId() : null;
    }

    @JsonProperty("userid")
    public Long getUserId() {
        return users != null ? users.getId() : null;
    }

}
