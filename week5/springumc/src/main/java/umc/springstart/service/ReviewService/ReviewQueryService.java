package umc.springstart.service.ReviewService;

import umc.springstart.domain.Review;
import umc.springstart.domain.enums.MemberStatus;
import umc.springstart.dto.ReviewDto;

import java.util.List;

public interface ReviewQueryService {
    Review findReview(Long id);
    List<ReviewDto> findReviewsByIdAndUserStatus(Long id, MemberStatus memberStatus);
}