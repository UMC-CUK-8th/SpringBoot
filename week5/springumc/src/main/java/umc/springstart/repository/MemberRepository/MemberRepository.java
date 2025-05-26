package umc.springstart.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springstart.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}