package umc.study.validation.annotation;

import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
// Validator를 구현하지 않음. 대신 resolver가 그 자리를 대체함
public @interface ValidPage {
    String message() default "페이지 번호가 유효하지 않습니다. ";

}
