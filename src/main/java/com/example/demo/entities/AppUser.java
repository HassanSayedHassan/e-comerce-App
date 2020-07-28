package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity

public class AppUser {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles = new ArrayList<>();

    public AppUser( ) {
    }

    public AppUser(Long o, String user, String s, Collection<AppRole> o1) {
        this.username = user;
        this.password = s;
        this.roles = o1;
    }


    public Long getId( ) {
        return id;
    }

    public void setId(Long id) {
        this.id = id;


    }

    public Collection<AppRole> getRoles( ) {
        return roles;
    }

    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }

    @JsonIgnore
    public String getPassword( ) {
        return password;
    }

    @JsonSetter
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername( ) {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
