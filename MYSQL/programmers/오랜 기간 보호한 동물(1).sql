-- 아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회하는 SQL문을 작성
-- 결과는 보호 시작일 순으로 조회
select ai.name, ai.datetime
from animal_ins as ai
left join animal_outs as ao on ao.animal_id = ai.animal_id
where ao.animal_id is null
order by ai.datetime limit 3
