package org.example.study.usermissionRepository;

import org.example.study.domain.enums.missionVisit;
import org.example.study.domain.mapping.Usermissions;

import java.util.List;

public interface usermissionRepositoryCustom {
    List<Usermissions> dynamicQueryWithBooleanBuilder(missionVisit status);
    long countVisitMission(missionVisit status);
}