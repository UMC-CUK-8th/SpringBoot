package umc.study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import umc.study.domain.enums.Statuses;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmpFirstDTO {
    private int phonenumberMissionid;
    private Statuses status;
}

//ump.phonenumberMissionid, ump.status ump.completedMission, mission.missionid, mission.createdAt