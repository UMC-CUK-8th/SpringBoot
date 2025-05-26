package umc.springstart.service.ReviewService;


import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springstart.domain.Review;
import umc.springstart.domain.enums.MemberStatus;
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
}
