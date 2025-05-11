package umc.study.service.StoreService;

import umc.study.domain.StoreInfo;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<StoreInfo> findStore(Long id);
    List<StoreInfo> findStoresByNameAndScore(String name, Float score);
}