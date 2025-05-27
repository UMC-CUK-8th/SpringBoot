package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.mapping.Review;
import umc.study.dto.ReviewDTO;
import umc.study.repository.MarketRepository.MarketRepository;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;


@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    // JpaRepository extends 안 하면 인식을 못 함. 왜지?
    private final MemberMissionRepository memberMissionRepository;
    private final MarketRepository marketRepository;

    @Override
    @Transactional
    public Long addReview(Long missionId, Long marketId, Float rate, String description, String picture) {

        Long reviewId=reviewRepository
                .insertReviewWithQueryDSL(missionId, marketId, rate, description, picture);
        //QuerySQL 기반 삽입 방식 사용

        return reviewId;
    }


}
