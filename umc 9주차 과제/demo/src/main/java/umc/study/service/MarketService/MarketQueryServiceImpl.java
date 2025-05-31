package umc.study.service.MarketService;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Market;
import umc.study.domain.Mission;
import umc.study.domain.mapping.Review;
import umc.study.repository.MarketRepository.MarketRepository;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MarketQueryServiceImpl  implements MarketQueryService{

    private final MarketRepository marketRepository;
    private final MissionRepository missionRepository;
    private final ReviewRepository reviewRepository;

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

    @Override
    public Page<Review> getReviewList(Long marketId, Integer page) {

        Market market = marketRepository.findById(marketId).get();

        Page<Review> MarketPage=reviewRepository.findAllByMarket(market, PageRequest.of(page,10));

        return MarketPage;

    }

    @Override
    public Page<Mission> getMissionList(Long marketId, Integer page) {
        Market market = marketRepository.findById(marketId).get();

        Page<Mission> MarketPage=missionRepository.findAllByMarket(market, PageRequest.of(page,10));
        return MarketPage;
    }


}
