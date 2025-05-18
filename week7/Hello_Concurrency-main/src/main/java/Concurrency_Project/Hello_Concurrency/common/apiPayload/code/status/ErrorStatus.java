package Concurrency_Project.Hello_Concurrency.common.apiPayload.code.status;


import Concurrency_Project.Hello_Concurrency.common.apiPayload.code.BaseErrorCode;
import Concurrency_Project.Hello_Concurrency.common.apiPayload.code.ErrorReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러입니다. 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),

    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 존재하지 않습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),
    NICKNAME_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4003", "이미 사용된 닉네임입니다."),
    EMAIL_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4004", "이미 사용된 이메일입니다."),


    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "테스트 예외가 발생했습니다."),

    // 추가 예시
    POST_ALREADY_UPDATED (HttpStatus.CONFLICT, "POST4001", "이미 수정된 글입니다."),
    INVALID_FILE_TYPE (HttpStatus.UNSUPPORTED_MEDIA_TYPE, "POST4002", "지원하지 않는 파일 형식입니다");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDto getReason() {
        return ErrorReasonDto.builder()
                .isSuccess(false)
                .code(code)
                .message(message)
                .build();
    }

    @Override
    public ErrorReasonDto getReasonHttpStatus() {
        return ErrorReasonDto.builder()
                .isSuccess(false)
                .httpStatus(httpStatus)
                .code(code)
                .message(message)
                .build();
    }
}
