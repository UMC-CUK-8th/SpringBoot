package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.FoodsExistValidator;
import umc.spring.validation.validator.UsersExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UsersExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistUsers {

    String message() default "해당하는 사용자가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
