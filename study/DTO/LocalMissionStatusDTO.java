package umcstudy.study.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import umcstudy.study.domain.mapping.locationbonusmission;

import java.util.List;

@Data
@AllArgsConstructor
public class LocalMissionStatusDTO {
    private List<locationbonusmission> localname;
    private long visitedMissionCount;
}