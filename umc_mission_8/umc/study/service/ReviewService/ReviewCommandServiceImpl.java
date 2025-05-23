package umc.study.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.apiPayload.exception.handler.PreferencesHandler;
import umc.study.apiPayload.exception.handler.StoreInfoHandler;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Mission;
import umc.study.domain.StoreInfo;
import umc.study.domain.mapping.Review;
import umc.study.dto.reviewDTO.ReviewRequestDTO;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;


@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Review joinReview(ReviewRequestDTO.JoinDto request) {
        // 1. DTO → Review로 변환
        Review newreview = ReviewConverter.toReview(request);
        // 2. storeId로 StoreInfo 찾아서 연결
        StoreInfo storeInfo = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreInfoHandler(ErrorStatus.STORE_NOT_FOUND));
        newreview.setStoreInfo(storeInfo);

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        newreview.setMission(mission);
        //storeInfo.getReviewList().add(newreview); 이거 때문에 가게가 중복생성됨


        // 연관관계 설정

        return reviewRepository.save(newreview);
    }
}
