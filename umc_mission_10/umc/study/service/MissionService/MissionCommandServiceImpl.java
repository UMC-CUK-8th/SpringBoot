package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.PreferencesHandler;
import umc.study.domain.Mission;
import umc.study.domain.StoreInfo;
import umc.study.dto.missionDTO.MissionRequestDTO;
import umc.study.converter.MissionConverter;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Mission joinMission(MissionRequestDTO.JoinDTO request){
        // 1. DTO → Review로 변환
        Mission newmission = MissionConverter.toMission(request);
        // 2. storeId로 StoreInfo 찾아서 연결
        StoreInfo storeInfo = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new PreferencesHandler(ErrorStatus.STORE_NOT_FOUND));
        newmission.setStoreInfo(storeInfo);
        return missionRepository.save(newmission);
    }
}
