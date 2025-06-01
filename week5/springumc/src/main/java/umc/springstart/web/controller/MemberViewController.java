package umc.springstart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import umc.springstart.web.dto.memberDTO.MemberRequestDTO;

@Controller
public class MemberViewController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("memberJoinDto", new MemberRequestDTO.JoinDto());
        return "signup";
    }

    @GetMapping("/home")
    public String home() {
        return "hoㅈme";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}