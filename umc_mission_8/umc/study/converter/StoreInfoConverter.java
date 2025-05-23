package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.StoreInfo;
import umc.study.domain.enums.Gender;
import umc.study.dto.member.MemberRequestDTO;
import umc.study.dto.member.MemberResponseDTO;
import umc.study.dto.reviewDTO.ReviewResponseDTO;
import umc.study.dto.storeInfoDTO.StoreInfoRequestDTO;
import umc.study.dto.storeInfoDTO.StoreInfoResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class StoreInfoConverter {

    public static StoreInfoResponseDTO.JoinResultDTO toJoinResultDTO(StoreInfo storeinfo){
        return StoreInfoResponseDTO.JoinResultDTO.builder()
                .storeId(storeinfo.getStoreId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static StoreInfo toStoreInfo(StoreInfoRequestDTO.JoinDto request){


        return StoreInfo.builder()
                .reviewList(new ArrayList<>())
                .storeName(request.getStoreName())
                .foodName(request.getFoodName())
                .build();
    }
}
