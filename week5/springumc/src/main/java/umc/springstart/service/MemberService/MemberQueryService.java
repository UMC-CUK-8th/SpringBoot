package umc.springstart.service.MemberService;

import com.querydsl.core.Tuple;
import umc.springstart.domain.Member;
import umc.springstart.domain.enums.MissionStatus;

import java.util.List;
import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findMember(Long id);
    List<Tuple> findMembersByIdAndMissionStatusAndRegionId(Long id, MissionStatus missionStatus, Long region_id);
}
