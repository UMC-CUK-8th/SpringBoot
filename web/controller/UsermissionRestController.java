package umcstudy.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umcstudy.apiPayload.ApiResponse;
import umcstudy.service.UsermissionCommandService.UsermissionCommandService;
import umcstudy.web.dto.MissionRequestDTO;
import umcstudy.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-missions")
public class UsermissionRestController {

    private final UsermissionCommandService usermissionCommandService;

    @PatchMapping("/challenge")
    public ApiResponse<MissionResponseDTO.MissionResultDTO> challengeMission(
            @RequestBody @Valid MissionRequestDTO.MissionDto request) {

        MissionResponseDTO.MissionResultDTO resultDTO = usermissionCommandService.visitingStore(request);

        return ApiResponse.onSuccess(resultDTO);
    }
}