package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.MarketRepository.MarketRepository;
import umc.study.validation.annotation.ExistMarket;

@Component
@RequiredArgsConstructor
public class MarketExistValidator  implements ConstraintValidator<ExistMarket, Long> {

    private final MarketRepository marketRepository;

    @Override
    public void initialize(ExistMarket constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = marketRepository.existsById(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MARKET_NOT_FOUND.toString())
                    .addConstraintViolation();
        }
        return isValid;
    }


}
