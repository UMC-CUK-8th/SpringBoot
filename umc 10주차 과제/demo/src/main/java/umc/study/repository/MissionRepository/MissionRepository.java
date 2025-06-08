package umc.study.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Market;
import umc.study.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> ,MissionRepositoryCustom{

    Page<Mission> findAllByMarket(Market market, PageRequest pageRequest);

}
