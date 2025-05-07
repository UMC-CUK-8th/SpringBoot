package umc.springstart.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.springstart.domain.Mission;
import umc.springstart.domain.enums.MissionStatus;

import java.util.Optional;

public interface MissionQueryService {
    Optional<Mission> findMission(Long id);
    Page<Mission> findMissionsByMemberIdAndMissionStatus(Long memberId, MissionStatus missionStatus, Pageable pageable);
}
