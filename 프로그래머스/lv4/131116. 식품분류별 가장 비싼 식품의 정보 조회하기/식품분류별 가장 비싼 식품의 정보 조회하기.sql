select CATEGORY, PRICE max_price, PRODUCT_NAME  
from
(select CATEGORY, PRICE, PRODUCT_NAME, rank() over(partition by CATEGORY order by PRICE desc) as rank
from FOOD_PRODUCT
where CATEGORY in ('과자', '국','김치','식용유'))
where rank =1
order by PRICE desc