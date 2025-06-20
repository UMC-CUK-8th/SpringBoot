package umc.spring.service.userService;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.exception.handler.UserHandler;
import umc.spring.converter.UserConverter;
import umc.spring.domain.User;
import umc.spring.repository.userRepository.UserRepository;
import umc.spring.web.dto.UserResponseDTO;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.config.security.jwt.JwtTokenProvider;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl  implements UserQueryService{

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional(readOnly = true)
    public UserResponseDTO.UserInfoDTO getUserInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(()-> new UserHandler(ErrorStatus.USER_NOT_FOUND));
        return UserConverter.toMemberInfoDTO(user);
    }
}
