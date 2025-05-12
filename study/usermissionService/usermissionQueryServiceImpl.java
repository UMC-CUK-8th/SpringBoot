package org.example.study.usermissionService;

import lombok.RequiredArgsConstructor;
import org.example.study.domain.enums.missionVisit;
import org.example.study.domain.mapping.Usermissions;
import org.example.study.usermissionRepository.usermissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

import static org.example.study.domain.QMissions.missions;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class usermissionQueryServiceImpl implements usermissionQueryService {

    private final usermissionRepository usermissionRepository;

    @Override
    public Optional<Usermissions> findmission(Long id) {
        return usermissionRepository.findById(id);
    }

    @Override
    public List<Usermissions> findvisitmissions(missionVisit status) {
        List<Usermissions> filteredMissions = usermissionRepository.dynamicQueryWithBooleanBuilder(status);
        filteredMissions.forEach(Usermissions -> System.out.println("missionsname" + missions.missionname));

        return filteredMissions;
    }
    public List<Usermissions> findUnvisitmissions(missionVisit status) {
        List<Usermissions> filteredMissions = usermissionRepository.dynamicQueryWithBooleanBuilder(status);
        filteredMissions.forEach(Usermissions -> System.out.println("missionsname" + missions.missionname));

        return filteredMissions;
    }
    public long missionVisitCount(missionVisit status){
        return usermissionRepository.countVisitMission(status);
    }

}