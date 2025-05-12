package org.example.study.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.study.domain.mapping.locationbonusmission;

import java.util.List;

@Data
@AllArgsConstructor
public class LocalMissionStatusDTO {
    private List<locationbonusmission> localname;
    private long visitedMissionCount;
}