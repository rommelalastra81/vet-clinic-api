package com.alastra.vet_clinic_api.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "firstname", nullable = false)
    @JsonProperty("firstname")
    private String firstName;

    @Column(name = "lastname", nullable = false)
    @JsonProperty("lastname")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    @JsonProperty("email")
    private String email;

    @Column(name = "password", nullable = false)
    @JsonProperty("password")
    private String password;

    @Column(name = "isactive", nullable = false)
    @JsonProperty("isactive")
    private Boolean isActive;

    // Relationships
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<UserRoles> userRoles = new ArrayList<>();

    // uncomment after these models created
    // @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval =
    // true)
    // @JsonIgnore
    // private List<Appointments> appointments = new ArrayList<>();
    //
    // @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval =
    // true)
    // @JsonIgnore
    // private List<Visits> visits = new ArrayList<>();
    //
    // @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval =
    // true)
    // @JsonIgnore
    // private List<Vaccinations> vaccinations = new ArrayList<>();

    // Constructors
    public Users() {
    }

    public Users(String firstName, String lastName, String email, String password, Boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    // Relationship getters and setters
    public List<UserRoles> getUserRole() {
        return userRoles;
    }

    public void setUserRole(List<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }

    // uncomment after created these models
    // public List<Appointments> getAppointments() {
    // return appointments;
    // }
    //
    // public void setAppointments(List<Appointments> appointments) {
    // this.appointments = appointments;
    // }

    //
    // public List<Visits> getVisits() {
    // return visits;
    // }
    //
    // public void setVisits(List<Visits> visits) {
    // this.visits = visits;
    // }

    //
    // public List<Vaccinations> getVaccinations() {
    // return vaccinations;
    // }
    //
    // public void setVaccinations(List<Vaccinations> vaccinations) {
    // this.vaccinations = vaccinations;
    // }
}
