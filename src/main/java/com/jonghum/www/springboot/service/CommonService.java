package com.jonghum.www.springboot.service;

import com.jonghum.www.springboot.web.dto.AdminModifyResponseDTO;
import com.jonghum.www.springboot.web.dto.LoginResponseDTO;

public interface CommonService {

    LoginResponseDTO login(LoginResponseDTO loginResponseDTO);

    int findById(String id, String password, String role);

    void adminUpdate(AdminModifyResponseDTO adminModifyResponseDTO, String role);
}
