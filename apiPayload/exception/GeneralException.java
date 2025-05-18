package umcstudy.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umcstudy.apiPayload.code.BaseErrorCode;
import umcstudy.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}