package umc.study.service.UserService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import umc.study.domain.User;
import umc.study.dto.UserDTO;
import umc.study.dto.UserResponseDTO;
import umc.study.web.dto.UserResponseDto;

import java.util.List;

public interface UserQueryService {
    UserDTO myPageHome(Long id);


    UserResponseDto.UserInfoDTO getUserInfo(HttpServletRequest request);
}
