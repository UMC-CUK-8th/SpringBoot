package umc.study.repository.MemberRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QMember;
import umc.study.domain.mapping.QReview;
import umc.study.domain.mapping.QUserMissionPointcounter;
import umc.study.domain.QCrm;
import umc.study.dto.member.MemberDetailDTO;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    QUserMissionPointcounter ump = QUserMissionPointcounter.userMissionPointcounter;
    QReview review = QReview.review;
    QCrm crm = QCrm.crm;

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = new QMember("member");


    public List<MemberDetailDTO> fourthpicture(){

        return jpaQueryFactory.select(Projections.bean(MemberDetailDTO.class,
                        member.nickname,
                        member.memberId,
                        member.email,
                        ump.totalPoint,
                        review.reviewId,
                        crm.title  // DTO의 필드명과 다르면 as()로 맞춰야 함
                ))
                .from(member)
                .join(ump).on(ump.member.eq(member))
                .join(review).on(review.member.eq(member))  // review 테이블과 JOIN
                .join(crm).on(crm.member.eq(member))  // cmr 테이블과 JOIN
                .fetch();

    }
}
