package org.example.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.study.domain.common.BaseEntity;
import org.example.study.domain.mapping.Reviews;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false, length = 50)
    private String storename;

    @Column(nullable = false, length = 40)
    private String storelocation;

    @Column(nullable = false, length = 20)
    private String storetype;


    private Integer reviewcount;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Reviews> reviewsList = new ArrayList<>();

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + storename + '\'' +
                ", address='" + storelocation + '\'' +
                ", type=" + storetype +
                 // region의 이름 출력
                '}';
    }
}

