package umc.study.repository.MarketRepository;

import umc.study.domain.Market;

import java.util.List;

public interface MarketRepositoryCustom {
    List<Market> dynamicQueryWithBooleanBuilder( String name, Float score);
}
