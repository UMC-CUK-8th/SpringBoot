package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.FoodsExistValidator;
import umc.spring.validation.validator.GreaterThanZeroValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = GreaterThanZeroValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface GreaterThanZero {
    String message() default "양수여야합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
