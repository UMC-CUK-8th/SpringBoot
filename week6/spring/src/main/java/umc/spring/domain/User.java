package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.mapping.UserAgree;
import umc.spring.domain.mapping.UserFood;
import umc.spring.domain.mapping.UserMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(columnDefinition = "VARCHAR(10)")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false, length = 20)
    private String address;


    private LocalDate birthDate;

    @Column(nullable = false, length = 40)
    private String email;

    private Integer point;

    private LocalDate inactiveDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserAgree> userAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserFood> userFoodList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();


}
