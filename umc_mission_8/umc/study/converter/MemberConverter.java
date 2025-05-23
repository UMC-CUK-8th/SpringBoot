package umc.study.converter;

import umc.study.dto.member.MemberRequestDTO;
import umc.study.dto.member.MemberResponseDTO;
import umc.study.domain.Member;
import umc.study.domain.enums.Gender;

import java.time.LocalDateTime;
import java.util.ArrayList;


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
                .build();
    }
}
