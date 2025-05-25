package umcstudy.apiPayload.exception.handler;

import umcstudy.apiPayload.code.status.ErrorStatus;
import umcstudy.apiPayload.exception.GeneralException;

public class ExistMissionHandler extends GeneralException {
    public ExistMissionHandler(ErrorStatus message) {
        super(message);
    }
}