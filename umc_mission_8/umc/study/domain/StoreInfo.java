package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.Review;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class StoreInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    @Column(nullable = false, length = 30)
    private String foodName;

    @Column(nullable = true, length = 20)
    private String foodInfo;

    @Column(nullable = false)
    private String storeName;

    @Lob
    private byte[] foodPicture;

    @ManyToOne
    @JoinColumn(name="owner_num")
    private OwnerList OwnerList;

    @OneToMany(mappedBy = "storeInfo", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "storeInfo", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    @Override
    public String toString() {
        return "Store{" +
                "id=" + storeId +
                ", name='" + storeName + '\'' +
                ", foodInfo='" + foodInfo + '\'' +
                '}';
    }


}
