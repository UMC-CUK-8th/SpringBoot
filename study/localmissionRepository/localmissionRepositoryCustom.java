package org.example.study.localmissionRepository;

import org.example.study.domain.enums.missionVisit;
import org.example.study.domain.mapping.locationbonusmission;
import java.util.List;

public interface localmissionRepositoryCustom {
    List<locationbonusmission> dynamicQueryWithBooleanBuilder(String localname);
}