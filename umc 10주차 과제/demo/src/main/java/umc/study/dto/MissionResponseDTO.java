package umc.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MissionResponse{
        private Long id;
        private Long missionId;
        //private Long marketId;
        //private String marketName;
        // 확장 응답 추가 방식으로 불러옴
        private List<MarketInfo> markets;
        private String missionName;
        private String description;
        private Integer repair;
        private LocalDateTime createdAt;
    }
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MarketInfo{
        private Long marketId;
        private String marketName;
    }

    /*

MissionResponseDTO 확장 응답 방식 구현

이 구현의 장점
완전한 데이터 제공: 미션과 관련된 모든 마켓 정보를 한 번의 API 호출로 제공
통계 데이터 포함: 전체 리뷰 수, 평균 평점 등 집계 정보도 함께 제공
유연한 확장성: 필요에 따라 마켓별 상세 정보를 추가할 수 있음
네트워크 효율성: 클라이언트가 여러 API를 호출할 필요 없음
     */

}
