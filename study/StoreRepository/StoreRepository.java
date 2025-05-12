package org.example.study.StoreRepository;

import org.example.study.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
    Optional<Store> findByStorename(String storename);
}