package umc.study.dto.usermissionpointcounterDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.study.validation.annotation.AlreadyChallenging;

import java.util.List;


public class UserMissionPointCounterRequestDTO {

    @Getter
    @AlreadyChallenging
    public static class JoinDTO{
        //List형태가 아니라 int 형식으로 받았기에 하나의 값만 가진다
        @NotNull
        private int statuses;//enum을 활용하기 위해서 int로 설정 gender와 마찬가지다.
        @NotNull(message = "missionId는 필수입니다.")
        private Long missionId;//해당 미션 아이디를 확인하는 용도
        @NotNull(message = "memberId는 필수입니다.")
        private Long memberId;//해당 멤버 아이디를 확인하는 용도
    }
}
