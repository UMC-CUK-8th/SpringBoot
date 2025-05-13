package Concurrency_Project.Hello_Concurrency.user.converter;

import Concurrency_Project.Hello_Concurrency.user.dto.UserResponseDto;

public class UserConverter {

    public static UserResponseDto.SignInValidateDto toUserSignInValidateDto () {
        return UserResponseDto.SignInValidateDto.builder()
                .isValid(true)
                .build();
    }

    public static UserResponseDto.SignInDto toUserSignInDto (String email, String username) {
        return UserResponseDto.SignInDto.builder()
                .username(username)
                .email(email)
                .build();
    }

    public static UserResponseDto.UserInfoDto toUserInfoDto (UserResponseDto.UserInfoDto userDto) {
        return UserResponseDto.UserInfoDto.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .postCount(userDto.getPostCount())
                .socialLogin(userDto.getSocialLogin())
                .build();
    }
}
