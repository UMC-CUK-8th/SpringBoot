# 🎯핵심 키워드

---

<aside>
💡 주요 내용들에 대해 조사해보고, 자신만의 생각을 통해 정리해보세요!
레퍼런스를 참고하여 정의, 속성, 장단점 등을 적어주셔도 됩니다.
조사는 공식 홈페이지 **Best**, 블로그(최신 날짜) **Not Bad**

</aside>

**이번 주차는 핵심 키워드를 무조건 100% 다 조사 해야 하며 자세히 조사 할 것을 권고 드립니다.**

- Spring Data JPA의 Paging
    - Page
        - **정의**: `org.springframework.data.domain.Page`는 전체 데이터에서 **몇 페이지인지**, **전체 페이지 수**, **총 데이터 수**, **현재 페이지의 데이터 목록**까지 제공해주는 완전한 페이징 결과 객체야.
        - **주요 메서드/속성**:
            - `getContent()` → 현재 페이지의 데이터 리스트
            - `getTotalPages()` → 전체 페이지 수
            - `getTotalElements()` → 전체 데이터 개수
            - `isFirst()`, `isLast()` → 첫 페이지인지, 마지막 페이지인지
        - **장점**:
            - 클라이언트에게 **전체 페이징 정보까지 모두 제공할 수 있음**
            - `Pageable` 인터페이스로 컨트롤러에 간단히 적용 가능
        - **단점**:
            - 전체 개수(`count(*)`)를 구하기 때문에 **쿼리 비용이 비쌈** (특히 데이터가 많을수록)
    - Slice
        - **정의**: `org.springframework.data.domain.Slice`는 Page와 비슷하지만 **전체 데이터 수나 전체 페이지 수 정보는 없음**.
        - **주요 메서드/속성**:
            - `getContent()`
            - `hasNext()`, `hasPrevious()` → 다음 페이지 있는지만 판단
        - **장점**:
            - **count 쿼리를 날리지 않음** → 성능이 중요할 때 유리 (예시. 무한 스크롤)
        - **단점**:
            - 전체 페이지 수나 총 개수를 알 수 없음 → UI에 전체 페이지 번호를 보여주기 어려움
- 객체 그래프 탐색
    
    ### 정의
    
    - JPA에서 객체를 조회할 때 **연관된 엔티티까지 함께 탐색**해서 접근하는 것
    - 예: `store.getReviews()` 처럼 `store` 객체에서 `review` 리스트로 연결되는 방식
    
    ### Lazy vs Eager
    
    - **Lazy (지연 로딩)**: 연관 객체를 실제 사용할 때 SQL 날려서 가져옴
        
        → `N+1 문제` 발생 가능
        
    - **Eager (즉시 로딩)**: 연관 객체를 무조건 함께 가져옴
        
        → 필요 없는 데이터까지 가져오는 비효율
        
    
    ### Fetch Join
    
    ```java
    @Query("SELECT s FROM Store s JOIN FETCH s.reviews WHERE s.id = :id")
    Store findStoreWithReviews(@Param("id") Long id);
    ```
    
    - 객체 그래프 탐색 시 **N+1 문제 방지**를 위해 `fetch join` 많이 씀

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

# 🔥 미션

---

### [UMC 서버 워크북 참고 자료](https://github.com/CYY1007/UMC_SERVER_WORKBOOK.git)

