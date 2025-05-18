package umc.study.service.ChallengeService;


import umc.study.ApiMission4.code.MissionChallengeRequestDTO;
import umc.study.domain.mapping.MemberMission;

public interface MissionChallengeService {
    MemberMission challengeMission(MissionChallengeRequestDTO request);
}