package umc.study.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.StoreInfoConverter;
import umc.study.domain.StoreInfo;
import umc.study.dto.storeInfoDTO.StoreInfoRequestDTO;
import umc.study.dto.storeInfoDTO.StoreInfoResponseDTO;
import umc.study.service.StoreService.StoreCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreInfoRestController {


    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreInfoResponseDTO.JoinResultDTO> join(@RequestBody @Valid StoreInfoRequestDTO.JoinDto request){
        StoreInfo storeinfo = storeCommandService.joinStoreinfo(request);
        return ApiResponse.onSuccess(StoreInfoConverter.toJoinResultDTO(storeinfo));
    }
}