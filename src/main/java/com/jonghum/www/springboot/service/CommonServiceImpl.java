package com.jonghum.www.springboot.service;


import com.jonghum.www.springboot.domain.Student.service.StudentService;
import com.jonghum.www.springboot.domain.admin.service.AdminService;
import com.jonghum.www.springboot.domain.professor.service.ProfessorService;
import com.jonghum.www.springboot.web.dto.AdminModifyResponseDTO;
import com.jonghum.www.springboot.web.dto.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;


@Service
public class CommonServiceImpl implements CommonService{


    private AdminService adminService;

    private final ProfessorService professorService;

    private final StudentService studentService;

    public CommonServiceImpl(@Qualifier("AdminServiceImpl") AdminService adminService,
                             @Qualifier("ProfessorServiceImpl") ProfessorService professorService,
                             @Qualifier("StudentServiceImpl") StudentService studentService) {
        this.adminService = adminService;
        this.professorService = professorService;
        this.studentService = studentService;
    }
    @Override
    public LoginResponseDTO login(LoginResponseDTO loginResponseDTO) {
        char code = loginResponseDTO.getId().charAt(0);
        String regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        LoginResponseDTO dto=null;
        if (loginResponseDTO.getId().length() == 7 && pattern.matcher(loginResponseDTO.getId().substring(1, 7)).matches() && String.valueOf(code).equalsIgnoreCase("p")) {

            dto=professorService.findByIdAndPassword(loginResponseDTO);
        } else if (loginResponseDTO.getId().length() == 7 && pattern.matcher(loginResponseDTO.getId().substring(1, 7)).matches() && !String.valueOf(code).equalsIgnoreCase("p")) {

            dto=studentService.findByIdAndPassword(loginResponseDTO);

        } else {
            dto=adminService.findByIdAndPassword(loginResponseDTO);
        }
        return dto;
    }

    @Override
    public int findById(String id, String password, String role) {
        if(role.equals("교직원")) {
           return adminService.findById(id,password);
        }
        else if(role.equals("교수")) {
            return  professorService.findById(id,password);
        }
        else {
            return  studentService.findById(id,password);
        }
    }

    @Override
    public void adminUpdate(AdminModifyResponseDTO adminModifyResponseDTO, String role) {
        if(role.equals("교직원")) {
            adminService.adminUpdate(adminModifyResponseDTO);
        }
        else if(role.equals("교수")) {
            professorService.adminUpdate(adminModifyResponseDTO);
        }
        else {
            studentService.adminUpdate(adminModifyResponseDTO);
        }
    }
}
