package umc.study.service.MissionService;

import umc.study.dto.MissionRequestDTO;

public interface MissionCommandService {
    Long addMission(MissionRequestDTO.AddMissionRequest request);
}
