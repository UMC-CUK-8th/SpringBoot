package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Statuses;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMissionPointcounter extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phonenumberMissionid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")//db상에서 missionid - 컬럼이름이 다르지만 mission_id 로 연결되어있음
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Column(nullable = false)
    private int completedMission;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15)")
    private Statuses status;

    @Column(nullable = false)
    private int totalPoint;

    @Column(nullable = false)
    private int addPoint;

    @Column(nullable = false)
    private int usedPoint;


    public void setMission(Mission mission) {//해당 데이터타입으로 바꾸기 위한 연관관계 설정
        if (this.mission != null)
            mission.getUserMissionPointcounter().remove(this);//바뀌어지는 데이터 타입
        this.mission = mission;
        mission.getUserMissionPointcounter().add(this);
    }

    public void setMember(Member member){//해당 데이터타입으로 바꾸기 위한 연관관계 설정
        if(this.member != null)
            member.getUserMissionPointcounter().remove(this);//바뀌어지는 데이터 타입
        this.member = member;
        member.getUserMissionPointcounter().add(this);
    }

}
