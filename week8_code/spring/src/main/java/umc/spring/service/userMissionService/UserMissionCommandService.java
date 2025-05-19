package umc.spring.service.userMissionService;

import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.UserMissionRequestDTO;

public interface UserMissionCommandService {
    UserMission createUserMission(UserMissionRequestDTO.JoinDTO request);
}
