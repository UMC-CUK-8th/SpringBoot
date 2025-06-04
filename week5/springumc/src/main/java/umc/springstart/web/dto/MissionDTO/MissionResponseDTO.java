package umc.springstart.web.dto.MissionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.springstart.domain.enums.MissionStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChallengeResultDTO {
        private Long memberMissionId; // 생성된 MemberMission의 ID
        private Long missionId; // 도전한 미션 ID
        private Long memberId; // 미션을 도전한 멤버 ID
        private MissionStatus status; // 초기 도전 상태 (CHALLENGING)
        private LocalDateTime challengedAt; // 도전 시작 시간 (생성 시간)
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddMissionResultDTO {
        private Long missionId; // 새로 생성된 미션의 ID
        private LocalDateTime createdAt; // 미션 생성 시간 (BaseEntity 상속 시)
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyChallengingMissionItemDTO{
        Long missionId;
        Integer reward;
        LocalDate deadline;
        String storeName;
        String missionSpec;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyChallengingMissionListDTO{
        List<MyChallengingMissionItemDTO> missionList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CompleMyMissionItemDTO {
        Long memberMissionId;
        MissionStatus status;
        LocalDateTime completeAt;
    }
}

