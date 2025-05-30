package umc.study.dto.storeInfoDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

public class StoreInfoRequestDTO {
    @Getter
    public static class JoinDto{
        @NotBlank
        private String storeName;
        @NotBlank
        private String foodName;
        private List<Long> reviewId;//null가능
    }
}
