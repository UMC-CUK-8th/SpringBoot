package umc.springstart.repository.MemberRepository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.springstart.domain.QMember;
import umc.springstart.domain.QMission;
import umc.springstart.domain.QStore;
import umc.springstart.domain.enums.MissionStatus;
import umc.springstart.domain.mapping.QMemberMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;

    @Override
    public List<Tuple> findByIdAndMissionStatusAndRegionId(Long id, MissionStatus missionStatus, Long region_id) {
        return jpaQueryFactory
                .select(store.name, store.id, mission)
                .from(member)
                .join(memberMission).on(member.id.eq(memberMission.member.id))
                .join(mission).on(mission.id.eq(memberMission.mission.id))
                .join(store).on(store.id.eq(mission.store.id))
                .where(member.id.eq(member.id)
                        .and(memberMission.status.eq(MissionStatus.CHALLENGING))
                        .and(store.region.id.eq(region_id)))
                .orderBy(mission.deadline.desc(), memberMission.updatedAt.desc())
                .fetch();
    }
}