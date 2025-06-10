package umc.springstart.service.MemberService;

import umc.springstart.web.dto.memberDTO.MemberRequestDTO;
import umc.springstart.web.dto.memberDTO.MemberResponseDTO;

public interface MemberCommandService {
    MemberResponseDTO.JoinResultDTO joinMember(MemberRequestDTO.JoinDto request);

    MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request);
}
