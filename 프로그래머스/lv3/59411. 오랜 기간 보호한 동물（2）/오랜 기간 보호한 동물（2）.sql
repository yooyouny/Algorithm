/*with max_diff as (
(select i.ANIMAL_ID, (datediff(o.datetime, i.datetime) + 1) as diff
                                from ANIMAL_INS i, ANIMAL_OUTS o
                                where i.animal_id = o.animal_id
                                group by i.ANIMAL_ID
                            )
)

select i.ANIMAL_ID, i.NAME
from ANIMAL_INS i, ANIMAL_OUTS o
where i.animal_id = o.animal_id
and (i.animal_id, datediff(o.datetime, i.datetime) + 1) in (
                        select i.ANIMAL_ID, max(diff)
                        from max_diff
                        )
group by i.ANIMAL_ID, i.NAME*/

/*가장 오래된 동물 두마리  
Girly Girl	350
Emily	293
select i.name, datediff(o.datetime, i.datetime)+1 as diff
from ANIMAL_INS i, ANIMAL_OUTS o
where i.animal_id = o.animal_id 
order by diff desc
limit 2
*/
select i.ANIMAL_ID, i.NAME
from ANIMAL_INS i, ANIMAL_OUTS o
where i.animal_id = o.animal_id
order by datediff(o.datetime, i.datetime)+1 desc
limit 2


