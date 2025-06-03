package umc.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.domain.User;
import umc.study.domain.mapping.MemberMission;
import umc.study.dto.MemberMissionDTO;
import umc.study.domain.enums.Status;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.repository.UserRepository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;
    private final UserRepository userRepository;


    @Override
    public List<MemberMission> findMission(Long user_id) {
        return memberMissionRepository.findByUserId(user_id);
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
        return memberMissionRepository.showCompletedMissions(user_id);
    }


    @Override
    public Page<MemberMission> getMissionByStatus(Long userId,Status status, Integer page) {
        User user = userRepository.findById(userId).
                orElseThrow(() -> new GeneralException(ErrorStatus.USER_NOT_FOUND));

        Page<MemberMission> ProgressMissionPage =memberMissionRepository.findAllByUserIdAndStatus(userId, status, PageRequest.of(page,10));
        return ProgressMissionPage;
    }

}
