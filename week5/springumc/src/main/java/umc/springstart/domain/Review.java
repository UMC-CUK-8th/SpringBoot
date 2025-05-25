package umc.springstart.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.springstart.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @Setter
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    @Setter
    private Store store;

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + id +
                ", storeId=" + (store != null ? store.getId() : "null") +
                ", memberId=" + (member != null ? member.getId() : "null") +
                ", memberStatus=" + (member != null ? member.getStatus() : "null") +
                ", body='" + body + '\'' +
                '}';
    }
}
