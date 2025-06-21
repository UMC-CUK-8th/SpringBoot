package umc.study.service.MissionService;

import umc.study.domain.Mission;
import umc.study.dto.missionDTO.MissionRequestDTO;

public interface MissionCommandService {
    Mission joinMission(MissionRequestDTO.JoinDTO request);
}
