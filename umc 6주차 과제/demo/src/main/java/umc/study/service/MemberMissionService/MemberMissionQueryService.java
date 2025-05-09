package umc.study.service.MemberMissionService;

import umc.study.domain.enums.Status;
import umc.study.domain.mapping.MemberMission;
import umc.study.dto.MemberMissionDTO;

import java.util.List;
import java.util.Optional;

public interface MemberMissionQueryService {
    Optional<MemberMission> findMission(Long user_id);
    List<MemberMissionDTO> findMissionByStatus(Long user_id, Status status);

    Integer showCompletedMission(Long user_id);
}
