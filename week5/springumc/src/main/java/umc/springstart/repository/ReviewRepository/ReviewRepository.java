package umc.springstart.repository.ReviewRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springstart.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
}
