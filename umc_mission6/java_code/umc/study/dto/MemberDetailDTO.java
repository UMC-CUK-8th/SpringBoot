package umc.study.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDetailDTO {
    private String nickname;
    private int phoneNumber;
    private String email;

    private int totalPoint;       // UserMissionPointcounter
    private String reviewName;    // Review
    private String title;      // Crm

}
