package umc.study.service.MarketService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Market;
import umc.study.repository.MarketRepository.MarketRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MarketQueryServiceImpl  implements MarketQueryService{

    private final MarketRepository marketRepository;

    @Override
    public Optional<Market> findMarket(Long id) {
        return marketRepository.findById(id);
    }

    @Override
    public List<Market> findMarketByNameAndRate(String name, Float rate) {
        List <Market> filteredMarkets=marketRepository.dynamicQueryWithBooleanBuilder(name, rate);
        filteredMarkets.forEach(market -> System.out.println("Market: "+ market));
        return filteredMarkets;
    }
}
