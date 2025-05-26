package umc.spring.repository.missionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringExpression;
import lombok.RequiredArgsConstructor;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Mission;
import umc.spring.domain.QMission;

import umc.spring.domain.QStore;
import umc.spring.domain.mapping.QUserMission;
import umc.spring.web.dto.MissionCursor;

import java.time.LocalDate;
import java.util.List;



/*
@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QUserMission userMission = QUserMission.userMission;
    private final QStore store = QStore.store;

    @Override
    public List<Mission> dynamicQueryWithBooleanBuilder(String missionSpec, Integer reward, LocalDate deadline) {
        BooleanBuilder predicate = new BooleanBuilder();


        if (reward != null) {
            predicate.and(mission.reward.goe(reward));
        }

        if (deadline != null) {
            predicate.and(mission.deadline.loe(deadline));
        }

        return jpaQueryFactory
                .selectFrom(mission)
                .where(predicate)
                .fetch();

    }

    public List<MissionCursor> dynamicQueryWithBooleanBuilder2(Long userId, String cursorValue, Long cursorId, int limit) {


        StringExpression cursorConcat = Expressions.stringTemplate(
                "CONCAT(LPAD(DATE_FORMAT({0}, '%Y%m%d%H%i%s'), 14, '0'), LPAD(CAST({1} AS CHAR), 10, '0'))",
                userMission.createdAt, userMission.id
        );

        StringExpression cursorParam = Expressions.stringTemplate(
                "CONCAT(LPAD(CAST({0} AS CHAR), 14, '0'), LPAD(CAST({1} AS CHAR), 10, '0'))",
                Expressions.constant(cursorValue), Expressions.constant(cursorId)
        );

        // 쿼리 실행
        return jpaQueryFactory
                .select(Projections.constructor(
                        MissionCursor.class,
                        store.name,
                        mission.reward,
                        cursorConcat.as("cursorValue")
                ))
                .from(userMission)
                .join(userMission.mission, mission)
                .join(mission.store, store)
                .where(
                        userMission.user.id.eq(userId),
                        cursorConcat.lt(cursorParam)
                )
                .orderBy(userMission.createdAt.desc(), userMission.id.desc())
                .limit(limit)
                .fetch();
    }
}
*/
