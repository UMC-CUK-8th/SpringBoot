package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

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
}
