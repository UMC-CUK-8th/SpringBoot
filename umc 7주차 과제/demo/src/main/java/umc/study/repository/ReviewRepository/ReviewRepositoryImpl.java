package umc.study.repository.ReviewRepository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Market;
import umc.study.domain.QMarket;
import umc.study.domain.QMission;
import umc.study.domain.Mission;
import umc.study.domain.mapping.QReview;
import umc.study.domain.mapping.Review;

import java.time.LocalDate;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    private final QMission Mission=QMission.mission;
    private final QReview review=QReview.review;
    private final QMarket market=QMarket.market;

    @PersistenceContext
    private EntityManager entityManager;
    // 리뷰를 저장하기 위한 엔티티 매니저 생성


    @Override
    @Transactional
    public Long insertReviewWithQueryDSL(Long missionId, Long marketId, Float rate, String description, String picture) {
        LocalDate now= LocalDate.now();

        Mission missionref =entityManager.getReference(Mission.class, missionId);
        Market marketref =entityManager.getReference(Market.class, marketId);

        Review review= Review.builder()
                .mission(missionref)
                .market(marketref)
                .rate(rate)
                .description(description)
                .picture(picture)
                .build();

        entityManager.persist(review);

        return review.getId();
    }
}
