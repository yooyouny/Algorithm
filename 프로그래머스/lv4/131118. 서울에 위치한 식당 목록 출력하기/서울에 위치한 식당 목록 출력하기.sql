-- 코드를 입력하세요
SELECT b.REST_ID, a.REST_NAME, a.FOOD_TYPE, a.FAVORITES, a.ADDRESS, Round(AVG(b.REVIEW_SCORE), 2) as SCORE 
from REST_INFO a 
join REST_REVIEW b on a.rest_id = b.rest_id 
group by a.rest_id
having a.ADDRESS like '서울%'
order by score desc, a.favorites desc