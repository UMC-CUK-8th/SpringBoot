package umc.study.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.apiPayload.exception.handler.UserHandler;
import umc.study.config.security.jwt.JwtTokenProvider;
import umc.study.converter.UserConverter;
import umc.study.converter.UserPreferConverter;
import umc.study.domain.FoodCategory;
import umc.study.domain.User;
import umc.study.domain.mapping.UserPrefer;
import umc.study.repository.FoodRepository.FoodCategoryRepository;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.web.dto.UserRequestDto;
import umc.study.web.dto.UserResponseDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository ;
    private final PasswordEncoder passwordEncoder ;

    private final FoodCategoryRepository foodCategoryRepository ;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public User joinUser(umc.study.dto.UserRequestDTO.JoinDTO request){

        User newUser= UserConverter.toUser(request);

        // 비밀번호를 암호화하여 저장하기 위함
        newUser.encodePassword(passwordEncoder.encode(request.getPassword()));

        List<FoodCategory> foodCategoryList=request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(()-> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<UserPrefer> userPreferList = UserPreferConverter.toUserPreferenceList(foodCategoryList);

        userPreferList.forEach(userPrefer -> {userPrefer.setUser(newUser);});


        return userRepository.save(newUser);
    }

    @Override
    public UserResponseDto.LoginResultDTO loginUser(UserRequestDto.LoginRequestDTO request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new UserHandler(ErrorStatus.USER_NOT_FOUND));
        // findbyEmail로 회원이 존재하는지 확인

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new UserHandler(ErrorStatus.INVALID_PASSWORD);
        }
        // 패스워드가 일치하는지 확인

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user.getEmail(), null,
                Collections.singleton(() -> user.getRole().name())
        );

        // Authentication 객체를 만들어서 jwt 토큰 발급
        // 근데 이거 다형성 적용이 안 된 것 같은데
        // import문제였음

        String accessToken = jwtTokenProvider.generateToken(authentication);

        return UserConverter.toLoginResultDTO(
                user.getId(),
                accessToken
        );
    }


}
