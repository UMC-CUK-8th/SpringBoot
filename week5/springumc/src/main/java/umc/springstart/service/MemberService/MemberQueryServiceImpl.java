package umc.springstart.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springstart.apiPayload.code.status.ErrorStatus;
import umc.springstart.apiPayload.exception.handler.MemberHandler;
import umc.springstart.config.security.jwt.JwtTokenProvider;
import umc.springstart.domain.Member;
import umc.springstart.domain.enums.MissionStatus;
import umc.springstart.web.dto.MemberMissionDto;
import umc.springstart.repository.MemberRepository.MemberRepository;
import umc.springstart.web.dto.memberDTO.MemberResponseDTO;
import umc.springstart.converter.MemberConverter;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public Optional<Member> findMember(Long id){
        return memberRepository.findById(id);
    }
    @Override
    public List<MemberMissionDto> findMembersByIdAndMissionStatusAndRegionId(Long id, MissionStatus missionStatus, Long region_id) {

        return memberRepository.findByIdAndMissionStatusAndRegionId(id, missionStatus, region_id);
    }

    @Override
    @Transactional(readOnly = true)
    public MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return MemberConverter.toMemberInfoDTO(member);
    }
}
