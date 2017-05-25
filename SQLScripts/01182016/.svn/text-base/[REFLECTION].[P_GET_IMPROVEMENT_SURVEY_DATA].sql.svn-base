IF EXISTS (
		SELECT *
		FROM sys.objects
		WHERE object_id = OBJECT_ID(N'[REFLECTION].[P_GET_IMPROVEMENT_SURVEY_DATA]')
			AND type IN (
				N'P'
				,N'PC'
				)
		)
	DROP PROCEDURE [REFLECTION].[P_GET_IMPROVEMENT_SURVEY_DATA]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [REFLECTION].[P_GET_IMPROVEMENT_SURVEY_DATA]
AS
BEGIN
	SET NOCOUNT ON

	DECLARE @Qry VARCHAR(MAX)
	DECLARE @Colname VARCHAR(MAX)
	DECLARE @SelColname VARCHAR(MAX)

	SELECT @Colname = ISNULL(@Colname + ',', '') + QUOTENAME(Option_id)
	FROM REFLECTION.ImprovementOptions

	SELECT @SelColname = ISNULL(@SelColname + ',', '') + QUOTENAME(Option_id) + ' as ' + Option_Name
	FROM REFLECTION.ImprovementOptions

	SET @Qry = ' SELECT Competency, ' + @SelColname + ' 
FROM (
      SELECT ImprovementOption
                        ,Competency
                        ,question_No
      FROM REFLECTION.Review
      ) p
PIVOT(COUNT(question_No) FOR ImprovementOption IN (
                 ' + @Colname + '
                  )) AS pvt
ORDER BY pvt.Competency;'

	EXECUTE (@Qry)
END
GO



