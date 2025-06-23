package umc.spring.converter;

import umc.spring.domain.User;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user) {
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }


    public static UserResponseDTO.LoginResultDTO toLoginResultDTO(Long userId, String accessToken) {
        return UserResponseDTO.LoginResultDTO.builder()
                .userId(userId)
                .accessToken(accessToken)
                .build();
    }

    public static UserResponseDTO.UserInfoDTO toMemberInfoDTO(User user){
        return UserResponseDTO.UserInfoDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .gender(user.getGender().name())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDTO request) {
        Gender gender = null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return User.builder()
                .address(request.getAddress())
                .gender(gender)
                .email(request.getEmail())
                .name(request.getName())
                .userFoodList(new ArrayList<>())
                //추가
                .email(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .build();
    }
}
