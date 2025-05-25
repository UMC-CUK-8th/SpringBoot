package umc.springstart.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.springstart.domain.QMember;
import umc.springstart.domain.QReview;
import umc.springstart.domain.QStore;
import umc.springstart.domain.enums.MemberStatus;
import umc.springstart.web.dto.ReviewDto;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QReview review = QReview.review;
    private final QStore store = QStore.store;
    private final QMember member = QMember.member;

    @Override
    public List<ReviewDto> findStoreIdAndMemberStatus(Long id, MemberStatus memberStatus) {
        return jpaQueryFactory
                .select(review.id,store.id, member.id, member.status, review.title, review.createdAt)
                .from(review)
                .join(member).on(review.member.id.eq(member.id))
                .join(store).on(review.store.id.eq(store.id))
                .where(store.id.eq(id)
                        .and(member.status.eq(memberStatus)))
                .orderBy(review.updatedAt.desc(), member.createdAt.desc())
                .stream()
                .map(tuple -> new ReviewDto(
                        tuple.get(review.id),
                        tuple.get(store.id),
                        tuple.get(member.id),
                        tuple.get(member.status),
                        tuple.get(review.title),
                        tuple.get(review.createdAt)
                ))
                .collect(Collectors.toList());
    }
}
