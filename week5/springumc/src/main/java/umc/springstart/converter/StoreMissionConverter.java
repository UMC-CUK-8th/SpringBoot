package umc.springstart.converter;

import umc.springstart.domain.Mission;
import umc.springstart.web.dto.MissionDTO.MissionRequestDTO;
import umc.springstart.web.dto.MissionDTO.MissionResponseDTO;

public class StoreMissionConverter {
    public static Mission toMission(MissionRequestDTO.AddMissionDTO request) {
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.AddMissionResultDTO toAddMissionResultDTO(Mission mission) {
        return MissionResponseDTO.AddMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}
