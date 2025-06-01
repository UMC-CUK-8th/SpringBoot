package umc.springstart.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springstart.converter.MemberMissionConverter;
import umc.springstart.domain.Mission;
import umc.springstart.domain.enums.MissionStatus;
import umc.springstart.domain.mapping.MemberMission;
import umc.springstart.repository.MissionRepository.MissionRepository;
import umc.springstart.repository.MissionRepository.MemberMissionRepository;
import umc.springstart.repository.MemberRepository.MemberRepository;
import umc.springstart.web.dto.MissionDTO.MissionResponseDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

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

    @Override
    public MissionResponseDTO.MyChallengingMissionListDTO getMyChallengingMissions(Long memberId, Integer page) {

        Pageable pageable = PageRequest.of(page - 1, 10);

        Page<MemberMission> memberMissionPage = memberMissionRepository.findByMemberIdAndStatus(memberId, MissionStatus.CHALLENGING, pageable);

        return MemberMissionConverter.toMyChallengingMissionListDTO(memberMissionPage);
    }
}
