package umc.springstart.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springstart.apiPayload.exception.handler.FoodCategoryHandler;
import umc.springstart.converter.MemberConverter;
import umc.springstart.converter.MemberPreferConverter;
import umc.springstart.domain.FoodCategory;
import umc.springstart.domain.Member;
import umc.springstart.domain.mapping.MemberPrefer;
import umc.springstart.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.springstart.repository.MemberRepository.MemberRepository;
import umc.springstart.web.dto.memberDTO.MemberRequestDTO;
import umc.springstart.apiPayload.code.status.ErrorStatus;
import umc.springstart.web.dto.memberDTO.MemberResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public MemberResponseDTO.JoinResultDTO joinMember(MemberRequestDTO.JoinDto request) {

        //1.요청 DTO를 Member 엔티티로 변환
        Member newMember = MemberConverter.toMember(request);
        //2. 요청 DTO의 선호음식 id목록으로 푸드카테고리 엔티티 목록 조회
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        //3. 푸드카테고리 엔티티 목록을 멤버선호 엔티티 목록으로~
        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        //4. 멤버선호 엔티티 목록에 멤버 엔티티를 설정
        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        //5. 멤버 엔티티, 연관된 멤버 선호 엔티티를 db에 저장
        Member savedMember = memberRepository.save(newMember);

        //6.저장된 Member Entity를 클라이언트에 반환할 응답 DTO로 변환
        MemberResponseDTO.JoinResultDTO responseDTO = MemberConverter.toJoinResultDTO(savedMember);

        return responseDTO;
    }


}