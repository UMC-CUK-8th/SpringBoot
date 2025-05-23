
# 🎯핵심 키워드

---

<aside>
💡 주요 내용들에 대해 조사해보고, 자신만의 생각을 통해 정리해보세요!
레퍼런스를 참고하여 정의, 속성, 장단점 등을 적어주셔도 됩니다.
조사는 공식 홈페이지 **Best**, 블로그(최신 날짜) **Not Bad**

</aside>

- java의 Exception 종류들
    
    우선 Exception이란 개발자가 프로그램 내에서 처리할 수 있는 예외이다. Exception은 **RuntimeException(unchecked exception  비체크 예외)**과 **OtherException(checked Exception  체크 예외)**으로 나뉜다 이 둘의 차이는 **컴파일러가 예외 처리를 하는지에 대한 여부이다.** 
    
    checked exception은 부모에 RuntimeException이 없는 것으로 예외인 경우 반드시 try-catch나 throws를 사용해서 예외를 처리해야한다
    unchecked exception은 부모로 RuntimeException를 가지지 않는 경우로  unchecked exception은 위 처럼 처리를 안해도 괜찮다.
    => 우리가 Exception클래스를 직접 정의해서 사용할때 자신이 체크드/언체크드 Exception을 만들어야하는 지를 우리가 판단 할 수 있는 기본적인 기반이 된다.
    
    checked-API의 사용자가 예외상황에서 복구할 수 있는 경우 개선 여지가 있는 경우 사용하면 바람직하다
    unchecked- 어차피 사용자가 할 수 있는것이 없는 상황이나 그 상황에서 애플리케이션을 종료 시키는 것이 그나마 나을 때 사용하면 바람직하다
    
    **비체크 예외**
    
    | 클래스명 | 설명 |
    | --- | --- |
    | `NullPointerException` | null 객체 참조 시 |
    | `ArrayIndexOutOfBoundsException` | 배열 인덱스 초과 |
    | `ArithmeticException` | 0으로 나누기 등 산술 오류 |
    | `IllegalArgumentException` | 메서드에 부적절한 인자 전달 |
    | `IllegalStateException` | 잘못된 상태에서 메서드 호출 |
    | `ClassCastException` | 클래스 타입 변환 실패 |
    | `NumberFormatException` | 문자열을 숫자로 파싱 실패 |
    | `StringIndexOutOfBoundsException` | 문자열 인덱스 오류 |
    | `UnsupportedOperationException` | 지원되지 않는 연산 호출 |
    | `IndexOutOfBoundsException` | 컬렉션 등에서 인덱스 초과 |
    
    체크 예외
    
    | 클래스명 | 설명 |
    | --- | --- |
    | `IOException` | 입출력 작업 중 오류 발생 |
    | `FileNotFoundException` | 파일을 찾을 수 없음 |
    | `SQLException` | 데이터베이스 접근 중 오류 |
    | `ParseException` | 문자열을 날짜 등으로 파싱할 때 오류 |
    | `ClassNotFoundException` | 클래스를 찾을 수 없음 |
    | `CloneNotSupportedException` | 객체 복제 불가능 |
    | `InterruptedException` | 스레드가 인터럽트될 때 |
    | `InstantiationException` | 추상 클래스 등을 인스턴스화 시도할 때 |
    | `NoSuchMethodException` | 존재하지 않는 메서드에 접근할 때 |
    | `InvocationTargetException` | 리플렉션 API 호출 중 예외 발생 |
    
