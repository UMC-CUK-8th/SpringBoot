package umc.springstart.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import umc.springstart.apiPayload.ApiResponse;
import umc.springstart.service.MissionService.MissionCommandService;
import umc.springstart.web.dto.MissionDTO.MissionRequestDTO;
import umc.springstart.web.dto.MissionDTO.MissionResponseDTO;

@RestController
@RequestMapping("/missions")
@Tag(name = "Mission", description = "Mission API")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    public MissionRestController(MissionCommandService missionCommandService) {
        this.missionCommandService = missionCommandService;
    }

    @PostMapping("/{missionId}/challenge")
    @Operation(summary = "미션도전하기", description = "미션도전하기")
    public ApiResponse<MissionResponseDTO.ChallengeResultDTO> challenge(
            @PathVariable(name = "missionId") Long missionId,
            @RequestBody @Valid MissionRequestDTO.ChallengeMissionDTO missionchallengeReq) {
        return ApiResponse.onSuccess(missionCommandService.challengeMission(missionId, missionchallengeReq));
    }

    @PostMapping("/stores/{storeId}")
    @Operation(summary = "가게에 미션추가", description = "가게에 미션추가")
    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> addStoreMission(
            @PathVariable(name = "storeId") Long storeId,
            @RequestBody @Valid MissionRequestDTO.AddMissionDTO request) {
        return ApiResponse.onSuccess(missionCommandService.addMission(storeId, request));
    }

}
