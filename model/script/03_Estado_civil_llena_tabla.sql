SET IDENTITY_INSERT [dbo].[Estado_civil] ON
GO
INSERT INTO Estado_civil (Estado_civil_id, Nombre, Estado) VALUES
(1, 'Soltero (a)', 1),
(2, 'Casado (a)', 1),
(3, 'Divorciado (a)', 1),
(4, 'Viudo (a)', 1);

GO
/* Turn Identity Insert OFF  */
SET IDENTITY_INSERT [dbo].[Ciudad] OFF
GO 