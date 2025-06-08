package umc.study.web.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import umc.study.ApiMission1.code.MemberRequestDTO;
import umc.study.service.MemberService.MemberCommandService;

@Controller
public class MemberViewController {

    private final MemberCommandService memberCommandService;

    public MemberViewController(MemberCommandService memberCommandService) {
        this.memberCommandService = memberCommandService;
    } // 오류가 떠서 이렇게 따로 추가

    @PostMapping("/members/signup")
    public String joinMember(@ModelAttribute("memberJoinDto") MemberRequestDTO.JoinDto request,
                             BindingResult bindingResult,
                             Model model) {
        System.out.println("✅✅✅ 컨트롤러 도착함 ✅✅✅");

        if (bindingResult.hasErrors()) {
            System.out.println("❌ BindingResult 오류 발생!");
            return "signup";
        }

        try {
            System.out.println("👉 회원가입 요청: " + request.getName() + ", " + request.getEmail());
            memberCommandService.joinMember(request);
            System.out.println("🎉 DB 저장 성공!");
            return "redirect:/login";
        } catch (Exception e) {
            System.out.println("🔥 예외 발생: " + e.getMessage());
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }


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
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}