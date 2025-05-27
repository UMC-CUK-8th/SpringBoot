package umc.study.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.MemberConverter;
import umc.study.converter.MemberPreferConverter;
import umc.study.domain.Member;
import umc.study.domain.Preferences;
import umc.study.domain.mapping.MemberPrefer;
import umc.study.dto.member.MemberRequestDTO;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.PreferencesRepository.PreferencesRepository;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.PreferencesHandler;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final PreferencesRepository preferencesRepository;
    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {


        Member newMember = MemberConverter.toMember(request);
        List<Preferences> PreferencesList = request.getPreferCategory().stream()
                .map(category -> {
                    return preferencesRepository.findById(category).orElseThrow(() -> new PreferencesHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());
        //위 코드가 validation을 하는 것 이를 어노테이션으로 처리 가능
        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(PreferencesList);

       //forEach와 람다식을 이용해 각 memberPrefer 객체에 newMember를 설정하는 코드
        memberPreferList.forEach(memberPrefer -> {
            memberPrefer.setMember(newMember);// 연관관계 설정
        });


        return memberRepository.save(newMember);
    }
}
