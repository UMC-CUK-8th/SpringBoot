package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistStores;

import java.time.LocalDate;
import java.util.List;

public class MissionRequestDTO {

    @Getter
    public static class JoinDTO {

        @NotNull
        Integer reward;
        @NotNull
        LocalDate deadline;
        @NotNull
        String leastOrderPrice;
        @ExistStores
        Long store_id;

    }
}
//"reward":200,"deadline":"2025-08-11","leastOrderPrice":"10000","store_id":2
