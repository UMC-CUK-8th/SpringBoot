package umc.spring.service.reviewService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.UserRequestDTO;

public interface ReviewCommandService {

    Review joinReview(ReviewRequestDTO.JoinDTO request);
    Page<Review> getReviewList(Long userId, Integer page);
}
