package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.StoreInfo;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String reply;

    @Column(nullable = false)
    private int score;

    @Lob
    private byte[] reviewPicture;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private StoreInfo storeInfo;


    public void setStoreInfo(StoreInfo storeInfo){//해당 데이터타입으로 바꾸기 위한 연관관계 설정
        if(this.storeInfo != null)
            storeInfo.getReviewList().remove(this);//바뀌어지는 데이터 타입
        this.storeInfo = storeInfo;
        storeInfo.getReviewList().add(this);
    }

    public void setMission(Mission mission){//해당 데이터타입으로 바꾸기 위한 연관관계 설정
        if(this.mission != null)
            mission.getReviewList().remove(this);//바뀌어지는 데이터 타입
        this.mission = mission;
        mission.getReviewList().add(this);
    }

}
