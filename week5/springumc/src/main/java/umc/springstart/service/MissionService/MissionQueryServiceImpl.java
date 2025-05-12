package umc.springstart.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springstart.domain.Mission;
import umc.springstart.domain.enums.MissionStatus;
import umc.springstart.repository.MissionRepository.MissionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public Optional<Mission> findMission(Long id) {
        return missionRepository.findById(id);
    }

    @Override
    public Page<Mission> findMissionsByMemberIdAndMissionStatus(Long memberId, MissionStatus missionStatus, Pageable pageable) {
        Page<Mission> filteredMissions = missionRepository.findByUserIdAndMissionStatus(memberId, missionStatus, pageable);
        filteredMissions.forEach(mission -> System.out.println("Mission: " + mission));
        return filteredMissions;
    }
}
