package umcstudy.study.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umcstudy.study.MissionRepository.MissionRepositoryCustom;
import umcstudy.study.domain.Members;
import umcstudy.study.domain.Missions;
import org.springframework.data.jpa.repository.JpaRepository;
import umcstudy.study.domain.Store;
import umcstudy.study.domain.mapping.Reviews;


public interface MissionRepository extends JpaRepository<Missions, Long>, MissionRepositoryCustom {
    Page<Missions> findAllByStore(Store store, PageRequest pageRequest);

}