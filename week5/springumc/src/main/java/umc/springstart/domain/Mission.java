package umc.springstart.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.springstart.domain.common.BaseEntity;
import umc.springstart.domain.mapping.MemberMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer reward;

    @Column(nullable = false)
    private LocalDate deadline;

    //예:만원이상 식사시
    @Column(nullable = false)
    private String missionSpec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    @Setter
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", reward=" + reward +
                ", deadline=" + deadline +
                ", missionSpec='" + missionSpec + '\'' +
                ", storeId=" + (store != null ? store.getId() : "null") +
                '}';
    }
}
