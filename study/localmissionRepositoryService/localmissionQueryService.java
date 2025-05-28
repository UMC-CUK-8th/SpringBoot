package umcstudy.study.localmissionRepositoryService;

import umcstudy.study.DTO.LocalMissionStatusDTO;
import umcstudy.study.domain.enums.missionVisit;
import umcstudy.study.domain.mapping.locationbonusmission;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface localmissionQueryService {
    Optional<locationbonusmission> findlocalmission(Long id);
    List<locationbonusmission> localname(String localname);
    LocalMissionStatusDTO getLocalMissionStatusWithCount(String localname, missionVisit status);

}