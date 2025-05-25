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
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}