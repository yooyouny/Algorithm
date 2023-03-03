select MEMBER_NAME, REVIEW_TEXT, date_format(REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
from MEMBER_PROFILE m, REST_REVIEW r
where m.member_id = r.member_id
and m.member_id in (select member_id
                  from REST_REVIEW
                  group by member_id
                 having count(*) in (select max(cnt) 
                                    from (select count(*) as cnt
                                     from rest_review
                                     group by member_id)c
                                     )
                    )
order by REVIEW_DATE, REVIEW_TEXT