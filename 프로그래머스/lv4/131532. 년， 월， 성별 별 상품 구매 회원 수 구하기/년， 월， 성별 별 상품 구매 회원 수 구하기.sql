select year(sales_date), month(sales_date), gender, count(distinct u.user_id) as users
from user_info u, online_sale s
where u.user_id = s.user_id
and gender is not null
group by year(sales_date), month(sales_date), gender
order by 1, 2, 3
