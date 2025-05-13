package Concurrency_Project.Hello_Concurrency.common.apiPayload.exception;

import Concurrency_Project.Hello_Concurrency.common.apiPayload.code.BaseErrorCode;
import Concurrency_Project.Hello_Concurrency.common.apiPayload.code.ErrorReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode errorCode;

    public ErrorReasonDto getReason (){
        return this.errorCode.getReason();
    }

    public ErrorReasonDto getReasonHttpStatus (){
        return this.errorCode.getReasonHttpStatus();
    }

}
