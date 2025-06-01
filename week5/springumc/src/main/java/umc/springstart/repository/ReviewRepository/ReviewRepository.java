package umc.springstart.repository.ReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.springstart.domain.Review;
import umc.springstart.domain.Store;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);

    Page<Review> findByMemberId(Long memberId, Pageable pageable);
}
