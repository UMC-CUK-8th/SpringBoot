package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.dto.missionDTO.MissionRequestDTO;
import umc.study.dto.missionDTO.MissionResponseDTO;
import umc.study.dto.storeInfoDTO.StoreInfoResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.JoinResultDTO toJoinResultDTO(Mission mission) {
        return MissionResponseDTO.JoinResultDTO.builder()
                .missionId(mission.getMissionId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.JoinDTO request){
        return Mission.builder()
                .missionName(request.getMissionName())
                .missionDetail(request.getMissionDetail())
                .reward(request.getReward())
                .build();
    }

}
