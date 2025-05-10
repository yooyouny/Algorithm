WITH TRUCK_DISCOUNT as (
    SELECT CASE 
        WHEN DURATION_TYPE LIKE '7%' THEN 7
        WHEN DURATION_TYPE LIKE '30%' THEN 30
        WHEN DURATION_TYPE LIKE '90%' THEN 90
    END AS DURATION_TYPE, 
    REPLACE(DISCOUNT_RATE, '%', '') / 100 AS DISCOUNT_RATE
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    WHERE CAR_TYPE = '트럭'
)

SELECT DAY.HISTORY_ID, CASE 
    WHEN DAY.DIFF >= 90 THEN FLOOR(DAY.DAILY_FEE * DAY.DIFF * (1 - (SELECT DISCOUNT_RATE 
                                                                FROM TRUCK_DISCOUNT 
                                                                WHERE DURATION_TYPE = 90)))
    WHEN DAY.DIFF >= 30 THEN FLOOR(DAY.DAILY_FEE * DAY.DIFF * (1 - (SELECT DISCOUNT_RATE 
                                                                FROM TRUCK_DISCOUNT 
                                                                WHERE DURATION_TYPE = 30)))
    WHEN DAY.DIFF >= 7 THEN FLOOR(DAY.DAILY_FEE * DAY.DIFF * (1 - (SELECT DISCOUNT_RATE 
                                                                FROM TRUCK_DISCOUNT 
                                                                WHERE DURATION_TYPE = 7)))
    ELSE DAY.DAILY_FEE * DAY.DIFF   
    END AS FEE
FROM (
    SELECT H.HISTORY_ID, 
    C.DAILY_FEE,
    DATEDIFF(H.END_DATE, H.START_DATE) + 1 AS DIFF
    FROM CAR_RENTAL_COMPANY_CAR C
    JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H ON C.CAR_ID = H.CAR_ID
    WHERE C.CAR_TYPE = '트럭'
) DAY
ORDER BY FEE DESC, DAY.HISTORY_ID DESC;
