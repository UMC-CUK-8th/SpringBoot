package org.example.study.PointRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.study.MemberRepository.MemberRepositoryCustom;
import org.example.study.domain.Members;
import org.example.study.domain.Point;
import org.example.study.domain.QMembers;
import org.example.study.domain.QPoint;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PointRepositoryImpl implements PointRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QPoint point = QPoint.point;

    @Override
    public List<Point> dynamicQueryWithBooleanBuilder(Long memberId) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (memberId != null) {
            predicate.and(point.members.id.eq(memberId));
        }

        return jpaQueryFactory
                .selectFrom(point)
                .where(predicate)
                .fetch();
    }
}