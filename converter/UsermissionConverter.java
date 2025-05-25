package umcstudy.converter;

import umcstudy.study.domain.Missions;
import umcstudy.study.domain.Store;
import umcstudy.study.domain.mapping.Reviews;
import umcstudy.study.domain.mapping.Usermissions;
import umcstudy.web.dto.MissionRequestDTO;
import umcstudy.web.dto.MissionResponseDTO;
import umcstudy.web.dto.ReviewRequestDTO;

import java.time.LocalDateTime;

public class UsermissionConverter {

    public static MissionResponseDTO.MissionResultDTO toMissionResultDTO(Usermissions usermissions) {
        return MissionResponseDTO.MissionResultDTO.builder()
                .missionId(usermissions.getId())
                .visitStatus(usermissions.getVisitstatus())
                .createdAt(LocalDateTime.now())
                .build();
    }
}

