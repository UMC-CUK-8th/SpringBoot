# 시니어 미션

### **서블릿 vs. Spring MVC 비교**

**💡 미션:**

## 전통적인 서블릿(Servlet) 기반 개발과 Spring MVC의 차이

| 항목 | 전통적인 서블릿 방식 | Spring MVC |
| --- | --- | --- |
| **클래스** | HttpServlet을 상속 | @Controller 어노테이션 사용 |
| **요청 처리 메서드** | doGet(), doPost() 오버라이드 | @RequestMapping, @GetMapping, @PostMapping 등 |
| **URL 매핑** | web.xml 또는 @WebServlet으로 수동 등록 | 어노테이션 기반 선언적 방식 (@RequestMapping) |
| **파라미터 수집** | request.getParameter() 수동 파싱 | 메서드 파라미터로 자동 바인딩 (@RequestParam, DTO 등) |
| **응답 생성** | response.getWriter().write() 직접 작성 | 뷰 이름 리턴 또는 @ResponseBody로 JSON 반환 |
| **구조** | 모든 흐름을 개발자가 직접 구현 | DispatcherServlet이 흐름을 제어하고 각 책임을 나눔 |

## Spring MVC가 왜 서블릿보다 편리한지 **프레임워크의 역할과 함께 정리해보기**

Spring MVC는 서블릿 개발에서 반복적으로 수행하던 작업들을 프레임워크가 대신 처리해줌. 덕분에 개발자는 핵심 비즈니스 로직에만 집중 가능함.

우선, 요청 매핑이 자동화됨. 기존 서블릿에서는 web.xml이나 @WebServlet을 통해 URL과 서블릿을 일일이 매핑해야 했음. 하지만 Spring MVC는 @RequestMapping, @GetMapping, @PostMapping 같은 어노테이션으로 컨트롤러 메서드와 URL을 쉽게 연결할 수 있음.

파라미터 처리도 편함. 예전엔 request.getParameter()로 수동으로 꺼내 써야 했는데, Spring은 쿼리 파라미터나 폼 데이터를 자바 객체로 자동 바인딩해줌. 코드도 훨씬 깔끔하고 보기 쉬움.

예외 처리도 강화됨. @ExceptionHandler, @ControllerAdvice를 사용하면 전역이나 공통 예외 처리 가능. 예외 상황에 대한 응답도 일관되게 관리 가능함.

응답 처리도 간편함. 컨트롤러에서 뷰 이름만 반환하면 ViewResolver가 알아서 JSP나 Thymeleaf 같은 실제 뷰로 연결해줌. REST API 만들 땐 @ResponseBody로 JSON도 쉽게 응답 가능.

그 외에도 Spring MVC는 폼 유효성 검사, 세션 관리, 국제화, 파일 업로드 등 기본 기능을 다 내장하고 있음. 의존성 주입도 @Autowired 한 줄이면 끝남.

결론적으로, Spring MVC는 개발자가 HTTP 요청 처리 흐름을 일일이 신경 쓰지 않아도 되게 도와주며, 오직 비즈니스 로직에만 집중할 수 있게 해주는 프레임워크임.

### **DispatcherServlet**이 내부적으로 요청을 처리하는 방식 단계별 분석하고, (키워드: HandlerMapping, HandlerAdpater) 다이어그램을 그려서 단계별로 설명하기

- 클라이언트가 요청을 보냄
- DispatcherServlet이 요청 받음
- HandlerMapping을 통해 어떤 컨트롤러의 어떤 메서드를 호출할지 결정함
- HandlerAdapter를 통해 해당 컨트롤러 메서드를 실제로 호출할 수 있게 준비함
- 준비된 컨트롤러 메서드 실행됨
- 컨트롤러가 ModelAndView 또는 데이터를 반환함
- ViewResolver가 반환된 뷰 이름을 실제 뷰 경로로 변환함
- 뷰가 렌더링됨 (JSP, Thymeleaf 등)
- DispatcherServlet이 최종 응답을 클라이언트에게 전달함

### **AOP(Aspect-Oriented Programming) 원리 탐구**

**💡 미션:**

## AOP?

**공통 기능(로깅, 트랜잭션, 보안 검사 등)을 핵심 로직과 분리하여 재사용성과 유지보수를 높이기 위해.**

- OOP vs AOP
    
    
    | 구분 | OOP (객체 지향) | AOP (관점 지향) |
    | --- | --- | --- |
    | **관심사 분리** | 클래스 단위로 책임을 분리 | 횡단 관심사를 분리하여 모듈화 |
    | **코드 위치** | 비즈니스 로직과 부가기능이 한 클래스에 공존 | 핵심 로직과 공통 로직이 서로 분리됨 |
    | **예시** | UserService 안에 log(), checkAuth()가 직접 포함 | 로그, 권한 검사는 별도의 Aspect에서 정의 후 삽입 |
- **AOP의 핵심 개념**
    - Advice :실제 실행될 공통 로직. 언제(전/후/예외)에 실행될지를 설정함 (@Before, @After, @Around)
    - JoinPoint : Advice가 적용될 수 있는 지점. 메서드 호출, 생성자 실행 등
    - Pointcut :어떤 JoinPoint에 Advice를 적용할지를 결정하는 조건 (예: execution(* com.example.service.*(..)))
    - Aspect : Advice + Pointcut을 하나로 묶은 모듈
    - Weaving : Advice를 핵심 로직에 실제로 삽입하는 과정 (컴파일, 클래스 로딩 또는 런타임 중)
- AOP가 적용되는 **런타임 위빙 vs 컴파일 타임 위빙**의 차이점 조사
    
    
    | 구분 | 컴파일 타임 위빙 | 런타임 위빙 (Spring AOP) |
    | --- | --- | --- |
    | 시점 | 코드 컴파일 시 Advice 삽입 | 객체 생성 후 프록시 객체로 기능 삽입 |
    | 도구 | AspectJ 컴파일러 사용 | Spring AOP (프록시 기반) |
    | 장점 | 성능 우수, 순수 자바 객체 | 유연성, 스프링 생명주기와 통합 |
    | 단점 | 빌드 과정 복잡, 의존성 높음 | 성능 약간 손해, 오직 메서드 수준만 가능 |

### Spring에서 AOP가 프록시 패턴(Proxy Pattern)을 활용하여 동작하는 원리 분석

프록시 동작 방식 요약

- 클라이언트가 UserService 호출함
- 실제 UserService가 아니라 프록시 객체가 대신 응답함
- 프록시 객체가 먼저 공통 로직(Advice) 실행함
- 이후 실제 메서드(userService.join()) 호출함
- 메서드 실행 완료 후 후처리 Advice 실행함

어떤 프록시를 쓰는가

- JDK 동적 프록시: 대상 객체가 인터페이스를 구현한 경우 사용함
- CGLIB 프록시: 대상 객체가 클래스만 있고 인터페이스가 없는 경우 사용함
- Spring은 대상 클래스 구조에 따라 자동으로 적절한 방식 선택함

- **🍀 도전 과제**
    - 기존 UMC에서 진행했던 프로젝트를 AOP 기반 Logging 전략을 채택하여 리팩토링할 수 있는 방안에 대해 논의해보세요.