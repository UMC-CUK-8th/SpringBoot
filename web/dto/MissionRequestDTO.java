package umcstudy.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umcstudy.validation.annotation.ExistStore;


public class MissionRequestDTO {

    @Getter
    public static class MissionDto{

        @ExistStore
        private Long storeId;

        @NotNull
        private Long missionId;

        @NotBlank
        String missionname;




    }
}

