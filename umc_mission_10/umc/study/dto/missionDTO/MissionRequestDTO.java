package umc.study.dto.missionDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.ExistStores;

public class MissionRequestDTO {

    @Getter
    public static class JoinDTO{
        @NotBlank
        private String missionName;
        @NotBlank
        private String missionDetail;
        @NotNull
        private int reward;
        @ExistStores
        private Long storeId;

    }
}
