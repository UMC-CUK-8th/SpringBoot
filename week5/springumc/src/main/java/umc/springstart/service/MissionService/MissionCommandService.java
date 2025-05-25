package umc.springstart.service.MissionService;

import umc.springstart.domain.mapping.MemberMission;
import umc.springstart.web.dto.MissionDTO.MissionRequestDTO;

public interface MissionCommandService {
    MemberMission challengeMission(Long missionId, MissionRequestDTO.ChallengeMissionDTO request);
}
