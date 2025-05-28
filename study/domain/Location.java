package umcstudy.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umcstudy.study.domain.common.BaseEntity;
import umcstudy.study.domain.mapping.Reviews;

import java.util.ArrayList;
import java.util.List;


@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

@Entity
public class Location extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false, length = 40)
    private String locationname;

    private Integer storecount;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Store> StoresList = new ArrayList<>();

}
