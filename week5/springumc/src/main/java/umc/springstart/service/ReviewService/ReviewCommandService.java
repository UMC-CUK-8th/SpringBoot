package umc.springstart.service.ReviewService;

import jakarta.validation.Valid;
import umc.springstart.domain.Review;
import umc.springstart.web.dto.ReviewDTO.ReviewRequestDTO;

public interface ReviewCommandService {
    Review addReview(ReviewRequestDTO.@Valid AddReviewDTO request);
}