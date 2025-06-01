package umc.springstart.service.MemberService;

import umc.springstart.domain.Member;
import umc.springstart.web.dto.memberDTO.MemberRequestDTO;
import umc.springstart.web.dto.memberDTO.MemberResponseDTO;

public interface MemberCommandService {
    public MemberResponseDTO.JoinResultDTO joinMember(MemberRequestDTO.JoinDto request);
}
