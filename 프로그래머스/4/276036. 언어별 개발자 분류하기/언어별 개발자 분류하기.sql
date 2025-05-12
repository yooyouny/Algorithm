WITH Front_Skill AS (
    SELECT SUM(CODE) as CODE
    FROM SKILLCODES
    WHERE CATEGORY = 'Front End'
),
CSharp_Skill AS (
    SELECT CODE
    FROM SKILLCODES
    WHERE NAME = 'C#'
),
Python_Skill AS (
    SELECT CODE 
    FROM SKILLCODES
    WHERE Name = 'Python'
)

SELECT CASE 
    WHEN (D.SKILL_CODE & Python_Skill.CODE) > 0 AND (D.SKILL_CODE & Front_Skill.CODE) > 0 THEN 'A'
    WHEN D.SKILL_CODE & CSharp_Skill.CODE > 0 THEN 'B'
    WHEN D.SKILL_CODE & Front_Skill.CODE > 0 THEN 'C'
    END AS GRADE,
    D.ID,
    D.EMAIL
FROM DEVELOPERS D, Front_Skill, Python_Skill, CSharp_Skill
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID;