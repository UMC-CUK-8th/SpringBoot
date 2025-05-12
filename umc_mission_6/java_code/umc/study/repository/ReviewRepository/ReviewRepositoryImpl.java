package umc.study.repository.ReviewRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QMember;
import umc.study.domain.mapping.QReview;
import umc.study.dto.ReviewDTO;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QReview rv  = QReview.review;
    QMember member = QMember.member;

    //@Override
    public List<ReviewDTO> secondpicture() {

        return jpaQueryFactory
                .select(Projections.bean(ReviewDTO.class,
                        rv.title, rv.score, rv.description, rv.reply))
                .from(rv)
                .join(member).on(member.phoneNumber.eq(rv.member.phoneNumber))
                .orderBy(rv.member.phoneNumber.asc())
                .fetch();
    }
}