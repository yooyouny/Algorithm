with joinon as(
    select user_id
    from user_info
    where year(joined) = 2021
), countjoin as (
    select count(*) tot
    from joinon
)

select year(sales_date) year
    , month(sales_date) month
    , (count(distinct a.user_id)) PUCHASED_USERS
    , round(
        (count(distinct a.user_id)/(select tot from countjoin)),1) PUCHASED_ratio
from online_sale a
where user_id in (select user_id from joinon)
group by year, month
order by year, month