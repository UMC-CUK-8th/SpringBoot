package Concurrency_Project.Hello_Concurrency.common.apiPayload.exception.handler;

import Concurrency_Project.Hello_Concurrency.common.apiPayload.code.BaseErrorCode;
import Concurrency_Project.Hello_Concurrency.common.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
