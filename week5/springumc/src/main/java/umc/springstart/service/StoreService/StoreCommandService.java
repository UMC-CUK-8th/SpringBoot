package umc.springstart.service.StoreService;

import umc.springstart.domain.Store;
import umc.springstart.web.dto.StoreRequestDTO.StoreRequestDTO;

public interface StoreCommandService {
    Store addStore(Long regionId, StoreRequestDTO.AddStoreDTO request);
}