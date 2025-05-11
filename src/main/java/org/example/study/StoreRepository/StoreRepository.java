package org.example.study.StoreRepository;
import org.example.study.domain.Store;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

@Bean
public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}