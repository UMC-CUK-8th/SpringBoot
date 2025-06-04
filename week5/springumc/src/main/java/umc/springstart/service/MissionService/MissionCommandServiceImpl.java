package umc.springstart.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springstart.converter.MemberMissionConverter;
import umc.springstart.converter.StoreMissionConverter;
import umc.springstart.domain.Member;
import umc.springstart.domain.Mission;
import umc.springstart.domain.Store;
import umc.springstart.domain.enums.MissionStatus;
import umc.springstart.domain.mapping.MemberMission;
import umc.springstart.exception.MemberMissionNotFoundException;
import umc.springstart.repository.MemberRepository.MemberRepository;
import umc.springstart.repository.MissionRepository.MissionRepository;
import umc.springstart.web.dto.MissionDTO.MissionRequestDTO;
import umc.springstart.repository.MissionRepository.MemberMissionRepository;
import umc.springstart.repository.StoreRepository.StoreRepository;
import umc.springstart.web.dto.MissionDTO.MissionResponseDTO;
import umc.springstart.apiPayload.code.status.ErrorStatus;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public MissionResponseDTO.ChallengeResultDTO challengeMission(Long missionId, MissionRequestDTO.ChallengeMissionDTO missionchallengeReq) {
        Member member = memberRepository.findById(missionchallengeReq.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found with ID: " + missionchallengeReq.getMemberId())); // 적절한 예외 처리 (MemberHandler 등 사용)

        Mission mission = missionRepository.findById(missionId) // missionId는 컨트롤러에서 넘어옴
                .orElseThrow(() -> new RuntimeException("Mission not found with ID: " + missionId)); // 적절한 예외 처리 (MissionHandler 등 사용)


        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(missionchallengeReq, member, mission);
        MemberMission savedMemberMission = memberMissionRepository.save(newMemberMission);

        return  MemberMissionConverter.toChallengeResultDTO(savedMemberMission);
    }

    @Override
    @Transactional
    public MissionResponseDTO.AddMissionResultDTO addMission(Long storeId, MissionRequestDTO.AddMissionDTO addmissionReq) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found with ID: " + storeId));
        Mission newMission = StoreMissionConverter.toMission(addmissionReq, store);
        Mission savedMission = missionRepository.save(newMission);
        return StoreMissionConverter.toAddMissionResultDTO(savedMission);
    }

    @Override
    @Transactional
    public MissionResponseDTO.CompleMyMissionItemDTO completeMemberMission(Long memberId, Long missionId){
        MemberMission memberMission = memberMissionRepository.findByMemberIdAndMissionIdAndStatus(memberId, missionId, MissionStatus.CHALLENGING)
                .orElseThrow(() -> new MemberMissionNotFoundException(ErrorStatus.MEMBER_MISSION_NOT_FOUND));

        memberMission.setStatus(MissionStatus.COMPLETE);

        return MemberMissionConverter.toCompleMyMissionItemDTO(memberMission);
    }

}

