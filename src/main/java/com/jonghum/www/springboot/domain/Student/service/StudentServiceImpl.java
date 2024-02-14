package com.jonghum.www.springboot.domain.Student.service;


import com.jonghum.www.springboot.domain.Student.entity.Student;
import com.jonghum.www.springboot.domain.Student.repository.StudentRepository;
import com.jonghum.www.springboot.web.dto.AdminModifyResponseDTO;
import com.jonghum.www.springboot.web.dto.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public LoginResponseDTO findByIdAndPassword(LoginResponseDTO loginResponseDTO) {
        Student student = studentRepository.findByIdAndPassword(loginResponseDTO.getId(), loginResponseDTO.getPassword());
        return new LoginResponseDTO(student);
    }

    @Override
    public int findById(String id, String password) {
        return 0;
    }

    @Override
    public void adminUpdate(AdminModifyResponseDTO adminModifyResponseDTO) {

    }
}
