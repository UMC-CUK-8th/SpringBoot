package umcstudy.study.MemberService;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umcstudy.study.MemberRepository.MemberRepository;
import umcstudy.study.MemberService.MemberQueryService;
import umcstudy.study.ReviewRepository.ReviewRepository;
import umcstudy.study.domain.Members;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umcstudy.study.domain.mapping.Reviews;

import static umcstudy.study.domain.QPoint.point;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

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
}