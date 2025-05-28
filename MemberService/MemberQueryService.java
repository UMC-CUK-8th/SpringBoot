package umcstudy.study.MemberService;


import org.springframework.data.domain.Page;
import umcstudy.study.domain.Members;
import org.springframework.stereotype.Service;
import umcstudy.study.domain.mapping.Reviews;

import java.util.List;
import java.util.Optional;

@Service
public interface MemberQueryService {

    Optional<Members> findMember(Long id);
    List<Members> findMemberbyID(String ID);
    Page<Reviews> getReviewList(Long MemberId, Integer page);
}