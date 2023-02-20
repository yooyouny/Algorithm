-- 코드를 입력하세요
SELECT count(USER_ID) as users
FROM user_info
WHERE joined >= '2021-01-01' and joined < '2022-01-01' and age between 20 and 29