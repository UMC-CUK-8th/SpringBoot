package umc.study.repository.ReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import umc.study.domain.Market;
import umc.study.domain.mapping.Review;

public interface ReviewRepository extends JpaRepository<Review,Long>, ReviewRepositoryCustom {

    Page<Review> findAllByMarket(Market market, PageRequest pageRequest);

}
