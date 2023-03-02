select b.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(price * sales) as SALES
from book b, author a, book_sales s
where b.author_id = a.author_id and b.book_id = s.book_id
and date_format(sales_date, '%Y-%m') = '2022-01'
group by author_id, category
order by AUTHOR_ID, category desc