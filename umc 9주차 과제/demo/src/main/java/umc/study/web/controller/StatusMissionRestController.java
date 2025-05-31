package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.enums.Status;
import umc.study.domain.mapping.MemberMission;
import umc.study.dto.MemberMissionDTO;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.service.MemberMissionService.MemberMissionQueryService;
import umc.study.validation.annotation.ValidPage;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class StatusMissionRestController {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberMissionQueryService memberMissionQueryService;

    @GetMapping("/{memberId}/missions/in-progress")
    @Operation(summary = "진행 중인 미션 목록 조회 API", description = "특정 회원의 진행 중인 미션 목록 조회")
    public ApiResponse<MemberMissionDTO.ProgessMisssionPreviewDTOList> getProgressMissions(@PathVariable("memberId") Long userId,
                                                                                           @ValidPage Integer page) {
        Page<MemberMission> missionPage=memberMissionQueryService.getMissionByStatus(userId, Status.IN_PROGRESS, page);
        return ApiResponse.onSuccess(MemberMissionConverter.toProgessMissionPreviewDTOList(missionPage));
    }

    @GetMapping("/{memberId}/missions/completed")
    @Operation(summary = "진행 완료한 미션 목록 조회 API", description = "특정 회원의 완료한 미션 목록 조회")
    public ApiResponse<MemberMissionDTO.ProgessMisssionPreviewDTOList> getCompletedMissions(@PathVariable("memberId") Long userId,
                                                                                           @ValidPage Integer page) {
        Page<MemberMission> missionPage=memberMissionQueryService.getMissionByStatus(userId, Status.COMPLETED, page);
        return ApiResponse.onSuccess(MemberMissionConverter.toProgessMissionPreviewDTOList(missionPage));
    }

}
