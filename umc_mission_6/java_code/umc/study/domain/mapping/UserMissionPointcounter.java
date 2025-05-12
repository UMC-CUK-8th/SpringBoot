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
    private int phonenumberMissionid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phoneNumber")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "missionId")
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
}
