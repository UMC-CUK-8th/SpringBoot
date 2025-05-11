package umc.springstart.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.springstart.domain.QMember;
import umc.springstart.domain.QMission;
import umc.springstart.domain.QStore;
import umc.springstart.domain.enums.MissionStatus;
import umc.springstart.domain.mapping.QMemberMission;
import umc.springstart.dto.MemberMissionDto;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;

    @Override
    public List<MemberMissionDto> findByIdAndMissionStatusAndRegionId(Long id, MissionStatus missionStatus, Long region_id) {
        return jpaQueryFactory
                .select(store.name, store.id, mission.id, memberMission.status, mission.deadline)
                .from(member)
                .join(memberMission).on(member.id.eq(memberMission.member.id))
                .join(mission).on(mission.id.eq(memberMission.mission.id))
                .join(store).on(store.id.eq(mission.store.id))
                .where(member.id.eq(id)
                        .and(memberMission.status.eq(missionStatus))
                        .and(store.region.id.eq(region_id)))
                .orderBy(mission.deadline.desc(), memberMission.updatedAt.desc())
                .fetch()
                .stream()
                .map(tuple -> new MemberMissionDto(
                        tuple.get(store.id),
                        tuple.get(store.name),
                        tuple.get(mission.id),
                        tuple.get(memberMission.status),
                        tuple.get(mission.deadline)
                ))
                .collect(Collectors.toList());
    }
    }
