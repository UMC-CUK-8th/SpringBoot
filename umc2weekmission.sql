CREATE DATABASE IF NOT EXISTS mydb;
use mydb;


CREATE TABLE `store` (
	`id`	bigint	NOT NULL,
	`지역id`	bigint	NOT NULL,
	`store_name`	varchar(20)	NULL,
	`store_loca`	varchar(20)	NULL,
	`store_menu`	varchar(50)	NULL,
	`store_review`	text	NULL
);

CREATE TABLE `missions` (
	`id`	bigint	NOT NULL,
	`지역id`	bigint	NOT NULL,
	`가게id`	bigint	NOT NULL,
	`visit`	varchar(10)	NULL,
	`created_at`	varchar(20)	NULL,
	`mission_point`	bigint	NULL
);

CREATE TABLE `alarm` (
	`id`	bigint	NOT NULL,
	`회원id`	bigint	NOT NULL,
	`created_at`	datetime(6)	NULL,
	`dtype`	varchar(20)	NULL,
	`title`	varchar(30)	NULL,
	`body`	text	NULL,
	`comfirmed_at`	boolean	NULL
);

CREATE TABLE `location` (
	`id`	bigint	NOT NULL,
	`location_name`	varchar(20)	NULL,
	`store_count`	bigint	NULL,
	`updated_at`	varchar(20)	NULL
);

CREATE TABLE `reviews` (
	`id`	bigint	NOT NULL AUTO_INCREMENT,
	`회원id`	bigint	NOT NULL,
	`가게id`	bigint	NOT NULL,
	`지역id`	bigint	NOT NULL,
	`review`	varchar(100)	NULL,
	`review_star`	bigint	NULL,
	`created_at`	datetime(6)	NULL,
	`upload_at`	datetime(6)	NULL
);

CREATE TABLE `members` (
	`id`	bigint	NOT NULL,
	`user_id`	varchar(20)	NULL,
	`user_pw`	varchar(20)	NULL,
	`user_name`	varchar(20)	NULL,
	`user_food`	varchar(20)	NULL,
	`user_birth`	bigint(20)	NULL,
	`user_address`	varchar(30)	NULL,
	`status`	varchar(20)	NULL,
	`inactive_date`	datetime	NULL
);

CREATE TABLE `usermission` (
	`id`	bigint	NOT NULL,
	`미션id`	bigint	NOT NULL,
	`지역id`	bigint	NOT NULL,
	`가게id`	bigint	NOT NULL,
	`회원id`	bigint	NOT NULL,
	`point`	bigint	NULL,
	`created_at`	datetime	NULL,
	`is_completed`	boolean	NULL
);

CREATE TABLE `locationbounusmission` (
	`id`	bigint	NOT NULL,
	`회원id`	bigint	NOT NULL,
	`지역id`	bigint	NOT NULL,
	`mission_count`	bigint	NULL,
	`bonus_check`	boolean	NULL,
	`bouns_point`	bigint	NULL,
	`gived_at`	datetime	NULL
);

CREATE TABLE `CopyOfmissions` (
	`id`	bigint	NOT NULL,
	`mission_count`	bigint	NULL,
	`point`	bigint	NULL,
	`created_at`	datetime	NULL,
	`id2`	bigint	NOT NULL,
	`지역id`	bigint	NOT NULL,
	`가게id`	bigint	NOT NULL
);
ALTER TABLE reviews
    MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE `store` ADD CONSTRAINT `PK_STORE` PRIMARY KEY (
	`id`,
	`지역id`
);
ALTER TABLE `store` ADD UNIQUE (`id`);


ALTER TABLE `missions` ADD CONSTRAINT `PK_MISSIONS` PRIMARY KEY (
	`id`,
	`지역id`,
	`가게id`
);

ALTER TABLE `alarm` ADD CONSTRAINT `PK_ALARM` PRIMARY KEY (
	`id`,
	`회원id`
);

ALTER TABLE `location` ADD CONSTRAINT `PK_LOCATION` PRIMARY KEY (
	`id`
);

ALTER TABLE `reviews` ADD CONSTRAINT `PK_REVIEWS` PRIMARY KEY (
	`id`,
	`회원id`,
	`가게id`,
	`지역id`
);

ALTER TABLE `members` ADD CONSTRAINT `PK_MEMBERS` PRIMARY KEY (
	`id`
);

ALTER TABLE `usermission` ADD CONSTRAINT `PK_USERMISSION` PRIMARY KEY (
	`id`,
	`미션id`,
	`지역id`,
	`가게id`,
	`회원id`
);

ALTER TABLE `locationbounusmission` ADD CONSTRAINT `PK_LOCATIONBOUNUSMISSION` PRIMARY KEY (
	`id`,
	`회원id`,
	`지역id`
);

