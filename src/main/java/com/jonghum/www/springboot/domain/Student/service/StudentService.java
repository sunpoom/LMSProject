package com.jonghum.www.springboot.domain.Student.service;

import com.jonghum.www.springboot.web.dto.AdminModifyResponseDTO;
import com.jonghum.www.springboot.web.dto.LoginResponseDTO;

public interface StudentService {
    LoginResponseDTO findByIdAndPassword(LoginResponseDTO loginResponseDTO);

    int findById(String id, String password);

    void adminUpdate(AdminModifyResponseDTO adminModifyResponseDTO);
}
