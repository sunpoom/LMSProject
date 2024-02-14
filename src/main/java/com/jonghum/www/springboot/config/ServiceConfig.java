package com.jonghum.www.springboot.config;

import com.jonghum.www.springboot.domain.Student.repository.StudentRepository;
import com.jonghum.www.springboot.domain.Student.service.StudentService;
import com.jonghum.www.springboot.domain.Student.service.StudentServiceImpl;
import com.jonghum.www.springboot.domain.admin.repository.AdminRepository;
import com.jonghum.www.springboot.domain.admin.service.AdminService;
import com.jonghum.www.springboot.domain.admin.service.AdminServiceImpl;
import com.jonghum.www.springboot.domain.professor.repository.ProfessorRepository;
import com.jonghum.www.springboot.domain.professor.service.ProfessorService;
import com.jonghum.www.springboot.domain.professor.service.ProfessorServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean(name = "AdminServiceImpl")
    public AdminService adminServiceImpl(AdminRepository adminRepository) {
        return new AdminServiceImpl(adminRepository);
    }

    @Bean(name="ProfessorServiceImpl")
    public ProfessorService professorServiceImpl(ProfessorRepository professorRepository) {
        return new ProfessorServiceImpl(professorRepository);
    }

    @Bean(name="StudentServiceImpl")
    public StudentService studentServiceImpl(StudentRepository studentRepository) {
        return new StudentServiceImpl(studentRepository);
    }

}