[GitHub - chock-cho/UMC-7th-spring-workbook at feature-week9-workbook](https://github.com/chock-cho/UMC-7th-spring-workbook/tree/feature-week9-workbook)

---

아래의 API를 구현해야 하며, 추가 조건을 무조건 포함해서 구현을 해야 함.

4개 중 3개 이상의 API를 구현해야 하며 그 이하(0개~2개 구현)는 **원 아웃** 부여.

**2개 이상을 구현 했다고 해도, 추가 조건을 모두 만족하지 않을 경우 구현하지 않은 것으로 판단함.**

**핵심 키워드를 하나라도 조사를 하지 않을 시 역시 원 아웃 부여.**

**구현이 필요한 API 목록**

1. 내가 작성한 리뷰 목록
    - 참고 화면
        
        ![Untitled](Untitled%207.png)
        
2. 특정 가게의 미션 목록
3. 내가 진행중인 미션 목록
4. 진행중인 미션 진행 완료로 바꾸기
    - 참고 화면
        
        ![Untitled](Untitled%208.png)
        

**API 구현 조건**

1. 반드시 Paging처리를 할 것, 한 페이지에 10개씩 조회 **프론트엔드는 1 이상의 page 번호를 전달**
2. 필요한 데이터는 데이터베이스에서 직접 삽입을 해서 진행 (미션 외 API는 구현해도 됨) 
    1. 다만 미션 외 API는 작성을 해도 구현한 API 갯수로 카운트가 되지 않음
3. 프론트엔드가 주는 page는 쿼리 스트링으로 받아오며 이에 대한 처리를 하는 커스텀 어노테이션 구현을 반드시 할 것 
    1. 1번의 page 범위에 따라 커스텀 어노테이션은 page 1을 0으로 만들어 return 해야 한다.
    2. 그와 동시에 page의 범위가 너무 작은지 (0 이하) 판단을 하여 작은 경우 에러를 발생
    3. 에러 발생 시 반드시 RestControllerAdvice와 연계를 해야 함
4. 반드시 모든 API에 대해 Swagger 명세를 해야 한다. 
5. Converter에서 절대로 for문을 사용해서는 안되며, 무조건 Java의 Stream을 사용해야 한다.
6. 무조건 빌더 패턴을 사용해야 한다.
7. API 구현

# 💪 미션 기록

---

<aside>
🍀 미션 기록의 경우, 아래 미션 기록 토글 속에 작성하시거나, 페이지를 새로 생성하여 해당 페이지에 기록하여도 좋습니다!

하지만, 결과물만 올리는 것이 아닌, **중간 과정 모두 기록하셔야 한다는 점!** 잊지 말아주세요.

</aside>

- **미션 기록**
    
    ### 공통 기능 구현
    
    ### 1. `@PageValidation` 커스텀 어노테이션 구현
    
    | 항목 | 설명 |
    | --- | --- |
    | 목적 | 클라이언트로부터 전달된 page 파라미터가 1 이상인지 검증 |
    | 처리 방식 | `ConstraintValidator` 구현 (`PageValidator.java`) |
    | 예외 처리 | page < 1인 경우 `PageValidationException` 발생 |
    | 예외 핸들러 | `ExceptionAdvice.java`에 등록 |
    | 에러 코드 등록 | `ErrorStatus.INVALID_PAGE_NUMBER` 항목 추가 |
    | 응답 포맷 | `ApiResponse` 형식으로 `"페이지는 1 이상이어야 합니다."` 반환 |
    
    ### 2. 예외 처리 흐름 세팅
    
    - `GeneralException` 기반 예외 구조 사용
    - `PageValidationException` → `ErrorReasonDTO` 응답으로 연계
    - Swagger에서 page=0, -1 요청 시 정확한 한글 메시지 반환 확인 완료
    
    ---
    
    ### 수정한 API
    
    ### `GET /stores/{storeId}/reviews`
    
    | 변경 내용 | 설명 |
    | --- | --- |
    | `@PageValidation` → 내부 수동 검증 방식으로 변경 |  |
    | `page < 1` 직접 체크 후 `PageValidationException` 발생 |  |
    | `page - 1` 변환 처리 | JPA 기준으로 0부터 시작하는 페이지 처리 적용 |
    | Swagger 테스트 결과 | page=1 정상, page=0은 한글 에러, page=-1도 에러 처리 완료 |
    
    ### 구현된 파일 정리
    
    ### 새로 만든 파일
    
    | 파일명 | 설명 |
    | --- | --- |
    | `PageValidation.java` | `@RequestParam("page")`에 적용할 커스텀 어노테이션 |
    | `PageValidator.java` | `PageValidation`에 대한 유효성 검사 구현체 |
    | `PageValidationException.java` | 페이지가 1 미만일 경우 발생시키는 커스텀 예외 |
    
    ### 수정한 파일
    
    | 파일명 | 설명 |
    | --- | --- |
    | `ErrorStatus.java` | `INVALID_PAGE_NUMBER` 코드 추가 (`"페이지는 1 이상이어야 합니다."`) |
    | `ExceptionAdvice.java` | `@ExceptionHandler(PageValidationException.class)` 메서드 추가 |
    
    ---
    
    ---
    
    ---
    
    # 1번 문제 미션
    
    ### API
    
    | 항목 | 내용 |
    | --- | --- |
    | **URL** | `GET /reviews/me` |
    | **기능 설명** | 요청자의 `memberId`를 헤더로 받아, 본인이 작성한 리뷰 목록을 페이징으로 반환 |
    | **페이징 방식** | `?page=1`부터 시작 (내부적으로 0으로 변환) |
    | **검증** | page가 1보다 작으면 `PageValidationException` 발생 |
    | **커스텀 예외 처리** | `@ExceptionAdvice` + `PageValidationException` |
    | **문서화** | Swagger 문서에 `@Operation`, `@ApiResponses` 적용 완료 |
    
    ---
    
    ### 요청 헤더 & 파라미터
    
    | 타입 | 이름 | 설명 |
    | --- | --- | --- |
    | Header | `memberId` | 리뷰를 조회할 사용자 ID |
    | Query String | `page` | 페이지 번호 (1부터 시작) |
    
    ---
    
    ### 주요 요소
    
    - **페이징 처리:** `PageRequest.of(page - 1, 10)`
    - **DTO 변환:** `StoreConverter.toReviewPreViewListDTO(Page<Review>)`
    - **Stream 그리고 Builder 사용 필수 규칙 준수**
    - **예외 상황 처리:** 페이지 1 미만 요청 시 커스텀 예외 응답 반환
    
    ---
    
    ### Swagger 결과
    
    ![image.png](image.png)
    
    ![image.png](image%201.png)
    
    ![image.png](image%202.png)
    
    ![image.png](image%203.png)
    
    ---
    
    ### 구현한 클래스 및 파일 요약
    
    | 파일 | 설명 |
    | --- | --- |
    | `ReviewRestController.java` | API 정의 및 Swagger 문서화 |
    | `ReviewQueryService.java` | 서비스 인터페이스 |
    | `ReviewQueryServiceImpl.java` | 멤버 ID 기반 리뷰 목록 조회 |
    | `ReviewRepository.java` | `findAllByMember` 메서드 정의 |
    | `StoreConverter.java` | `toReviewPreViewListDTO` 변환 처리 |
    | `PageValidationException.java` | 페이지 값 유효성 검증 예외 |
    | `ExceptionAdvice.java` | 글로벌 예외 처리 핸들러 |
    
    ## **수정한 파일**
    
    | 파일명 | 설명 |
    | --- | --- |
    | `ReviewRestController.java` | 리뷰 생성 + 내가 작성한 리뷰 목록 조회 API 추가 |
    | `ReviewRepository.java` | `findAllByMember(Member, Pageable)` 메서드 추가 |
    | `StoreConverter.java` | `toReviewPreViewListDTO(Page<Review>)` 메서드 이미 사용됨 |
    
    ## 새로 만든 파일
    
    | 파일명 | 설명 |
    | --- | --- |
    | `ReviewQueryService.java` | 내가 작성한 리뷰 목록 조회용 서비스 인터페이스 |
    | `ReviewQueryServiceImpl.java` | `ReviewQueryService` 구현체 |
    | `PageValidationException.java` | 페이지 번호 유효성 검증용 커스텀 예외 |
    | (기존) `ExceptionAdvice.java` | `@ExceptionHandler(PageValidationException.class)` 메서드 추가만 했으면 수정된 걸로 취급 가능 |
    
    ---
    
    ---
    
    ---
    
    # 2번 문제 미션
    
    ### API
    
    | 항목 | 내용 |
    | --- | --- |
    | **URL** | `GET /stores/{storeId}/missions` |
    | **기능 설명** | 특정 가게에 등록된 미션 목록을 조회하며, 페이징 처리 포함 |
    | **페이징 방식** | `?page=1`부터 시작 (내부적으로 `page - 1`로 처리) |
    | **검증** | page가 1보다 작으면 `PageValidationException` 발생 |
    | **커스텀 예외 처리** | `@ExceptionAdvice` + `PageValidationException` |
    | **문서화** | Swagger 문서에 `@Operation`, `@ApiResponses`, `@Parameter` 적용 완료 |
    
    ---
    
    ### 요청 파라미터
    
    | 타입 | 이름 | 설명 |
    | --- | --- | --- |
    | Path Variable | `storeId` | 가게 ID |
    | Query String | `page` | 페이지 번호 (1부터 시작) |
    
    ---
    
    ### 주요 요소
    
    - **페이징 처리:** `PageRequest.of(page - 1, 10)`
    - **DTO 변환:** `StoreConverter.toMissionPreviewListDTO(Page<Mission>)`
    - **Stream 그리고 Builder 사용 필수 규칙 준수**
    - **예외 상황 처리:** 페이지 1 미만 요청 시 커스텀 예외 발생 및 핸들링
    - **Swagger 명세 철저하게 작성함**
    
    ---
    
    ### Swagger 결과
    
    ![image.png](image%204.png)
    
    ![image.png](image%205.png)
    
    ![image.png](image%206.png)
    
    ![image.png](image%207.png)
    
    ---
    
    ### 구현한 클래스 및 파일 요약
    
    | 파일명 | 설명 |
    | --- | --- |
    | `StoreRestController.java` | 특정 가게 미션 목록 조회 API 정의 |
    | `StoreQueryService.java` | `getMissionListByStore(Long storeId, int page)` 메서드 정의 |
    | `StoreQueryServiceImpl.java` | 실제 미션 목록 조회 로직 구현 |
    | `StoreConverter.java` | `toMissionPreviewDTO`, `toMissionPreviewListDTO` 작성 |
    | `MissionRepository.java` | `findAllByStore(Store store, Pageable pageable)` 메서드 추가 |
    
    ---
    
    ## **수정한 파일**
    
    | 파일명 | 설명 |
    | --- | --- |
    | `Mission.java` | `price` 컬럼 nullable 허용 (`@Column(nullable = true)`) |
    | `StoreRestController.java` | 새로운 GET API 추가 |
    | `StoreQueryServiceImpl.java` | 미션 목록 페이징 조회 메서드 구현 |
    | `StoreConverter.java` | Mission 관련 DTO 변환 메서드 추가 |
    | `MissionRepository.java` | `findAllByStore(...)` 메서드 추가 |
    
    ---
    
    ## **새로 만든 파일**
    
    | 파일명 | 설명 |
    | --- | --- |
    | `StoreResponseDTO.MissionPreviewDTO` | 단일 미션 정보 응답 DTO |
    | `StoreResponseDTO.MissionPreviewListDTO` | 미션 리스트 및 페이징 정보 응답 DTO |
    
    ---
    
    ---
    
    ---
    
    # 3번 문제 미션
    
    ### API 개요
    
    | 항목 | 내용 |
    | --- | --- |
    | **URL** | `GET /missions/me` |
    | **기능 설명** | 요청자의 `memberId`를 헤더로 받아, **진행 중인 미션(CHALLENGING)** 목록을 페이징으로 반환 |
    | **페이징 방식** | `?page=1`부터 시작 (내부적으로 0으로 변환) |
    | **검증** | page가 1보다 작으면 `PageValidationException` 발생 |
    | **커스텀 예외 처리** | `@ExceptionAdvice` + `PageValidationException` |
    | **문서화** | Swagger 문서에 `@Operation`, `@ApiResponses` 적용 완료 |
    
    ---
    
    ### 요청 헤더 & 파라미터
    
    | 타입 | 이름 | 설명 |
    | --- | --- | --- |
    | Header | `memberId` | 현재 로그인한 유저의 ID |
    | Query String | `page` | 페이지 번호 (1부터 시작) |
    
    ---
    
    ### 주요 요소
    
    - **페이징 처리:** `PageRequest.of(page - 1, 10)`
    - **DTO 변환:** `MissionConverter.toMyMissionPreviewListDTO(Page<MemberMission>)`
    - **Stream + Builder 사용 필수 조건 충족**
    - **예외 상황 처리:** 페이지 1 미만 요청 시 커스텀 예외 발생
    
    ---
    
    ### Swagger 결과
    
    ![image.png](image%208.png)
    
    ![image.png](image%209.png)
    
    ![image.png](image%2010.png)
    
    ![image.png](image%2011.png)
    
    ---
    
    ### 구현한 클래스 및 파일 요약
    
    | 파일명 | 설명 |
    | --- | --- |
    | `MissionRestController.java` | API 정의 및 Swagger 문서화 |
    | `MissionQueryService.java` | 서비스 인터페이스 |
    | `MissionQueryServiceImpl.java` | 진행 중인 미션 목록 조회 구현 |
    | `MissionConverter.java` | `toMyMissionPreviewListDTO`, `toMyMissionPreviewDTO` 변환 처리 |
    | `MissionResponseDTO.java` | `MyMissionPreviewListDTO`, `MyMissionPreviewDTO` 내부 클래스 생성 |
    | `MemberMissionRepository.java` | `findAllByMemberIdAndStatus(...)` 메서드 정의 |
    | `PageValidationException.java` | 페이지 유효성 검증 예외 클래스 |
    | `ExceptionAdvice.java` | 글로벌 예외 처리 핸들러 (이미 구현됨) |
    
    ---
    
    ## 수정한 파일
    
    | 파일명 | 설명 |
    | --- | --- |
    | `MissionRestController.java` | `GET /missions/me` API 추가 |
    | `MissionConverter.java` | `toMyMissionPreviewDTO`, `toMyMissionPreviewListDTO` 메서드 추가 |
    | `MissionResponseDTO.java` | 내부 클래스 `MyMissionPreviewDTO`, `MyMissionPreviewListDTO` 정의 |
    | `MissionQueryService.java` | `getMyOngoingMissions` 메서드 추가 |
    | `MemberMissionRepository.java` | `findAllByMemberIdAndStatus` 메서드 추가 |
    
    ---
    
    ## 새로 만든 파일
    
    없음.
    
    ---
    
    ---
    
    ---
    
    # 4번 문제 미션
    
    ### API
    
    | 항목 | 내용 |
    | --- | --- |
    | **URL** | `PATCH /missions/progress` |
    | **기능 설명** | 진행 중인 미션을 완료 상태로 변경하는 API |
    | **요청 방식** | `PATCH` |
    | **헤더** | `memberId` (사용자 ID) |
    | **요청 Body** | `missionId` (완료할 미션의 ID) |
    | **검증** | - 미션 상태가 `CHALLENGING`일 경우에만 완료 상태로 변경 가능- 미션 상태가 `CHALLENGING`이 아니면 `MissionStatus`가 `COMPLETED`로 변경되지 않음 |
    | **커스텀 예외 처리** | `@ExceptionAdvice` + `MissionNotFoundException` |
    | **문서화** | Swagger 문서에 `@Operation`, `@ApiResponses` 적용 완료 |
    
    ---
    
    ### 요청 헤더 & 파라미터
    
    | 타입 | 이름 | 설명 |
    | --- | --- | --- |
    | Header | `memberId` | 요청한 사용자의 ID |
    | Body | `missionId` | 완료할 미션의 ID |
    
    ---
    
    ### 주요 요소
    
    - **DTO 변환:** `MissionConverter.toResponseDTO(mission)`
    - **미션 상태 변경:** `MemberMission.changeStatus(MissionStatus.COMPLETED)`
    - **예외 상황 처리:** 미션 상태가 `CHALLENGING`이 아니면 처리되지 않음
    
    ---
    
    ### Swagger 결과
    
    ![image.png](image%2012.png)
    
    ![image.png](image%2013.png)
    
    ![image.png](image%2014.png)
    
    ---
    
    ### 구현한 클래스 및 파일 요약
    
    | 파일 | 설명 |
    | --- | --- |
    | `MissionRestController.java` | API 정의 및 Swagger 문서화 |
    | `MissionCommandService.java` | 미션 완료 처리 로직을 포함한 서비스 인터페이스 |
    | `MissionCommandServiceImpl.java` | 미션 완료 처리 구현 |
    | `MissionQueryService.java` | 미션 조회 서비스 인터페이스 |
    | `MissionConverter.java` | 미션 DTO 변환 처리 |
    | `MissionStatus.java` | 미션 상태를 나타내는 Enum |
    | `MissionNotFoundException.java` | 미션이 없는 경우 예외 처리 |
    
    ---
    
    ### 새로 만든 파일
    
    | 파일명 | 설명 |
    | --- | --- |
    | `MissionStatus.java` | 미션의 상태를 나타내는 Enum 파일 추가 |
    | `MissionNotFoundException.java` | 미션이 존재하지 않는 경우의 예외 클래스 추가 |
    
    ---
    
    ### 수정된 파일
    
    | 파일명 | 설명 |
    | --- | --- |
    | `MissionRestController.java` | 미션 완료 처리 API 추가 |
    | `MissionCommandServiceImpl.java` | 미션 완료 처리 로직 추가 |
    | `MissionConverter.java` | 미션 DTO 변환 메서드 추가 |
    

> **github 링크**
> 
> 
> 

[시니어 미션](%E1%84%89%E1%85%B5%E1%84%82%E1%85%B5%E1%84%8B%E1%85%A5%20%E1%84%86%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%201f7b57f4596b817b97cdcfd55b48bb1f.md)

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