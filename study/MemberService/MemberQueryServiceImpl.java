package org.example.study.MemberService;


import lombok.RequiredArgsConstructor;
import org.example.study.MemberRepository.MemberRepository;
import org.example.study.domain.Members;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.example.study.domain.QMembers.members;
import static org.example.study.domain.QPoint.point;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;

    @Override
    public Optional<Members> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Members> findMemberbyID(String ID) {
        List<Members> filteredMember = memberRepository.dynamicQueryWithBooleanBuilder(ID);

        filteredMember.forEach(members ->
                System.out.println(" Member name: " + members.getName() +
                        " Member ID:" + members.getMemID() +
                        " Member Email:" + members.getEmail() +
                        " Member Point:" + point.nowpoint));

        return filteredMember;
    }
}