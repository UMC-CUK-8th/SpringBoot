package umc.springstart.repository.MissionRepository;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import umc.springstart.domain.Mission;
import umc.springstart.domain.enums.MissionStatus;

public interface MissionRepositoryCustom {
    PageImpl<Mission> findByUserIdAndMissionStatus(Long user_id, MissionStatus missionStatus, Pageable pageable);
}