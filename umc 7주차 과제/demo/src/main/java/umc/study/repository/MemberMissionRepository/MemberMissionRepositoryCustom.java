package umc.study.repository.MemberMissionRepository;

import umc.study.domain.enums.Status;
import umc.study.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMission> dynamicQueryWithBooleanBuilder (Long userId, Status status);

    Integer showCompletedMissions(Long userId);

}
