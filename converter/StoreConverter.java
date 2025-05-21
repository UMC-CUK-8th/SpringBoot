package umcstudy.converter;

import umcstudy.study.domain.Location;
import umcstudy.study.domain.Store;
import umcstudy.web.dto.StoreRequestDTO;
import umcstudy.web.dto.StoreResponseDTO;
import java.time.LocalDateTime;
import static umcstudy.study.domain.QLocation.location;

public class StoreConverter {

    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store) {
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinDto request, Location location) {

        return Store.builder()
                .storename(request.getStorename())
                .storeaddress(request.getStoreaddress())
                .storetype(request.getStoretype())
                .reviewcount(request.getReviewcount())
                .location(location)
                .build();
    }
}
