package umc.study.service.MissionService;

import umc.study.ApiMission3.code.MissionRequestDTO;
import umc.study.domain.Mission;

public interface MissionCommandService {
    Mission createMission(MissionRequestDTO request);
}