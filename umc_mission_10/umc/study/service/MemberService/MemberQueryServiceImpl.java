package umc.study.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.config.security.jwt.JwtTokenProvider;
import umc.study.domain.Member;
import umc.study.domain.enums.Statuses;
import umc.study.domain.mapping.Review;
import umc.study.domain.mapping.UserMissionPointcounter;
import umc.study.dto.member.MemberResponseDTO;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.UserMemberPointcounterRepository.UmpRepository;
import umc.study.apiPayload.exception.handler.MemberHandler;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.converter.MemberConverter;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final UmpRepository umpRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public Page<Review> getReviewList(Long MemberId, Integer page) {
       Member member = memberRepository.findById(MemberId).get();

       Page<Review> MemberPage = reviewRepository.findALLByMember(member, PageRequest.of(page, 10));
       return MemberPage;
    }


    public Page<UserMissionPointcounter> getChallengingMissionList(Long MemberId, Integer page) {
        Member member = memberRepository.findById(MemberId).get();

        //int CHALLENGING_STATUS = 1;
        Page<UserMissionPointcounter> challengingMissionPage = umpRepository.findAllByMemberAndStatus(member, Statuses.challenging, PageRequest.of(page, 10));

        return challengingMissionPage;
    }

    //getMemberInfo() 메소드의 구현체를 MemberQueryImpl 클래스에 정의
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
