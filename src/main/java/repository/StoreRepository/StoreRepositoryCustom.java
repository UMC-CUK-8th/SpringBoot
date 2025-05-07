package repository.StoreRepository;

import org.example.study.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, String type);
}