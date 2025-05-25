package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO{
        Long missionId;
        LocalDateTime createdAt;


    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreMissionListDTO {
        List<MissionResponseDTO.MissionPreMissionDTO> missionList; //미션 목록
        Integer listSize; //한 페이지당 미션 개수
        Integer totalPage;//총 페이지 개수
        Long totalElements;//총 미션 개수
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreMissionDTO {
        String storeName; //가게이름
        String leastOrderPrice;//최소주문금액
        Integer reward;//보상금액
        LocalDate deadline;//기한
        LocalDate createdAt;
    }
}
