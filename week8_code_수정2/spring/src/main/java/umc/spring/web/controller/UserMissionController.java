package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.UserMissionConverter;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.UserMission;
import umc.spring.service.userMissionService.UserMissionCommandService;
import umc.spring.validation.annotation.ExistUsers;
import umc.spring.validation.annotation.GreaterThanZero;
import umc.spring.web.dto.MissionResponseDTO;
import umc.spring.web.dto.UserMissionRequestDTO;
import umc.spring.web.dto.UserMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/userMissions")
public class UserMissionController {

    private final UserMissionCommandService userMissionCommandService;

    @PostMapping("/")
    public ApiResponse<UserMissionResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserMissionRequestDTO.JoinDTO request) {
        UserMission userMission = userMissionCommandService.createUserMission(request);
        return ApiResponse.onSuccess(UserMissionConverter.toJoinResultDTO(userMission));

    }

     @GetMapping("/{userId}/missions")
    @Operation(summary = "특정 사용자가 진행중인 미션 목록 조회 API",description = "특정 사용자가 진행중인 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "사용자의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.MissionPreMissionListDTO> getChallengingMissionList(@ExistUsers @PathVariable(name = "userId") Long userId, @GreaterThanZero @RequestParam(name = "page") Integer page){
        Page<UserMission> userMissionList = userMissionCommandService.getChallengingMissionList(userId, page);
        return ApiResponse.onSuccess(UserMissionConverter.userMissionPreUserMissionListDTO(userMissionList));
    }
}
