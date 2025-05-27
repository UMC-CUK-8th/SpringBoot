package umc.study.service.MemberService;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import umc.study.domain.mapping.Review;

public interface MemberQueryService {
    Page<Review> getReviewList(Long MemberId, Integer page);
    //Page는 Spring Data JPA에서 제공하는 Paging을 위한 추상화를 제공
}
