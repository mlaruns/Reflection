IF EXISTS (
		SELECT *
		FROM sys.objects
		WHERE object_id = OBJECT_ID(N'[REFLECTION].[JohariWidowAdjectives]')
			AND type IN (N'U')
		)
	DROP TABLE [REFLECTION].[JohariWidowAdjectives]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [REFLECTION].[JohariWidowAdjectives] (
	[option_id] [int] IDENTITY(1, 1) NOT NULL
	,[option_name] [varchar](100) NOT NULL
	,CONSTRAINT [JohariWidowAdjectives_PK] PRIMARY KEY CLUSTERED ([option_id] ASC) WITH (
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

-- inserion scripts
/*INSERT INTO [REFLECTION].[JohariWidowAdjectives] (option_name)
VALUES ('Aggressive');
INSERT INTO [REFLECTION].[JohariWidowAdjectives] (option_name)
VALUES ('Caring');
INSERT INTO [REFLECTION].[JohariWidowAdjectives] (option_name)
VALUES ('Negative');
INSERT INTO [REFLECTION].[JohariWidowAdjectives] (option_name)
VALUES ('Confident');
INSERT INTO [REFLECTION].[JohariWidowAdjectives] (option_name)
VALUES ('Flexible');
INSERT INTO [REFLECTION].[JohariWidowAdjectives] (option_name)
VALUES ('Passive');
INSERT INTO [REFLECTION].[JohariWidowAdjectives] (option_name)
VALUES ('Temperamental');
INSERT INTO [REFLECTION].[JohariWidowAdjectives] (option_name)
VALUES ('self-conscious');
INSERT INTO [REFLECTION].[JohariWidowAdjectives] (option_name)
VALUES ('regretful');
INSERT INTO [REFLECTION].[JohariWidowAdjectives] (option_name)
VALUES ('imaginative');
INSERT INTO [REFLECTION].[JohariWidowAdjectives] (option_name)
VALUES ('unreasonable');
INSERT INTO [REFLECTION].[JohariWidowAdjectives] (option_name)
VALUES ('sensible');
INSERT INTO [REFLECTION].[JohariWidowAdjectives] (option_name)
VALUES ('responsible');
INSERT INTO [REFLECTION].[JohariWidowAdjectives] (option_name)
VALUES ('lively');
INSERT INTO [REFLECTION].[JohariWidowAdjectives] (option_name)
VALUES ('organized');  */