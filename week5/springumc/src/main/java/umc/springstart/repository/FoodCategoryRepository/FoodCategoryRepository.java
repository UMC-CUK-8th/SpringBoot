package umc.springstart.repository.FoodCategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springstart.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
