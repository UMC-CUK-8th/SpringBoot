package org.example.study.MemberService;


import org.example.study.domain.Members;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MemberQueryService {

    Optional<Members> findMember(Long id);
    List<Members> findMemberbyID(String ID);
}