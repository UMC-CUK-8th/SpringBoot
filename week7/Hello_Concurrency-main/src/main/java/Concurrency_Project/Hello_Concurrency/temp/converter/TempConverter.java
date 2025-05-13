package Concurrency_Project.Hello_Concurrency.temp.converter;


import Concurrency_Project.Hello_Concurrency.temp.dto.TempRespDto;

public class TempConverter {
    public static TempRespDto.TempTestDto toTempRespDto() {
        return TempRespDto.TempTestDto.builder()
                .testString("temp test string")
                .build();
    }

    public static TempRespDto.TempTestDto toSignInTempRespDto() {
        return TempRespDto.TempTestDto.builder()
                .testString("success to sign in")
                .build();
    }

    public static TempRespDto.TempTestDto toLoginTempRespDto() {
        return TempRespDto.TempTestDto.builder()
                .testString("success to login")
                .build();
    }

    public static TempRespDto.TempExceptionDto toTempExceptionDto(Integer flag) {
        return TempRespDto.TempExceptionDto.builder()
                .flag(flag)
                .build();
    }
}
