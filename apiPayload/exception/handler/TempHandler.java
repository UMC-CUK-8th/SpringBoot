package umcstudy.apiPayload.exception.handler;

import umcstudy.apiPayload.code.BaseErrorCode;
import umcstudy.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}