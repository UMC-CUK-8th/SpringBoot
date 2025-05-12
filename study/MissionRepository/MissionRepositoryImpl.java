package org.example.study.MissionRepository;



import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.study.domain.Missions;
import org.example.study.domain.QMissions;
import org.example.study.domain.enums.missionVisit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMissions missions = QMissions.missions;

    @Override
    public List<Missions> dynamicQueryWithBooleanBuilder(missionVisit status) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (status != null) {
        }
        return jpaQueryFactory
                .selectFrom(missions)
                .where(predicate)
                .fetch();
    }
}