select p.PRODUCT_ID, p.PRODUCT_NAME, sum(price * amount) as total_sales
from FOOD_PRODUCT p, FOOD_ORDER o
where p.product_id = o.product_id
and PRODUCE_DATE like '2022-05%'
group by p.PRODUCT_ID, p.PRODUCT_NAME
order by total_sales desc, product_id
