package umc.study.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import umc.study.domain.Mission;
import umc.study.domain.mapping.Review;
import umc.study.domain.mapping.UserMissionPointcounter;
import umc.study.dto.member.MemberResponseDTO;

public interface MemberQueryService {
    //Page는 Spring Data JPA에서 제공하는 Paging을 위한 추상화를 제공
    Page<Review> getReviewList(Long MemberId, Integer page);
    Page<UserMissionPointcounter> getChallengingMissionList(Long MemberId, Integer page);
    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}
