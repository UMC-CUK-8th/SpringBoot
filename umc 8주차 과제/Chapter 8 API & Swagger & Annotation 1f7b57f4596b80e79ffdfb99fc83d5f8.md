# Chapter 8. API & Swagger & Annotation

# 🎯핵심 키워드

---

<aside>
💡 주요 내용들에 대해 조사해보고, 자신만의 생각을 통해 정리해보세요!
레퍼런스를 참고하여 정의, 속성, 장단점 등을 적어주셔도 됩니다.
조사는 공식 홈페이지 **Best**, 블로그(최신 날짜) **Not Bad**

</aside>

- java의 Exception 종류들
    - illegalArgumentException: 잘못된 인자 전달시
    - IllegalStateException: 객체 상태가 잘못된 경우
    - TypeMismatchException: 타입 변환 실패
    - MissingServletRequestParameterException: 필수 쿼리/매개변수를 안 넣엇을 때
    - MethodArgumentNotValidException: 유효성 검사 실패시
    - EmptyResultDataAccessException: 조회 결과가 없는데 호출하는 경우
    - DuplicateKeyException: 고유키의 위반
    
    이 외에도 다른 예외들이 많이 존재한다. 서비스 단에서 발생하는 예외들은 하나같이 try-catch로 처리해줘야 하는데, 이를 간편하게 한 곳에서 모아 관리할 수 있게 해주는 것이 RestControllerAdvice이다.
    

