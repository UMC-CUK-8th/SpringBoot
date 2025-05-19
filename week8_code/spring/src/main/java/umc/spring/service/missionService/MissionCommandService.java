package umc.spring.service.missionService;

import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.UserRequestDTO;

public interface MissionCommandService {
    Mission joinMission(MissionRequestDTO.JoinDTO mission);
}
