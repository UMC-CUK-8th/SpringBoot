select
    mission.id,
    mission.reward,
    mission.mission_spec, 
    mission.price, 
    store.name, 
    DATEDIFF(mission.deadline, NOW()) AS d_day 
FROM mission
JOIN store ON mission.store_id = store.id
JOIN region ON store.region_id = region.id
WHERE region.name = '서울' 
ORDER BY mission.deadline desc
LIMIT 10 OFFSET 0; 