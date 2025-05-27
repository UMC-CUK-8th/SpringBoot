package umc.study.domain.mapping;
import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.FoodCategory;
import umc.study.domain.User;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserPrefer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(columnDefinition = "BIGINT")
    private Long id;
    @Column(nullable = false,length = 20)
    private String preferred;
    @Column(nullable = false,length = 20)
    private String notPreferred;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="food_category_id")
    private FoodCategory foodCategory;

    public void setUser(User user) {
        if (this.user != null) {
            user.getUserPreferList().remove(this);
        }
        this.user = user;
        user.getUserPreferList().add(this);
    }


    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }

}