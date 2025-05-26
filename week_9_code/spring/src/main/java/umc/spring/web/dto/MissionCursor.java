package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MissionCursor {

    private String storeName;
    private String missionSpec;
    private Integer reward;
    private String cursorValue;
}
