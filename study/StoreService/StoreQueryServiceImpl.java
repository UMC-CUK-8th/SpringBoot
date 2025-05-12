package org.example.study.StoreService;


import lombok.RequiredArgsConstructor;
import org.example.study.StoreRepository.StoreRepository;
import org.example.study.StoreService.StoreQueryService;
import org.example.study.domain.Store;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;

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
}