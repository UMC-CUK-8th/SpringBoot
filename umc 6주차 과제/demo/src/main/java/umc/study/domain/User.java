package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.Status;
import umc.study.domain.mapping.MemberMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity // 이 클래스가 jpa의 엔티티임을 명시
@Getter // lombok에서 제공하는 어노테이셔능로, getter를 만들어주는 어노테이션
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
// 빌더 패턴을 사용하기 위한 어노테이션 3개

public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // jpa가 통신을 하는 dbms의 방식을 따른다는 뜻
    // mysql을 사용하므로 해당 방식을 따르게 됨
    @Column(columnDefinition = "BIGINT")
    private Long id;

    @Column(nullable = false,length = 20)
    private String nickname;
    @Column(nullable = false,length = 20)
    private String password;
    @Column(nullable = false,length = 20)
    private String name;
    @Column(nullable = false,length = 255)
    private String email;
    @Column(nullable = false,length = 20)
    private String birth;
    @Column(nullable = false,length = 255)
    private String address;
    @Column(nullable = true)
    private LocalDate deleted_at;
    @Column(nullable = false,length = 11)
    private Integer phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'ACTIVE' ")
    private Status status;

    /*
    * enumType를 ordinal로 사용하면 enum의 순서가 저장됨
    * 만약 SpringBoot에서 enum의 순서를 바꿀 경우 에러가 발생하기에 반드시 STRING을 사용해야 함!!
    * */

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Point point;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<PersonalPreference> personalPreferenceList=new ArrayList<>();


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList=new ArrayList<>();


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Alarm> alarmList=new ArrayList<>();
}
