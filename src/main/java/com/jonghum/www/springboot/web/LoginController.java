package com.jonghum.www.springboot.web;

import com.jonghum.www.springboot.domain.Student.service.StudentService;
import com.jonghum.www.springboot.domain.admin.service.AdminService;
import com.jonghum.www.springboot.domain.professor.service.ProfessorService;
import com.jonghum.www.springboot.service.CommonService;
import com.jonghum.www.springboot.web.dto.AdminModifyResponseDTO;
import com.jonghum.www.springboot.web.dto.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final CommonService commonService;

    @PostMapping("/index/api/login")
    public String login(@ModelAttribute LoginResponseDTO loginResponseDTO, HttpSession session) {
        String index="redirect:/";
        LoginResponseDTO login =commonService.login(loginResponseDTO);
        if(login.getRole().equals("교직원")) {
            session.setAttribute("user",login);
            index+="admin";
        }
        else if(login.getRole().equals("교수")) {
            session.setAttribute("user",login);
            index+="professor";
        }else {
            session.setAttribute("user",login);
            index+="student";
        }
        return index;
    }

    @PostMapping("/api/admin")
    public void findById(@RequestParam(value = "id", defaultValue = "", required = false) String id, @RequestParam(value = "password", defaultValue = "", required = false) String password, HttpServletResponse response,HttpSession session) throws IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String role=((LoginResponseDTO)session.getAttribute("user")).getRole();
        int i = commonService.findById(id, password,role);
        System.out.println(i);
        out.write(i + "");
    }

    @PostMapping("/api/admin/modify")
    public String adminModify(@ModelAttribute AdminModifyResponseDTO adminModifyResponseDTO,HttpSession session) {
        String role=((LoginResponseDTO)session.getAttribute("user")).getRole();
        commonService.adminUpdate(adminModifyResponseDTO,role);
        return "redirect:/admin";
    }
}
