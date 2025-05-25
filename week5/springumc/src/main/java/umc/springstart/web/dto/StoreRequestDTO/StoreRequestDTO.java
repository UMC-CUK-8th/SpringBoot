package umc.springstart.web.dto.StoreRequestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class StoreRequestDTO {
    @Getter
    public static class AddStoreDTO{
        @NotBlank(message = "가게 이름은 필수입니다")
        @Size(max=10, message = "가게 이름은 최대 10자까지 입력 가능합니다")
        private String name;

        @NotBlank(message = "주소는 필수입니다.")
        @Size(max = 100, message = "주소는 100자를 초과할 수 없습니다.")
        private String address;

        @NotBlank(message = "상세 주소는 필수입니다.")
        @Size(max = 100, message = "상세 주소는 100자를 초과할 수 없습니다.")
        private String specAddress;

    }
}
