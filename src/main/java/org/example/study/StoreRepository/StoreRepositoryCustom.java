package org.example.study.StoreRepository;

import org.example.study.domain.Store;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, String type);
}