package umc.study.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Member;

import java.util.Optional;

//서비스단에서 사용됨
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    Optional<Member> findByEmail(String email);
}

