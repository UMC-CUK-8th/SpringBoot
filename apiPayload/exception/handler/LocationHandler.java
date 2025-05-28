package umcstudy.apiPayload.exception.handler;

import umcstudy.apiPayload.code.status.ErrorStatus;
import umcstudy.apiPayload.exception.GeneralException;

public class LocationHandler extends GeneralException {
    public LocationHandler(ErrorStatus message) {
        super(message);
    }
}