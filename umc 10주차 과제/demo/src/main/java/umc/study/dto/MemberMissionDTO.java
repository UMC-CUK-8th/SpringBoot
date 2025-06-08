package umc.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.enums.Status;
import umc.study.domain.mapping.MemberMission;

import java.time.LocalDateTime;
import java.util.List;

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


    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProgessMisssionPreviewDTOList {
        private List<ProgressMissionPreviewDTO> progressMissionList;
        private Integer totalPages;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProgressMissionPreviewDTO {
        private Long missionId;
        private String missionName;
        private String description;
        private Integer repair;
        private Status status;
        private LocalDateTime createdAt;

    }

}