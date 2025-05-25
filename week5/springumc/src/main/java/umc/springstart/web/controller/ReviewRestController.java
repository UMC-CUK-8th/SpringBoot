package umc.springstart.web.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.springstart.apiPayload.ApiResponse;
import umc.springstart.converter.ReviewConverter;
import umc.springstart.domain.Review;
import umc.springstart.service.ReviewService.ReviewCommandService;
import umc.springstart.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.springstart.web.dto.ReviewDTO.ReviewResponseDTO;

@RestController
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    public ReviewRestController(ReviewCommandService reviewCommandService) {
        this.reviewCommandService = reviewCommandService;
    }

    @PostMapping("/reviews")
    public ApiResponse<ReviewResponseDTO.addResultDTO> join(@RequestBody @Valid ReviewRequestDTO.AddReviewDTO request) {
        Review review = reviewCommandService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toaddReviewDTO(review));

}}
