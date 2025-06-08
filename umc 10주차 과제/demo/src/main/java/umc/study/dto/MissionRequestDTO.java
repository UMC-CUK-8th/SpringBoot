package umc.study.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.validation.annotation.ChallengedMission;
import umc.study.validation.annotation.ExistMarket;

public class MissionRequestDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AddMissionRequest {
        @NotNull
        @ExistMarket
        private Long marketId;
        @NotNull
        private Long missionId;

        @NotNull
        private String missionName;

        @NotNull
        private String marketName;

        @NotBlank
        private String description;

        @NotNull
        private Integer repair;

    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ChallengedMission
    // 필드 단에서 상태를 입력받으면 db상에서 관리되어야 할 status가 외부 입력으로 변경될 수 있기 때문에 class 단위 어노테이션으로 검증해야 ㅎㅁ
    public static class ChallengeMissionRequest {
        @NotNull
        private Long userId;
        @NotNull
        private Long missionId;
    }


}
