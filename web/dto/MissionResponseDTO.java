package umcstudy.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umcstudy.study.domain.enums.missionVisit;
import umcstudy.study.domain.mapping.Usermissions;

import java.time.LocalDateTime;

public class MissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionResultDTO {
        private Long missionId;
        LocalDateTime createdAt;
        missionVisit visitStatus;
    }
}
