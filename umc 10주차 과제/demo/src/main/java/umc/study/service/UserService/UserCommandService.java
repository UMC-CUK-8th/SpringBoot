package umc.study.service.UserService;

import umc.study.domain.User;
import umc.study.dto.UserRequestDTO;
import umc.study.web.dto.UserRequestDto;
import umc.study.web.dto.UserResponseDto;

public interface UserCommandService {
    User joinUser(UserRequestDTO.JoinDTO request);
    UserResponseDto.LoginResultDTO loginUser(UserRequestDto.LoginRequestDTO request);
}
