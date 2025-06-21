package umc.study.converter;

import umc.study.domain.Preferences;
import umc.study.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {
//List<Preferences>를 List<MemberPrefer>로 변환하는 과정이며 최종적으로 리스트로 결과를 수집하는 부분이 collect(Collectors.toList())입니다
    //map에서 Preferences > MemberPrefer 으로 전환한다
    public static List<MemberPrefer> toMemberPreferList(List<Preferences> PreferencesList){

        return PreferencesList.stream()
                .map(preferences ->
                        MemberPrefer.builder()
                                .preferences(preferences)
                                .build()
                ).collect(Collectors.toList());
    }
}
