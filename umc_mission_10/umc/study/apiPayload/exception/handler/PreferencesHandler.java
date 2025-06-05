package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exception.GeneralException;

public class PreferencesHandler extends GeneralException {
    public PreferencesHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
