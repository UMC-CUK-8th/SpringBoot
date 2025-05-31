package umc.spring.service.missionCursorService;

import umc.spring.web.dto.MissionCursor;

import java.util.List;

public interface MissionCursorQueryService {
    List<MissionCursor> findMissionsByCursor(Long userId, String cursorValue, Long cursorId, int limit);
}
