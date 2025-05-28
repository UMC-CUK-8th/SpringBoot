package umcstudy.study.domain;


import jakarta.persistence.*;
import lombok.*;
import umcstudy.study.domain.Store;
import umcstudy.study.domain.common.BaseEntity;
import umcstudy.study.domain.mapping.Reviews;
import umcstudy.study.domain.mapping.Usermissions;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Missions extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    @Column(nullable = false, length = 40)
    private String missionname;

    private Integer missionpoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "missions", cascade = CascadeType.ALL)
    private List<Usermissions> UsermissionsmissionsList = new ArrayList<>();




}
