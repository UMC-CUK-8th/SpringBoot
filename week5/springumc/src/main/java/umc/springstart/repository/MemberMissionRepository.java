package umc.springstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springstart.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}

