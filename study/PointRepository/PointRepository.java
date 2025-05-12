package org.example.study.PointRepository;

import org.example.study.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PointRepository extends JpaRepository<Point, Long>, PointRepositoryCustom {
}