package com.jonghum.www.springboot.domain.admin.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Entity
public class Admin {
    @Id
    private String id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 255, nullable = false)
    private String role;

    @Column(length = 255)
    private String phoneNumber;

    @Column(length = 255)
    private String address;

    @Column(length = 30)
    private String bathday;

    @Column(length = 30)
    private String register;

    @Builder
    public Admin(String id, String name, String password, String role, String bathday, String phoneNumber, String address, String register) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.bathday = bathday;
        this.register = register;
    }

    public void update(String password, String phoneNumber, String address) {
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
