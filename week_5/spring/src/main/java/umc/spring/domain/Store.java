package umc.spring.domain;


import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.UserAgree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 10)
    private String cuisine;

    private String address;

    private Float score;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();
}
