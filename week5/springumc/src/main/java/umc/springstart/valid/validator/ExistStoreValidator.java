package umc.springstart.valid.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.springstart.repository.StoreRepository.StoreRepository;
import umc.springstart.valid.annotation.ExistStore;

@Component
@RequiredArgsConstructor
public class ExistStoreValidator implements ConstraintValidator<ExistStore, Long> {
    private final StoreRepository storeRepository;

    @Override
    public void initialize(ExistStore constraintAnnotation) {
        // 어노테이션의 설정값을 초기화할 내용이 있다면 여기에 작성
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {

        if (storeId == null) {
            return false;
        }
        boolean isValid = storeRepository.existsById(storeId);

        return isValid;
    }
}