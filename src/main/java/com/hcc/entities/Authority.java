package com.hcc.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

// this is an example entity feel free to delete this once you have created your own.
@Entity
@Table(name = "authority")
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authority")
    private String authority;
    @ManyToOne
    @Column(name = "user")
    private String user;

    public Authority() {
    }

    public Authority(Long id, String authority, String user) {
        this.id = id;
        this.authority = authority;
        this.user = user;
    }
    public Authority(String authority) {
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
