package umc.study.service.UserMissionPointCounter;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.apiPayload.exception.handler.PreferencesHandler;
import umc.study.apiPayload.exception.handler.UserMissionPointCounterHandler;
import umc.study.converter.MissionConverter;
import umc.study.converter.UserMissionPointCounterConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.UserMissionPointcounter;
import umc.study.dto.usermissionpointcounterDTO.UserMissionPointCounterRequestDTO;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.UserMemberPointcounterRepository.UmpRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserMissionPointCounterCommandServiceImpl implements UserMissionPointCounterCommandService{
    private final UmpRepository umpRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public UserMissionPointcounter joinUserMissionPointCounter(UserMissionPointCounterRequestDTO.JoinDTO request) {
        UserMissionPointcounter newUserMissionPointcounter = UserMissionPointCounterConverter.toUserMissionPointCounter(request);

        log.info("🔍 Received missionId: {}", request.getMissionId());
        log.info("🔍 Received memberId: {}", request.getMemberId());

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        newUserMissionPointcounter.setMission(mission);

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MEMBER_NOT_FOUND));
        newUserMissionPointcounter.setMember(member);


/*
        UserMissionPointcounter statuses = umpRepository.findById((long) request.getStatuses())
                .orElseThrow(()-> new PreferencesHandler(ErrorStatus.STATUSES_CATEGORY_NOT_FOUND));
        */
        return umpRepository.save(newUserMissionPointcounter);
    }

}
