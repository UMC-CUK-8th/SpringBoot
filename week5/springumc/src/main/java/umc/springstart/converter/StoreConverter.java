package umc.springstart.converter;

import umc.springstart.domain.Region;
import umc.springstart.domain.Store;
import umc.springstart.web.dto.StoreRequestDTO.StoreRequestDTO;
import umc.springstart.web.dto.StoreRequestDTO.StoreResponseDTO;

public class StoreConverter {
    public static Store toStore(StoreRequestDTO.AddStoreDTO request, Region region) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .build();
    }

    public static StoreResponseDTO.AddStoreResultDTO toAddStoreResultDTO(Store store) {
        return StoreResponseDTO.AddStoreResultDTO.builder()
                .storeId(store.getId())
                .build();
    }
}