- @Valid
    
    RequestBody와 같이 쓰이는 어노테이션으로, DTO 필드의 제약 조건을 자동으로 검사해주는 역할을 한다.  @valid가 붙은 객체는 컨트롤러에 진입하기 전 스프링의 argument resolver에 의해 검증이 수행되는데, 이때 필드에 선언된 제약 어노테이션들을 검사한다. 검사 실패시 예외를 발생시킨다. 
    
    이때 발생하는 예외가 MethodArgumentNotValidException으로, 이를 Exceptionhandler나 ControllerAdvice를 통해 에러 메세지를 다른 형태로 반환받을 수 있다. 
    

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
4. **가게의 미션을 도전 중인 미션에 추가(미션 도전하기) API**

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
    
    지역을 erd 상에 만들지 않아 가게 리뷰 추가 api, 가게 미션 추가 api, 미션 도전하기 api 세 가지 API를 구현하고자 했습니다. 
    
    ### 가게에 리뷰 추가하기 API
    
    ![image.png](image.png)
    
    리뷰 요청 데이터를 담을 dto를 먼저 만들었습니다. 리뷰 테이블은 미션 테이블과 가게 테이블의 매핑 테이블이므로, 각 미션과 가게의 id를 불러왔습니다. 별점의 경우 1점에서 5점 사이에 들어갈 수 있게끔 제한을 뒀습니다. picture의 경우 뒤늦게 추가한 컬럼인데, 리뷰에 컬럼이 필요하지는 않으므로 우선 어노테이션을 제거하고 두었습니다.
    
    ![image.png](image%201.png)
    
    입력받은 리뷰 응답을 반환받기 위해 ReviewResponse도 같이 선언했습니다.
    
    이때 바깥쪽 클래스에 getter를 비롯한 어노테이션을 선언하였기에 안쪽 클래스에는 어노테이션을 선언하지 않아도 될 것 이라 생각했는데, 클래스마다 붙여야 한다는 것을 알게 되었습니다. 
    
    처음엔 클래스가 아니라 값을 반환하는 메서드일 것이라 착각해 class를 붙이지 않고 코드를 짰었는데, 값을 생성한 다음 반환받는다고 생각하는 게 맞는 것 같습니다.
    
    ![image.png](image%202.png)
    
    ![image.png](image%203.png)
    
    리뷰의 서비스와 레포지토리는 저번 주차에서 만든 것에서 추가로 수정할 필요가 없었습니다.
    
    ![image.png](image%204.png)
    
    마지막으로 컨트롤러를 만들어 [localhost](http://localhost) 상에서 출력할 수 있도록 만들었습니다. get과 달리 어노테이션을 GetMapping 대신 PostMapping을 사용하는 것을 확인할 수 있었습니다.
    
    미션 중 커스텀 어노테이션을 통해 리뷰를 작성하려는 가게가 존재하는지 확인해야 하는 조건이 있었습니다. 따라서 실습과 같은 방법으로 어노테이션을 만들어보았습니다.
    
    ![image.png](image%205.png)
    
    ErrorStatus에 가서 가게 관련 에러를 추가했습니다.
    
    ![image.png](image%206.png)
    
    그 다음 MarketExistValidator를 만들어 ConstraintValidator를 구현한 다음 isValid에서 MARKET_NOT_FOUND 예외를 출력하도록 했습니다.
    
    미션에서는 validator에 개선할 수 있는 부분이 있다고 하였습니다. 코드를 작성하며 생각해본 개선점은 다음과 같습니다. 
    
    validator는 가게가 존재하는지 찾고, 존재하지 않는다면 미리 정의해둔 MARKET_NOT_FOUND 예외를 반환합니다. 이때 하나의 예외를 찾기 위해 하나의 validator를 구현하는데, 여러 개의 예외에 각각의 validator를 주어 구현하기는 어려울 것이라 생각했습니다. 예외를 한 곳에서 모아서 관리하듯 validator 또한 하나로 모아 관리할 수 있을 거라 생각합니다.
    
    하지만 어떻게 고쳐야 하는지는 찾지 못 했습니다. 이후 스터디에서 배워가보자 합니다..
    
    ![image.png](image%207.png)
    
    어노테이션이 될 코드도 완성했습니다.
    
    이를 ReviewRequestDTO에서 요청시 확인할 수 있도록 어노테이션을 붙여줍니다.
    
    ![image.png](image%208.png)
    
    이후 swagger를 통해 작동하는지 확인해보았습니다. 데이터베이스 상에 가게 id가 1~5까지 존재하도록 입력했습니다. 
    
    ![스크린샷 2025-05-20 024149.png](%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7_2025-05-20_024149.png)
    
    ![스크린샷 2025-05-20 024159.png](%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7_2025-05-20_024159.png)
    
    존재하는 가게 id이므로, 성공했다는 뜻의 200코드가 발생합니다.
    
    ![스크린샷 2025-05-20 024220.png](%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7_2025-05-20_024220.png)
    
    ![스크린샷 2025-05-20 024225.png](%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7_2025-05-20_024225.png)
    
    다음에는 존재하지 않는 가게에 리뷰를 작성하기 위해 가게 id를 10294로 변경하여 다시 시도했습니다.
    
    400코드 에러가 발생하며, 미리 선언해뒀던 예외인 MARKET_NOT_FOUND가 발생합니다.
    

> **github 링크**
> 
> 
> [jaemin0413/UMC-8th-Spring-Workbook at feature/#3](https://github.com/jaemin0413/UMC-8th-Spring-Workbook/tree/feature/%233)
> 

[시니어 미션](https://www.notion.so/1f7b57f4596b812687e2f7a5175f0b46?pvs=21)

# ⚡ 트러블 슈팅

---

<aside>
💡 실습하면서 생긴 문제들에 대해서, **이슈 - 문제 - 해결** 순서로 작성해주세요.

</aside>

<aside>
💡 스스로 해결하기 어렵다면? 스터디원들에게 도움을 요청하거나 **너디너리의 지식IN 채널에 질문**해보세요!

</aside>

- ⚡이슈 작성 예시 (이슈가 생기면 아래를 복사해서 No.1, No.2, No3 … 으로 작성해서 트러블 슈팅을 꼭 해보세요!)
    
    **`이슈`**
    
    👉 앱 실행 중에 노래 다음 버튼을 누르니까 앱이 종료되었다.
    
    **`문제`**
    
    👉 노래클래스의 데이터리스트의 Size를 넘어서 NullPointException이 발생하여 앱이 종료된 것이었다. 
    
    **`해결`**
    
    👉  노래 다음 버튼을 눌렀을 때 데이터리스트의 Size를 검사해 Size보다 넘어가려고 하면 다음으로 넘어가는 메서드를 실행시키지 않고, 첫 노래로 돌아가게끔 해결
    
    **`참고레퍼런스`**
    
    - 링크
- ⚡이슈 No.1
    
    **`이슈`**
    
    👉 [트러블이 생긴 상태 작성]
    
    **`문제`**
    
    👉 [어떤 이유로 해당 이슈가 일어났는지 작성]
    
    **`해결`**
    
    👉  [해결 방법 작성]
    
    **`참고레퍼런스`**
    
    - [문제 해결 시 참고한 링크]

---

Copyright © 2023 최용욱(똘이) All rights reserved.

Copyright © 2024 김준환(제이미) All rights reserved.