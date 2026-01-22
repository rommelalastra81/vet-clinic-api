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

    // many to one
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnore
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleid", nullable = false)
    @JsonIgnore
    private Roles roles;

    // constructors
    public UserRoles() {
    }

    public UserRoles(Users users, Roles roles) {
        this.users = users;
        this.roles = roles;
    }

    // getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    // Helper methods for JSON output
    @JsonProperty("userid")
    public Long getUserId() {
        return users != null ? users.getId() : null;
    }

    @JsonProperty("roleid")
    public Long getRoleId() {
        return roles != null ? roles.getId() : null;
    }

}
