package umcstudy.service.UsermissionCommandService;

import umcstudy.web.dto.MissionRequestDTO;
import umcstudy.web.dto.MissionResponseDTO;

public interface UsermissionCommandService {
    MissionResponseDTO.MissionResultDTO visitingStore(MissionRequestDTO.MissionDto request);
}
