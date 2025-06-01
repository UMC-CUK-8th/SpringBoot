package umc.springstart.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import umc.springstart.apiPayload.ApiResponse;
import umc.springstart.domain.Store;
import umc.springstart.service.StoreService.StoreCommandService;
import umc.springstart.web.dto.StoreRequestDTO.StoreRequestDTO;
import umc.springstart.web.dto.StoreRequestDTO.StoreResponseDTO;

@RestController
@RequestMapping("/regions")
@Tag(name = "Store", description = "Store API")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    public StoreRestController(StoreCommandService storeCommandService) {
        this.storeCommandService = storeCommandService;
    }

    @PostMapping("/{regionId}/stores")
    @Operation(summary = "지역에 가게추가하기", description = "지역에 가게추가하기")
    public ApiResponse<StoreResponseDTO.AddStoreResultDTO> addStore(
            @PathVariable(name = "regionId") Long regionId,
            @RequestBody @Valid StoreRequestDTO.AddStoreDTO addStorereq) {
        return ApiResponse.onSuccess(storeCommandService.addStore(regionId, addStorereq));
    }
}
