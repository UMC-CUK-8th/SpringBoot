package umc.spring.repository.reviewRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QReview;
import umc.spring.domain.Review;

import java.time.LocalDate;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImp implements ReviewRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QReview review = QReview.review;

    @Override
    public List<Review> dynamicQueryWithBooleanBuilder(LocalDate WritingDate, Float score) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (WritingDate != null) {
            predicate.and(review.WritingDate.goe(WritingDate));
        }

        if (score != null) {
            predicate.and(review.score.goe(score));
        }

        return jpaQueryFactory
                .selectFrom(review)
                .where(predicate)
                .fetch();
    }
}
