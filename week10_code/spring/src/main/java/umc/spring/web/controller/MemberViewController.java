package umc.spring.web.controller;

/*
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import umc.spring.service.userService.UserCommandService;
import umc.spring.web.dto.UserRequestDTO;

@Controller
@RequiredArgsConstructor
public class MemberViewController {
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("userJoinDTO", new UserRequestDTO.JoinDTO());
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

    private final UserCommandService userCommandService;
    // thymeleaf 사용을 위해 일부가 변경되었습니다.
    // 실제로는 8주차에서 작성한 컨트롤러와 동일하게 작성하시면 됩니다!!
    @ResponseBody
    @PostMapping("/users/signup")
    public String joinMember(@ModelAttribute("userJoinDTO") UserRequestDTO.JoinDTO request, // 협업시에는 기존 RequestBody 어노테이션을 붙여주시면 됩니다!
                             BindingResult bindingResult,
                             Model model) {

        // --- 여기에 디버깅용 코드 추가 ---
        System.out.println("--- UserRequestDTO.JoinDTO received ---");
        System.out.println("Name: " + request.getName());
        System.out.println("Email: " + request.getEmail());
        System.out.println("Gender: " + request.getGender());
        System.out.println("BirthDate: " + request.getBirthDate());
        System.out.println("Address: " + request.getAddress());
        System.out.println("Role: " + request.getRole());

        // *** 가장 중요한 부분: userFoodList 값 확인 ***
        System.out.println("UserFoodList (before validation): " + request.getUserFoodList());
        if (request.getUserFoodList() == null) {
            System.out.println("!!! WARNING: userFoodList is NULL !!!");
        } else if (request.getUserFoodList().isEmpty()) {
            System.out.println("INFO: userFoodList is EMPTY (but not null).");
        }
        System.out.println("-------------------------------------");

        if (bindingResult.hasErrors()) {
            // 뷰에 데이터 바인딩이 실패할 경우 signup 페이지를 유지합니다.
            System.out.println("--- Binding Errors ---");
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println("Error: " + error.getObjectName() + "." + ((org.springframework.validation.FieldError) error).getField() + " - " + error.getDefaultMessage());
            });
            System.out.println("--------------------");

            // 이 부분에 model.addAttribute("errors", bindingResult); 등을 추가하여
            // HTML에서 th:errors 등으로 상세 오류 메시지를 출력하도록 할 수 있습니다.
            // 예를 들어:
            model.addAttribute("bindingErrors", bindingResult.getAllErrors()); // 모든 오류를 전달
            return "signup";

        }



        try {
            userCommandService.joinUser(request);
            return "redirect:/login";
        } catch (Exception e) {
            // 회원가입 과정에서 에러가 발생할 경우 에러 메시지를 보내고, signup 페이디를 유지합니다.
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }
}
*/
