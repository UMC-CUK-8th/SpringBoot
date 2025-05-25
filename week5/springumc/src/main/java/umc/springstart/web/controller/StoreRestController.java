package umc.springstart.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import umc.springstart.apiPayload.ApiResponse;
import umc.springstart.converter.StoreConverter;
import umc.springstart.domain.Store;
import umc.springstart.service.StoreService.StoreCommandService;
import umc.springstart.web.dto.StoreRequestDTO.StoreRequestDTO;
import umc.springstart.web.dto.StoreRequestDTO.StoreResponseDTO;

@RestController
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    public StoreRestController(StoreCommandService storeCommandService) {
        this.storeCommandService = storeCommandService;
    }

    @Tag(name = "특정 지역에 가게 추가하기")
    @PostMapping("/regions/{regionId}/stores")
    public ApiResponse<StoreResponseDTO.AddStoreResultDTO> addStore(
            @PathVariable(name = "regionId") Long regionId,
            @RequestBody @Valid StoreRequestDTO.AddStoreDTO request) {

        Store store = storeCommandService.addStore(regionId, request);

        StoreResponseDTO.AddStoreResultDTO responseDTO = StoreConverter.toAddStoreResultDTO(store);
        return ApiResponse.onSuccess(responseDTO);
    }
}
