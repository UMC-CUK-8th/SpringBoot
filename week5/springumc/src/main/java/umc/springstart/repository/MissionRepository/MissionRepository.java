package umc.springstart.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springstart.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long>,MissionRepositoryCustom {
}
