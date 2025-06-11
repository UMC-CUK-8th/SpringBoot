package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.Role;
import umc.study.domain.mapping.MemberPrefer;
import umc.study.domain.mapping.Review;
import umc.study.domain.mapping.UserMissionPointcounter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@DynamicUpdate
@DynamicInsert
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = true, length = 100)
    private String address;



    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Column(nullable = true, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean isActive;

    @Column(nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime deletedAt;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15)")
    private Gender gender;

    @ColumnDefault("0")
    private Integer point;


    @Column(nullable = false, length = 30, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


    public void encodePassword(String password) {
        this.password = password;
    }


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> ReviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<UserMissionPointcounter> UserMissionPointcounter = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Crm> Crm = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    public void setMemberPreferList(List<MemberPrefer> memberPreferList) {
        this.memberPreferList = memberPreferList;
        for (MemberPrefer mp : memberPreferList) {
            mp.setMember(this); // 역방향도 자동 설정
        }
    }

}
