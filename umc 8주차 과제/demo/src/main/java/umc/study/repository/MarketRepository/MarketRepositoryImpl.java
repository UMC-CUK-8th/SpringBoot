package umc.study.repository.MarketRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.Market;
import umc.study.domain.QMarket;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MarketRepositoryImpl implements MarketRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final QMarket market= QMarket.market;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Market> dynamicQueryWithBooleanBuilder(String name, Float rate) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (name != null) {
            predicate.and(market.name.eq(name));
        }

        return jpaQueryFactory
                .selectFrom(market)
                .where(predicate)
                .fetch();
    }
}
