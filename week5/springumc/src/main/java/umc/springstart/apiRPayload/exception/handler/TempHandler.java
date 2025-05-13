package umc.springstart.apiRPayload.exception.handler;

import umc.springstart.apiRPayload.code.BaseErrorCode;
import umc.springstart.apiRPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}