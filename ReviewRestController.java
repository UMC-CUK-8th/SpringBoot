package umcstudy.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umcstudy.apiPayload.ApiResponse;
import umcstudy.converter.ReviewConverter;
import umcstudy.service.ReviewService.ReviewCommandService;
import umcstudy.study.domain.mapping.Reviews;
import umcstudy.web.dto.ReviewRequestDTO;
import umcstudy.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.RevJoinResultDTO> register(@RequestBody @Valid ReviewRequestDTO.RevJoinDto request) {
        ReviewResponseDTO.RevJoinResultDTO RevreponseDTO = reviewCommandService.registerReview(request);
        return ApiResponse.onSuccess(RevreponseDTO);
    }
}
