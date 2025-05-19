package umc.spring.repository.userMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.UserMission;

public interface UserMissionRepository extends JpaRepository <UserMission, Long> {
}
