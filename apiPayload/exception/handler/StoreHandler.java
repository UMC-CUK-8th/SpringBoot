package umcstudy.apiPayload.exception.handler;

import umcstudy.apiPayload.code.status.ErrorStatus;
import umcstudy.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(ErrorStatus message) {
        super(message);
    }
}