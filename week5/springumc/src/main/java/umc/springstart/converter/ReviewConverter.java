package umc.springstart.converter;

import org.springframework.data.domain.Page;
import umc.springstart.domain.Member;
import umc.springstart.domain.Review;
import umc.springstart.domain.Store;
import umc.springstart.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.springstart.web.dto.ReviewDTO.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static ReviewResponseDTO.addResultDTO toaddReviewDTO(Review review){
        return ReviewResponseDTO.addResultDTO.builder()
                .createdAt(review.getCreatedAt())
                .build();
    }
    public static Review toReview(ReviewRequestDTO.AddReviewDTO request, Store store, Member member) {
        Review review = Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .build();

        review.setStore(store);
        review.setMember(member);

        return review;
    }

    public static ReviewResponseDTO.MyReviewItemDTO toMyReviewItemDTO(Review review) {
        return ReviewResponseDTO.MyReviewItemDTO.builder()
                .reviewId(review.getId())
                .score(review.getScore())
                .body(review.getBody())
                .createdAt(review.getCreatedAt())
                .storeName(review.getStore().getName())
                .build();
    }

    public static ReviewResponseDTO.MyReviewListDTO toMyReviewListDTO(Page<Review> reviewPage){
        List<ReviewResponseDTO.MyReviewItemDTO> myReviewItemDTOList = reviewPage.stream()
                .map(ReviewConverter::toMyReviewItemDTO)
                .collect(Collectors.toList());

        return ReviewResponseDTO.MyReviewListDTO.builder()
                .reviewList(myReviewItemDTOList)
                .listSize(myReviewItemDTOList.size())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements()) //리뷰개수
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .build();
    }

}
