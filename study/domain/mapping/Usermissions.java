package org.example.study.domain.mapping;


import jakarta.persistence.*;
import lombok.*;
import org.example.study.domain.Members;
import org.example.study.domain.Missions;
import org.example.study.domain.common.BaseEntity;
import org.example.study.domain.enums.missionVisit;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Usermissions extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Enumerated(EnumType.STRING)
    private missionVisit visitstatus;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "members_id")
    private Members members;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "missions_id")
    private Missions missions;

    @Override
    public String toString() {
        return "mission{" +
                "id=" + id +
                ", name='" + missions.getMissionname() + '\'' +
                ", point='" + missions.getMissionpoint() + '\'' +
                '}';
    }
}
