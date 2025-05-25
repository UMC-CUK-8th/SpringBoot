package umc.springstart.service.MemberService;

import umc.springstart.domain.Member;
import umc.springstart.web.dto.memberDTO.MemberRequestDTO;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinDto request);
}
