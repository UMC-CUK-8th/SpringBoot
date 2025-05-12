package org.example.study.StoreRepository;

import org.example.study.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, String type);
}