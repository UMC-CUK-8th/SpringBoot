package umcstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcstudy.study.domain.Location;

public interface LocationRegiRepository extends JpaRepository<Location, Long> {
}