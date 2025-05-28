package umcstudy.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umcstudy.validation.validator.PageExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistPage {

    String message() default "페이지는 '1' 이상 입력해야합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
