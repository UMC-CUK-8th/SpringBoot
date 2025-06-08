package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.domain.mapping.Review;
import umc.study.dto.MarketResponseDTO;
import umc.study.dto.ReviewRequestDTO;
import umc.study.service.ReviewService.ReviewService;
import umc.study.validation.annotation.ExistMarket;

import java.util.List;

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
