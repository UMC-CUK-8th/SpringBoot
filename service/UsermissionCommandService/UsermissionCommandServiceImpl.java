package umcstudy.service.UsermissionCommandService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umcstudy.apiPayload.code.status.ErrorStatus;
import umcstudy.apiPayload.exception.handler.ExistMissionHandler;
import umcstudy.apiPayload.exception.handler.MissionHandler;
import umcstudy.apiPayload.exception.handler.StoreHandler;
import umcstudy.apiPayload.exception.handler.UsermissionHandler;
import umcstudy.converter.UsermissionConverter;
import umcstudy.repository.MissionRegiRepository;
import umcstudy.repository.StoreRegiRepository;
import umcstudy.repository.UsermissionRegiRepository;
import umcstudy.study.domain.Missions;
import umcstudy.study.domain.Store;
import umcstudy.study.domain.enums.missionVisit;
import umcstudy.study.domain.mapping.Usermissions;
import umcstudy.web.dto.MissionRequestDTO;
import umcstudy.web.dto.MissionResponseDTO;

@Service
@RequiredArgsConstructor
public class UsermissionCommandServiceImpl implements UsermissionCommandService {

    private final UsermissionRegiRepository usermissionRegiRepository;
    private final MissionRegiRepository missionRegiRepository;
    private final StoreRegiRepository storeRegiRepository;

    @Transactional
    public MissionResponseDTO.MissionResultDTO visitingStore(MissionRequestDTO.MissionDto request) {
        Store store = storeRegiRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Missions missions = missionRegiRepository.findByMissionname(request.getMissionname())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        Usermissions usermissions = usermissionRegiRepository.findByStoreAndMissions(store, missions)
                .orElseThrow(() -> new UsermissionHandler(ErrorStatus.STOREMISSION_NOT_FOUND));


        if (usermissions.getVisitstatus() != missionVisit.NOTVISITED) {
            throw new ExistMissionHandler(ErrorStatus.NOTVISITEDMISSION_NOT_FOUND);
        }

        // 5. VISITING으로 상태 변경
        usermissions.setVisitstatus(missionVisit.VISITING);


        return UsermissionConverter.toMissionResultDTO(usermissions);
    }
}
