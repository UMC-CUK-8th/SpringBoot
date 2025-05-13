package umc.study.service.UserService;

import umc.study.domain.User;
import umc.study.dto.UserDTO;

import java.util.List;

public interface UserQueryService {
    UserDTO myPageHome(Long id);
}
