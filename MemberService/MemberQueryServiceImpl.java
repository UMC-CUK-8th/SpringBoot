package umcstudy.study.MemberService;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import umcstudy.apiPayload.code.status.ErrorStatus;
import umcstudy.apiPayload.exception.handler.MemberHandler;
import umcstudy.config.security.jwt.JwtTokenProvider;
import umcstudy.converter.MemberConverter;
import umcstudy.study.MemberRepository.MemberRepository;
import umcstudy.study.MemberService.MemberQueryService;
import umcstudy.study.ReviewRepository.ReviewRepository;
import umcstudy.study.domain.Members;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umcstudy.study.domain.mapping.Reviews;
import umcstudy.web.dto.MemberResponseDTO;

import static umcstudy.study.domain.QPoint.point;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public Optional<Members> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Members> findMemberbyID(String ID) {
        List<Members> filteredMember = memberRepository.dynamicQueryWithBooleanBuilder(ID);

        filteredMember.forEach(members ->
                System.out.println(" Member name: " + members.getName() +
                        " Member ID:" + members.getMemID() +
                        " Member Email:" + members.getEmail() +
                        " Member Point:" + point.nowpoint));

        return filteredMember;
    }
    @Override
    public Page<Reviews> getReviewList(Long MemberId, Integer page) {
        Members members = memberRepository.findById(MemberId).get();
        Page<Reviews> MemberPage = reviewRepository.findAllByMembers(members, PageRequest.of(page,10));
        return MemberPage;
    }
    @Override
    @Transactional(readOnly = true)
    public MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String memID = authentication.getName();

        Members members = memberRepository.findByMemID(memID)
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return MemberConverter.toMemberInfo(members);
    }
}