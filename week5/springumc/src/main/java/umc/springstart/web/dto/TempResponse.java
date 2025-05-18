package umc.springstart.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TempResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor

    //DTO들은 이렇게 큰 묶음으로 클래스를 만들고 내부적으로 static 클래스를 만드는 것이 좋음
    //DTO는 많은 곳에서 쓰기때문에 static으로 만들면 매번 class 파일을 만들 필요가 없어서 범용적으로 DTO를 사용할 수 있습니다
    public static class TempTestDTO{
        String testString;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TempExceptionDTO{
        Integer flag;
    }
}