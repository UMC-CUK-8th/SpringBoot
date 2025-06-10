package umc.springstart.apiPayload.exception.handler;

import umc.springstart.apiPayload.code.BaseErrorCode;
import umc.springstart.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
