package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.Mission;
import umc.study.domain.enums.Status;
import umc.study.validation.annotation.ChallengedMission;


@Component
@RequiredArgsConstructor
public class ChallengedMissionValidator implements ConstraintValidator<ChallengedMission, Object> {

    private final ValidatorService validatorService;



    @Override
    public void initialize(ChallengedMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        BeanWrapper beanWrapper = new BeanWrapperImpl(value);
        Long userId=(Long) beanWrapper.getPropertyValue("userId");
        Long missionId=(Long) beanWrapper.getPropertyValue("missionId");

        if (userId==null || missionId==null) {
            return true;
        }

        boolean isValid = validatorService.validateMissionStatus(userId,missionId, Status.BEFORE_START);

        if (!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_STATUS_IS_NOT_BEFORE_START.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
