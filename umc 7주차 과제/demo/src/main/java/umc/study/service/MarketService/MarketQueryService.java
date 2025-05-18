package umc.study.service.MarketService;

import umc.study.domain.Market;

import java.util.List;
import java.util.Optional;

public interface MarketQueryService {

    Optional<Market> findMarket(Long id);
    List<Market> findMarketByNameAndRate(String name, Float rate);

}
