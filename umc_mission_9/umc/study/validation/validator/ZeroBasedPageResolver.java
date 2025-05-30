package umc.study.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.validation.annotation.ZeroBasedPage;

@Component
@RequiredArgsConstructor
public class ZeroBasedPageResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean hasAnnotation = parameter.hasParameterAnnotation(ZeroBasedPage.class);
        Class<?> paramType = parameter.getParameterType();
        boolean isInteger = Integer.class.equals(paramType) || int.class.equals(paramType);
        boolean result = hasAnnotation && isInteger;
        return result;
    }

    // 실제 파라미터 값을 어떻게 바인딩할지 정의하는 메서드
    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {



        // 1. 파라미터 이름 (ex: "page")
        String paramName = parameter.getParameterName();

        // 2. @RequestParam 애노테이션에서 이름을 가져오기 (ex: @RequestParam(name="page"))
        RequestParam requestParam = parameter.getParameterAnnotation(RequestParam.class);
        String requestParamName = (requestParam != null && !requestParam.name().isEmpty())
                ? requestParam.name()
                : paramName;

        // 3. 요청에서 실제 파라미터 값 읽기
        String paramValue = webRequest.getParameter(requestParamName);

        System.out.println("ZeroBasedPageResolver invoked, paramName = " + paramName + ", rawValue = " + paramValue);

        // 값이 없으면 null 반환 (또는 기본값 지정 가능)
        if (paramValue == null) {
            throw new GeneralException(ErrorStatus.INVALID_PAGE_NUMBER);
        }

        // 문자열 -> 정수 변환 (숫자가 아니면 NumberFormatException 발생 가능)
        int page = Integer.parseInt(paramValue);

        // page가 1보다 작으면 예외 발생
        if(page < 1) {
            throw new GeneralException(ErrorStatus.INVALID_PAGE_NUMBER);
        }

        // page가 1 이상이면 0-based 인덱스로 변환하여 반환
        return page - 1;
    }

}
