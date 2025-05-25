package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.ApiMission3.code.MissionRequestDTO;
import umc.study.ApiMission3.code.MissionResponseDTO;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO dto, Store store) {
        return Mission.builder()
                .missionSpec(dto.getMissionSpec())
                .reward(dto.getReward())
                .store(store)
                .deadline(dto.getDeadline())
                .build();
    }

    public static MissionResponseDTO toResponseDTO(Mission mission) {
        return MissionResponseDTO.builder()
                .missionId(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .storeName(mission.getStore().getName())
                .build();
    }
}