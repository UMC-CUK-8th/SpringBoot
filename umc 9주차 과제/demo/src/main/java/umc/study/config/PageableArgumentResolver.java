package umc.study.config;

import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.validation.annotation.ValidPage;

@Component
@RequiredArgsConstructor
public class PageableArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {

        return parameter.getParameterAnnotation(ValidPage.class) !=null &&
                parameter.getParameterType().equals(Integer.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory)  {

        String pageValue = webRequest.getParameter("page");

        if (pageValue == null || pageValue.isEmpty()) {
            return 0;
        }

        try {
            int page = Integer.parseInt(pageValue);

            if (page<1) {
                throw new GeneralException(ErrorStatus.PAGE_NUMBER_INVALID);
            }

            return page-1;
            // 페이지의 기본번호를 1에서 0으로 변환

        } catch (NumberFormatException e) {
            throw new GeneralException(ErrorStatus.PAGE_NUMBER_FORMAT_INVALID);
        }

    }
}
