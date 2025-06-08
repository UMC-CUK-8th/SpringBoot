package umc.study.service.MemberMissionService;

public interface MemberMissionCommandService {
    Long ChallengeMission(Long userId,Long missionId) ;
    Long ChallengeMarketMission(Long userId,Long missionId, Long MarketId) ;

}