- @Valid
    
    `@Valid` 어노테이션은 **Java Bean Validation** (JSR-303 / JSR-380)을 기반으로, 객체의 **유효성 검사를 트리거**하는 데 사용된다 즉 빈 검사기이다.  주로 **Spring Framework**에서 컨트롤러, 서비스 계층, 또는 DAO 레벨 등에서 객체의 필드 값을 자동으로 검증하기 위해 사용 
    스프링에서 일종의 어뎁터인 LocalValidatorFactoryBean가 제약조건 검증을 처리한다
    DTO의 필드값에 대해 어노테이션을 붙여주고 컨트롤러 클래스에 리퀴스트바디 부분에 valid어노테이션을 붙여줌으로 유효성 검증이 진행된다
    모든 요청은 프론트 컨트롤러인 디스패처 서블릿을 통해 컨트롤러로 전달된다. 전달 과정에서는 컨트롤러 메소드의 객체를 만들어주는 ArgumentResolver가 동작하는데, @Valid 역시 ArgumentResolver에 의해 처리가 된다.
    대표적으로 @RequestBody는 Json 메세지를 객체로 변환해주는 작업이 ArgumentResolver의 구현체인  RequestResponseBodyMethodProcessor가 처리하며, 이 내부에서 @Valid로 시작하는 어노테이션이 있을 경우에 유효성 검사를 진행한다. (이러한 이유로 @Valid가 아니라 커스텀 어노테이션여도 동작한다.) 만약 @ModelAttribute를 사용중이라면 ModelAttributeMethodProcessor에 의해 @Valid가 처리된다.
    

# 📢 학습 후기

---

- 이번 주차 워크북을 해결해보면서 어땠는지 회고해봅시다.
- 핵심 키워드에 대해 완벽하게 이해했는지? 혹시 이해가 안 되는 부분은 뭐였는지?

<aside>
💡

</aside>

# ⚠️ 스터디 진행 방법

---

1. 스터디를 진행하기 전, 워크북 내용들을 모두 채우고 스터디에서는 서로 모르는 내용들을 공유해주세요.
2. 미션은 워크북 내용들을 모두 완료하고 나서 스터디 전/후로 진행해보세요.
3. 다음주 스터디를 진행하기 전, 지난주 미션을 서로 공유해서 상호 피드백을 진행하시면 됩니다.

---

### [UMC 서버 워크북 참고 자료](https://github.com/CYY1007/UMC_SERVER_WORKBOOK.git)

[GitHub - chock-cho/UMC-7th-spring-workbook at feature-week8-workbook](https://github.com/chock-cho/UMC-7th-spring-workbook/tree/feature-week8-workbook)

---

3주차에 설계한 URL(없으면 추가!)을 바탕으로 아래의 API 구현

단, 로그인 기능이 없는 관계로 리뷰를 작성하거나 미션 도전하는 유저는

**하드 코딩(그냥 무조건 디비에 있는 아무나 한명)**으로 하기!

1. 특정 지역에 가게 추가하기 API
2. **가게에 리뷰 추가하기 API**
3. 가게에 미션 추가하기 API
4. **가게의 미션을 도전 중인 미션에 추가(미x션 도전하기) API**

3주차에 설계하지 않은 API URL의 경우는 설계를 복습 할 겸 해보고 진행해주세요!

반드시 인증 사진을 중간 중간 남기며, 7주차와 동일하게 github에 브랜치를 새로 만들어서 푸시하기

<aside>
📌 **조건**

1. github branch를 만들 때 issue를 만들고 branch 생성하여 진행 후 push할 것
2. controller, service, converter, dto, repository를 모두 활용할 것
3. ExceptionAdvice를 적극 활용해야하며 RequestBody에 값이 누락되거나 값이 잘못된 것을 @Valid 어노테이션으로 검증하기
4. **4번 API의 경우는 도전 하려는 미션이 이미 도전 중인지를 검증해야 하며 이를 커스텀 어노테이션을 통해 검증을 해야 함.**
5. **2번 API의 경우도 4번 API처럼 리뷰를 작성하려는 가게가 존재하는지 검증하는 커스텀 어노테이션을 사용할 것.**
</aside>

1, 2, 3 번 조건을 충족하지 않을 경우 해당 API는 미션 완료 대상에서 제외가 되며

**2, 4번 API는 필수로 구현해야 하고,**

만약 3번 API를 만들지 않을 경우 2,4번 API 만들 때 DB에 수동으로 미션 정보 기입해서 진행

위의 4개 API중 **필수 API 포함 3개 미만으로 완료 시 원 아웃 부여**

# 💪 미션 기록

---

<aside>
🍀 미션 기록의 경우, 아래 미션 기록 토글 속에 작성하시거나, 페이지를 새로 생성하여 해당 페이지에 기록하여도 좋습니다!

하지만, 결과물만 올리는 것이 아닌, **중간 과정 모두 기록하셔야 한다는 점!** 잊지 말아주세요.

</aside>

- **미션 기록**

> **github 링크**
> 
> 
> 