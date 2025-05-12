package org.example.study.MemberRepository;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.study.domain.Members;
import org.example.study.domain.QMembers;
import org.example.study.domain.QPoint;
import org.springframework.stereotype.Repository;
import java.util.List;

import static org.example.study.domain.QMembers.members;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMembers member = QMembers.members;
    private final QPoint point = QPoint.point;

    @Override
    public List<Members> dynamicQueryWithBooleanBuilder(String ID) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (ID != null) {
            predicate.and(member.memID.eq(ID));
        }

        return jpaQueryFactory
                .selectFrom(member)
                .join(members.points, point).fetchJoin()
                .where(predicate)
                .fetch();
    }



}
