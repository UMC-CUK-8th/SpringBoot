package umc.spring.repository.userMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.UserMission;

import java.util.List;

public interface UserMissionRepository extends JpaRepository <UserMission, Long> {
    boolean existsByUserIdAndMissionIdAndStatus(Long userId, Long missionId, MissionStatus status);
    Page<UserMission> findAllByUserIdAndStatus(Long userId, MissionStatus status, PageRequest pageRequest);

}
