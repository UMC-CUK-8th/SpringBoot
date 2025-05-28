package umcstudy.study.StoreRepository;

import umcstudy.study.StoreRepository.StoreRepositoryCustom;
import umcstudy.study.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
    Optional<Store> findByStorename(String storename);
}