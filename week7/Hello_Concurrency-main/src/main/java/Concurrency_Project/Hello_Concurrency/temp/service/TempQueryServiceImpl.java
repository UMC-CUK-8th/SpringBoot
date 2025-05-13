package Concurrency_Project.Hello_Concurrency.temp.service;

import Concurrency_Project.Hello_Concurrency.common.apiPayload.code.status.ErrorStatus;
import Concurrency_Project.Hello_Concurrency.common.apiPayload.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService {

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 2) {
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
        }
    }
}
