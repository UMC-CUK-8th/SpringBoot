package umcstudy.service.ReviewService;

import umcstudy.study.domain.mapping.Reviews;
import umcstudy.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {

    Reviews registerReview(ReviewRequestDTO.RevJoinDto request);
}
