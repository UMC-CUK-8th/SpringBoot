# Chapter 4. Spring Boot의 코어 개념


## 🎯핵심 키워드

---

<aside>
💡 주요 내용들에 대해 조사해보고, 자신만의 생각을 통해 정리해보세요!
레퍼런스를 참고하여 정의, 속성, 장단점 등을 적어주셔도 됩니다.
조사는 공식 홈페이지 **Best**, 블로그(최신 날짜) **Not Bad**

</aside>

- **DI**
    
    DI(의존성주입)
    
    한 객체가 사용할 객체를 직접생성하지 않고 스프링이 주입해주는것
    
    예 :
    
    ```
    @Service
    public class MyService {
        private final MyRepository repository;
    
        // 의존성 주입
        public MyService(MyRepository repository) {
            this.repository = repository;
        }
    }
    ```
    
    장점
    
    - 의존성을 명확히 표현하고 객체간 결합도를 낮출수 있어 유지보수가 쉬워진다
- **IoC**
    
    "개발자가 아닌 스프링이 직접 new를 해준다"
    
    spring이 수많은 object들을 class로 만들어 놨는데 spring이 읽어서 이 객체들을 직접 띄운다
    
    즉, spring이 알아서 이것들을 메모리에 올려준다
    
    컨테이너는 보통 객체의 life cycle을 관리하고 제어하는것을 말한다
    
    제어권이 spring framework로 넘어오면서
    
    DI(의존성주입), AOP(관점지향프로그래밍)을 가능하게 한다
    
- **프레임워크와 API의 차이**
    
    ### 프레임워크
    
    프레임워크는 `개발자들이 애플리케이션을 개발하는 데 사용되는 구조를 제공`한다. 프레임워크는 `일련의 규칙과 구조를 정의하고, 개발자가 애플리케이션을 작성할 때 이러한 규칙과 구조를 따르도록 한다.` 프레임워크는 보통 여러 컴포넌트와 라이브러리를 포함하며, 개발자가 특정 기능을 구현하기 위해 이를 조합하여 사용한다.
    
    요약하면, API는 소프트웨어 컴포넌트 간의 인터페이스를 정의하는 것이고, 라이브러리는 개발자들이 자주 사용하는 코드 집합이며, 프레임워크는 애플리케이션을 개발하는 데 사용되는 구조를 제공하는 것이다.
    
    ### API
    
    API는 `두 개 이상의 소프트웨어 컴포넌트 사이에서 상호 작용할 수 있도록 정의된 인터페이스`를 말한다. API는 일반적으로 함수, 프로토콜 또는 클래스로 구성되며, `다른 소프트웨어 개발자들이 이를 사용하여 특정 서비스 또는 기능을 사용할 수 있다.` API는 소프트웨어 컴포넌트 간의 인터페이스를 정의하는 것으로, 예를 들어, 다른 개발자들이 사용할 수 있는 함수, 메서드, 클래스 등을 정의하는 것이다.
    
- **AOP**
    
    공통 관심 사항(cross-cutting concern)과 핵심 관심 사항(core concern)을 분리하여 모듈화하는 프로그래밍 기법
    
    AOP가 필요한 상황
    
    **문제가 되는 코드 예시:**
    
    ```json
    @Transactional
    public class MemberService {
        public Long join(Member member) {
            // 시간 측정 시작 - 공통 관심 사항
            long start = System.currentTimeMillis();
    
            try {
                // 핵심 관심 사항
                validateDuplicateMember(member);
                memberRepository.save(member);
                return member.getId();
            } finally {
                // 시간 측정 종료 - 공통 관심 사항
                long finish = System.currentTimeMillis();
                long timeMs = finish - start;
                System.out.println("join " + timeMs + "ms");
            }
        }
    }
    ```
    
    **문제점:**
    
    1. 시간 측정 로직이 핵심 비즈니스 로직과 섞여 있음
    2. 같은 시간 측정 로직이 여러 메서드에 중복됨
    3. 유지보수가 어려움
        
        AOP 적용 효과
        
        1. **코드의 분리**
            - 핵심 관심 사항과 공통 관심 사항이 분리됨
            - 핵심 비즈니스 로직에 집중 가능
        2. **코드 중복 제거**
            
            ```java
            // 핵심 로직만 남은 깔끔한 코드
            public Long join(Member member) {
                validateDuplicateMember(member);
                memberRepository.save(member);
                return member.getId();
            }
            
            ```
            
        3. **유지보수성 향상**
            - 공통 관심 사항 변경 시 한 곳만 수정하면 됨
            - 코드가 깔끔해지고 가독성 향상
        4. **재사용성**
            - 공통 관심 사항을 여러 곳에서 재사용 가능
            - 새로운 기능 추가가 쉬움

