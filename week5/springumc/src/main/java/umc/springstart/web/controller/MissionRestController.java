package umc.springstart.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import umc.springstart.apiPayload.ApiResponse;
import umc.springstart.converter.MemberMissionConverter;
import umc.springstart.converter.StoreMissionConverter;
import umc.springstart.domain.Mission;
import umc.springstart.domain.mapping.MemberMission;
import umc.springstart.service.MissionService.MissionCommandService;
import umc.springstart.web.dto.MissionDTO.MissionRequestDTO;
import umc.springstart.web.dto.MissionDTO.MissionResponseDTO;

@RestController
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    public MissionRestController(MissionCommandService missionCommandService) {
        this.missionCommandService = missionCommandService;
    }
    @Tag(name = "미션도전!")
    @PostMapping("/{missionId}/challenge")
    public ApiResponse<MissionResponseDTO.ChallengeResultDTO> challenge(
            @PathVariable(name = "missionId") Long missionId,
            @RequestBody @Valid MissionRequestDTO.ChallengeMissionDTO request) {
        MemberMission memberMission = missionCommandService.challengeMission(missionId, request);
        MissionResponseDTO.ChallengeResultDTO responseDTO = MemberMissionConverter.toChallengeResultDTO(memberMission);
        return ApiResponse.onSuccess(responseDTO);
    }

    @PostMapping("/stores/{storeId}")
    @Tag(name = "가게에 미션추가")
    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> addStoreMission(
            @PathVariable(name = "storeId") Long storeId,
            @RequestBody @Valid MissionRequestDTO.AddMissionDTO request) {

        Mission mission = missionCommandService.addMission(storeId, request);

        MissionResponseDTO.AddMissionResultDTO responseDTO = StoreMissionConverter.toAddMissionResultDTO(mission);

        return ApiResponse.onSuccess(responseDTO);
    }

}
