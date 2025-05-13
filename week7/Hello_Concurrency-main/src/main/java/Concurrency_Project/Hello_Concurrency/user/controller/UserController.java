package Concurrency_Project.Hello_Concurrency.user.controller;

import Concurrency_Project.Hello_Concurrency.common.apiPayload.ApiResponse;
import Concurrency_Project.Hello_Concurrency.common.apiPayload.code.status.SuccessStatus;
import Concurrency_Project.Hello_Concurrency.user.converter.UserConverter;
import Concurrency_Project.Hello_Concurrency.user.dto.UserRequestDto;
import Concurrency_Project.Hello_Concurrency.user.dto.UserResponseDto;
import Concurrency_Project.Hello_Concurrency.user.entity.User;
import Concurrency_Project.Hello_Concurrency.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    
    // Response API 통일하기

    private final UserService userService;

    @GetMapping("/{userId}")
    public ApiResponse<UserResponseDto.UserInfoDto> getUser(@PathVariable Long userId) {
        return ApiResponse.onSuccess(UserConverter.toUserInfoDto(userService.getUserByUserId(userId)), SuccessStatus._OK);
    }

    @PostMapping("")
    public ApiResponse<UserResponseDto.SignInDto> createUser(@RequestBody UserRequestDto.SignInRequestDto signInRequestDto) {
        log.info("Creating user: {}", signInRequestDto);
        userService.signIn(signInRequestDto);
        return ApiResponse.onSuccess(UserConverter.toUserSignInDto(signInRequestDto.getEmail(), signInRequestDto.getUsername()), SuccessStatus._SIGN_IN_SUCCESS);
    }

    @PostMapping("/validate")
    public ApiResponse<UserResponseDto.SignInValidateDto> validateSignIn (@RequestBody UserRequestDto.SignInValidateDto signInValidateDto) {
        log.info("Validating user: {}", signInValidateDto);
        userService.validateSignIn(signInValidateDto);
        return ApiResponse.onSuccess(UserConverter.toUserSignInValidateDto(), SuccessStatus._VALIDATE_SUCCESS); // 여기서 valid는 도대체 어디서 추가로 붙는걸까
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody UserRequestDto.UpdateRequestDto updateRequestDto) {
        userService.updateUser(userId, updateRequestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

}
