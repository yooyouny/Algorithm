SET @HOUR = -1;
select (@hour := @HOUR + 1) as hour
    , (select count(*)
      from ANIMAL_OUTS
      where (hour(datetime) = @hour)
      )
from ANIMAL_OUTS
where @HOUR<23
group by hour
order by hour