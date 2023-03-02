/*
1. 식품의 분류 별로 -> Group by 생각함
2. groupby에 특정 기준을 쓰면 반드시 select에도 써줘야 한다고 생각했음 
-> 집계함수만 select할 경우 생략 가능함 
3. where절 서브쿼리 시 =을 쓸 경우 서브쿼리의 결과가 하나여야함 
-> in으로 대체
*/
select CATEGORY, PRICE, PRODUCT_NAME
from FOOD_PRODUCT
where PRICE in (select max(PRICE)
                from FOOD_PRODUCT
                group by category)
AND CATEGORY in ('과자', '국', '김치', '식용유')
order by price desc 
        