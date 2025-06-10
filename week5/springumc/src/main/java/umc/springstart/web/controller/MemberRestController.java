package umc.springstart.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.springstart.apiPayload.ApiResponse;
import umc.springstart.web.dto.memberDTO.MemberRequestDTO;
import umc.springstart.web.dto.memberDTO.MemberResponseDTO;
import umc.springstart.service.MemberService.MemberCommandService;
import umc.springstart.service.MemberService.MemberQueryService;

@RestController
@RequiredArgsConstructor
@Tag(name = "User", description = "User API")
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/join")
    @Operation(summary = "회원가입", description = "회원가입")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto signUpReq){
        return ApiResponse.onSuccess(memberCommandService.joinMember(signUpReq));
    }

    @PostMapping("/login")
    @Operation(summary = "유저 로그인 API",description = "유저가 로그인하는 API입니다.")
    public ApiResponse<MemberResponseDTO.LoginResultDTO> login(@RequestBody @Valid MemberRequestDTO.LoginRequestDTO LoginReq) {
        return ApiResponse.onSuccess(memberCommandService.loginMember(LoginReq));
    }

    @GetMapping("/info")
    @Operation(summary = "유저 내 정보 조회 API - 인증 필요",
            description = "유저가 내 정보를 조회하는 API입니다.",
            security = { @SecurityRequirement(name = "JWT TOKEN") }
    )
    public ApiResponse<MemberResponseDTO.MemberInfoDTO> getMyInfo(HttpServletRequest request) {
        return ApiResponse.onSuccess(memberQueryService.getMemberInfo(request));
    }
}
