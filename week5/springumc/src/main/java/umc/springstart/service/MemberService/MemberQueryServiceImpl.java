package umc.springstart.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springstart.domain.Member;
import umc.springstart.domain.enums.MissionStatus;
import umc.springstart.web.dto.MemberMissionDto;
import umc.springstart.repository.MemberRepository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberRepository memberRepository;

    @Override
    public Optional<Member> findMember(Long id){
        return memberRepository.findById(id);
    }
    @Override
    public List<MemberMissionDto> findMembersByIdAndMissionStatusAndRegionId(Long id, MissionStatus missionStatus, Long region_id) {

        return memberRepository.findByIdAndMissionStatusAndRegionId(id, missionStatus, region_id);
    }
}
