package umc.study;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import umc.study.domain.enums.Status;
import umc.study.dto.UserDTO;
import umc.study.service.MarketService.MarketQueryService;
import umc.study.service.MemberMissionService.MemberMissionQueryService;
import umc.study.dto.MemberMissionDTO;
import umc.study.service.UserService.UserQueryService;

@SpringBootApplication
@EnableJpaAuditing
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

    // @Bean
    // public CommandLineRunner run(ApplicationContext context) {
    //     return args -> {
    //         MarketQueryService marketQueryService = context.getBean(MarketQueryService.class);

    //         // 파라미터 값 설정
    //         String name="달콤 디저트";
    //         Float rate=4.5f;

    //         //쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
    //         System.out.println("Excuting findStoreByNameAndRate with parameters");
    //         System.out.println("Name:"+name);
    //         System.out.println("rate "+rate);

    //         marketQueryService.findMarketByNameAndRate(name,rate)
    //                 .forEach(System.out::println);
    //     };
    // }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext context) {
//        return args -> {
//
//            // 멤버미션쿼리서비스 호출
//            MemberMissionQueryService memberMissionQueryService=context.getBean(MemberMissionQueryService.class);
//
//            //파라미터 설정
//            Long userId=1L;
//            Status status = Status.ACTIVE; // 진행중인 미션
//
//            List<MemberMissionDTO> memberMissions=memberMissionQueryService.findMissionByStatus(userId,status);
//
//
//            System.out.println("사용자"+ userId+"이 진행중인 미션");
//            if (memberMissions.isEmpty()) {
//                System.out.println("진행중인 미션이 없습니다.");
//            } else {
//                System.out.println("진행중인 미션:");
//
//                for (MemberMissionDTO memberMission : memberMissions) {
//                    System.out.println("미션 이름: " + memberMission.getMissionName());
//                    System.out.println("미션 설명: " + memberMission.getDescription());
//                    System.out.println("보상 포인트: " + memberMission.getRepair());
//                    System.out.println("미션 시작일: " + memberMission.getCreatedAt());
//
//                }
//            }
//            // 파라미터 변경 -> 진행중인 미션에서 완료한 미션 모아보기로
//
//            status = Status.INACTIVE; // 진행중인 미션
//
//            memberMissions=memberMissionQueryService.findMissionByStatus(userId,status);
//            // 변경한 파라미터를 memberMissions로 변경
//
//            System.out.println("사용자"+ userId+"이 완료한 미션");
//            if (memberMissions.isEmpty()) {
//                System.out.println("완료한 미션이 없습니다.");
//            } else {
//                System.out.println("완료한 미션:");
//
//                for (MemberMissionDTO memberMission : memberMissions) {
//                    System.out.println("미션 이름: " + memberMission.getMissionName());
//                    System.out.println("미션 설명: " + memberMission.getDescription());
//                    System.out.println("보상 포인트: " + memberMission.getRepair());
//                    System.out.println("미션 시작일: " + memberMission.getCreatedAt());
//
//                }
//            }
//
//
//        };
//    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext context) {
//        return args -> {
//
//            // 멤버미션쿼리서비스 호출
//            MemberMissionQueryService memberMissionQueryService=context.getBean(MemberMissionQueryService.class);
//            //파라미터 설정
//            Long userId=1L;
//            Status status = Status.ACTIVE; // 진행중인 미션
//            List<MemberMissionDTO> memberMissions=memberMissionQueryService.findMissionByStatus(userId,status);
//            Integer CompletedMissions=memberMissionQueryService.showCompletedMission(userId);
//
//            System.out.println("사용자"+ userId+"가 수행완료한 미션 개수: " +CompletedMissions);
//
//
//            System.out.println("사용자"+ userId+"이 수행할 수 있는 미션");
//            if (memberMissions.isEmpty()) {
//                System.out.println("수행할 수 있는 미션이 없습니다.");
//            } else {
//                System.out.println("수행중인 미션:");
//
//                for (MemberMissionDTO memberMission : memberMissions) {
//                    System.out.println("미션 이름: " + memberMission.getMissionName());
//                    System.out.println("미션 설명: " + memberMission.getDescription());
//                    System.out.println("보상 포인트: " + memberMission.getRepair());
//                    System.out.println("미션 시작일: " + memberMission.getCreatedAt());
//
//                }
//            }
//
//
//
//
//        };
//    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {

            // 유저쿼리서비스 호출
            UserQueryService userQueryService = context.getBean(UserQueryService.class);

            //파라미터 설정
            Long userId=1L;
            Status status = Status.ACTIVE; // 진행중인 미션

            UserDTO user = userQueryService.myPageHome(userId);

            System.out.println("사용자"+ userId+"의 마이페이지");

                System.out.println("수행중인 미션:");

                    System.out.println("사용자 id: " + user.getId());
                    System.out.println("닉네임: " + user.getNickname());
                    System.out.println("보유 포인트: " + user.getPoint());
                    System.out.println("이메일: " + user.getEmail());







        };
    }

}