package umc.springstart.service.MissionService;

import umc.springstart.web.dto.MissionDTO.MissionRequestDTO;
import umc.springstart.web.dto.MissionDTO.MissionResponseDTO;

public interface MissionCommandService {
    MissionResponseDTO.ChallengeResultDTO challengeMission(Long missionId, MissionRequestDTO.ChallengeMissionDTO request);

    MissionResponseDTO.AddMissionResultDTO addMission(Long storeId, MissionRequestDTO.AddMissionDTO request);

    MissionResponseDTO.CompleMyMissionItemDTO completeMemberMission(Long memberId, Long missionId);
}
