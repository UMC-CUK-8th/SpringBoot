package umc.study.service.StoreService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.StoreInfo;
import umc.study.domain.mapping.Review;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<StoreInfo> findStore(Long id);
    List<StoreInfo> findStoresByNameAndScore(String name, Float score);

    Page<Review> getReviewList(Long StoreId, Integer page);
    //Page는 Spring Data JPA에서 제공하는 Paging을 위한 추상화를 제공

    Page<Mission> getMissionList(Long StoreId, Integer page);
}