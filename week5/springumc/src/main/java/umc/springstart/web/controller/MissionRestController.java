package umc.springstart.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import umc.springstart.apiPayload.ApiResponse;
import umc.springstart.service.MissionService.MissionCommandService;
import umc.springstart.service.MissionService.MissionQueryService;
import umc.springstart.valid.annotation.ExistMember;
import umc.springstart.valid.annotation.ExistMission;
import umc.springstart.web.dto.MissionDTO.MissionRequestDTO;
import umc.springstart.web.dto.MissionDTO.MissionResponseDTO;

@RestController
@RequestMapping("/missions")
@Tag(name = "Mission", description = "Mission API")
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    public MissionRestController(MissionCommandService missionCommandService , MissionQueryService missionQueryService) {
        this.missionCommandService = missionCommandService;
        this.missionQueryService = missionQueryService;
    }

    @PostMapping("/{missionId}/challenge")
    @Operation(summary = "미션도전하기", description = "미션도전하기")
    public ApiResponse<MissionResponseDTO.ChallengeResultDTO> challenge(
            @PathVariable(name = "missionId") Long missionId,
            @RequestBody @Valid MissionRequestDTO.ChallengeMissionDTO missionchallengeReq) {
        return ApiResponse.onSuccess(missionCommandService.challengeMission(missionId, missionchallengeReq));
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

    @PatchMapping("/{memberId}/missions/{missionId}/complete")
    @Operation(summary = "미션 완료", description = "미션 완료")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원 ID"),
            @Parameter(name = "missionId", description = "미션 ID")
    })
    public ApiResponse<MissionResponseDTO.CompleMyMissionItemDTO> completeMission(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @ExistMission @PathVariable(name = "missionId") Long missionId
    ) {
        return ApiResponse.onSuccess(missionCommandService.completeMemberMission(memberId, missionId));
    }


    @PostMapping("/stores/{storeId}")
    @Operation(summary = "가게에 미션추가", description = "가게에 미션추가")
    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> addStoreMission(
            @PathVariable(name = "storeId") Long storeId,
            @RequestBody @Valid MissionRequestDTO.AddMissionDTO request) {
        return ApiResponse.onSuccess(missionCommandService.addMission(storeId, request));
    }

}
