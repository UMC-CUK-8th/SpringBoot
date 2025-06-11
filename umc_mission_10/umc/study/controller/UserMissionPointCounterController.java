package umc.study.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.StoreInfoConverter;
import umc.study.converter.UserMissionPointCounterConverter;
import umc.study.domain.StoreInfo;
import umc.study.domain.mapping.UserMissionPointcounter;
import umc.study.dto.storeInfoDTO.StoreInfoRequestDTO;
import umc.study.dto.storeInfoDTO.StoreInfoResponseDTO;
import umc.study.dto.usermissionpointcounterDTO.UserMissionPointCounterRequestDTO;
import umc.study.dto.usermissionpointcounterDTO.UserMissionPointCounterResponseDTO;
import umc.study.repository.UserMemberPointcounterRepository.UmpRepository;
import umc.study.service.UserMissionPointCounter.UserMissionPointCounterCommandService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/usermissionpointcounter")
public class UserMissionPointCounterController {
    private final UserMissionPointCounterCommandService userMissionPointCounterCommandService;

    @PostMapping("/")
    public ApiResponse<UserMissionPointCounterResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserMissionPointCounterRequestDTO.JoinDTO request){

        UserMissionPointcounter userMissionPointcounter = userMissionPointCounterCommandService.joinUserMissionPointCounter(request);

        return ApiResponse.onSuccess(UserMissionPointCounterConverter.joinResultDTO(userMissionPointcounter));


    }


}
