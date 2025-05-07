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
    QReview rv = QReview.review;
    QCrm cm = QCrm.crm;

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member  = QMember.member;

    public List<MemberDetailDTO> fourthpicture(String nickname, int phonenumber,
                                               String email, int totalpoint, String reviewName, String crmTitle){

        return jpaQueryFactory.select(Projections.bean(MemberDetailDTO.class,
                        member.nickname,
                        member.phoneNumber,
                        member.email,
                        ump.totalPoint,
                        rv.reviewId,
                        cm.title  // DTO의 필드명과 다르면 as()로 맞춰야 함
                ))
                .from(member, cm, rv, ump)
                .join(ump).on(member.phoneNumber.eq(ump.member.phoneNumber))
                .join(rv).on(member.phoneNumber.eq(rv.member.phoneNumber))  // review 테이블과 JOIN
                .join(cm).on(member.phoneNumber.eq(cm.member.phoneNumber))  // cmr 테이블과 JOIN
                .fetch();

    }
}
