package org.example.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.study.domain.common.BaseEntity;


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


}
