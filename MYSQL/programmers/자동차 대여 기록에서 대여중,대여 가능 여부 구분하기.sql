-- 2022년 10월 16일에 대여 중인 자동차인 경우 '대여중', 대여 중이지 않은 자동차인 경우 '대여 가능'을 표시하는 컬럼(컬럼명: AVAILABILITY)을 추가하여 
-- 자동차 ID와 AVAILABILITY 리스트를 출력하는 SQL문을 작성
-- 반납 날짜가 2022년 10월 16일인 경우에도 '대여중'으로 표시
-- 결과는 자동차 ID를 기준으로 내림차순 정렬
SELECT c.CAR_ID,
    CASE 
        WHEN rh.CAR_ID IS NOT NULL THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM (SELECT DISTINCT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY) AS c
LEFT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY rh
ON c.CAR_ID = rh.CAR_ID AND rh.START_DATE <= '2022-10-16' AND rh.END_DATE >= '2022-10-16'
ORDER BY c.CAR_ID DESC;
