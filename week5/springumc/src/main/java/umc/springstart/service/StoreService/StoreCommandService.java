package umc.springstart.service.StoreService;

import umc.springstart.web.dto.StoreRequestDTO.StoreRequestDTO;
import umc.springstart.web.dto.StoreRequestDTO.StoreResponseDTO;

public interface StoreCommandService {
    StoreResponseDTO.AddStoreResultDTO addStore(Long regionId, StoreRequestDTO.AddStoreDTO request);
}