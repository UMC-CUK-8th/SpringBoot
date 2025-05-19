package umc.study.apiPayload.code;


public interface BaseCode {
    ReasonDTO getReason();

    ReasonDTO getReasonHttpStatus();

    // 구체화 해주는 status에서 두 개의 메소드를 반드시 Overide 할 것을 강제하는 역할
}
