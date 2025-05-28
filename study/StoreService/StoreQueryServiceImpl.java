package umcstudy.study.StoreService;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umcstudy.study.MissionRepository.MissionRepository;
import umcstudy.study.StoreRepository.StoreRepository;
import umcstudy.study.StoreService.StoreQueryService;
import umcstudy.study.domain.Members;
import umcstudy.study.domain.Missions;
import umcstudy.study.domain.Store;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umcstudy.study.domain.mapping.Reviews;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, String type) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, type);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }
    @Override
    public Page<Missions> getMissionList(Long StoreId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();
        Page<Missions> StorePage = missionRepository.findAllByStore(store, PageRequest.of(page,10));
        return StorePage;
    }
}