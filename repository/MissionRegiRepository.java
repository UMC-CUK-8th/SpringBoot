package umcstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcstudy.study.domain.Missions;

import java.util.Optional;

public interface MissionRegiRepository extends JpaRepository<Missions, Long> {
    Optional<Missions> findByMissionname(String missionname);
}