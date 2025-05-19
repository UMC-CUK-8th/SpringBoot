package umc.study.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.converter.UserConverter;
import umc.study.converter.UserPreferConverter;
import umc.study.domain.FoodCategory;
import umc.study.domain.User;
import umc.study.domain.mapping.UserPrefer;
import umc.study.dto.UserRequestDTO;
import umc.study.repository.FoodRepository.FoodCategoryRepository;
import umc.study.repository.UserRepository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository ;

    private final FoodCategoryRepository foodCategoryRepository ;
    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDTO request){

        User newUser= UserConverter.toUser(request);
        List<FoodCategory> foodCategoryList=request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(()-> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<UserPrefer> userPreferList = UserPreferConverter.toUserPreferenceList(foodCategoryList);

        userPreferList.forEach(userPrefer -> {userPrefer.setUser(newUser);});


        return userRepository.save(newUser);
    }
}
