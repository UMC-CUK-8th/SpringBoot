package umcstudy.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umcstudy.apiPayload.code.status.ErrorStatus;
import umcstudy.repository.LocationRegiRepository;
import umcstudy.validation.annotation.ExistLocation;
import umcstudy.validation.annotation.ExistPage;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PageExistValidator implements ConstraintValidator<ExistPage, Integer> {


    @Override
    public boolean isValid(Integer values, ConstraintValidatorContext context) {
        if (values == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        if (values <= 0){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
