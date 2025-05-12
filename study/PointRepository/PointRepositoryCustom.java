package org.example.study.PointRepository;

import org.example.study.domain.Point;
import java.util.List;

public interface PointRepositoryCustom {
    List<Point> dynamicQueryWithBooleanBuilder(Long memberId);
}