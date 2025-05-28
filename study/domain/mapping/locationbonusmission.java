package umcstudy.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umcstudy.study.domain.Location;
import umcstudy.study.domain.Members;
import umcstudy.study.domain.Missions;
import umcstudy.study.domain.common.BaseEntity;
import umcstudy.study.domain.enums.bounscheck;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class locationbonusmission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Integer locationmissioncount;
    private Integer bounspoint;

    @Enumerated(EnumType.STRING)
    private bounscheck bonusstatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "members_id")
    private Members members;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Missions mission;

    public String toString() {
        return "location{" +
                "id=" + id +
                ", name='" + location.getLocationname() + '\'' +
                '}';
    }

}
