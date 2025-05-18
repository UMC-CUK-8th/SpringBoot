package umc.study.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UmpThirdDTO {
    private int completedMission;
    private int missionId;
    private LocalDateTime createdAt;
}