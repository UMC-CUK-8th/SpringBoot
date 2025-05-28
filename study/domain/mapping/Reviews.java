package umcstudy.study.domain.mapping;


import jakarta.persistence.*;
import lombok.*;
import umcstudy.study.domain.Members;
import umcstudy.study.domain.Store;
import umcstudy.study.domain.common.BaseEntity;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Reviews extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false, length = 200)
    private String text;

    private Integer reviewstar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "members_id")
    private Members members;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

}
