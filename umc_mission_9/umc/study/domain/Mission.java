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
    @Column(name = "missionid")
    private Long missionId;

    @Column(name = "missionname",nullable = false)
    private String missionName;

    @Column(nullable = false)
    private int reward;

    @Column(name = "mission_detail",nullable = false)
    private String missionDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private StoreInfo storeInfo;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<UserMissionPointcounter> userMissionPointcounter = new ArrayList<>();

    public void setStoreInfo(StoreInfo storeInfo){//해당 데이터타입으로 바꾸기 위한 연관관계 설정
        if(this.storeInfo != null)
            storeInfo.getMissionList().remove(this);//바뀌어지는 데이터 타입
        this.storeInfo = storeInfo;
        storeInfo.getMissionList().add(this);
    }

}
