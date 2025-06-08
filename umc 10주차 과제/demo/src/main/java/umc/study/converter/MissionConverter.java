package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.mapping.Review;
import umc.study.dto.MissionResponseDTO;
import umc.study.dto.MissionRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.AddMissionRequest request) {
        return Mission.builder()
                .missionName(request.getMissionName())
                .description(request.getDescription())
                .repair(request.getRepair())
                .build();
    }

    public static MissionResponseDTO.MissionResponse toMissionResponse(Mission mission, List<Review> reviews) {
        List<MissionResponseDTO.MarketInfo> marketInfos = reviews.stream()
                .map(review ->MissionResponseDTO.MarketInfo.builder()
                        .marketId(review.getMarket().getId())
                        .marketName(review.getMarket().getName())
                        .build())
                .distinct()
                .collect(Collectors.toList());

        return MissionResponseDTO.MissionResponse.builder()
                .id(mission.getId())
                .missionId(mission.getId())
                .missionName(mission.getMissionName())
                .description(mission.getDescription())
                .repair(mission.getRepair())
                .markets(marketInfos)
                .createdAt(mission.getCreatedAt())

                .build();

    }

}
