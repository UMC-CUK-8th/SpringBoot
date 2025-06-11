package umc.study.service.UserMissionPointCounter;

import umc.study.domain.mapping.UserMissionPointcounter;
import umc.study.dto.usermissionpointcounterDTO.UserMissionPointCounterRequestDTO;

public interface UserMissionPointCounterCommandService {
    UserMissionPointcounter joinUserMissionPointCounter(UserMissionPointCounterRequestDTO.JoinDTO request);
}
