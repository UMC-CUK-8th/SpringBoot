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
    private final QReview review  = QReview.review;
    QMember member = new QMember("member");


    //@Override
    public List<ReviewDTO> secondpicture() {

        return jpaQueryFactory
                .select(Projections.bean(ReviewDTO.class,
                        review.title, review.score, review.description, review.reply))
                .from(review)
                .join(member).on(member.memberId.eq(review.member.memberId))
                .orderBy(review.member.memberId.asc())
                .fetch();
    }
}