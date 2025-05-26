package umc.spring.service.missionCursorService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.missionRepository.MissionRepository;
import umc.spring.web.dto.MissionCursor;

import java.util.List;

/*@Service
@RequiredArgsConstructor
public class MissionCursorQueryServiceImpl implements MissionCursorQueryService {

    *//*private final MissionRepository missionRepository;

    @Override
    public List<MissionCursor> findMissionsByCursor(Long userId, String cursorValue, Long cursorId, int limit) {

        List<MissionCursor> filteredMissionCursors = missionRepository.dynamicQueryWithBooleanBuilder2(userId, cursorValue, cursorId, limit);

        filteredMissionCursors.forEach(mission -> System.out.println("Mission: " + mission));

        return filteredMissionCursors;

    }*//*
}*/
