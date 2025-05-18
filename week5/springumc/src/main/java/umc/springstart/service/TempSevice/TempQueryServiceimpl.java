package umc.springstart.service.TempSevice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.springstart.apiRPayload.exception.handler.TempHandler;
import umc.springstart.apiRPayload.code.status.ErrorStatus;

@Service
@RequiredArgsConstructor
public class TempQueryServiceimpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}