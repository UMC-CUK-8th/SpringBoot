package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exception.GeneralException;

public class StoreInfoHandler extends GeneralException {
    public StoreInfoHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
