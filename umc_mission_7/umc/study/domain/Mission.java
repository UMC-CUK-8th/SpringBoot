package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.Review;
import umc.study.domain.mapping.UserMissionPointcounter;

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
    private int missionid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId")
    private StoreInfo storeInfo;

    @Column(nullable = false)
    private String missionname;

    private int reward;

    @Column(nullable = false)
    private String missionDetail;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<Review> Review = new ArrayList<>();

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<UserMissionPointcounter> UserMissionPointcounter = new ArrayList<>();

}
