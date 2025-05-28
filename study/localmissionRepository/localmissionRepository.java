package umcstudy.study.localmissionRepository;

import umcstudy.study.domain.mapping.locationbonusmission;
import umcstudy.study.localmissionRepository.localmissionRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;


public interface localmissionRepository extends JpaRepository<locationbonusmission, Long>, localmissionRepositoryCustom {
}