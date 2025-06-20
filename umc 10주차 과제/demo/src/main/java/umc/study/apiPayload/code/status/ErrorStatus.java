package umc.study.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "Internal Server Error, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다. "),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    //멤버 관련 에러
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER4001" , "사용자가 없습니다."),
    NICKNAME_NOT_EXISTS(HttpStatus.NOT_FOUND, "MEMBER4002","닉네임은 필수입니다." ),
    INVALID_PASSWORD(HttpStatus.NOT_FOUND, "MEMBER4003","유효하지 않는 비밀번호입니다." ),


    //미션 관련 예외
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND,"MISSION4001","미션이 존재하지 않습니다."),

    //멤버미션 관련 예외
    MEMBER_MISSION_NOT_FOUND(HttpStatus.NOT_FOUND,"MEMBER_MISSION4001","사용자에게 해당 미션이 존재하지 않습니다."),
    MISSION_STATUS_IS_NOT_BEFORE_START(HttpStatus.BAD_REQUEST,"MEBER_MISSION4002", "이 미션은 진행중입니다"),
    //음식 카테고리 관련 에러
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND,"FOODCATEGORY4001", "음식 카테고리가 없습니다."),

    // 가게 관련 에러
    MARKET_NOT_FOUND(HttpStatus.NOT_FOUND, "MARKET4001", "존재하지 않는 가게입니다."),
    MISSION_NOT_BELONG_TO_MARKET(HttpStatus.BAD_REQUEST,"MARKET4001", "이 미션과 가게가 일치하지 않습니다."),

    // 페이지 관련 에러

    PAGE_NUMBER_INVALID(HttpStatus.BAD_REQUEST, "PAGE4001","페이지 번호는 1 이상이어야 합니다, "),
    PAGE_NUMBER_FORMAT_INVALID(HttpStatus.BAD_REQUEST, "PAGE4002","페이지 번호 형식이 이상합니다. "),

    // 토큰 관련 에러
    INVALID_TOKEN(HttpStatus.BAD_REQUEST, "TOKEN4001", "유효하지 않은 토큰입니다"),

    // 예시
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),

    // 테스트용
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001","테스트용 메세지 출력");



    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {

        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}
