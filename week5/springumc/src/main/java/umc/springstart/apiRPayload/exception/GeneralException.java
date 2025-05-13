package umc.springstart.apiRPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.springstart.apiRPayload.code.BaseErrorCode;
import umc.springstart.apiRPayload.code.ErrorReasonDTO;

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