package umc.spring.service.userMissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.UserMissionRequestDTO;

public interface UserMissionCommandService {
    UserMission createUserMission(UserMissionRequestDTO.JoinDTO request);
    Page<UserMission> getChallengingMissionList(Long userId, Integer page);
}
