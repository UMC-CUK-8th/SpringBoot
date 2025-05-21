package umcstudy.service.StoreService;

import umcstudy.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    void registerStore(StoreRequestDTO.JoinDto request);
}
