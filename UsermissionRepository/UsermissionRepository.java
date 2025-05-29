package umcstudy.study.UsermissionRepository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umcstudy.study.domain.Members;
import umcstudy.study.domain.Missions;
import umcstudy.study.domain.Store;
import umcstudy.study.domain.enums.missionVisit;
import umcstudy.study.domain.mapping.Usermissions;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsermissionRepository extends JpaRepository<Usermissions, Long>, UsermissionRepositoryCustom {
    Page<Usermissions> findByMembersAndVisitstatus(Members members, missionVisit visitStatus, PageRequest pageRequest);
}