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
public class Market extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false,length = 20)
    private String name;
    @Column(nullable = false,length = 20)
    private String food;
    @Column(nullable = true)
    private String description;
    @Column(nullable = true)
    private String picture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mission_id")
    private Mission mission;


    @OneToMany(mappedBy = "market",cascade = CascadeType.ALL)
    private List<Review> reviewList=new ArrayList<>();
}
