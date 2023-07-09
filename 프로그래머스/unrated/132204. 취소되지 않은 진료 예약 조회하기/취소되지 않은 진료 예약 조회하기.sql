SELECT C.APNT_NO,
        P.PT_NAME,
        C.PT_NO,
        C.MCDP_CD,
        C.DR_NAME,
        C.APNT_YMD
FROM
    (
         SELECT A.apnt_no,
                A.pt_no,
                A.mcdp_cd,
               A.apnt_ymd ,
               D.DR_NAME
        FROM 
            APPOINTMENT A
        JOIN 
            DOCTOR D
        ON
            D.DR_ID=A.MDDR_ID
        WHERE 
            A.APNT_CNCL_YN = 'N'
            AND
            A.MCDP_CD ='CS'
            AND
            TO_CHAR(A.APNT_YMD,'YYYY-MM-DD')='2022-04-13') C
JOIN
    PATIENT P
ON 
    C.PT_NO = P.PT_NO
ORDER BY 
    C.APNT_YMD ASC