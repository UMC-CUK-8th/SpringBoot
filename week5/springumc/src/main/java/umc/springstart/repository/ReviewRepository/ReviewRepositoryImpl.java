package umc.springstart.repository.ReviewRepository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.springstart.domain.QMember;
import umc.springstart.domain.QReview;
import umc.springstart.domain.QStore;
import umc.springstart.domain.enums.MemberStatus;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QReview review = QReview.review;
    private final QStore store = QStore.store;
    private final QMember member = QMember.member;

    @Override
    public List<Tuple> findStoreIdAndMemberStatus(Long id, MemberStatus memberStatus) {
        return jpaQueryFactory
                .select(member.nickname, review)
                .from(review)
                .join(member).on(review.member.id.eq(member.id))
                .join(store).on(review.store.id.eq(store.id))
                .where(store.id.eq(store.id)
                        .and(member.status.eq(memberStatus.ACTIVE)))
                .orderBy(review.updatedAt.desc(), member.createdAt.desc())
                .fetch();
    }
}
