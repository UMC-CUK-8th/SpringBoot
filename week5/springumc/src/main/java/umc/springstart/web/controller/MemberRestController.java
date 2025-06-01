package umc.springstart.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.springstart.apiPayload.ApiResponse;
import umc.springstart.converter.MemberConverter;
import umc.springstart.domain.Member;
import umc.springstart.service.MissionService.MissionQueryService;
import umc.springstart.valid.annotation.ExistMember;
import umc.springstart.web.dto.MissionDTO.MissionResponseDTO;
import umc.springstart.web.dto.memberDTO.MemberRequestDTO;
import umc.springstart.web.dto.memberDTO.MemberResponseDTO;
import umc.springstart.service.MemberService.MemberCommandService;

@RestController
@RequiredArgsConstructor
@Tag(name = "User", description = "User API")
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/")
    @Operation(summary = "회원가입", description = "회원가입")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto signUpReq){
        return ApiResponse.onSuccess(memberCommandService.joinMember(signUpReq));
    }

    @GetMapping("/{memberId}/missions/challenging")
    @Operation(summary = "진행 중인 미션 조회", description = "진행 중인 미션 조회")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원 ID")
    })
    public ApiResponse<MissionResponseDTO.MyChallengingMissionListDTO> getMyChallengingMissions(
            @ExistMember @PathVariable Long memberId,
            @RequestParam(value = "page", defaultValue = "1") Integer page) {
        return ApiResponse.onSuccess(missionQueryService.getMyChallengingMissions(memberId, page));
    }
}
