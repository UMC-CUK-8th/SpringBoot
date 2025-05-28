package umcstudy.service.ReviewService;

import umcstudy.study.domain.mapping.Reviews;
import umcstudy.web.dto.ReviewRequestDTO;
import umcstudy.web.dto.ReviewResponseDTO;

public interface ReviewCommandService {

    ReviewResponseDTO.RevJoinResultDTO registerReview(ReviewRequestDTO.RevJoinDto request);
}
