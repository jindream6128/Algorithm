SELECT ANIMAL_ID, NAME
FROM
(SELECT (A.DATETIME-B.DATETIME) DATEDIFF, A.ANIMAL_ID, A.NAME
FROM ANIMAL_OUTS A
JOIN ANIMAL_INS B
ON A.ANIMAL_ID = B.ANIMAL_ID
ORDER BY DATEDIFF DESC)
WHERE ROWNUM <= 2