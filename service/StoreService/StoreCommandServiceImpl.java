package umcstudy.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umcstudy.apiPayload.code.status.ErrorStatus;
import umcstudy.apiPayload.exception.handler.LocationHandler;
import umcstudy.converter.StoreConverter;
import umcstudy.repository.LocationRegiRepository;
import umcstudy.repository.StoreRegiRepository;
import umcstudy.study.domain.Location;
import umcstudy.study.domain.Store;
import umcstudy.web.dto.StoreRequestDTO;
import umcstudy.web.dto.StoreResponseDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRegiRepository storeRegiRepository;
    private final LocationRegiRepository locationRegiRepository;


    @Override
    @Transactional
    public StoreResponseDTO.JoinResultDTO registerStore(StoreRequestDTO.JoinDto request) {
        Location location = locationRegiRepository.findById(request.getLocationId())
                .orElseThrow(() -> new LocationHandler(ErrorStatus.LOCATION_NOT_FOUND));

        Store store = StoreConverter.toStore(request, location);
        Store savedStore = storeRegiRepository.save(store);


        return StoreConverter.toJoinResultDTO(savedStore);
    }
}
