package umc.springstart.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springstart.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    Optional<Member> findByEmail(String email);
}