-- 코드를 입력하세요
SELECT PRODUCT_CODE, SUM(SALES_AMOUNT * PRICE) as SALES
FROM PRODUCT P 
JOIN OFFLINE_SALE O on P.PRODUCT_ID = O.PRODUCT_ID
GROUP BY PRODUCT_CODE
ORDER BY SALES desc, PRODUCT_CODE