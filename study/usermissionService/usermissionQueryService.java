package org.example.study.usermissionService;


import org.example.study.domain.enums.missionVisit;
import org.example.study.domain.mapping.Usermissions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface usermissionQueryService {

    Optional<Usermissions> findmission(Long id);
    List<Usermissions> findvisitmissions(missionVisit status);
    long missionVisitCount(missionVisit status);
    List<Usermissions> findUnvisitmissions(missionVisit status);
}