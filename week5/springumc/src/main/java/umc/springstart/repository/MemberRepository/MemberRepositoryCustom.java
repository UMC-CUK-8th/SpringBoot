package umc.springstart.repository.MemberRepository;

import com.querydsl.core.Tuple;
import umc.springstart.domain.enums.MissionStatus;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Tuple> findByIdAndMissionStatusAndRegionId(Long id, MissionStatus missionStatus, Long region_id);
}
