package umc.spring.service.userService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodHandler;
import org.springframework.security.core.Authentication;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.apiPayload.exception.handler.UserHandler;
import umc.spring.config.security.jwt.JwtTokenProvider;
import umc.spring.converter.UserConverter;
import umc.spring.converter.UserFoodConverter;
import umc.spring.domain.Food;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserFood;
import umc.spring.repository.foodRepository.FoodRepository;
import umc.spring.repository.reviewRepository.ReviewRepository;
import umc.spring.repository.userRepository.UserRepository;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService{

    private final UserRepository userRepository;
    private final FoodRepository foodRepository;
    private final ReviewRepository reviewRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDTO request) {

        User newUser = UserConverter.toUser(request);
        newUser.encodePassword(passwordEncoder.encode(request.getPassword()));
        List<Food> foodList = request.getUserFoodList().stream()
                .map(food -> foodRepository.findById(food).orElseThrow(() -> new FoodHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND))).collect(Collectors.toList());

        List<UserFood> userFoodList = UserFoodConverter.toUserFoodList(foodList);

        userFoodList.forEach(userFood -> userFood.setUser(newUser));

        return userRepository.save(newUser);
    }

    @Override
    @Transactional
    public UserResponseDTO.LoginResultDTO loginUser(UserRequestDTO.LoginRequestDTO request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new  UserHandler(ErrorStatus.USER_NOT_FOUND));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new  UserHandler(ErrorStatus.INVALID_PASSWORD);
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user.getEmail(), null,
                Collections.singleton(() -> user.getRole().name())
        );

        String accessToken = jwtTokenProvider.generateToken(authentication);

        return  UserConverter.toLoginResultDTO(
                user.getId(),
                accessToken
        );
    }

}



