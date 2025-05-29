package umcstudy.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umcstudy.study.domain.enums.missionVisit;

import java.time.LocalDate;
import java.util.List;

public class UsermissionResponseDTO {


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IngMissionPreViewListDTO {
        List<IngMissionPreViewDTO> IngMissionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IngMissionPreViewDTO {
        String storeName;
        String missionName;
        missionVisit visitStatus;
        int point;
        LocalDate createdAt;
        LocalDate updatedAt;
    }
}

