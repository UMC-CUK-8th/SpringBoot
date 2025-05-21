package umcstudy.web.dto;

import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class JoinDto{
        String storename;
        String storeaddress;
        String storetype;
        int reviewcount;
        private Long locationId;
    }
}
