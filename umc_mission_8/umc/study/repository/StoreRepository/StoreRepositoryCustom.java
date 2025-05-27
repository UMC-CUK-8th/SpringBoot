package umc.study.repository.StoreRepository;

import umc.study.domain.StoreInfo;

import java.util.List;


public interface StoreRepositoryCustom {
    List<StoreInfo> dynamicQueryWithBooleanBuilder(String name, Float score);
}