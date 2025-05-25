package umcstudy.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umcstudy.apiPayload.code.status.ErrorStatus;
import umcstudy.repository.LocationRegiRepository;
import umcstudy.validation.annotation.ExistLocation;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LocationExistValidator implements ConstraintValidator<ExistLocation, Long> {

    private final LocationRegiRepository locationRegiRepository;

    @Override
    public void initialize(ExistLocation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long values, ConstraintValidatorContext context) {
        boolean isValid = locationRegiRepository.existsById(values);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.LOCATION_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}