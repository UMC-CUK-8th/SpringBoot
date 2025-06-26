package umcstudy.converter;

import org.springframework.data.domain.Page;
import umcstudy.study.domain.Location;
import umcstudy.study.domain.Members;
import umcstudy.study.domain.Store;
import umcstudy.study.domain.mapping.Reviews;
import umcstudy.web.dto.MemberRequestDTO;
import umcstudy.web.dto.MemberResponseDTO;
import umcstudy.web.dto.StoreRequestDTO;
import umcstudy.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static umcstudy.study.domain.QLocation.location;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Members members) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(members.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static MemberResponseDTO.LoginResultDTO toLoginResultDTO(Members members, String accessToken) {
        return MemberResponseDTO.LoginResultDTO.builder()
                .memberId(members.getId())
                .accessToken(accessToken)
                .build();
    }

    public static MemberResponseDTO.MemberInfoDTO toMemberInfo(Members members) {
        return MemberResponseDTO.MemberInfoDTO.builder()
                .name(members.getName())
                .memID(members.getMemID())
                .email(members.getEmail())
                .build();
    }


    public static Members toMembers(MemberRequestDTO.JoinDto request) {

        return Members.builder()
                .name(request.getName())
                .memID(request.getMemID())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .birth(request.getBirth())
                .address(request.getAddress())
                .phonenumber(request.getPhonenumber())
                .foodprefer(request.getFoodprefer())
                .build();
    }

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


