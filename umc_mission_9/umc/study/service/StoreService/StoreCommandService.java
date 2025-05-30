package umc.study.service.StoreService;

import umc.study.domain.StoreInfo;
import umc.study.dto.storeInfoDTO.StoreInfoRequestDTO;

public interface StoreCommandService {
    StoreInfo joinStoreinfo(StoreInfoRequestDTO.JoinDto request);
}
