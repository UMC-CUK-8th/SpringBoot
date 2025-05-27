package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Market;
import umc.study.domain.mapping.Review;
import umc.study.dto.MarketResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MarketConverter {

    public static MarketResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review) {
        return MarketResponseDTO.ReviewPreViewDTO.builder()

                //.ownerNickname(review.getMission().getMemberMission().getUser().getNickname())
                .rate(review.getRate())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getDescription())
                .build();
    }

    public static MarketResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList) {
        List<MarketResponseDTO.ReviewPreViewDTO>reviewPreViewDTOList = reviewList.stream()
                .map(MarketConverter::reviewPreViewDTO).collect(Collectors.toList());


        return MarketResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}