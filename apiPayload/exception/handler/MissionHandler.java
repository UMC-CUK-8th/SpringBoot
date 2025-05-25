package umcstudy.apiPayload.exception.handler;

import umcstudy.apiPayload.code.status.ErrorStatus;
import umcstudy.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(ErrorStatus message) {
        super(message);
    }
}