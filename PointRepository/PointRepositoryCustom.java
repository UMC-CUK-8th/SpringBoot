package umcstudy.study.PointRepository;

import umcstudy.study.domain.Point;
import java.util.List;

public interface PointRepositoryCustom {
    List<Point> dynamicQueryWithBooleanBuilder(Long memberId);
}