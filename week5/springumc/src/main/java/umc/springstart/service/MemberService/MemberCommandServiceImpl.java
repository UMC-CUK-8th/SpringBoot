package umc.springstart.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springstart.apiPayload.exception.handler.FoodCategoryHandler;
import umc.springstart.apiPayload.exception.handler.MemberHandler;
import umc.springstart.converter.MemberConverter;
import umc.springstart.converter.MemberPreferConverter;
import umc.springstart.domain.FoodCategory;
import umc.springstart.domain.Member;
import umc.springstart.domain.mapping.MemberPrefer;
import umc.springstart.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.springstart.repository.MemberRepository.MemberRepository;
import umc.springstart.web.dto.memberDTO.MemberRequestDTO;
import umc.springstart.apiPayload.code.status.ErrorStatus;
import umc.springstart.web.dto.memberDTO.MemberResponseDTO;
import umc.springstart.config.security.jwt.JwtTokenProvider;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;


    @Override
    @Transactional
    public MemberResponseDTO.JoinResultDTO joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});
        Member savedMember = memberRepository.save(newMember);

        return MemberConverter.toJoinResultDTO(savedMember);
    }


    @Override
    public MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        if(!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new MemberHandler(ErrorStatus.INVALID_PASSWORD);
        }

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                member.getEmail(), null ,
                Collections.singleton(() -> member.getRole().name())
        );

        String accessToken = jwtTokenProvider.generateToken(authentication);

        return MemberConverter.toLoginResultDTO(
                member.getId(),
                accessToken
        );
    }
}