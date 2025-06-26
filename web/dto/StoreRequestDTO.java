package umcstudy.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umcstudy.validation.annotation.ExistLocation;

public class StoreRequestDTO {

    @Getter
    public static class StoJoinDto{
        @NotBlank
        String storename;
        @NotBlank
        String storeaddress;
        @NotBlank
        String storetype;
        @NotNull
        int reviewcount;
        @ExistLocation
        private Long locationId;
    }
}
