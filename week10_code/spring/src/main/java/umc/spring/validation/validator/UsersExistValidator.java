package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.foodRepository.FoodRepository;
import umc.spring.repository.userRepository.UserRepository;
import umc.spring.validation.annotation.ExistFoods;
import umc.spring.validation.annotation.ExistUsers;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsersExistValidator implements ConstraintValidator<ExistUsers, Long> {
    private final UserRepository userRepository;

    @Override
    public void initialize(ExistUsers constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = userRepository.existsById(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.USER_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
