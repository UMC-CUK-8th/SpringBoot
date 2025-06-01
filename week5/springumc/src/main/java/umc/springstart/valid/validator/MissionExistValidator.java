package umc.springstart.valid.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.springstart.repository.MissionRepository.MissionRepository;
import umc.springstart.valid.annotation.ExistMission;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMission, Long> {
    private final MissionRepository missionRepository;

    @Override
    public void initialize(ExistMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        boolean isValid = missionId != null && missionRepository.existsById(missionId);

        if (!isValid) {
             context.disableDefaultConstraintViolation();
             context.buildConstraintViolationWithTemplate("미션이 존재하지 않습니다 ").addConstraintViolation();
        }

        return isValid;
    }
}
