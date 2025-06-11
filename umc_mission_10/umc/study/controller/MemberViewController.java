/*
package umc.study.controller;

//토큰 기반 로그인을 위한 주석처리
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import umc.study.dto.member.MemberRequestDTO;
import umc.study.service.MemberService.MemberCommandService;

@RequiredArgsConstructor
@Controller
public class MemberViewController {
//Thymeleaf 템플릿과 Spring MVC를 연결하고 기본적인 페이지 네비게이션을 설정할 수 있습니다.
    private final MemberCommandService memberCommandService;

    @PostMapping("/members/signup")
    public String joinMember(@ModelAttribute("memberJoinDto") MemberRequestDTO.JoinDto request, // 협업시에는 기존 RequestBody 어노테이션을 붙여주시면 됩니다!
                             BindingResult bindingResult,
                             Model model) {

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println("에러: " + error.getDefaultMessage());
            });
            model.addAttribute("memberJoinDto", request);
            return "signup";
        }

        if (bindingResult.hasErrors()) {
            // 뷰에 데이터 바인딩이 실패할 경우 signup 페이지를 유지합니다.
            model.addAttribute("memberJoinDto", request);  // 폼 데이터를 다시 뷰에 전달
            return "signup";
        }


        try {
            memberCommandService.joinMember(request);
            return "redirect:/login";
        } catch (Exception e) {
            // 회원가입 과정에서 에러가 발생할 경우 에러 메시지를 보내고, signup 페이디를 유지합니다.
            e.printStackTrace(); // 로그 찍기
            model.addAttribute("error", e.getMessage());
            model.addAttribute("memberJoinDto", request);  // 에러 시에도 폼 데이터 유지
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
*/
