select category, price as max_price, product_name
from
(SELECT CATEGORY, PRICE, PRODUCT_NAME,
                RANK() OVER(PARTITION BY CATEGORY ORDER BY PRICE DESC) AS RANK
          FROM FOOD_PRODUCT
          WHERE CATEGORY IN ('과자', '국', '김치', '식용유'))
         where rank =1
         order by price desc;