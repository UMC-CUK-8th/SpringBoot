package umc.spring.repository.missionRepository;


import umc.spring.domain.Mission;

import java.time.LocalDate;
import java.util.List;
public interface MissionRepositoryCustom {

    List<Mission> dynamicQueryWithBooleanBuilder(String missionSpec, Integer reward, LocalDate deadline);
}
