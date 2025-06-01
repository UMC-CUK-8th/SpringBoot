package umc.springstart.converter;

import org.springframework.data.domain.Page;
import umc.springstart.domain.Member;
import umc.springstart.domain.Mission;
import umc.springstart.domain.enums.MissionStatus;
import umc.springstart.domain.mapping.MemberMission;
import umc.springstart.web.dto.MissionDTO.MissionRequestDTO;
import umc.springstart.web.dto.MissionDTO.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    // MemberMission 엔티티를 ChallengeResultDTO로 변환
    public static MissionResponseDTO.ChallengeResultDTO toChallengeResultDTO(MemberMission memberMission) {
        return MissionResponseDTO.ChallengeResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionId(memberMission.getMission().getId()) // MemberMission에서 Mission 객체 가져와서 ID 추출
                .memberId(memberMission.getMember().getId()) // MemberMission에서 Member 객체 가져와서 ID 추출
                .status(memberMission.getStatus())
                .challengedAt(memberMission.getCreatedAt()) // BaseEntity에서 상속받은 생성 시간
                .build();
    }

    public static MemberMission toMemberMission(
            MissionRequestDTO.ChallengeMissionDTO request,
            Member member,
            Mission mission) {

        MemberMission memberMission = MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .build();

        memberMission.setMember(member);
        memberMission.setMission(mission);

        return memberMission;
    }

    public static MissionResponseDTO.MyChallengingMissionItemDTO toMyChallengingMissionItemDTO(MemberMission memberMission) {
        Mission mission = memberMission.getMission();
        String storeName = (mission.getStore() != null) ? mission.getStore().getName() : "N/A";

        return MissionResponseDTO.MyChallengingMissionItemDTO.builder()
                .missionId(mission.getId())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .storeName(storeName)
                .missionSpec(mission.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.MyChallengingMissionListDTO toMyChallengingMissionListDTO(Page<MemberMission> memberMissionPage) {

        List<MissionResponseDTO.MyChallengingMissionItemDTO> missionItemDTOList = memberMissionPage.stream()
                .map(MemberMissionConverter::toMyChallengingMissionItemDTO)
                .collect(Collectors.toList());

        return MissionResponseDTO.MyChallengingMissionListDTO.builder()
                .missionList(missionItemDTOList)
                .build();
    }


}