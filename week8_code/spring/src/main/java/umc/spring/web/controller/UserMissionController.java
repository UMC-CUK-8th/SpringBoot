package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.UserMissionConverter;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.UserMission;
import umc.spring.service.userMissionService.UserMissionCommandService;
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
}
