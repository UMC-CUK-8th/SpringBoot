package umcstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcstudy.study.domain.mapping.Reviews;

public interface ReviewRegiRepository extends JpaRepository<Reviews, Long> {
}