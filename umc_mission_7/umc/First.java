package umc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import umc.study.repository.MemberRepository.MemberRepositoryImpl;
import umc.study.repository.ReviewRepository.ReviewRepositoryImpl;
import umc.study.repository.UserMemberPointcounterRepository.UmpRepositoryImpl;
import umc.study.service.StoreService.StoreQueryService;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableJpaAuditing
public class First {
    public static void main(String[] args) {
        SpringApplication.run(First.class, args);
    }

        @Bean
        public CommandLineRunner run(ApplicationContext context) {
            return args -> {
                StoreQueryService storeService = context.getBean(StoreQueryService.class);

                // 파라미터 값 설정
                String name = "요아정";
                Float score = 4.0f;

                int phoneNumber=1234;
                LocalDateTime createdAT=LocalDateTime.now();

                // 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
                System.out.println("Executing findStoresByNameAndScore with parameters:");
                System.out.println("Name: " + name);
                System.out.println("Score: " + score);

                storeService.findStoresByNameAndScore(name, score)
                        .forEach(System.out::println);

                ReviewRepositoryImpl reviewRepository = context.getBean(ReviewRepositoryImpl.class);
                System.out.println(">>> Executing secondpicture() from ReviewRepositoryImpl");
                reviewRepository.secondpicture().forEach(System.out::println);

                MemberRepositoryImpl memberRepository = context.getBean(MemberRepositoryImpl.class);
                System.out.println(">>> Executing fourthpicture() from MemberRepositoryImpl");
                memberRepository.fourthpicture().forEach(System.out::println);


                UmpRepositoryImpl umpRepository = context.getBean(UmpRepositoryImpl.class);
                System.out.println(">>> Executing firstpicture() from UmpRepositoryImpl");
                umpRepository.firstpictureWithCursor(createdAT).forEach(System.out::println);

                umpRepository = context.getBean(UmpRepositoryImpl.class);
                System.out.println(">>> Executing thirdpicture() from UmpRepositoryImpl");
                umpRepository.thirdpictureWithCursor(phoneNumber,createdAT).forEach(System.out::println);

            };


        }


    }

