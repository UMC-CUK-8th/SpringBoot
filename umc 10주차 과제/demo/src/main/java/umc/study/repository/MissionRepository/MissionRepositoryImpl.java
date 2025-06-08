package umc.study.repository.MissionRepository;

import com.querydsl.core.QueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.Mission;
import umc.study.domain.QMission;
import umc.study.domain.mapping.QReview;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QReview review = QReview.review;
    private final QueryFactory queryFactory;


    @Override
    public List<Mission> findMissionsByMarketId(Long marketId) {

        return jpaQueryFactory
                .selectFrom(mission)
                .join(review).on(review.mission.id.eq(mission.id))
                .where(review.market.id.eq(marketId))
                .distinct()
                .fetch();
    }
}
