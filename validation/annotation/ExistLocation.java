package umcstudy.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umcstudy.validation.validator.LocationExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LocationExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistLocation {

    String message() default "해당하는 지역이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
