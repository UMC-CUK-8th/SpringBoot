package umc.study.converter;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import umc.study.domain.enums.Status;
import umc.study.domain.mapping.MemberMission;
import umc.study.dto.MemberMissionDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


public class MemberMissionConverter {


//    private Long missionId;
//    private String missionName;
//    private String description;
//    private Integer repair;
//    private Status status;
//    private LocalDateTime createdAt;

    public static MemberMissionDTO.ProgressMissionPreviewDTO toProgressMissionPreviewDTO(MemberMission memberMission) {
        return MemberMissionDTO.ProgressMissionPreviewDTO.builder()
                .missionId(memberMission.getMission().getId())
                .missionName(memberMission.getMission().getMissionName())
                .description(memberMission.getMission().getDescription())
                .repair(memberMission.getMission().getRepair())
                .status(memberMission.getStatus())
                .createdAt(LocalDateTime.now())
                .build();
    }


//    private List<MemberMissionDTO.ProgressMissionPreviewDTO> progressMissionList;
//    private Integer totalPages;
//    private Long totalElements;
//    private Boolean isFirst;
//    private Boolean isLast;
    public static MemberMissionDTO.ProgessMisssionPreviewDTOList toProgessMissionPreviewDTOList(Page<MemberMission> missionList) {
        List<MemberMissionDTO.ProgressMissionPreviewDTO> progressMissionPreviewDTOList = missionList.stream()
                .map(MemberMissionConverter::toProgressMissionPreviewDTO)
                .collect(Collectors.toList());

        return MemberMissionDTO.ProgessMisssionPreviewDTOList.builder()
                .progressMissionList(progressMissionPreviewDTOList)
                .totalPages(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .build();
    }


}
