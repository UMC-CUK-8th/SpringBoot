package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.validation.annotation.ExistMembers;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MembersExistValidator implements ConstraintValidator<ExistMembers, Long> {

    private final MemberRepository memberRepository;

    @Override
    public void initialize(ExistMembers constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    //아래 isVaild 클래스를 구현함으로 어노테이션 기능을 구체화 할 수 있다.
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean exists = memberRepository.existsById(value);

        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
        }
//위의 코드를 보면 isValid함수에서 검증 대상인 List<Long> 의 값을 가진
// 카테고리가 모두 데이터베이스에 있는 지를 판단하고 없을 경우 false를 반환합니다
        return exists;
    }


}
