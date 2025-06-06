package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.validation.annotation.ExistMissions;
import umc.spring.validation.annotation.ExistUsers;
import umc.spring.validation.annotation.IsChallenging;

import java.time.LocalDate;
import java.util.List;

public class UserMissionRequestDTO {

    @Getter
    public static class JoinDTO {

        @IsChallenging
        List<Long> userAndMissionId;



    }
}
