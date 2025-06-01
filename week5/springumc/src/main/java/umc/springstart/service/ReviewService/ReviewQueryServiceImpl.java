package umc.springstart.service.ReviewService;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springstart.converter.ReviewConverter;
import umc.springstart.domain.Review;
import umc.springstart.domain.enums.MemberStatus;
import umc.springstart.web.dto.ReviewDTO.ReviewResponseDTO;
import umc.springstart.web.dto.ReviewDto;
import umc.springstart.exception.ReviewNotFoundException;
import umc.springstart.repository.ReviewRepository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;

    @Override
    public Review findReview(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException(id));
    }

    @Override
    public List<ReviewDto> findReviewsByIdAndUserStatus(Long id, MemberStatus memberStatus) {

        return reviewRepository.findStoreIdAndMemberStatus(id, memberStatus);
    }

    @Override
    public ReviewResponseDTO.MyReviewListDTO getMyReviewList(Long memberId, Integer page) {
        Pageable pageable = PageRequest.of(page-1, 10);
        Page<Review> reviewPage = reviewRepository.findByMemberId(memberId, pageable);

        return ReviewConverter.toMyReviewListDTO(reviewPage);
    }

}
