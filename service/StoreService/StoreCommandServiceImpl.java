package umcstudy.service.StoreService;

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

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRegiRepository StoreRegiRepository;
    private final LocationRegiRepository LocationRegiRepository;

    @Override
    public void registerStore(StoreRequestDTO.JoinDto request) {
        Location location = LocationRegiRepository.findById(request.getLocationId())
                .orElseThrow(() -> new LocationHandler(ErrorStatus.LOCATION_NOT_FOUND));

        Store store = StoreConverter.toStore(request, location);

        StoreRegiRepository.save(store);
    }
}
