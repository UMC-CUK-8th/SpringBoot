package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.mapping.Review;
import umc.study.domain.mapping.UserMissionPointcounter;
import umc.study.dto.member.MemberRequestDTO;
import umc.study.dto.member.MemberResponseDTO;
import umc.study.domain.Member;
import umc.study.domain.enums.Gender;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//Member 객체를 만드는 작업 (클라이언트가 준 DTO to Entity)를 지금 클래스위치인 converter에서 함
public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getMemberId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.male;
                break;
            case 2:
                gender = Gender.female;
                break;
            case 3:
                gender = Gender.none;
                break;
        }

        return Member.builder()
                .name(request.getName())
                .nickname(request.getNickname())
                .email(request.getEmail())
                .gender(gender)
                .birth(request.getBirth())
                .memberPreferList(new ArrayList<>())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .password(request.getPassword())
                .role(request.getRole())
                .build();
    }


    public static MemberResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){


        return MemberResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getNickname())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .description(review.getDescription())
                .build();
    }
    //Page를 데이터 타입으로 설정함으로 isLast()등 다양한 메소드들을 사용할 수 있다
    public static MemberResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

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



    //회원의 진행중인 미션 컨버터
    public static MemberResponseDTO.challengingMissionPreViewDTO challengingMissionPreViewDTO(UserMissionPointcounter challengingMission){
        return MemberResponseDTO.challengingMissionPreViewDTO.builder()
                .missionName(challengingMission.getMission().getMissionName())
                .missionDetail(challengingMission.getMission().getMissionDetail())
                .reward(challengingMission.getMission().getReward())
                .createdAt(challengingMission.getCreatedAt().toLocalDate())
                .build();
    }

    public static MemberResponseDTO.challengingMissionPreViewListDTO challengingMissionPreViewListDTO(Page<UserMissionPointcounter> challengingMissionList){

        List<MemberResponseDTO.challengingMissionPreViewDTO> challengingMissionPreViewDTOList = challengingMissionList.stream()
                .map(MemberConverter::challengingMissionPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.challengingMissionPreViewListDTO.builder()
                .isLast(challengingMissionList.isLast())
                .isFirst(challengingMissionList.isFirst())
                .totalPage(challengingMissionList.getTotalPages())
                .totalElements(challengingMissionList.getTotalElements())
                .listSize(challengingMissionPreViewDTOList.size())
                .reviewList(challengingMissionPreViewDTOList)
                .build();
    }

}
