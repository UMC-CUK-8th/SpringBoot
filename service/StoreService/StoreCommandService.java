package umcstudy.service.StoreService;

import umcstudy.study.domain.Store;
import umcstudy.web.dto.StoreRequestDTO;
import umcstudy.web.dto.StoreResponseDTO;

public interface StoreCommandService {

    StoreResponseDTO.JoinResultDTO registerStore(StoreRequestDTO.JoinDto request);
}
