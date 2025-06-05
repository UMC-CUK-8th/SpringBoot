package umc.springstart.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import umc.springstart.domain.Member;
import umc.springstart.domain.enums.MissionStatus;
import umc.springstart.web.dto.MemberMissionDto;
import umc.springstart.web.dto.memberDTO.MemberResponseDTO;

import java.util.List;
import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findMember(Long id);
    List<MemberMissionDto> findMembersByIdAndMissionStatusAndRegionId(Long id, MissionStatus missionStatus, Long region_id);
    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}
