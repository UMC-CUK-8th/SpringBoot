package umcstudy.study.ReviewService;


import lombok.RequiredArgsConstructor;
import umcstudy.study.MemberRepository.MemberRepository;
import umcstudy.study.ReviewRepository.ReviewRepository;
import umcstudy.study.ReviewService.ReviewQueryService;
import umcstudy.study.StoreRepository.StoreRepository;
import umcstudy.study.domain.Members;
import umcstudy.study.domain.Store;
import umcstudy.study.domain.mapping.Reviews;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository ReviewRepository;
    private final StoreRepository StoreRepository;
    private final MemberRepository MemberRepository;

    @Override
    public Optional<Reviews> findReview(Long id) {
        return ReviewRepository.findById(id);
    }

    @Override
    public void writeReview(String contents, int star, String memId, String storename) {
        Members member = MemberRepository.findByMemID(memId)
                .orElseThrow(() -> new IllegalArgumentException("No exist Member" + memId));

        Store store = StoreRepository.findByStorename(storename)
                .orElseThrow(() -> new IllegalArgumentException("No exist Store" + storename));

        Reviews review = Reviews.builder()
                .text(contents)
                .reviewstar(star)
                .members(member)
                .store(store)
                .build();
        ReviewRepository.save(review);
    }
}