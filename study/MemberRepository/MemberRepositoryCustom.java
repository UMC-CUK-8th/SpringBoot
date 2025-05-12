package org.example.study.MemberRepository;


import org.example.study.domain.Members;
import org.example.study.domain.Point;

import java.util.List;
import java.util.Optional;

public interface MemberRepositoryCustom {
    List<Members> dynamicQueryWithBooleanBuilder(String ID);
}