
with counts as (
    select *, count(*) tot
    from rest_review
    group by member_id
),max_counts as(
    select max(tot) a
    from counts
)
select member_name
    , review_text
    , date_format(review_date, '%Y-%m-%d') review_date
from rest_review a, member_profile b 
where a.member_id = b.member_id
and b.member_id in (
        select member_id
        from rest_review
        group by member_id
        having count(*) = (
                select a
                from max_counts
        )
    )
order by review_date, review_text
