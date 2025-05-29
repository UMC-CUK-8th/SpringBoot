package umcstudy.study.MemberRepository;


import umcstudy.study.domain.Members;
import umcstudy.study.domain.Point;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Members> dynamicQueryWithBooleanBuilder(String ID);
}