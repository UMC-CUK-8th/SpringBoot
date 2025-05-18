package umc.study.repository.UserMemberPointcounterRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.UserMissionPointcounter;

//서비스단에서 사용됨
public interface UmpRepository extends JpaRepository<UserMissionPointcounter, Long>, UmpRepositoryCustom {
}
