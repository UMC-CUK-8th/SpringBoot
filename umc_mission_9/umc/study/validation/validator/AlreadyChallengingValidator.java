package umc.study.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.UserMissionPointCounterHandler;
import umc.study.domain.enums.Statuses;
import umc.study.repository.UserMemberPointcounterRepository.UmpRepository;
import umc.study.validation.annotation.AlreadyChallenging;

@Component
@RequiredArgsConstructor
public class AlreadyChallengingValidator implements ConstraintValidator<AlreadyChallenging, Integer> {
    //isValid함수에서 검증 대상인 List<Long> 의 값을 가진 카테고리가 모두 데이터베이스에 있는 지를 판단하고
    // 없을 경우 false를 반환
    private final UmpRepository umpRepository;
    @Override
    public void initialize(AlreadyChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    @Override
    public boolean isValid(Integer requested, ConstraintValidatorContext context) {
        //UserMissionCounterDTO상 statuses값이 없으면 기본 0으로 설정됨
        //예상으로는 statuses값이 없어도 상관이 없을 것 같다
        //if (requested.getStatuses() == 0 || requested.getMissionId() == null) return true;

        if (requested == null) {return true;}

        Statuses statusEnum;
        switch (requested){
            case 1:
                statusEnum = Statuses.challenging;
                break;
            case 2:
                statusEnum = Statuses.completed;
                break;
            case 3:
                statusEnum = Statuses.nonstart;
                break;
            default: throw new UserMissionPointCounterHandler(ErrorStatus.STATUSES_CATEGORY_NOT_FOUND);
        }

        // 예: Statuses.completed 일 때만 검사
        if (statusEnum == Statuses.challenging) {

                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(ErrorStatus.ALREADY_CHALLENGED.toString()).addConstraintViolation();
                return false;

        }

        return true;
    }

}
