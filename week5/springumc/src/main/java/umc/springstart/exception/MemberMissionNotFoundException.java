package umc.springstart.exception;

import umc.springstart.apiPayload.code.BaseErrorCode;
import umc.springstart.apiPayload.exception.GeneralException;

public class MemberMissionNotFoundException extends GeneralException {
    public MemberMissionNotFoundException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}