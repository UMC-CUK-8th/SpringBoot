package umc.study.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.enums.Status;
import umc.study.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {

    
    List<MemberMission> findByUserId(Long userId);
    List<MemberMission> findByUserIdAndStatus(Long userId, Status status);
}
