package umc.study.repository.UserMemberPointcounterRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QMember;
import umc.study.domain.QMission;
import umc.study.domain.mapping.QUserMissionPointcounter;
import umc.study.dto.UmpFirstDTO;
import umc.study.dto.UmpThirdDTO;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UmpRepositoryImpl implements UmpRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QUserMissionPointcounter ump  = QUserMissionPointcounter.userMissionPointcounter;
    QMember member = new QMember("member");
    QMission mission = QMission.mission;

    //@Override
    public List<UmpFirstDTO> firstpictureWithCursor(LocalDateTime cursorCreatedAt) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (cursorCreatedAt != null) {
            predicate.and(ump.createdAt.lt(cursorCreatedAt)); // 커서 조건
        }


        return jpaQueryFactory
                .select(Projections.constructor(UmpFirstDTO.class, ump.phonenumberMissionid, ump.status))
                .from(ump)
                .join(ump.member, member)//.on(member.memberId.eq(ump.member.memberId))
                .join(ump.mission, mission)//.on(mission.missionid.eq(ump.mission.missionid))
                .where(predicate)
                .orderBy(ump.createdAt.desc())
                .limit(20)
                .fetch();
    }

    //@override
    public List<UmpThirdDTO> thirdpictureWithCursor(long memberId, LocalDateTime cursorCreatedAt) {

        BooleanBuilder predicate = new BooleanBuilder();

        if (memberId != 0) {
            predicate.and(member.memberId.eq(memberId));
        }
        //ph 가oneNumber와 같은 값을진 Member와 연관된 UserMissionPointcounter(ump) 레코드만 조회됩니다.
        if (cursorCreatedAt != null) {
            predicate.and(ump.createdAt.lt(cursorCreatedAt)); // 커서 조건 : "현재 커서 시점보다 더 과거의 데이터만 가져온다."
        }

        return jpaQueryFactory
                .select(Projections.constructor(UmpThirdDTO.class, ump.completedMission, mission.missionId, mission.createdAt))
                .from(ump)
                .join(ump.mission, mission)//.on(mission.missionid.eq(ump.mission.missionid))
                .where(predicate)
                .orderBy(ump.createdAt.desc())
                .limit(20)
                .fetch();
    }
}