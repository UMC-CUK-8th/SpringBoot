package umc.study.domain;

import com.mysql.cj.protocol.ColumnDefinition;
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
    @Column(columnDefinition = "FLOAT")
    private Float rate;
    @Column(nullable = false,length = 20)
    private String food;
    @Column(nullable = false,length = 20)
    private String category;
    @Column(nullable = true)
    private String description;
    @Column(nullable = true)
    private String picture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mission_id")
    private Mission mission;


    @OneToMany(mappedBy = "market",cascade = CascadeType.ALL)
    private List<Review> reviewList=new ArrayList<>();


    @Override
    public String toString() {
        return "가게정보 " +
                "가게 id: " + id +
                ", 가게명: " + name+
                ", 가게 별점: " + rate+
                ", 파는 음식 종류: " + category+
                ". 파는 음식: "+ food+
                ", 설명: "+ description;
    }


}
