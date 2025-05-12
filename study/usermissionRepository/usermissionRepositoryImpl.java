package org.example.study.usermissionRepository;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.study.domain.QMissions;
import org.example.study.domain.enums.missionVisit;
import org.example.study.domain.mapping.QUsermissions;
import org.example.study.domain.mapping.Usermissions;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class usermissionRepositoryImpl implements usermissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QUsermissions usermissions = QUsermissions.usermissions;
    private final QMissions missions = QMissions.missions;

    @Override
    public List<Usermissions> dynamicQueryWithBooleanBuilder(missionVisit status) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (status != null) {
            predicate.and(usermissions.visitstatus.eq(status));
        }
        return jpaQueryFactory
                .selectFrom(usermissions)
                .join(usermissions.missions, missions).fetchJoin()
                .where(predicate)
                .fetch();
    }
    @Override
    public long countVisitMission(missionVisit status) {

        Long count = jpaQueryFactory
                .select(usermissions.count())
                .from(usermissions)
                .where(usermissions.visitstatus.eq(status))
                .fetchOne();

        return count != null ? count : 0L;
    }

}