package umc.springstart.service.StoreService;

import umc.springstart.domain.Store;
import umc.springstart.domain.Review;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);

    Page<Review> getReviewList(Long storeId, Integer page);
}

