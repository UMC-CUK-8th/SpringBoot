package umcstudy.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import umcstudy.apiPayload.code.status.ErrorStatus;
import umcstudy.apiPayload.exception.handler.MemberHandler;
import umcstudy.config.security.jwt.JwtTokenProvider;
import umcstudy.converter.MemberConverter;
import umcstudy.converter.StoreConverter;
import umcstudy.repository.MemberRegiRepository;
import umcstudy.study.domain.Members;
import umcstudy.study.domain.Store;
import umcstudy.web.dto.MemberRequestDTO;
import umcstudy.web.dto.MemberResponseDTO;
import umcstudy.web.dto.StoreResponseDTO;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRegiRepository memberRegiRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    @Override
    public MemberResponseDTO.JoinResultDTO registerMember(MemberRequestDTO.JoinDto request) {

        Members members = MemberConverter.toMembers(request);
        members.encodePassword(passwordEncoder.encode(request.getPassword()));
        Members savedMembers = memberRegiRepository.save(members);

        return MemberConverter.toJoinResultDTO(savedMembers);
    }
    @Override
    public MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request) {
        Members members = memberRegiRepository.findByMemID(request.getMemID())
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        if(!passwordEncoder.matches(request.getPassword(), members.getPassword())) {
            throw new MemberHandler(ErrorStatus.INVALID_PASSWORD);
        }
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                members.getMemID(), null,
                Collections.singleton(() -> members.getRole().name())
        );

        String accessToken = jwtTokenProvider.generateToken(authentication);

        return MemberConverter.toLoginResultDTO(
                members,
                accessToken
        );
    }
}
