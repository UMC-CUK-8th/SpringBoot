package umc.springstart.web.dto.MissionDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MissionRequestDTO {
    @Getter
    public static class ChallengeMissionDTO{
        @NotNull
        private Long memberId;

    }
}
