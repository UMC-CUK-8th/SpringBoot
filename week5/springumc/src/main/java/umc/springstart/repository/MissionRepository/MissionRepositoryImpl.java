package umc.springstart.repository.MissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import umc.springstart.domain.Mission;
import umc.springstart.domain.QMission;
import umc.springstart.domain.enums.MissionStatus;
import umc.springstart.domain.mapping.QMemberMission;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public PageImpl<Mission> findByUserIdAndMissionStatus(Long userId, MissionStatus missionStatus, Pageable pageable) {
        // 전체 개수 조회를 위한 쿼리
        long total = jpaQueryFactory
                .selectFrom(mission)
                .join(memberMission).on(memberMission.mission.eq(mission))
                .where(
                        memberMission.member.id.eq(userId),
                        memberMission.status.eq(missionStatus)
                )
                .fetchCount();

        // 실제 데이터 조회 쿼리
        List<Mission> missions = jpaQueryFactory
                .selectFrom(mission)
                .join(memberMission).on(memberMission.mission.eq(mission))
                .where(
                        memberMission.member.id.eq(userId),
                        memberMission.status.eq(missionStatus)
                )
                .orderBy(mission.deadline.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(missions, pageable, total);
    }
}