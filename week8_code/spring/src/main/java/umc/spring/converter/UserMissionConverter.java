package umc.spring.converter;

import umc.spring.domain.Food;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserFood;
import umc.spring.domain.mapping.UserMission;
import umc.spring.repository.userRepository.UserRepository;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;
import umc.spring.web.dto.UserMissionRequestDTO;
import umc.spring.web.dto.UserMissionResponseDTO;

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
}
