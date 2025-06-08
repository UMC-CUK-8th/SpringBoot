package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.domain.Mission;
import umc.study.dto.MissionRequestDTO;
import umc.study.dto.MissionResponseDTO;
import umc.study.service.MissionService.MissionCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    public final MissionCommandService missionCommandService;

    @PostMapping
    public ApiResponse<Long> addMission(@Valid @RequestBody MissionRequestDTO.AddMissionRequest request) {
        Long MissionId = missionCommandService.addMission(request);
        return ApiResponse.onSuccess(MissionId);
    }
}
