package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.converter.MissionConverter;
import umc.study.domain.Market;
import umc.study.domain.Mission;
import umc.study.dto.MissionRequestDTO;
import umc.study.repository.MarketRepository.MarketRepository;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.validation.validator.MarketExistValidator;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final MarketRepository marketRepository;

    @Override
    public Long addMission(MissionRequestDTO.AddMissionRequest request) {

        Market market = marketRepository.findById(request.getMarketId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.MARKET_NOT_FOUND));

        Mission mission=MissionConverter.toMission(request);

        Mission savedMission=missionRepository.save(mission);

        return savedMission.getId();

    }
}
