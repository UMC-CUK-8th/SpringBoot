package umcstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcstudy.study.domain.Missions;
import umcstudy.study.domain.Store;
import umcstudy.study.domain.mapping.Usermissions;

import java.util.Optional;

public interface UsermissionRegiRepository extends JpaRepository<Usermissions, Long> {
    Optional<Usermissions> findByStoreAndMissions(Store store, Missions missions);

}
