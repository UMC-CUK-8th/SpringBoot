package umc.spring.domain.mapping;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(20)")
    @Enumerated(EnumType.STRING)
    private MissionStatus status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void setMission(Mission mission) {
        this.mission = mission;
        mission.getUserMissionList().add(this);
    }

    public void setUser(User user) {
        this.user = user;
        user.getUserMissionList().add(this);
    }


}
