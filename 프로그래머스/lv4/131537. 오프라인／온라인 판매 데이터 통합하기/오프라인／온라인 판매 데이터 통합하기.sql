-- 코드를 입력하세요
SELECT date_format(sales_date, '%Y-%m-%d')as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
from ONLINE_SALE 
WHERE SALES_DATE between '2022-03-01' and '2022-03-31'

union all 

SELECT date_format(sales_date, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, NULL as USER_ID, SALES_AMOUNT
from OFFLINE_SALE 
WHERE SALES_DATE between '2022-03-01' and '2022-03-31'

order by SALES_DATE, PRODUCT_ID, USER_ID