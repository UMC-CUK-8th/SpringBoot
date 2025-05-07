package umc.study.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.StoreInfo;

public interface StoreRepository extends JpaRepository<StoreInfo, Long>, StoreRepositoryCustom {
}
