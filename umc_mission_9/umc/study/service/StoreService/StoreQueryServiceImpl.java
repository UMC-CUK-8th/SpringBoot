package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Mission;
import umc.study.domain.StoreInfo;
import umc.study.domain.mapping.Review;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<StoreInfo> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<StoreInfo> findStoresByNameAndScore(String name, Float score) {
        List<StoreInfo> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }
/*

    @Override
    public List<Review>getReviewList(Long reviewId, Integer page){}
*/
    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        StoreInfo storeInfo = storeRepository.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStoreInfo(storeInfo, PageRequest.of(page, 10));
        return StorePage;
    }

    //미션리스트 끌어오는 메소드
    @Override
    public Page<Mission> getMissionList(Long StoreId, Integer page) {
        StoreInfo storeInfo = storeRepository.findById(StoreId).get();

        Page<Mission> StorePage = missionRepository.findAllByStoreInfo(storeInfo, PageRequest.of(page, 10));
        return StorePage;
    }
}