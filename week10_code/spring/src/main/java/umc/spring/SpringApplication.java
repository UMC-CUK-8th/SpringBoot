package umc.spring;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


import umc.spring.domain.Mission;
import umc.spring.repository.missionRepository.MissionRepository;
import umc.spring.web.dto.MissionCursor;

@SpringBootApplication
@EnableJpaAuditing
public class SpringApplication {

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);


    }

    /*@Bean
    public CommandLineRunner run(ApplicationContext context) {
        return args -> {
            StoreQueryService storeService = context.getBean(StoreQueryService.class);

            // 파라미터 값 설정
            String name = "요아정";
            Float score = 4.0f;

            // 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
            System.out.println("Executing findStoresByNameAndScore with parameters:");
            System.out.println("Name: " + name);
            System.out.println("Score: " + score);

            storeService.findStoresByNameAndScore(name, score)
                    .forEach(System.out::println);
        };
    }*/

    /*@Bean
    public CommandLineRunner run(ApplicationContext context) {
        return args -> {
            MissionCursorQueryService missionCursorQueryService = context.getBean(MissionCursorQueryService.class);

            // 파라미터 값 설정
            String cursorValue = "20250507000000";
            Long cursorId = 10L;
            int limit = 3;
            Long userId = 1L;

            // 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
            System.out.println("Executing findMissionsByCursor with parameters:");
            System.out.println("userId = " + userId);

            missionCursorQueryService.findMissionsByCursor(userId, cursorValue,cursorId,limit)
                    .forEach(System.out::println);
        };
    }*/

}
