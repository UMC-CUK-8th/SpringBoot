package umcstudy.study.UsermissionService;


import org.springframework.data.domain.Page;
import umcstudy.study.domain.Members;
import umcstudy.study.domain.enums.missionVisit;
import umcstudy.study.domain.mapping.Usermissions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsermissionQueryService {

    Optional<Usermissions> findmission(Long id);
    List<Usermissions> findvisitmissions(missionVisit status);
    long missionVisitCount(missionVisit status);
    List<Usermissions> findUnvisitmissions(missionVisit status);
    Page<Usermissions> getIngMissionList(Long MemberId, Integer page);

}