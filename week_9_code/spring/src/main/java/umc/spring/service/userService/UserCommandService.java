package umc.spring.service.userService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.web.dto.UserRequestDTO;

public interface UserCommandService {

    User joinUser(UserRequestDTO.JoinDTO request);

}
