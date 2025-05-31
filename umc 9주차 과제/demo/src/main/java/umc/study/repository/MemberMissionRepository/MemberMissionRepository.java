package umc.study.repository.MemberMissionRepository;

import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.User;
import umc.study.domain.enums.Status;
import umc.study.domain.mapping.MemberMission;

import java.util.List;
import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {

    
    List<MemberMission> findByUserId(Long userId);
    Optional<MemberMission> findByUserIdAndMissionId(Long userId, Long missionId);


    Page<MemberMission> findAllByUserIdAndStatus(Long userId, Status status, PageRequest pageRequest);


}
