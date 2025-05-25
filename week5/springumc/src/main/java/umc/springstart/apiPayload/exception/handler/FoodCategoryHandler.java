package umc.springstart.apiPayload.exception.handler;


import umc.springstart.apiPayload.code.BaseErrorCode;
import umc.springstart.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}