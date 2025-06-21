package umc.study.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.mapping.Review;
import umc.study.dto.reviewDTO.ReviewRequestDTO;
import umc.study.dto.reviewDTO.ReviewResponseDTO;
import umc.study.service.ReviewService.ReviewCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.JoinResultDTO> join(@RequestBody @Valid ReviewRequestDTO.JoinDto request){
        Review review = reviewCommandService.joinReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }


}
