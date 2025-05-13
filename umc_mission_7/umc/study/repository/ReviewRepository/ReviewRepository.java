package umc.study.repository.ReviewRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.StoreInfo;

//서비스단에서 사용됨
public interface ReviewRepository extends JpaRepository<StoreInfo, Long>, ReviewRepositoryCustom {
}
