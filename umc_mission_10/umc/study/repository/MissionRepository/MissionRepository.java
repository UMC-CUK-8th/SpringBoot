package umc.study.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Mission;
import umc.study.domain.StoreInfo;
import umc.study.domain.mapping.Review;

public interface MissionRepository extends JpaRepository<Mission, Long>,MissionRepositoryCustom {
    //찾아오려는 데이터의 데이터타입의 레포지토리에 아래처럼 설정을 해야한다
    Page<Mission> findAllByStoreInfo(StoreInfo storeInfo, PageRequest pageRequest);
}
