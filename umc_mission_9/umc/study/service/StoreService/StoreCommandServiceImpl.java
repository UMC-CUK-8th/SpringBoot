package umc.study.service.StoreService;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.StoreInfoConverter;
import umc.study.domain.StoreInfo;
import umc.study.dto.storeInfoDTO.StoreInfoRequestDTO;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;


@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public StoreInfo joinStoreinfo(StoreInfoRequestDTO.JoinDto request){
        StoreInfo newstoreinfo = StoreInfoConverter.toStoreInfo(request);
        return storeRepository.save(newstoreinfo);
    }


}
