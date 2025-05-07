package umc.study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmpThirdDTO {
    private int completedMission;
    private Long missionId;
    private LocalDateTime createdAt;
}