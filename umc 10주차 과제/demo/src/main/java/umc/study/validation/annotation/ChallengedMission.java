package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.ChallengedMissionValidator;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ChallengedMissionValidator.class)
@Documented
public @interface ChallengedMission {
    String message() default "이미 도전 중인 미션입니다.";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
