package umc.spring.repository.missionRepository;

import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Mission;
import umc.spring.domain.QMission;

import java.time.LocalDate;
import java.util.List;



@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    @Override
    public List<Mission> dynamicQueryWithBooleanBuilder(String missionSpec, Integer reward, LocalDate deadline) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (missionSpec != null) {
            predicate.and(mission.missionSpec.loe(missionSpec));
        }

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
}
