package umc.springstart.valid.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.springstart.valid.validator.CategoriesExistValidator;

import java.lang.annotation.*;

@Documented  //사용자 정의 어노테이션만들때 붙임
@Constraint(validatedBy = CategoriesExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })//어노테이션 적용범위 지정
@Retention(RetentionPolicy.RUNTIME) //생명주기 지정
public @interface ExistCategories {

    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
