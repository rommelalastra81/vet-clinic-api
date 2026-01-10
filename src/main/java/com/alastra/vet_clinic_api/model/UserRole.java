package com.alastra.vet_clinic_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "userroles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    //many to one
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid" , nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleid", nullable = false)
    @JsonIgnore
    private Role role;

    //constructors
    public UserRole() {}

    public UserRole(User user, Role role ) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
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
