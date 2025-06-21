package umc.study.service.MemberService;

import umc.study.domain.Member;
import umc.study.dto.member.MemberRequestDTO;
import umc.study.dto.member.MemberResponseDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
    MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request);
}
