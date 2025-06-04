package umc.springstart.service.ReviewService;

import umc.springstart.domain.Review;
import umc.springstart.domain.enums.MemberStatus;
import umc.springstart.web.dto.ReviewDTO.ReviewResponseDTO;
import umc.springstart.web.dto.ReviewDto;

import java.util.List;

public interface ReviewQueryService {
    Review findReview(Long id);
    List<ReviewDto> findReviewsByIdAndUserStatus(Long id, MemberStatus memberStatus);

    ReviewResponseDTO.MyReviewListDTO getMyReviewList(Long memberId, Integer page);
}