package umc.springstart.apiPayload.exception.handler;

import umc.springstart.apiPayload.code.BaseErrorCode;
import umc.springstart.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}