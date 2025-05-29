package umcstudy.study.PointRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import umcstudy.study.MemberRepository.MemberRepositoryCustom;
import umcstudy.study.PointRepository.PointRepositoryCustom;
import umcstudy.study.domain.Members;
import umcstudy.study.domain.Point;
import umcstudy.study.domain.QPoint;
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