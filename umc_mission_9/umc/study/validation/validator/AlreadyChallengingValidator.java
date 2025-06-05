package umc.study.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.UserMissionPointCounterHandler;
import umc.study.domain.enums.Statuses;
import umc.study.dto.usermissionpointcounterDTO.UserMissionPointCounterRequestDTO;
import umc.study.repository.UserMemberPointcounterRepository.UmpRepository;
import umc.study.validation.annotation.AlreadyChallenging;

@Component
@RequiredArgsConstructor
public class AlreadyChallengingValidator implements ConstraintValidator<AlreadyChallenging, UserMissionPointCounterRequestDTO.JoinDTO> {
    //isValid함수에서 검증 대상인 List<Long> 의 값을 가진 카테고리가 모두 데이터베이스에 있는 지를 판단하고
    // 없을 경우 false를 반환
    //지금처럼 단일 필드(Integer)를 검증하는 대신, 전체 DTO(JoinDTO) 를 대상으로 검증하도록 설계를 바꾸는 게 가장 안정적이고 안전합니다.
    private final UmpRepository umpRepository;
    @Override
    public void initialize(AlreadyChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    @Override
    public boolean isValid(UserMissionPointCounterRequestDTO.JoinDTO requested, ConstraintValidatorContext context) {
        //UserMissionCounterDTO상 statuses값이 없으면 기본 0으로 설정됨
        //예상으로는 statuses값이 없어도 상관이 없을 것 같다
        //if (requested.getStatuses() == 0 || requested.getMissionId() == null) return true;

        if (requested == null) {return true;}

        Statuses statusEnum;
        switch (requested.getStatuses()){
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
        //추가로 memberId와 missionId도 접근 가능!
        if (statusEnum == Statuses.challenging) {
            boolean alreadyExists = umpRepository.existsByMember_MemberIdAndMission_MissionIdAndStatus(
                    requested.getMemberId(), requested.getMissionId(), Statuses.challenging
            );

            if (alreadyExists) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(ErrorStatus.ALREADY_CHALLENGED.toString()).addConstraintViolation();
                return false;
            }


        }

        return true;
    }

}
