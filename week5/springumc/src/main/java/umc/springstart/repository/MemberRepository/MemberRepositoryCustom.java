package umc.springstart.repository.MemberRepository;

import com.querydsl.core.Tuple;
import umc.springstart.domain.enums.MissionStatus;
import umc.springstart.web.dto.MemberMissionDto;

import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberMissionDto> findByIdAndMissionStatusAndRegionId(Long id, MissionStatus missionStatus, Long region_id);
}
