package umcstudy.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umcstudy.validation.annotation.ExistStore;


public class ReviewRequestDTO {

    @Getter
    public static class RevJoinDto{
        @NotBlank
        String text;

        @NotNull
        int reviewstar;

        @ExistStore
        private Long storeId;
    }
}