- **서블릿**
    
    ### 서블릿(Servlet)의 주요 특징
    
    - 클라이언트의 Request에 대해 동적으로 작동하는 웹 어플리케이션 컴포넌트
    - 기존의 정적 웹 프로그램의 문제점을 보완하여 동적인 여러 가지 기능을 제공
    - JAVA의 스레드를 이용하여 동작
    - MVC패턴에서 컨트롤러로 이용됨
    - 컨테이너에서 실행
    - 보안 기능을 적용하기 쉬움
    
    **서블릿 생명주기 메서드**
    
    **초기화 : init()**
    
    - 서블릿 요청 시 맨 처음 한 번만 호출된다.
    - 서블릿 생성 시 초기화 작업을 주로 수행한다.
    
    **작업 수행 : doGet(), doPost()**
    
    - 실제로 클라이언트가 요청하는 작업을 수행한다.
    - 서블릿 요청 시 매번 호출된다.
    
    **종료 : destroy()**
    
    - 서블릿의 마무리 작업을 주로 수행한다
    - 서블릿이 기능을 수행하고 메모리에서 소멸될 때 호출된다.
    
    **서블릿의 생명주기**
    
    서블릿도 자바 클래스이므로 실행하면 초기화부터 서비스 수행 후 소멸하기까지의 과정을 거친다. 이 과정을 서블릿의 생명주기라하며 각 단계마다 호출되어 기능을 수행하는 콜백 메서드를 서블릿 생명주기 메서드라한다.
    

## 📢 학습 후기

---

- 이번 주차 워크북을 해결해보면서 어땠는지 회고해봅시다.
- 핵심 키워드에 대해 완벽하게 이해했는지? 혹시 이해가 안 되는 부분은 뭐였는지?

<aside>
💡

</aside>

## ⚠️ 스터디 진행 방법

---

1. 스터디를 진행하기 전, 워크북 내용들을 모두 채우고 스터디에서는 서로 모르는 내용들을 공유해주세요.
2. 미션은 워크북 내용들을 모두 완료하고 나서 스터디 전/후로 진행해보세요.
3. 다음주 스터디를 진행하기 전, 지난주 미션을 서로 공유해서 상호 피드백을 진행하시면 됩니다.

## ✅ 실습 체크리스트

---

## ☑️ 실습 인증

---

**1. aws에서 rds에 들어가 데이터베이스를 생성한다**

