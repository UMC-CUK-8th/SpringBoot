package Concurrency_Project.Hello_Concurrency.temp.controller;

import Concurrency_Project.Hello_Concurrency.common.apiPayload.ApiResponse;
import Concurrency_Project.Hello_Concurrency.common.apiPayload.code.status.SuccessStatus;
import Concurrency_Project.Hello_Concurrency.temp.converter.TempConverter;
import Concurrency_Project.Hello_Concurrency.temp.dto.TempRespDto;
import Concurrency_Project.Hello_Concurrency.temp.service.TempQueryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/temp")
public class TempController {

    private final TempQueryServiceImpl tempQueryService;

    /*@GetMapping("/test")
    public ApiResponse<TempRespDto.TempTestDto> test() {
        return ApiResponse.onSuccess(TempConverter.toTempRespDto());
    }*/

    @GetMapping("/test")
    public ApiResponse<TempRespDto.TempTestDto> test() {
        return ApiResponse.onSuccess(TempConverter.toTempRespDto(), SuccessStatus._OK);
    }

    @PostMapping("/")
    public ApiResponse<TempRespDto.TempTestDto> signIn() {
        return ApiResponse.onSuccess(TempConverter.toSignInTempRespDto(), SuccessStatus._SIGN_IN_SUCCESS);
    }

    @PostMapping("/login")
    public ApiResponse<TempRespDto.TempTestDto> login() {
        return ApiResponse.onSuccess(TempConverter.toLoginTempRespDto(), SuccessStatus._LOGIN_SUCCESS);
    }

    @GetMapping("/ex")
    public ApiResponse<TempRespDto.TempExceptionDto> exceptionTest(@RequestParam Integer flag) {
        tempQueryService.CheckFlag(flag);
        return  ApiResponse.onSuccess(TempConverter.toTempExceptionDto(flag), SuccessStatus._TEST_EXCEPTION_SUCCESS);
    }
}