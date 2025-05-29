package umcstudy.study.PointRepository;

import umcstudy.study.PointRepository.PointRepositoryCustom;
import umcstudy.study.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PointRepository extends JpaRepository<Point, Long>, PointRepositoryCustom {
}