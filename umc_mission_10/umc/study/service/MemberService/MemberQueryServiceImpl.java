package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.domain.enums.Statuses;
import umc.study.domain.mapping.Review;
import umc.study.domain.mapping.UserMissionPointcounter;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.UserMemberPointcounterRepository.UmpRepository;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final UmpRepository umpRepository;

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

}
