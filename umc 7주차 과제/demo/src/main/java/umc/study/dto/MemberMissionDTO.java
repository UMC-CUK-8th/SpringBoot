package umc.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.enums.Status;
import umc.study.domain.mapping.MemberMission;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class MemberMissionDTO{
    private long id;
    private String missionName;
    private String description;
    private int repair;
    private Status status;
    private Integer completedMission;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static MemberMissionDTO fromEntity(MemberMission memberMission) {
        return MemberMissionDTO.builder()
                .id(memberMission.getId())
                .missionName(memberMission.getMission().getMissionName())
                .description(memberMission.getMission().getDescription())
                .repair(memberMission.getMission().getRepair())
                .status(memberMission.getStatus())
                .completedMission(memberMission.getCompletedMission())
                .createdAt(memberMission.getCreatedAt())
                .updatedAt(memberMission.getUpdatedAt())
                .build();
    }

}