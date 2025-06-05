package umc.study.dto.member;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDetailDTO {
    private String nickname;
    private Long memberId;
    private String email;

    private int totalPoint;       // UserMissionPointcounter
    private String reviewName;    // Review
    private String title;      // Crm

}
