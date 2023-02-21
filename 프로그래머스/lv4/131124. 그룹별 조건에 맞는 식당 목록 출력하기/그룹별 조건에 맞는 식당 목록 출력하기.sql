-- 코드를 입력하세요
SELECT MEMBER_NAME, B.REVIEW_TEXT, date_format(B.REVIEW_DATE, '%Y-%m-%d')
FROM REST_REVIEW B
JOIN(
         SELECT   I.MEMBER_ID
                , I.REVIEW_DATE
                , I.REVIEW_TEXT
                , M.MEMBER_NAME
                , RANK() OVER (ORDER BY CNT DESC) AS RK
         FROM   ( SELECT *
                 , COUNT(MEMBER_ID) as CNT
                  FROM REST_REVIEW
                  GROUP BY MEMBER_ID
                ) I
        JOIN MEMBER_PROFILE M ON I.MEMBER_ID = M.MEMBER_ID
     ) A #가장 리뷰 수가 많은 멤버 출력 
ON A.MEMBER_ID = B.MEMBER_ID
WHERE 1=1
AND A.RK = 1
ORDER BY B.REVIEW_DATE, B.REVIEW_TEXT
;