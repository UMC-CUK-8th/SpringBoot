package umc.study.repository.MarketRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Market;

public interface  MarketRepository extends JpaRepository<Market, Long>,MarketRepositoryCustom{

}
 