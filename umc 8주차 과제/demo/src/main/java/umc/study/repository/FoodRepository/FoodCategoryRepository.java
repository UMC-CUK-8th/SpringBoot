package umc.study.repository.FoodRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory,Long> {
}
