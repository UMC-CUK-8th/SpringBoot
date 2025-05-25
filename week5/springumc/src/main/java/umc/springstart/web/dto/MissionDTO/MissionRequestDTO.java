package umc.springstart.web.dto.MissionDTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import org.aspectj.bridge.IMessage;

import java.time.LocalDate;

public class MissionRequestDTO {
    //미션 도전 요청 dto
    @Getter
    public static class ChallengeMissionDTO{
        @NotNull
        private Long memberId;
    }

    //가게에 미션 추가 dto
    @Getter
    public static class AddMissionDTO{
        @NotNull
        @Min(value = 1, message = "보상은 1p 이상이어야합니다")
        private Integer reward;

        @NotNull
        @Future
        private LocalDate deadline;

        @NotBlank
        @Size(min = 1, max = 100)
        private String missionSpec;

    }

}
