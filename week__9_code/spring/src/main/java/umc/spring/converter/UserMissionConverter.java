package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Food;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserFood;
import umc.spring.domain.mapping.UserMission;
import umc.spring.repository.userRepository.UserRepository;
import umc.spring.web.dto.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static umc.spring.domain.enums.MissionStatus.CHALLENGING;

public class UserMissionConverter {

    public static UserMission toUserMission(User user, Mission mission) {

        return UserMission.builder()
                .user(user)
                .mission(mission)
                .status(CHALLENGING)
                .build();
    }

    public static UserMissionResponseDTO.JoinResultDTO toJoinResultDTO(UserMission userMission) {
        return  UserMissionResponseDTO.JoinResultDTO.builder()
                .userMissionId(userMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }


    public static MissionResponseDTO.MissionPreMissionDTO userMissionPreUserMissionDTO(UserMission userMission){
        return MissionResponseDTO.MissionPreMissionDTO.builder()
                .storeName(userMission.getMission().getStore().getName())
                .reward(userMission.getMission().getReward())
                .createdAt(userMission.getMission().getCreatedAt().toLocalDate())
                .deadline(userMission.getMission().getDeadline())
                .leastOrderPrice(userMission.getMission().getLeastOrderPrice())
                .build();
    }



    public static MissionResponseDTO.MissionPreMissionListDTO userMissionPreUserMissionListDTO(Page<UserMission> userMissionList){

        List<MissionResponseDTO.MissionPreMissionDTO> missionPreMissionDTOList = userMissionList.stream()
                .map(umc.spring.converter.UserMissionConverter::userMissionPreUserMissionDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreMissionListDTO.builder()
                .isLast(userMissionList.isLast())
                .isFirst(userMissionList.isFirst())
                .totalPage(userMissionList.getTotalPages())
                .totalElements(userMissionList.getTotalElements())
                .listSize(missionPreMissionDTOList.size())
                .missionList(missionPreMissionDTOList)
                .build();
    }


}
