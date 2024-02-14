package com.jonghum.www.springboot.domain.professor.service;

import com.jonghum.www.springboot.web.dto.AdminModifyResponseDTO;
import com.jonghum.www.springboot.web.dto.LoginResponseDTO;

public interface ProfessorService {
    LoginResponseDTO findByIdAndPassword(LoginResponseDTO loginResponseDTO);

    int findById(String id, String password);

    void adminUpdate(AdminModifyResponseDTO adminModifyResponseDTO);
}
