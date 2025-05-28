package umcstudy.converter;

import org.springframework.data.domain.Page;
import umcstudy.study.domain.mapping.Reviews;
import umcstudy.web.dto.MemberResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Reviews reviews){
        return MemberResponseDTO.ReviewPreViewDTO.builder()
                .storeName(reviews.getStore().getStorename())
                .nickname((reviews.getMembers().getMemID()))
                .reviewStar(reviews.getReviewstar())
                .createdAt(reviews.getCreatedAt().toLocalDate())
                .text(reviews.getText())
                .build();
    }
    public static MemberResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Reviews> reviewList){

        List<MemberResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(MemberConverter::reviewPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}


