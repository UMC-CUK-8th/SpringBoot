package umcstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcstudy.study.domain.Store;

public interface StoreRegiRepository extends JpaRepository<Store, Long> {
}