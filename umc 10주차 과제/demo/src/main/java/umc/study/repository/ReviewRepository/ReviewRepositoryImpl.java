package umc.study.repository.ReviewRepository;


import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Market;
import umc.study.domain.QMarket;
import umc.study.domain.QMission;
import umc.study.domain.Mission;
import umc.study.domain.mapping.QReview;
import umc.study.domain.mapping.Review;
import umc.study.dto.ReviewDTO;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.boot.origin.Origin.from;
import static umc.study.domain.QMission.mission;
import static umc.study.domain.QUser.user;
import static umc.study.domain.mapping.QMemberMission.memberMission;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    private final QMission Mission= mission;
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

    @Override
    public Page<ReviewDTO.UserReviewDTO> findReviewByUserId(Long userId, Pageable pageable) {
        List<ReviewDTO.UserReviewDTO> content=jpaQueryFactory
                .select(Projections.constructor(ReviewDTO.UserReviewDTO.class,
                        review.id,
                        mission.missionName,
                        market.name,
                        review.rate,
                        review.description,
                        review.createdAt))
                .from(review)
                .join(review.mission, mission)
                .join(mission.memberMissionList, memberMission)
                .join(memberMission.user, user)
                .join(review.market, market)
                .where(memberMission.user.id.eq(userId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(review.createdAt.desc())
                .fetch();


        JPAQuery<Long> countQuery=jpaQueryFactory
                .select(review.count())
                .from(review)
                .join(review.mission, mission)
                .join(mission.memberMissionList, memberMission)
                .where(memberMission.user.id.eq(userId));
        return PageableExecutionUtils.getPage(content, pageable,countQuery::fetchCount);
    }
}
