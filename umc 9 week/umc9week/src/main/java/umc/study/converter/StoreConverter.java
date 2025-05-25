package umc.study.converter;

import umc.study.ApiMission1.code.StoreRequestDTO;
import umc.study.ApiMission1.code.StoreResponseDTO;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.domain.UserMain;

public class StoreConverter {
    public static Store toStore(StoreRequestDTO dto, Region region, UserMain userMain) {
        return Store.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .score(dto.getScore())
                .region(region)
                .userMain(userMain)
                .build();
    }

    public static StoreResponseDTO toStoreResponseDTO(Store store) {
        return StoreResponseDTO.builder()
                .storeId(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .score(store.getScore())
                .createdAt(store.getCreatedAt())
                .updatedAt(store.getUpdatedAt())
                .build();
    }
}