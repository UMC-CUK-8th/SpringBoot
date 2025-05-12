package org.example.study;

import jakarta.persistence.EntityManager;
import org.example.study.DTO.LocalMissionStatusDTO;
import org.example.study.ReviewService.ReviewQueryService;
import org.example.study.StoreService.StoreQueryService;
import org.example.study.MemberService.MemberQueryService;
import org.example.study.domain.Members;
import org.example.study.domain.QLocation;
import org.example.study.domain.Store;
import org.example.study.domain.enums.missionVisit;
import org.example.study.localmissionRepositoryService.localmissionQueryService;
import org.example.study.usermissionService.usermissionQueryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static org.example.study.domain.QLocation.location;
import static org.example.study.domain.QMissions.missions;
import static org.example.study.domain.enums.missionVisit.NOTVISITED;
import static org.example.study.domain.enums.missionVisit.VISITED;
import static org.example.study.domain.mapping.Qlocationbonusmission.locationbonusmission;

@SpringBootApplication
@EnableJpaAuditing
public class StudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }


    public CommandLineRunner run(ApplicationContext context, usermissionQueryService usermissionQueryService) {
        return args -> {
            usermissionQueryService usermissionService = context.getBean(usermissionQueryService.class);

            // 파라미터 값 설정
            missionVisit status = VISITED;

            // 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
            System.out.println("Executing findVisitMissions with parameters:");
            System.out.println("finishedmissions = " + missions.missionname);
            usermissionService.findvisitmissions(status)
                    .forEach(System.out::println);
        };
    }



    public CommandLineRunner run(ApplicationContext context, ReviewQueryService reviewQueryService
    , StoreQueryService storeQueryService, MemberQueryService memberQueryService) {
        return args -> {
            MemberQueryService MemberQueryService = context.getBean(MemberQueryService.class);
            StoreQueryService StoreService = context.getBean(StoreQueryService.class);
            String memId = "jjkk123";
            String storename = "홍대 치킨";
            reviewQueryService.writeReview("파스타 맛있어요!", 5,memId,storename );


        };
    }

    public CommandLineRunner run(ApplicationContext context, usermissionQueryService usermissionQueryService,
                                 localmissionQueryService localmissionQueryService) {
        return args -> {
            usermissionQueryService usermissionService = context.getBean(usermissionQueryService.class);
            localmissionQueryService localmissionService = context.getBean(localmissionQueryService.class);
            missionVisit status = VISITED;
            String localname = "강남구";
            System.out.println("Executing localname with parameters:");
            System.out.println("localname = " + location.locationname);
            localmissionService.localname(localname)
                    .forEach(System.out::println);

            LocalMissionStatusDTO dto = localmissionQueryService.getLocalMissionStatusWithCount(localname, status);
            System.out.println("방문 완료 미션 수: " + dto.getVisitedMissionCount());



            // 파라미터 값 설정
            status = NOTVISITED;

            // 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
            System.out.println("Executing findVisitMissions with parameters:");
            System.out.println("finishedmissions = " + missions.missionname);
            usermissionService.findvisitmissions(status)
                    .forEach(System.out::println);
        };

    };
    @Bean
    public CommandLineRunner run(ApplicationContext context) {
        return args -> {
            MemberQueryService MemberService = context.getBean(MemberQueryService.class);

            String ID = "jjkk123";

            System.out.println("Executing findStoresByNameAndScore with parameters:");
            System.out.println("ID" + ID);

            MemberService.findMemberbyID(ID)
                    .forEach(System.out::println);
        };
    }

}
