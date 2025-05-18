package umc.study.service.UserService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.User;
import umc.study.dto.UserDTO;
import umc.study.repository.UserRepository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;
    @Override
    public UserDTO myPageHome(Long id) {
        User user = userRepository.findByUserId(id);

        return UserDTO.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .point(user.getPoint().getPoint())
                .build();
    }
}
