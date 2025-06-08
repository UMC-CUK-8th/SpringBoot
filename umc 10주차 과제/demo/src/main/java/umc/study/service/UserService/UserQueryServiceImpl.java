package umc.study.service.UserService;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.UserHandler;
import umc.study.config.security.jwt.JwtTokenProvider;
import umc.study.converter.UserConverter;
import umc.study.domain.User;
import umc.study.dto.UserDTO;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.web.dto.UserResponseDto;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

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

    @Override
    @Transactional(readOnly = true)
    public UserResponseDto.UserInfoDTO getUserInfo(HttpServletRequest request) {
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        User user=userRepository.findByEmail(email)
                .orElseThrow(()-> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        return UserConverter.toUserInfoDTO(user);
        // 왜 컨버터로 반환하는지? 컨버터에는 toUserInfoDTO가 없음
    }
}
