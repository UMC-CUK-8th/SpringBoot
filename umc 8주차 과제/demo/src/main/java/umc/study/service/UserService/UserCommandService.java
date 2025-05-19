package umc.study.service.UserService;

import umc.study.domain.User;
import umc.study.dto.UserRequestDTO;

public interface UserCommandService {
    User joinUser(UserRequestDTO.JoinDTO request);
}
