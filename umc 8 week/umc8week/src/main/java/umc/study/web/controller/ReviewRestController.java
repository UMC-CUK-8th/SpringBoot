package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.ApiMission2.code.ReviewRequestDTO;
import umc.study.ApiMission2.code.ReviewResponseDTO;
import umc.study.ApiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.ReviewService.ReviewCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/create")
    public ApiResponse<ReviewResponseDTO> createReview(@RequestBody @Valid ReviewRequestDTO request) {
        Review review = reviewCommandService.createReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toDTO(review));
    }
}
