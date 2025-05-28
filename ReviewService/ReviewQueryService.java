package umcstudy.study.ReviewService;

import umcstudy.study.domain.Members;
import umcstudy.study.domain.Store;
import umcstudy.study.domain.mapping.Reviews;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ReviewQueryService {
    Optional<Reviews> findReview(Long id);
    void writeReview(String contents, int star, String memId, String storename);
}
