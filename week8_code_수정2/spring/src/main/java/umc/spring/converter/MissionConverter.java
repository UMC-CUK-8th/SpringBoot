package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.JoinDTO request) {

        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .leastOrderPrice(request.getLeastOrderPrice())
                .userMissionList(new ArrayList<>())
                .build();
    }

    public static MissionResponseDTO.JoinResultDTO toJoinResultDTO(Mission mission) {
        return MissionResponseDTO.JoinResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }


        public static MissionResponseDTO.MissionPreMissionDTO missionPreMissionDTO(Mission mission){
            return MissionResponseDTO.MissionPreMissionDTO.builder()
                    .storeName(mission.getStore().getName())
                    .reward(mission.getReward())
                    .createdAt(mission.getCreatedAt().toLocalDate())
                    .deadline(mission.getDeadline())
                    .leastOrderPrice(mission.getLeastOrderPrice())
                    .build();
        }



        public static MissionResponseDTO.MissionPreMissionListDTO missionPreMissionListDTO(Page<Mission> missionList){

            List<MissionResponseDTO.MissionPreMissionDTO> missionPreMissionDTOList = missionList.stream()
                    .map(umc.spring.converter.MissionConverter::missionPreMissionDTO).collect(Collectors.toList());

            return MissionResponseDTO.MissionPreMissionListDTO.builder()
                    .isLast(missionList.isLast())
                    .isFirst(missionList.isFirst())
                    .totalPage(missionList.getTotalPages())
                    .totalElements(missionList.getTotalElements())
                    .listSize(missionPreMissionDTOList.size())
                    .missionList(missionPreMissionDTOList)
                    .build();
        }
}
