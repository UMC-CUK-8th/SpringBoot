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
        @ExistStores
        Long store;

    }
}
