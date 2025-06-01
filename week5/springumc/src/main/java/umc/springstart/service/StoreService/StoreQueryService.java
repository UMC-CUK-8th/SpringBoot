package umc.springstart.service.StoreService;

import umc.springstart.domain.Store;

import java.util.List;
import java.util.Optional;
import umc.springstart.web.dto.StoreRequestDTO.StoreResponseDTO;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);

    StoreResponseDTO.ReviewPreViewListDTO getReviewList(Long storeId, Integer page);
}

