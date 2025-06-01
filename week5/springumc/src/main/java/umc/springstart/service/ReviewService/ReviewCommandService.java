package umc.springstart.service.ReviewService;

import jakarta.validation.Valid;
import umc.springstart.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.springstart.web.dto.ReviewDTO.ReviewResponseDTO;

public interface ReviewCommandService {
    ReviewResponseDTO.addResultDTO addReview(@Valid ReviewRequestDTO.AddReviewDTO request);
}