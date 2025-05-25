package umc.study.repository.MemberMissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QMission;
import umc.study.domain.QUser;
import umc.study.domain.enums.Status;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.QMemberMission;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    // QueryDSL 쿼리를 실행하기 위한 팩토리 객체 의존성 주입
    private  final QMemberMission memberMission = QMemberMission.memberMission;
    // Q타입 인스턴스 초기화
    private final QMission mission = QMission.mission;
    // 여러 테이블에서 데이터를 조회하기 위해서는 각 엔티티에 대한 Q타입 객체가 필요함.
    private final QUser user = QUser.user;

    @Override
    public List<MemberMission> dynamicQueryWithBooleanBuilder(Long userId, Status status) {

        BooleanBuilder predicate = new BooleanBuilder();
        // 동적 조건을 구성할 BooleanBuilder 객체

        if (userId!=null) {
            predicate.and(memberMission.user.id.eq(userId));
            // 사용자 id가 null이 아니면 predicate 조건에 추가함함
        }

        if (status !=null) {
            predicate.and(memberMission.status.eq(Status.BEFORE_START));
            // 상태가 null이 아니면 조건에 포함시킴킴
        }

        return jpaQueryFactory
                .select(memberMission)
                .from(memberMission)
                .join(memberMission.mission, mission).fetchJoin()
                .join(memberMission.user, user).fetchJoin()
                .where(predicate) //predicate를 통해 조건을 추가함
                .orderBy(memberMission.createdAt.desc())
                .limit(5)
                .offset(0)
                .fetch();

    }

    @Override
    public Integer showCompletedMissions(Long userId) {
        MemberMission result= jpaQueryFactory
                .selectFrom(memberMission)
                .where(memberMission.user.id.eq(userId))
                .fetchFirst();
        return result.getCompletedMission();

    }



}
