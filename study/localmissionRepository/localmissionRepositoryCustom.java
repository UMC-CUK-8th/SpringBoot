package umcstudy.study.localmissionRepository;

import umcstudy.study.domain.enums.missionVisit;
import umcstudy.study.domain.mapping.locationbonusmission;
import java.util.List;

public interface localmissionRepositoryCustom {
    List<locationbonusmission> dynamicQueryWithBooleanBuilder(String localname);
}