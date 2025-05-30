package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.validation.annotation.NonZeroPage;

@Component
@RequiredArgsConstructor
public class NonZeroPageValidator implements ConstraintValidator<NonZeroPage, Integer > {

    @Override
    public void initialize(NonZeroPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context){
        Integer pageStart = 1;
        if(value < pageStart){
            return false;
        }
        else {
            return true;
        }
    }
}
