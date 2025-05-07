package umc.study.repository.MemberRepository;

import umc.study.dto.MemberDetailDTO;

import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberDetailDTO> fourthpicture(String nickname, int phonenumber,
                                        String email, int totalpoint, String reviewName, String crmTitle);
}
