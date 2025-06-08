package umc.study.service.MemberMissionService;

import org.springframework.data.domain.Page;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.domain.User;
import umc.study.domain.enums.Status;
import umc.study.domain.mapping.MemberMission;
import umc.study.dto.MemberMissionDTO;
import umc.study.repository.UserRepository.UserRepository;

import java.util.List;
import java.util.Optional;

public interface MemberMissionQueryService {


    List<MemberMission> findMission(Long user_id);
    List<MemberMissionDTO> findMissionByStatus(Long user_id, Status status);

    Integer showCompletedMission(Long user_id);

    Page<MemberMission> getMissionByStatus(Long userId, Status status, Integer page);
}
