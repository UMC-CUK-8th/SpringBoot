package umc.springstart.valid.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.springstart.repository.MemberRepository.MemberRepository;
import umc.springstart.valid.annotation.ExistMember;

@Component
@RequiredArgsConstructor
public class ExistMemberValidator implements ConstraintValidator<ExistMember, Long> {
    private final MemberRepository memberRepository;

    @Override
    public void initialize(ExistMember constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(Long memberId, ConstraintValidatorContext context) {
        boolean isValid = memberId != null && memberRepository.existsById(memberId);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("해당하는 유저가 존재하지 않습니다.").addConstraintViolation();
        }
        return isValid;
    }
}
