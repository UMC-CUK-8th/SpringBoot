package umcstudy.study.localmissionRepository;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import umcstudy.study.domain.QLocation;
import umcstudy.study.domain.mapping.Qlocationbonusmission;
import umcstudy.study.domain.mapping.locationbonusmission;
import umcstudy.study.localmissionRepository.localmissionRepositoryCustom;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class localmissionRepositoryImpl implements localmissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final Qlocationbonusmission locationbonusmission= Qlocationbonusmission.locationbonusmission;
    private final QLocation location = QLocation.location;

    @Override
    public List<locationbonusmission> dynamicQueryWithBooleanBuilder(String locationname) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (locationname != null) {
            predicate.and(location.locationname.eq(locationname));
        }

        return jpaQueryFactory
                .selectFrom(locationbonusmission)
                .join(locationbonusmission.location, location).fetchJoin()
                .where(predicate)
                .fetch();
    }
}