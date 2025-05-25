package umc.springstart.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springstart.converter.StoreConverter;
import umc.springstart.domain.Region;
import umc.springstart.domain.Store;
import umc.springstart.repository.RegionRepository;
import umc.springstart.repository.StoreRepository.StoreRepository;
import umc.springstart.web.dto.StoreRequestDTO.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store addStore(Long regionId, StoreRequestDTO.AddStoreDTO request) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RuntimeException("Region not found with ID: " + regionId)); // 실제로는 사용자 정의 예외 처리 클래스 사용 (RegionHandler 등)


        Store newStore = StoreConverter.toStore(request);

        newStore.setRegion(region);

        Store savedStore = storeRepository.save(newStore);

        return savedStore;
    }
}

