package umc.springstart.apiRPayload.code;

//구체화 하는 status에서 두개의 메소드를 반드시 override할것을 강제한느 역할
public interface BaseCode {

    ReasonDTO getReason();

    ReasonDTO getReasonHttpStatus();
}