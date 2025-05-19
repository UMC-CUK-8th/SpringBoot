package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.apiPayload.exception.handler.UserHandler;
import umc.spring.converter.UserConverter;
import umc.spring.domain.Food;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserMission;
import umc.spring.repository.foodRepository.FoodRepository;

import umc.spring.repository.missionRepository.MissionRepository;
import umc.spring.repository.userMissionRepository.UserMissionRepository;
import umc.spring.repository.userRepository.UserRepository;
import umc.spring.validation.annotation.IsChallenging;

import java.util.List;

import static umc.spring.domain.enums.MissionStatus.CHALLENGING;


@Component
@RequiredArgsConstructor
public class IsChallengingValidator implements ConstraintValidator<IsChallenging,List<Long>> {

    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;
    private final MissionRepository missionRepository;

    @Override
    public void initialize(IsChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {

        Boolean isValid = null;
        Long userId = values.get(0);
        System.out.println("userId = " + userId);
        Long missionId = values.get(1);
        System.out.println("missionId = " + missionId);

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        List<UserMission> userMissionList = mission.getUserMissionList();
        System.out.println("userMissionList = " + userMissionList);
        for (UserMission userMission : userMissionList) {
            if (userMission.getUser().getId().equals(userId)) {
                if (userMission.getStatus() == CHALLENGING) {
                    isValid = false;
                }
            }
        }
        System.out.println("isValid" + isValid);


        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.ALREADY_CHALLENGING.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
