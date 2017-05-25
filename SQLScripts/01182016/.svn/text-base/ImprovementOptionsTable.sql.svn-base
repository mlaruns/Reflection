IF EXISTS (
		SELECT *
		FROM sys.objects
		WHERE object_id = OBJECT_ID(N'[REFLECTION].[ImprovementOptions]')
			AND type IN (N'U')
		)
	DROP TABLE [REFLECTION].[ImprovementOptions]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [REFLECTION].[ImprovementOptions] (
	[option_id] [int] IDENTITY(1, 1) NOT NULL
	,[option_name] [varchar](100) NULL
	,[description] [varchar](200) NULL
	,[isActive] [BIT] NULL
	,PRIMARY KEY CLUSTERED ([option_id] ASC) WITH (
		PAD_INDEX = OFF
		,STATISTICS_NORECOMPUTE = OFF
		,IGNORE_DUP_KEY = OFF
		,ALLOW_ROW_LOCKS = ON
		,ALLOW_PAGE_LOCKS = ON
		)
	ON [PRIMARY]
	) ON [PRIMARY]
GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [REFLECTION].[ImprovementOptions] ADD DEFAULT(NULL)
FOR [option_name]
GO

-- inserion scripts
/*INSERT INTO REFLECTION.ImprovementOptions (option_name)
VALUES ('-select-');
INSERT INTO REFLECTION.ImprovementOptions (option_name)
VALUES ('Trainings');
INSERT INTO REFLECTION.ImprovementOptions (option_name)
VALUES ('Ciber University Course')		
INSERT INTO REFLECTION.ImprovementOptions (option_name)
VALUES ('Some Other Options');
*/




