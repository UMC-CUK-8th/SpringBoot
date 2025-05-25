package umcstudy.apiPayload.exception.handler;

import umcstudy.apiPayload.code.status.ErrorStatus;
import umcstudy.apiPayload.exception.GeneralException;

public class UsermissionHandler extends GeneralException {
    public UsermissionHandler(ErrorStatus message) {
        super(message);
    }
}