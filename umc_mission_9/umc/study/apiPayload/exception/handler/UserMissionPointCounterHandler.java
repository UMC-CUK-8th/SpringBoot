package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exception.GeneralException;

public class UserMissionPointCounterHandler extends GeneralException {
    public UserMissionPointCounterHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}