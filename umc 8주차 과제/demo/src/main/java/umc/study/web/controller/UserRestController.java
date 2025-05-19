package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.UserConverter;
import umc.study.domain.User;
import umc.study.dto.UserDTO;
import umc.study.dto.UserRequestDTO;
import umc.study.dto.UserResponseDTO;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.service.UserService.UserCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {

    private final UserCommandService userCommandService ;

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDTO requset) {
        User user =userCommandService.joinUser(requset);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }
}
