package umcstudy.study.MissionRepository;

import umcstudy.study.domain.Missions;
import umcstudy.study.domain.enums.missionVisit;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Missions> dynamicQueryWithBooleanBuilder(missionVisit status);
}