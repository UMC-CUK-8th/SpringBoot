package umc.study.repository.MemberRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QMember;
import umc.study.domain.mapping.QReview;
import umc.study.domain.mapping.QUserMissionPointcounter;
import umc.study.domain.QCrm;
import umc.study.dto.MemberDetailDTO;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    QUserMissionPointcounter ump = QUserMissionPointcounter.userMissionPointcounter;
    QReview reaview = QReview.review;
    QCrm crm = QCrm.crm;

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member  = QMember.member;

    public List<MemberDetailDTO> fourthpicture(){

        return jpaQueryFactory.select(Projections.bean(MemberDetailDTO.class,
                        member.nickname,
                        member.phoneNumber,
                        member.email,
                        ump.totalPoint,
                        reaview.reviewId,
                        crm.title  // DTO의 필드명과 다르면 as()로 맞춰야 함
                ))
                .from(member)
                .join(ump).on(member.phoneNumber.eq(ump.member.phoneNumber))
                .join(reaview).on(member.phoneNumber.eq(reaview.member.phoneNumber))  // review 테이블과 JOIN
                .join(crm).on(member.phoneNumber.eq(crm.member.phoneNumber))  // cmr 테이블과 JOIN
                .fetch();

    }
}
