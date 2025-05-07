package repository.StoreRepository;
import org.example.study.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}