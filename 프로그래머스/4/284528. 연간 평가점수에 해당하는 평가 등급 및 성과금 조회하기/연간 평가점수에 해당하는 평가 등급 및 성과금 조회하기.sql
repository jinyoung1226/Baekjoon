SELECT
    HE.EMP_NO,
    HE.EMP_NAME,
    HG.GRADE,
    CASE
        WHEN HG.GRADE = 'S' THEN HE.SAL * 0.2
        WHEN HG.GRADE = 'A' THEN HE.SAL * 0.15
        WHEN HG.GRADE = 'B' THEN HE.SAL * 0.1
        ELSE 0
    END AS BONUS
FROM HR_EMPLOYEES HE
JOIN (
    SELECT
        HG.EMP_NO,
        CASE
            WHEN SUM(HG.SCORE) / 2 >= 96 THEN 'S'
            WHEN SUM(HG.SCORE) / 2 >= 90 THEN 'A'
            WHEN SUM(HG.SCORE) / 2 >= 80 THEN 'B'
            ELSE 'C'
        END AS GRADE
    FROM HR_GRADE HG
    GROUP BY HG.EMP_NO
) AS HG
ON HE.EMP_NO = HG.EMP_NO
ORDER BY 1 ASC;

