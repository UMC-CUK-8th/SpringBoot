package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class UserFoodHandler extends GeneralException {
    public UserFoodHandler(BaseErrorCode errorCode) {
        super(errorCode);;
    }
}
