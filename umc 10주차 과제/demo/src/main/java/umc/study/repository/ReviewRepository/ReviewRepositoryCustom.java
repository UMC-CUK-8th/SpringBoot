package umc.study.repository.ReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import umc.study.dto.ReviewDTO;

public interface ReviewRepositoryCustom {
    Long insertReviewWithQueryDSL(Long missionId,Long marketId, Float rate, String description, String picure);

    Page<ReviewDTO.UserReviewDTO> findReviewByUserId(Long userId, Pageable pageable);

}
