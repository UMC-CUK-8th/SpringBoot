package umc.study.repository.ReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.StoreInfo;
import umc.study.domain.mapping.Review;

//서비스단에서 사용됨
public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
    Page<Review> findAllByStoreInfo(StoreInfo storeInfo, PageRequest pageRequest);
    Page<Review> findALLByMember(Member member, PageRequest pageRequest);

}
