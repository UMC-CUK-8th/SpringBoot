package org.example.study.localmissionRepositoryService;

import org.example.study.DTO.LocalMissionStatusDTO;
import org.example.study.domain.enums.missionVisit;
import org.example.study.domain.mapping.locationbonusmission;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface localmissionQueryService {
    Optional<locationbonusmission> findlocalmission(Long id);
    List<locationbonusmission> localname(String localname);
    LocalMissionStatusDTO getLocalMissionStatusWithCount(String localname, missionVisit status);

}