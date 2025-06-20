package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.dto.MissionRequestDTO;
import umc.study.service.MemberMissionService.MemberMissionCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member-missions")
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PatchMapping("/challenge")
    public ApiResponse<Long> ChallengeMission(@Valid  @RequestBody MissionRequestDTO.ChallengeMissionRequest request) {
        Long memberMissionId = memberMissionCommandService.ChallengeMission(request.getUserId(), request.getMissionId());
        return ApiResponse.onSuccess(memberMissionId);
    }


}
