package com.customer.billing.prototype.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    // UserDetails interface methods:

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // For now, no roles/authorities, so return empty list
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // can customize if you want
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // can customize if you want
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // can customize if you want
    }

    @Override
    public boolean isEnabled() {
        return true; // can customize if you want
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
