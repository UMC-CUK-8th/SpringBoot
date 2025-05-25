package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.foodRepository.FoodRepository;
import umc.spring.repository.missionRepository.MissionRepository;
import umc.spring.validation.annotation.ExistFoods;
import umc.spring.validation.annotation.ExistMissions;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MissionsExistValidator implements ConstraintValidator<ExistMissions, Long> {
    private final MissionRepository missionRepository;

    @Override
    public void initialize(ExistMissions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        boolean isValid = missionRepository.existsById(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
