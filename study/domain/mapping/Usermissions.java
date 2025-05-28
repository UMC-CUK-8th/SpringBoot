package umcstudy.study.domain.mapping;


import jakarta.persistence.*;
import lombok.*;
import umcstudy.study.domain.Members;
import umcstudy.study.domain.Missions;
import umcstudy.study.domain.Store;
import umcstudy.study.domain.common.BaseEntity;
import umcstudy.study.domain.enums.missionVisit;

@Setter
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

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;


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
