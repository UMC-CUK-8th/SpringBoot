package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.domain.mapping.Review;
import umc.study.dto.ReviewRequestDTO;
import umc.study.service.ReviewService.ReviewService;

@RestController
@RequiredArgsConstructor
@RequestMapping("reviews")

public class ReviewRestController {

    private final ReviewService reviewService;

    @PostMapping
    public ApiResponse<Long> addReview(@RequestBody @Valid ReviewRequestDTO.AddReviewRequest request) {
        Long reviewId = reviewService.addReview(
                request.getMissionId(),
                request.getMarketId(),
                request.getRate(),
                request.getDescription(),
                request.getPicture()
        );
        return  ApiResponse.onSuccess(reviewId);
    }

}
