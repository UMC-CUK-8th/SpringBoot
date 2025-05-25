package umc.springstart.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springstart.converter.ReviewConverter;
import umc.springstart.domain.Member;
import umc.springstart.domain.Review;
import umc.springstart.domain.Store;
import umc.springstart.repository.MemberRepository.MemberRepository;
import umc.springstart.repository.ReviewRepository.ReviewRepository;
import umc.springstart.repository.StoreRepository.StoreRepository;
import umc.springstart.web.dto.ReviewDTO.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Review addReview(ReviewRequestDTO.AddReviewDTO request){
        Review newReview = ReviewConverter.toReview(request);
        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(() -> new RuntimeException("Store not found with ID: " + request.getStoreId()));
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found with ID: " + request.getMemberId()));

        newReview.setStore(store);
        newReview.setMember(member);
        return reviewRepository.save(newReview);
    }

}