ALTER TABLE `CopyOfmissions` ADD CONSTRAINT `PK_COPYOFMISSIONS` PRIMARY KEY (
	`id`
);

ALTER TABLE `store` ADD CONSTRAINT `FK_location_TO_store_1` FOREIGN KEY (
	`지역id`
)
REFERENCES `location` (
	`id`
);


ALTER TABLE `missions` ADD CONSTRAINT `FK_store_TO_missions_1` FOREIGN KEY (
	`지역id`
)
REFERENCES `store` (
	`id`
);

ALTER TABLE `missions` ADD CONSTRAINT `FK_store_TO_missions_2` FOREIGN KEY (
	`가게id`
)
REFERENCES `store` (
	`지역id`
);


ALTER TABLE `alarm` ADD CONSTRAINT `FK_members_TO_alarm_1` FOREIGN KEY (
	`회원id`
)
REFERENCES `members` (
	`id`
);

ALTER TABLE `reviews` ADD CONSTRAINT `FK_members_TO_reviews_1` FOREIGN KEY (
	`회원id`
)
REFERENCES `members` (
	`id`
);

ALTER TABLE `reviews` ADD CONSTRAINT `FK_store_TO_reviews_1` FOREIGN KEY (
	`가게id`
)
REFERENCES `store` (
	`id`
);

ALTER TABLE `reviews` ADD CONSTRAINT `FK_store_TO_reviews_2` FOREIGN KEY (
	`지역id`
)
REFERENCES `store` (
	`지역id`
);

ALTER TABLE `usermission` ADD CONSTRAINT `FK_missions_TO_usermission_1` FOREIGN KEY (
	`미션id`
)
REFERENCES `missions` (
	`id`
);

ALTER TABLE `usermission` ADD CONSTRAINT `FK_missions_TO_usermission_2` FOREIGN KEY (
	`지역id`
)
REFERENCES `missions` (
	`지역id`
);

ALTER TABLE `usermission` ADD CONSTRAINT `FK_missions_TO_usermission_3` FOREIGN KEY (
	`가게id`
)
REFERENCES `missions` (
	`가게id`
);

ALTER TABLE `usermission` ADD CONSTRAINT `FK_members_TO_usermission_1` FOREIGN KEY (
	`회원id`
)
REFERENCES `members` (
	`id`
);

ALTER TABLE `locationbounusmission` ADD CONSTRAINT `FK_members_TO_locationbounusmission_1` FOREIGN KEY (
	`회원id`
)
REFERENCES `members` (
	`id`
);

ALTER TABLE `locationbounusmission` ADD CONSTRAINT `FK_location_TO_locationbounusmission_1` FOREIGN KEY (
	`지역id`
)
REFERENCES `location` (
	`id`
);

use mydb;

select
    m.visit as 미션이름,
    um.created_at,
    um.point
from usermission as um
         join missions as m
              on um.미션id = m.id
                  and um.지역id = m.지역id
                  and um.가게id = m.가게id
where um.회원id = ?
  and um.is_completed = 1
order by um.created_at desc
limit 10 offset 0;  -- ← 페이지 1

select
    m.visit as 미션이름,
    um.created_at,
    um.point
from usermission as um
         join missions as m
              on um.미션id = m.id
                  and um.지역id = m.지역id
                  and um.가게id = m.가게id
where um.회원id = ?
  and um.is_completed = 0
order by um.created_at desc
limit 10 offset 0;  -- ← 페이지 1

select
    re.review as 리뷰내용,
    re.review_star as 별점,
    re.created_at,
    st.store_name
from reviews as re
        join store as st
            on re.가게id = st.id
                and re.지역id = st.지역id
where re.회원id = ?;

insert into reviews(
                    회원id,
                    가게id,
                    지역id,
                    review,
                    review_star,
                    created_at,
                    upload_at
) values(
        ?,?,?,?,?,now(),now()
        );

select
    m.id,
    m.visit as 미션이름,
    m.mission_point as 포인트,
    count(um.id) as 달성미션수
from missions as m
left join usermission as um
    on m.id = um.미션id
    and m.지역id = um.지역id
    and m.가게id = um.가게id
where m.지역id = ?
group by m.id,m.visit,m.mission_point
order by m.id desc
limit 10 offset 0;


SHOW CREATE TABLE reviews;


select
    m.user_name as 이름,
    m.user_id as 아아디,
    coalesce(sum(um.point),0) as 누적포인트

from members as m
left join usermission as um
    on m.id = um.회원id and um.is_completed = 1
where m.id = ?
group by m.id,m.user_name, m.user_id;

select
    m.user_name as 이름,
    m.user_id as 아아디,
    sum(um.point) as 누적포인트

from members as m
         left join usermission as um
                   on m.id = um.회원id

where m.id = ?
group by m.id,m.user_name, m.user_id;