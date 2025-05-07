package umc.springstart.service.ReviewService;


import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springstart.domain.Review;
import umc.springstart.domain.enums.MemberStatus;
import umc.springstart.repository.ReviewRepository.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Review> findReview(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Tuple> findReviewsByIdAndUserStatus(Long id, MemberStatus memberStatus) {
        List<Tuple> filteredReviews = reviewRepository.findStoreIdAndMemberStatus(id, memberStatus);

        filteredReviews.forEach(review -> System.out.println("Review: " + review));

        return filteredReviews;
    }
}
