package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import umc.study.domain.Member;
import umc.study.domain.enums.MemberStatus;

import java.util.List;

//public interface MemberRepository extends JpaRepository<Member, Long> {
//    @Query("SELECT m FROM Member m WHERE m.name = :name AND m.status = :status")
//    List<Member> findByNameAndStatus(String name, MemberStatus status);
//
//}
public interface MemberRepository extends JpaRepository<Member, Long> {
}