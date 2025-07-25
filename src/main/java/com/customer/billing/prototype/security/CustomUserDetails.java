package com.customer.billing.prototype.security;

import com.customer.billing.prototype.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // For now, return empty roles/authorities.
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();  // password is already encoded
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // Simplify for now
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Simplify for now
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Simplify for now
    }

    @Override
    public boolean isEnabled() {
        return true;  // Simplify for now
    }
}

