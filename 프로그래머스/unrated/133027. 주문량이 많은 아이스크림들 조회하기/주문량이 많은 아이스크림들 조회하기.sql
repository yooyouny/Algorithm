select flavor
from (
    select h.flavor, sum(h.total_order) + sum(j.total_order) as cnt
    from first_half h, july j
    where h.flavor = j.flavor
    group by h.flavor
    order by cnt desc
)a
limit 3