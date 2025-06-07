package umcstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcstudy.study.domain.Members;

import java.util.Optional;

public interface MemberRegiRepository extends JpaRepository<Members, Long> {
    Optional<Members> findByMemID(String memID);
}
