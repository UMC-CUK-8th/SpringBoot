package umcstudy.service.StoreService;

import umcstudy.study.domain.Store;
import umcstudy.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Store registerStore(StoreRequestDTO.JoinDto request);
}
