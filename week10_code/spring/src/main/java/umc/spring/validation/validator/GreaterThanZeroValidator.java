package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.userRepository.UserRepository;
import umc.spring.validation.annotation.ExistFoods;
import umc.spring.validation.annotation.ExistUsers;
import umc.spring.validation.annotation.GreaterThanZero;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GreaterThanZeroValidator implements ConstraintValidator<GreaterThanZero, Integer> {

    private final UserRepository userRepository;

    @Override
    public void initialize(GreaterThanZero constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
       boolean isValid = (value>0);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.INVALID_PAGE_NUMBER.toString()).addConstraintViolation();
        }
        else {
            value-=1;
        }

        return isValid;

    }
}
