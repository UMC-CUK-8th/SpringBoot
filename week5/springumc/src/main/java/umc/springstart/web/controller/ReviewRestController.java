package umc.springstart.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.springstart.apiPayload.ApiResponse;
import umc.springstart.domain.Review;
import umc.springstart.service.ReviewService.ReviewCommandService;
import umc.springstart.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.springstart.web.dto.ReviewDTO.ReviewResponseDTO;

@RestController
@Tag(name = "Review", description = "Review API")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    public ReviewRestController(ReviewCommandService reviewCommandService) {
        this.reviewCommandService = reviewCommandService;
    }

    @PostMapping("/reviews")
    @Operation(summary = "리뷰작성하기", description = "리뷰작성하기")
    public ApiResponse<ReviewResponseDTO.addResultDTO> join(@RequestBody @Valid ReviewRequestDTO.AddReviewDTO reviewReq) {
        return ApiResponse.onSuccess(reviewCommandService.addReview(reviewReq));

}}
