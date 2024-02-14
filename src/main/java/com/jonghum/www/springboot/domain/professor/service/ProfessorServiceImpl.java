package com.jonghum.www.springboot.domain.professor.service;

import com.jonghum.www.springboot.domain.professor.entity.Professor;
import com.jonghum.www.springboot.domain.professor.repository.ProfessorRepository;
import com.jonghum.www.springboot.web.dto.AdminModifyResponseDTO;
import com.jonghum.www.springboot.web.dto.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Override
    @Transactional
    public LoginResponseDTO findByIdAndPassword(LoginResponseDTO loginResponseDTO) {
        Professor professor = professorRepository.findByIdAndPassword(loginResponseDTO.getId(), loginResponseDTO.getPassword());
        return new LoginResponseDTO(professor);
    }

    @Override
    public int findById(String id, String password) {
        return 0;
    }

    @Override
    public void adminUpdate(AdminModifyResponseDTO adminModifyResponseDTO) {

    }
}
