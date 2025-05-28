package umcstudy.study.ReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umcstudy.study.domain.Members;
import umcstudy.study.domain.mapping.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepository extends JpaRepository<Reviews, Long>, ReviewRepositoryCustom {
    Page<Reviews> findAllByMembers(Members members, PageRequest pageRequest);
}