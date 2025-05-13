package Concurrency_Project.Hello_Concurrency.temp.dto;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class TempRespDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class  TempTestDto{
        private String testString;
    }


    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TempExceptionDto{
        private Integer flag;
    }
}
