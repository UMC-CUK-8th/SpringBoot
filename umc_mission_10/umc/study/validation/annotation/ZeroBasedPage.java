package umc.study.validation.annotation;

import java.lang.annotation.*;

@Documented
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ZeroBasedPage {
    String message() default "페이지 번호는 1 이상이여야 합니다.";
}