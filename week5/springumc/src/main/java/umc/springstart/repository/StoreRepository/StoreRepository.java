package umc.springstart.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springstart.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}