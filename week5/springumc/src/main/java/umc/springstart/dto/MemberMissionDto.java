package umc.springstart.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import umc.springstart.domain.enums.MissionStatus;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class MemberMissionDto {
    private final Long storeId;
    private final String storeName;
    private final Long missionId;
    private final MissionStatus status;
    private final LocalDate deadline;
}
