package umc.study.converter;

import umc.study.web.dto.TempResponse;

public class TempConverter {
    // 메서드 형식은 to[생성되는 것]
    public static TempResponse.TempTestDTO toTemptestDTO() {
        return TempResponse.TempTestDTO.builder()
                .testString("테스트입니다.")
                .build();
    }

    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag) {
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
