package umcstudy.study.StoreService;

import org.springframework.data.domain.Page;
import umcstudy.study.domain.Missions;
import umcstudy.study.domain.Store;
import org.springframework.stereotype.Service;
import umcstudy.study.domain.mapping.Reviews;

import java.util.List;
import java.util.Optional;

@Service
public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, String type);
    Page<Missions> getMissionList(Long StoreId, Integer page);
}