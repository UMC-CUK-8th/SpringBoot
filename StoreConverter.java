package umcstudy.converter;

import org.springframework.data.domain.Page;
import umcstudy.study.domain.Location;
import umcstudy.study.domain.Missions;
import umcstudy.study.domain.Store;
import umcstudy.study.domain.enums.missionVisit;
import umcstudy.study.domain.mapping.Reviews;
import umcstudy.study.domain.mapping.Usermissions;
import umcstudy.web.dto.MemberResponseDTO;
import umcstudy.web.dto.StoreRequestDTO;
import umcstudy.web.dto.StoreResponseDTO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store) {
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinDto request, Location location) {

        return Store.builder()
                .storename(request.getStorename())
                .storeaddress(request.getStoreaddress())
                .storetype(request.getStoretype())
                .reviewcount(request.getReviewcount())
                .location(location)
                .build();
    }

    public static StoreResponseDTO.MissionPreViewDTO missionPreViewDTO(Missions missions){
        missionVisit missionVisitList = missions.getUsermissionsmissionsList().stream()
                .map(Usermissions::getVisitstatus)
                .findFirst().get();
        return StoreResponseDTO.MissionPreViewDTO.builder()
                .locationName(missions.getStore().getLocation().getLocationname())
                .storeName((missions.getStore().getStorename()))
                .missionName(missions.getMissionname())
                .visitStatus(missionVisitList)
                .point(missions.getMissionpoint())
                .createdAt(missions.getCreatedAt().toLocalDate())
                .build();
    }
    public static StoreResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Missions> missionList){

        List<StoreResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(StoreConverter::missionPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
