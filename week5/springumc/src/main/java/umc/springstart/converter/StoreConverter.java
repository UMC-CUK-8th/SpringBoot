package umc.springstart.converter;

import umc.springstart.domain.Store;
import umc.springstart.web.dto.StoreRequestDTO.StoreRequestDTO;
import umc.springstart.web.dto.StoreRequestDTO.StoreResponseDTO;

public class StoreConverter {
    public static Store toStore(StoreRequestDTO.AddStoreDTO request) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                // .region(...) // Region은 Service에서 찾아서 설정
                // .score(0.0f) // 필요하다면 여기서 기본값 설정
                .build();
    }

    public static StoreResponseDTO.AddStoreResultDTO toAddStoreResultDTO(Store store) {
        return StoreResponseDTO.AddStoreResultDTO.builder()
                .storeId(store.getId())
                .build();
    }
}
