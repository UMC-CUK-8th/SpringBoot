package umc.study.ApiMission1.code;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class StoreResponseDTO {
    private Long storeId;
    private String name;
    private String address;
    private Float score;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}