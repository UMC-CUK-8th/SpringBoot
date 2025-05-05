package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.Mission;
import umc.study.domain.User;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.IsConfirmed;
import umc.study.domain.enums.Status;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT")
    private Long id;
    @Column(columnDefinition = "INT")
    private Integer completedMission;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mission_id")
    private Mission mission;

}
