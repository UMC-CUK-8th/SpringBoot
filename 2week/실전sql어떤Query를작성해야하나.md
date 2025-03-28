- 책📖 목록중 좋아요수를 내림차순해서 페이지네이션하는 쿼리
    - select count(*) as like_count from book_likes group by book_id
        - `book_likes` 테이블에서 책별(`book_id`)로 몇개의 좋아요가 있는지 세기
    - JOIN (…) AS likes
        - 이걸 likes라는 임시 테이블 처럼 만듦(서브쿼리)
    - book as b 와 조인
        - on [b.id](http://b.id) = likes.book_id
        - 책 정보(`book` 테이블)과 그 책의 좋아요수(`like_count`)를 조인해서 같이 가져오는 것
    - ORDER BY likes.like_count desc;
        - 좋아요 수 많은 순서대로 정렬
    - limit 15 offset (n-1) * 15;
        - 한번에 15개만 가져오고, n번째 페이지 부터 가져오겠다는 뜻
            - n=1 → offset 0 (1~15번째 책)
            - n=2 → offset 15(16~30번째 책)





🔖 왜 `Having`이 아니라 `WHERE`인 이유? 

- HAVING은 집계함수 이후 필터라서 속도가 느릴 수 있다
- 여기서 WHERE절에서 직접 커서 조건을 주는 방식으로 바꾼것 → 효율적이다




## 🤔Offset과 커서 기반 쿼리중 언제 무엇을 써야할까

| 데이터 수가 적고, 페이지 점프가 많음 | `Offset 기반` |
| --- | --- |

| 데이터가 많고, 순차 탐색이 주 목적 (ex: 무한스크롤) | `커서 기반` |
| --- | --- |

| 정렬된 리스트에서 최신 순으로 계속 내려보기 | `커서 기반` |
| --- | --- |

| 관리자용 UI에서 페이지 번호로 이동해야 함 | `Offset 기반` |
| --- | --- |
- 커서기반은 기본적으로 이전 데이터의 커서값을 기준으로 이어서 조회하는 방식이므로 1~10번까지 페이지가 있을경우 예를들어 6번으로 가는 기능을 바로 지원하지는 않고 순차적으로 타고 와야함  → 이런경우 offset기반으로 해야됨


## 🔥 미션

---

1. 1주차 때 설계한 데이터베이스를 토대로 아래의 화면에 대한 쿼리를 작성

![내가 진행중, 진행 완료한 미션 모아서 보는 쿼리(페이징 포함)](Untitled%204.png)

내가 진행중, 진행 완료한 미션 모아서 보는 쿼리(페이징 포함)

- 내가 진행중, 진행 완료한 미션 모아서 보는 쿼리
    
    Offset 기반 페이징 
    
    ```sql
    SELECT
      mm.status AS Status,
      m.reward AS Reward,
      s.name AS StoreName,
      m.mission_spec AS MissionDescription,
      mm.created_at AS MissionStartDate, 
      mm.updated_at AS LastUpdated
    FROM
      member_mission mm
    JOIN
      mission m ON mm.mission_id = m.id
    JOIN
      store s ON m.store_id = s.id
    WHERE
      mm.member_id = :user_id  //로그인한 사용자의 ID 
      mm.status IN ('진행중', '완료')
    ORDER BY
      mm.updated_at DESC
    LIMIT
      10 OFFSET 0; //첫 페이지, 페이지 당 10개의 결과 
      
    ```
    
    커서기반 페이징으로 바꾼 쿼리( 지금처럼 아래로 스크롤해서 불러오는 구조 즉, 무한 스크롤은 Cursor 기반 페이징이 적합하다) 
    
    ```jsx
    SELECT
      mm.status AS Status,
      m.reward AS Reward,
      s.name AS StoreName,
      m.mission_spec AS MissionDescription,
      mm.created_at AS MissionStartDate, 
      mm.updated_at AS LastUpdated
    FROM
      member_mission mm
    JOIN
      mission m ON mm.mission_id = m.id
    JOIN
      store s ON m.store_id = s.id
    WHERE
      mm.member_id = :user_id
      mm.status IN ('진행중', '완료')
      AND (mm.updated_at, mm.id) < (?, ?)
    ORDER BY
      mm.updated_at DESC,
      mm.id DESC
    LIMIT 10;
    ```
    

![리뷰 작성하는 쿼리,
* 사진의 경우는 일단 배제](Untitled%205.png)

리뷰 작성하는 쿼리,
* 사진의 경우는 일단 배제

- 리뷰 작성하는 쿼리
    
    ```sql
    INSERT INTO review (member_id, store_id, body, score, created_at, updated_at)
    VALUES (1, 101, '너무 맛있어요.', 5, NOW(), NOW());
    
    SET @review_id = LAST_INSERT_ID();  //방금 등록된 review의 id 
    
    INSERT INTO review_img (review_id, image_url, created_at, updated_at)
    VALUES 
      (@review_id, 'https://reviewImg.com/image1.jpg', NOW(), NOW()),
      (@review_id, 'https://reviewImg.com/image2.jpg', NOW(), NOW());
    ```
    

![홈 화면 쿼리
(현재 선택 된 지역에서 도전이 가능한 미션 목록, 페이징 포함)](Untitled%206.png)

홈 화면 쿼리
(현재 선택 된 지역에서 도전이 가능한 미션 목록, 페이징 포함)

- 홈 화면 쿼리 (현재 선택된 지역에서 도전 가능한 미션목록, 페이징 포함)
    
    ```sql
    SELECT 
        m.id AS MissionID,
        m.mission_spec AS MissionDescription,
        m.reward AS Reward,
        m.deadline AS Deadline,
        s.name AS StoreName,
        s.address AS StoreAddress
    FROM 
        mission m
    JOIN 
        store s ON m.store_id = s.id
    WHERE 
        s.region_id = 7 AND          //예시 지역id 7
        m.deadline > NOW()           //현재 날짜 이후의 미션만 조회
    ORDER BY 
        m.created_at DESC
    LIMIT 
        10 OFFSET 0;                 
    ```
    

![마이 페이지 화면 쿼리](Untitled%207.png)

마이 페이지 화면 쿼리

- 마이 페이지 화면 쿼리
    
    ```sql
    SELECT 
        m.nickname AS Nickname,
        m.email AS Email,
        m.point AS Points
    FROM 
        member m
    WHERE 
        m.id = {사용자 번호};
    ```
