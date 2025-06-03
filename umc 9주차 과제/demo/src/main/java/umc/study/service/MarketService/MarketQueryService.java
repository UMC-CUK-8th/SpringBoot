package umc.study.service.MarketService;

import org.springframework.data.domain.Page;
import umc.study.domain.Market;
import umc.study.domain.Mission;
import umc.study.domain.mapping.Review;

import java.util.List;
import java.util.Optional;

public interface MarketQueryService {

    Optional<Market> findMarket(Long id);
    List<Market> findMarketByNameAndRate(String name, Float rate);

    Page<Review> getReviewList(Long marketId, Integer page);
    Page<Mission> getMissionList(Long marketId, Integer page);

}
