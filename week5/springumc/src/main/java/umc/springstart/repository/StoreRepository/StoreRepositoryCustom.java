package umc.springstart.repository.StoreRepository;

import umc.springstart.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}

