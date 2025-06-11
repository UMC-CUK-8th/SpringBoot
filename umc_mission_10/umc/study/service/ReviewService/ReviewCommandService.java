package umc.study.service.ReviewService;

import umc.study.domain.mapping.Review;
import umc.study.dto.reviewDTO.ReviewRequestDTO;

public interface ReviewCommandService {
    Review joinReview(ReviewRequestDTO.JoinDto request);
}
