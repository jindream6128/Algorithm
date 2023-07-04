SELECT 
    INFO.REST_ID,
    INFO.REST_NAME,
    INFO.FOOD_TYPE,
    INFO.FAVORITES,
    INFO.ADDRESS,
    ROUND(AVG(REVIEW.REVIEW_SCORE),2) AS SCORE
FROM REST_INFO INFO 
JOIN REST_REVIEW REVIEW 
ON INFO.REST_ID = REVIEW.REST_ID
WHERE INFO.ADDRESS LIKE '서울%'
GROUP BY INFO.REST_ID,
    INFO.REST_NAME,
    INFO.FOOD_TYPE,
    INFO.FAVORITES,
    INFO.ADDRESS
ORDER BY 
SCORE DESC, 
INFO.FAVORITES DESC;
    