![](https://blog.kakaocdn.net/dn/dCK3VF/btsL1tooenB/6fKCezkxMs89SMIcCO1ubK/img.png)

MySQL을 선택합니다

![](https://blog.kakaocdn.net/dn/KlJlq/btsL0ERMNx4/2kDso8VTwHh67K5EoW4sR0/img.png)

템플릿은 프리티어로 만듭니다

![](https://blog.kakaocdn.net/dn/bkNJRM/btsL1DYBBQ0/kXvCZK0BOGtrl4hAOnRoW1/img.png)

이름을 설정합니다

![](https://blog.kakaocdn.net/dn/wMFtv/btsL1sXjL1p/rkg9V1bOtXmYrJouTvixb1/img.png)

암호도 적습니다 ( 기억해둬야함)

![](https://blog.kakaocdn.net/dn/NzF8E/btsL1XiaKs2/MmyLydJiEP9qnNlSeUaC30/img.png)

혹시 몰라서 백업도 꺼줍니다

![](https://blog.kakaocdn.net/dn/ldxii/btsL1iGVgUh/Mqx4pzTZq8DigEg9bL3hbk/img.png)

데이터베이스 생성 버튼 누르면 생성 성공~!🔥

![](https://blog.kakaocdn.net/dn/bVjZry/btsL0XjddeW/A3MxyeTtSBBWa9MJL4X751/img.png)

이렇게 생성됐으면 datagrip에서 aws를 연결한다

🤔연결안되는 이슈

![](https://blog.kakaocdn.net/dn/JeEEm/btsL07lohUn/FJRjGFVIfUUiGF9DtddFn1/img.png)

datagrip에 연결하려했더니 연결이 안됨

1. aws 데이터베이스에 들어가서 수정으로 간다

![](https://blog.kakaocdn.net/dn/cMXDhS/btsL2bUOls6/QJAjPCFQRUXmcGNhYdSSnk/img.png)

2. 퍼블릭 엑세스를 한다

![](https://blog.kakaocdn.net/dn/bFtyZj/btsL0oauhux/qYd9y7kq0YR0Wjw1KFkOR0/img.png)

🤔그래도 안됨

보안설정

![](https://blog.kakaocdn.net/dn/bzV9gy/btsL2btH8vS/c0Nfa3lP9PqHicTMo26Tbk/img.png)

홈으로간다

![](https://blog.kakaocdn.net/dn/om3Mt/btsL0EddsdN/IkJPLETFTiAlfyDbzheuGk/img.png)

EC2로 간다

![](https://blog.kakaocdn.net/dn/nn62F/btsL1F29SQm/ENvvbChXZvKfzRZ9zr5hi1/img.png)

대시보드에서 보안그룹으로 들어온다

![](https://blog.kakaocdn.net/dn/A7M9T/btsL175WhAo/YeAA4XFB5jxMYKlN1v1vKk/img.png)

50

인바운드 규칙편집으로 들어간다

![](https://blog.kakaocdn.net/dn/OMYMk/btsL1EQIfDY/L9hPmVftykGZAP4SsGvayk/img.png)

규칙을 추가함

![](https://blog.kakaocdn.net/dn/nl105/btsL0VFHKet/4VpsQgm8bfYvtnEyc7yzn0/img.png)

이렇게 만든 규칙을 추가한다

![](https://blog.kakaocdn.net/dn/qARzM/btsL0DysksO/Ez0mECGYXmV7twIgKIjW9k/img.png)

호스트에 엔트포인트를 넣고

사용자 이름과 비밀번호를 작성합니다

이때 aws rds에서

![](https://blog.kakaocdn.net/dn/c3dgrr/btsL0B1HwCp/ZFsPSXH688DQoxcfkJbNi0/img.png)

여기에 있는 이름은 rds의 인스턴스이름이다 데이터베이스와는 별개이다

RDS 인스턴스는 데이터베이스를 호스팅하는 환경이고, 그 안에 여러 데이터베이스를 생성하고 사용할 수 있다

따라서 위의 사진에서 데이터베이스에 이름을 넣으면 안된다

![](https://blog.kakaocdn.net/dn/02KMm/btsL1XboTSS/VsqUJhmGtl2diGXp8onUJ0/img.png)

연결 성공🔥🔥

![](https://blog.kakaocdn.net/dn/dk7DLV/btsL1EpGqID/bge2O3xMQikYpEyccDsZl0/img.png)

여기서 ctrl+enter을 누른다

![](https://blog.kakaocdn.net/dn/cXAl8H/btsL1gpiMzA/y03D14XVoIO61yOBO468N1/img.png)

### 데이터베이스 만들기

![](https://blog.kakaocdn.net/dn/cJQGuN/btsL1AADavj/DER0ReTNNwQcI1iZodTQK0/img.png)

그 후에

![](https://blog.kakaocdn.net/dn/XIvGz/btsL1DROdCB/7xePbTuix1H0TmYFM9kVU1/img.png)

```json
spring:
  datasource:
    url: jdbc:mysql://springstart.{        }:3306
    username: [유저이름]
    password: [비밀번호]
    driver-class-name: com.mysql.cj.jdbc.Driver
  sql:
    init:
      mode: never
    jpa:
      properties:
        hibernate:
          dialect: org.hibernate.dialect.MySQL8Dialect
          show_sql: true
          format_sql: true
          use_sql_comments: true
          hbm2ddl:
            auto: update
          default_batch_fetch_size: 1000
```

