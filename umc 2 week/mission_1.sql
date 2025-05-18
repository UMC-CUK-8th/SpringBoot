select
    member_mission.id, -- member_mission 테이블의 id
    mission.reward, -- member_mission 테이블의 하위테이블 mission의 reward
    mission.mission_spec, -- member_mission 테이블의 하위테이블 mission의 spec
    mission.price, -- member_mission 테이블의 하위테이블 mission의 price
    store.name, -- store 테이블의 name
    member_mission.status, -- member_mission테이블의 status (성공,실패 여부)
    member_mission.updated_at, -- member_mission테이블의 업데이트시간
    member.name, -- 화면상에 보이진 않지만 member테이블의 닉네임 
    member.point -- member 테이블의 포인트 (위와 같음)
from member_mission -- member_mission테이블에서 from
join mission on member_mission.mission_id = mission.id -- from문의 member_mission과
-- join문의 mission 문의 이너조인,  즉 member_mission테이블의 mission_id(10,11,12)와
-- mission테이블의 id와 같은 데이터끼리 연결하겠다는 의미.
join store on mission.store_id = store.id  -- mission테이블의 id와 store의 id 이너조인
join member on member_mission.member_id = member.id
-- memver_mission의 member_id와 member테이블의 id 이너조인
where member_mission.member_id = 2  -- 특정 사용자 ID
-- 특정 조건, member_mission테이블의 member_id가 2인 사람을 지정
order by member_mission.updated_at desc;
-- member_mission테이블의 updated_at열을 기준으로 내림차순 정렬
limit 10 offset 0;
