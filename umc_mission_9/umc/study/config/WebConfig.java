package umc.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import umc.study.validation.validator.ZeroBasedPageResolver;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ZeroBasedPageResolver zeroBasedPageResolver;

    public WebConfig(ZeroBasedPageResolver zeroBasedPageResolver) {
            this.zeroBasedPageResolver = zeroBasedPageResolver;
        System.out.println("WebConfig 빈이 생성되었고, ZeroBasedPageResolver가 주입되었습니다.");
    }
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        System.out.println("이거 작동하나??????????");
            resolvers.add(zeroBasedPageResolver);  // 생성자 주입 받은 객체 사용

    }
}
