package umc.springstart.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.springstart.domain.enums.MissionStatus;
import umc.springstart.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    Page<MemberMission> findByMemberIdAndStatus(Long memberId, MissionStatus status, Pageable pageable);
}

