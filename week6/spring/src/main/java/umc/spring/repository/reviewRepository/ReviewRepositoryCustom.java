package umc.spring.repository.reviewRepository;

import umc.spring.domain.Review;

import java.time.LocalDate;
import java.util.List;

public interface ReviewRepositoryCustom {

    List<Review> dynamicQueryWithBooleanBuilder(LocalDate WritingDate, Float score);
}

