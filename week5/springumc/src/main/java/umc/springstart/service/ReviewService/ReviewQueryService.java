package umc.springstart.service.ReviewService;

import com.querydsl.core.Tuple;
import umc.springstart.domain.Review;
import umc.springstart.domain.enums.MemberStatus;

import java.util.List;
import java.util.Optional;

public interface ReviewQueryService {
    Optional<Review> findReview(Long id);
    List<Tuple> findReviewsByIdAndUserStatus(Long id, MemberStatus memberStatus);
}