SELECT 
    A.PRODUCT_ID,
    A.PRODUCT_NAME,
    SUM(A.PRICE * B.AMOUNT) TOTAL_SALES
FROM
    FOOD_PRODUCT A
JOIN 
    FOOD_ORDER B
    ON A.PRODUCT_ID = B.PRODUCT_ID
WHERE
    to_char(B.PRODUCE_DATE,'YYYY-MM') = '2022-05'
GROUP BY A.PRODUCT_ID, A.PRODUCT_NAME
ORDER BY TOTAL_SALES DESC, A.PRODUCT_ID ASC;