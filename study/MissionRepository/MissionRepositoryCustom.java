package org.example.study.MissionRepository;

import org.example.study.domain.Missions;
import org.example.study.domain.enums.missionVisit;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Missions> dynamicQueryWithBooleanBuilder(missionVisit status);
}