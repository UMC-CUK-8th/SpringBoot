package umc.study.service.MemberMissionService;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.domain.Mission;
import umc.study.domain.User;
import umc.study.domain.enums.Status;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MarketRepository.MarketRepository;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.UserRepository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor

public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;
    private final MarketRepository marketRepository;

    @Override
    public Long ChallengeMission(Long userId, Long missionId) {
        User user = userRepository.findById(userId)
                // findBYUserId를 옵셔널로 감싸야 orELseThrhow가 활성화되는데 안 감싸서 생긴 문제
                // 왜 밑에의 findById는 Long을 잘 받는데 여긴 int만 받는지?
                .orElseThrow(()-> new GeneralException(ErrorStatus.USER_NOT_FOUND)  );
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(()-> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

        MemberMission memberMission = memberMissionRepository.findByUserIdAndMissionId(userId,missionId)
                .orElseThrow(()-> new GeneralException(ErrorStatus.MEMBER_MISSION_NOT_FOUND));


        if (memberMission.getStatus()!= Status.BEFORE_START) {
            throw new GeneralException(ErrorStatus.MISSION_STATUS_IS_NOT_BEFORE_START);
        }

        memberMission.changeStatus(Status.IN_PROGRESS);


        return memberMission.getId();
    }

    @Override
    public Long ChallengeMarketMission(Long userId, Long missionId, Long marketId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.USER_NOT_FOUND));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

        if (!mission.getMarket().getId().equals(marketId)) {
            throw new GeneralException(ErrorStatus.MISSION_NOT_BELONG_TO_MARKET);
        }

        MemberMission memberMission = memberMissionRepository.findByUserIdAndMissionId(userId, missionId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));


        if (memberMission.getStatus() != Status.BEFORE_START) {
            throw new GeneralException(ErrorStatus.MISSION_STATUS_IS_NOT_BEFORE_START);
        }

        memberMission.changeStatus(Status.IN_PROGRESS);

        return memberMission.getId();
    }
}
