package umc.springstart.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springstart.domain.Member;
import umc.springstart.domain.Mission;
import umc.springstart.domain.enums.MissionStatus;
import umc.springstart.domain.mapping.MemberMission;
import umc.springstart.repository.MemberRepository.MemberRepository;
import umc.springstart.repository.MissionRepository.MissionRepository;
import umc.springstart.web.dto.MissionDTO.MissionRequestDTO;
import umc.springstart.repository.MemberMissionRepository;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public MemberMission challengeMission(Long missionId, MissionRequestDTO.ChallengeMissionDTO request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found with ID: " + request.getMemberId())); // 적절한 예외 처리 (MemberHandler 등 사용)

        Mission mission = missionRepository.findById(missionId) // missionId는 컨트롤러에서 넘어옴
                .orElseThrow(() -> new RuntimeException("Mission not found with ID: " + missionId)); // 적절한 예외 처리 (MissionHandler 등 사용)


        MemberMission newMemberMission = MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .build();


        newMemberMission.setMember(member);
        newMemberMission.setMission(mission);

        MemberMission savedMemberMission = memberMissionRepository.save(newMemberMission);

        return savedMemberMission;
    }

}

