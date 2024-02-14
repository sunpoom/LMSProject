package com.jonghum.www.springboot.domain.professor.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class Professor {
    @Id
    private String id;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(length = 200, nullable = false)
    private String email;
    @Column(length = 200, nullable = false)
    private String password;
    private String phoneNumber;
    @Column(length = 200, nullable = false)
    private String role;
    @Column(length = 200, nullable = false)
    private String major;
    private String subMajor;

    @Builder
    public Professor(String id,String name,String email,String password,String phoneNumber,String role,String major,String subMajor) {
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.role=role;
        this.major=major;
        this.subMajor=subMajor;
    }

}
