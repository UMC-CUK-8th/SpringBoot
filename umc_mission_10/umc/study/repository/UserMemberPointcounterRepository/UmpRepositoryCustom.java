package umc.study.repository.UserMemberPointcounterRepository;

import umc.study.domain.mapping.UserMissionPointcounter;
import umc.study.dto.UmpFirstDTO;
import umc.study.dto.UmpThirdDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface UmpRepositoryCustom {
    List<UmpFirstDTO> firstpictureWithCursor(LocalDateTime cursorCreatedAt);
    List<UmpThirdDTO> thirdpictureWithCursor(long memberId, LocalDateTime cursorCreatedAt);
}

