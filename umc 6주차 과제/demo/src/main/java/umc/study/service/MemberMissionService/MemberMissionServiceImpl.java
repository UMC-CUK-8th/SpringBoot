package umc.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.mapping.MemberMission;
import umc.study.dto.MemberMissionDTO;
import umc.study.domain.enums.Status;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class MemberMissionServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;


    @Override
    public Optional<MemberMission> findMission(Long user_id) {
        return memberMissionRepository.findById(user_id);
    }

    @Override
    public List<MemberMissionDTO> findMissionByStatus(Long user_id, Status status) {
        List<MemberMission> filteredMission=
                memberMissionRepository.dynamicQueryWithBooleanBuilder(user_id, status);
                // 동적 쿼리로 필터링된 MemberMission 리스트를 가져옴
        return filteredMission.stream()
                // 컬렉션을 스트림으로 변환
                .map(MemberMissionDTO::fromEntity)
                //.map() -> 각 엔티티를 DTO로 변환
                .collect(Collectors.toList()); // 변환된 DTO 리스트를 수집
                // 변환된 DTO 리스트를 반환
    }

    @Override
    public Integer showCompletedMission(Long user_id) {
        Integer CM=memberMissionRepository.showCompletedMissions(user_id);
        return CM;
    }

}
