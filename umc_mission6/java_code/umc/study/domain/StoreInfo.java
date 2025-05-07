package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

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
    private int storeId;

    @Column(nullable = false, length = 30)
    private String foodName;

    @Column(nullable = true, length = 20)
    private String foodInfo;

    @Column(nullable = false)
    private String storeName;

    @Lob
    private byte[] foodPicture;

    @ManyToOne
    @JoinColumn(name="ownerNum")
    private OwnerList OwnerList;

    @Override
    public String toString() {
        return "Store{" +
                "id=" + storeId +
                ", name='" + storeName + '\'' +
                ", foodInfo='" + foodInfo + '\'' +
                '}';
    }
}
