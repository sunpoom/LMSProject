package com.jonghum.www.springboot.domain.admin.service;

import com.jonghum.www.springboot.domain.admin.entity.Admin;
import com.jonghum.www.springboot.domain.admin.repository.AdminRepository;
import com.jonghum.www.springboot.web.dto.AdminModifyResponseDTO;
import com.jonghum.www.springboot.web.dto.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    @Transactional
     public LoginResponseDTO findByIdAndPassword(LoginResponseDTO loginResponseDTO) {
        Admin admin = adminRepository.findByIdAndPassword(loginResponseDTO.getId(), loginResponseDTO.getPassword());
        return new LoginResponseDTO(admin);
    }

    @Override
    @Transactional
    public int findById(String id, String password) {
        Admin admin = adminRepository.findById(id, password);
        if (admin != null) {
            return 1;
        }
        return 0;
    }

    @Override
    @Transactional
    public void adminUpdate(AdminModifyResponseDTO adminModifyResponseDTO) {
        String postcode = adminModifyResponseDTO.getPostcode();
        String sample4_roadAddress = adminModifyResponseDTO.getRoadAddress();
        String sample4_jibunAddress = adminModifyResponseDTO.getJibunAddress();
        String sample4_detailAddress = adminModifyResponseDTO.getDetailAddress();
        String sample4_extraAddress = adminModifyResponseDTO.getExtraAddress();
        String address = postcode + "/" + sample4_roadAddress + "/" + sample4_jibunAddress + "/" + sample4_detailAddress + "/" + sample4_extraAddress;
        Admin admin = adminRepository.findById(adminModifyResponseDTO.getId()).orElseThrow(() -> new IllegalArgumentException("해당아이디가없음"));
        admin.update(adminModifyResponseDTO.getPassword(), adminModifyResponseDTO.getPhoneNumber(), address);
    }
}
