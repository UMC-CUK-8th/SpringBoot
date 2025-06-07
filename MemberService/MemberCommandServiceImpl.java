package umcstudy.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import umcstudy.converter.MemberConverter;
import umcstudy.converter.StoreConverter;
import umcstudy.repository.MemberRegiRepository;
import umcstudy.study.domain.Members;
import umcstudy.study.domain.Store;
import umcstudy.web.dto.MemberRequestDTO;
import umcstudy.web.dto.MemberResponseDTO;
import umcstudy.web.dto.StoreResponseDTO;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRegiRepository memberRegiRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public MemberResponseDTO.JoinResultDTO registerMember(MemberRequestDTO.JoinDto request) {

        Members members = MemberConverter.toMembers(request);
        members.encodePassword(passwordEncoder.encode(request.getPassword()));

        Members savedMembers = memberRegiRepository.save(members);

        return MemberConverter.toJoinResultDTO(savedMembers);
    }
}