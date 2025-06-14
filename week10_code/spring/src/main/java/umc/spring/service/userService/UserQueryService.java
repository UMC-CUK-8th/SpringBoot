package umc.spring.service.userService;


import jakarta.servlet.http.HttpServletRequest;
import umc.spring.web.dto.UserResponseDTO;


import java.util.Optional;

public interface UserQueryService {

    UserResponseDTO.UserInfoDTO getUserInfo(HttpServletRequest request);
}
