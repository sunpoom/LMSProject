package com.jonghum.www.springboot.domain.Student.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class Student {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String role;
    private String major;
    private String submajor;
    private int grade;

    @Builder
    public Student(String id,String name,String email,String password,String phoneNumber,String role,String major,String submajor,int grade) {
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.role=role;
        this.major=major;
        this.submajor=submajor;
        this.grade=grade;
    }
}
