package umcstudy.study.StoreRepository;

import umcstudy.study.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, String type);
}