package com.alastra.vet_clinic_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "userroles")
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    //many to one
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid" , nullable = false)
    @JsonIgnore
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleid", nullable = false)
    @JsonIgnore
    private Roles role;

    //constructors
    public UserRoles() {}

    public UserRoles(Users user, Roles role ) {
        this.user = user;
        this.role = role;
    }

    //getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    // Helper methods for JSON output
    @JsonProperty("userid")
    public Long getUserId() {
        return user != null ? user.getId() : null;
    }

    @JsonProperty("roleid")
    public Long getRoleId() {
        return role != null ? role.getId() : null;
    }

}
