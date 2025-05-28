package umcstudy.converter;

import org.springframework.data.domain.Page;
import umcstudy.study.domain.Missions;
import umcstudy.study.domain.enums.missionVisit;
import umcstudy.study.domain.mapping.Usermissions;
import umcstudy.web.dto.MissionResponseDTO;
import umcstudy.web.dto.StoreResponseDTO;
import umcstudy.web.dto.UsermissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class UsermissionConverter {

    public static MissionResponseDTO.MissionResultDTO toMissionResultDTO(Usermissions usermissions) {
        return MissionResponseDTO.MissionResultDTO.builder()
                .missionId(usermissions.getId())
                .visitStatus(usermissions.getVisitstatus())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static UsermissionResponseDTO.IngMissionPreViewDTO ingmissionPreViewDTO(Usermissions usermissions){

        return UsermissionResponseDTO.IngMissionPreViewDTO.builder()
                .storeName(usermissions.getStore().getStorename())
                .missionName(usermissions.getMissions().getMissionname())
                .visitStatus(usermissions.getVisitstatus())
                .point(usermissions.getMissions().getMissionpoint())
                .createdAt(usermissions.getCreatedAt().toLocalDate())
                .updatedAt(usermissions.getUpdatedAt().toLocalDate())
                .build();
    }
    public static UsermissionResponseDTO.IngMissionPreViewListDTO ingmissionPreViewListDTO(Page<Usermissions> ingmissionList){

        List<UsermissionResponseDTO.IngMissionPreViewDTO> ingmissionPreViewDTOList = ingmissionList.stream()
                .map(UsermissionConverter::ingmissionPreViewDTO).collect(Collectors.toList());

        return UsermissionResponseDTO.IngMissionPreViewListDTO.builder()
                .isLast(ingmissionList.isLast())
                .isFirst(ingmissionList.isFirst())
                .totalPage(ingmissionList.getTotalPages())
                .totalElements(ingmissionList.getTotalElements())
                .listSize(ingmissionPreViewDTOList.size())
                .IngMissionList(ingmissionPreViewDTOList)
                .build();
    }
}

