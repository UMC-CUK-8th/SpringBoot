package umcstudy.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umcstudy.study.domain.Members;
import umcstudy.study.domain.common.BaseEntity;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Point extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private Integer missioncount;

    private Integer nowpoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "members_id")
    private Members members;


}
