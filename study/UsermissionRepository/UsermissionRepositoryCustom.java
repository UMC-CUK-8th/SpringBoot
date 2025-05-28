package umcstudy.study.UsermissionRepository;

import umcstudy.study.domain.enums.missionVisit;
import umcstudy.study.domain.mapping.Usermissions;

import java.util.List;

public interface UsermissionRepositoryCustom {
    List<Usermissions> dynamicQueryWithBooleanBuilder(missionVisit status);
    long countVisitMission(missionVisit status);
}