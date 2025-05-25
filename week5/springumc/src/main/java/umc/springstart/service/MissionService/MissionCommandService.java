package umc.springstart.service.MissionService;

import umc.springstart.domain.Mission;
import umc.springstart.domain.mapping.MemberMission;
import umc.springstart.web.dto.MissionDTO.MissionRequestDTO;

public interface MissionCommandService {
    MemberMission challengeMission(Long missionId, MissionRequestDTO.ChallengeMissionDTO request);

    Mission addMission(Long storeId, MissionRequestDTO.AddMissionDTO request);
}
