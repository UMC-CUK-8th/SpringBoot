package umc.springstart.converter;

import umc.springstart.domain.mapping.MemberMission;
import umc.springstart.web.dto.MissionDTO.MissionResponseDTO;

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

    // 필요하다면 요청 DTO -> MemberMission 엔티티 변환 메소드 추가 가능
    // public static MemberMission toMemberMission(MissionRequestDTO.ChallengeMissionDTO request) { ... }
}