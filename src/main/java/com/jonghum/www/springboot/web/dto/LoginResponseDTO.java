package com.jonghum.www.springboot.web.dto;


import com.jonghum.www.springboot.domain.Student.entity.Student;
import com.jonghum.www.springboot.domain.admin.entity.Admin;
import com.jonghum.www.springboot.domain.professor.entity.Professor;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponseDTO {
    private String id;
    private String name;
    private String password;
    private String role;
    private String email;
    private String phoneNumber;
    private String address;
    private String bathday;
    private String register;
    private String submajor;
    private String major;

    public LoginResponseDTO(Admin entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.password = entity.getPassword();
        this.phoneNumber = entity.getPhoneNumber();
        this.address = entity.getAddress();
        this.role = entity.getRole();
        this.bathday = entity.getBathday();
        this.register = entity.getRegister();
    }

    public LoginResponseDTO(Professor entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.password = entity.getPassword();
        this.submajor = entity.getSubMajor();
    }

    public LoginResponseDTO(Student entity) {
        this.id = entity.getId();
        this.password = entity.getPassword();
        this.role = entity.getRole();
        this.submajor = entity.getSubmajor();
    }

}
