package umcstudy.service.MemberService;

import umcstudy.web.dto.MemberRequestDTO;
import umcstudy.web.dto.MemberResponseDTO;

public interface MemberCommandService {
    MemberResponseDTO.JoinResultDTO registerMember(MemberRequestDTO.JoinDto request);
}

