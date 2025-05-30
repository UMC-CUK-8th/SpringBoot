package umc.study.repository.UserMemberPointcounterRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Member;
import umc.study.domain.StoreInfo;
import umc.study.domain.enums.Statuses;
import umc.study.domain.mapping.Review;
import umc.study.domain.mapping.UserMissionPointcounter;

//서비스단에서 사용됨
public interface UmpRepository extends JpaRepository<UserMissionPointcounter, Long>, UmpRepositoryCustom {
    Page<UserMissionPointcounter> findAllByMemberAndStatus(Member member, Statuses status, Pageable pageable);
    boolean existsByMember_MemberIdAndMission_MissionIdAndStatus(Long memberId, Long missionId, Statuses status);
}
