package umc.study.repository.UserRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QPoint;
import umc.study.domain.QUser;
import umc.study.domain.User;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final QUser user = QUser.user;
    private final QPoint point= QPoint.point1;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public User findByUserId(Long userId) {

        BooleanBuilder predicate = new BooleanBuilder();

        if (userId != null) {
            predicate.and(user.id.eq(userId));
        }

        return jpaQueryFactory
                .select(user)
                .from(user)
                .join(point).on(user.id.eq(point.id)).fetchJoin()
                .where(predicate)
                .fetchOne();

    }
}
