package umc.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing; // 수정해서 추가된 것

@SpringBootApplication
@EnableJpaAuditing // 내가 방금 수정해서 추가한거
public class Umc5weekApplication {

    public static void main(String[] args) {
        SpringApplication.run(Umc5weekApplication.class, args);
    }


}
