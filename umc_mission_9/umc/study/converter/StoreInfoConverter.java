package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.StoreInfo;
import umc.study.domain.mapping.Review;
import umc.study.dto.storeInfoDTO.StoreInfoRequestDTO;
import umc.study.dto.storeInfoDTO.StoreInfoResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreInfoConverter {

    public static StoreInfoResponseDTO.JoinResultDTO toJoinResultDTO(StoreInfo storeinfo){
        return StoreInfoResponseDTO.JoinResultDTO.builder()
                .storeId(storeinfo.getStoreId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    //가게 정보 post를 위한 컨버터
    public static StoreInfo toStoreInfo(StoreInfoRequestDTO.JoinDto request){


        return StoreInfo.builder()
                .reviewList(new ArrayList<>())
                .storeName(request.getStoreName())
                .foodName(request.getFoodName())
                .build();
    }

    //하나의 리뷰에 대한 내용 컨버터
    public static StoreInfoResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreInfoResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .description(review.getDescription())
                .title(review.getTitle())
                .build();
    }
    //리뷰 리스트 컨버터
    public static StoreInfoResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<StoreInfoResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreInfoConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreInfoResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    //하나의 미션에 대한 내용
    public static StoreInfoResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return StoreInfoResponseDTO.MissionPreViewDTO.builder()
                .missionName(mission.getMissionName())
                .missionDetail(mission.getMissionDetail())
                .reward(mission.getReward())
                .build();
    }

    public static StoreInfoResponseDTO.MissionPreViewListDTO MissionPreViewListDTO(Page<Mission> missionList){

        List<StoreInfoResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(StoreInfoConverter::missionPreViewDTO).collect(Collectors.toList());

        return StoreInfoResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .reviewList(missionPreViewDTOList)
                .build();
    }


}
