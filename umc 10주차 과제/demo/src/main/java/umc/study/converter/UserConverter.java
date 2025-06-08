package umc.study.converter;

import umc.study.domain.User;
import umc.study.domain.enums.Gender;
import umc.study.dto.UserRequestDTO;
import umc.study.dto.UserResponseDTO;
import umc.study.web.dto.UserResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {
    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user) {
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static UserResponseDto.LoginResultDTO toLoginResultDTO(Long userId, String accessToken) {
        return UserResponseDto.LoginResultDTO.builder()
                .userId(userId)
                .accessToken(accessToken)
                .build();
    }

    public static UserResponseDto.UserInfoDTO toUserInfoDTO(User user) {
        return UserResponseDto.UserInfoDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .gender(user.getGender().toString())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDTO request) {
        Gender gender=null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            default:
                gender=Gender.NONE;
                break;
        }

        return User.builder()
                .name(request.getName())
                .email(request.getEmail()) // 이메일
                .password(request.getPassword()) // 비번
                .nickname(request.getNickname())
                .birth(request.getBirth())
                .address(request.getAddress())
                .gender(gender)
                .phoneNumber(010-1234-5678)//테스트용 기본값
                .role(request.getRole())// 역할
                .userPreferList(new ArrayList<>())
                .build();
    }
}
