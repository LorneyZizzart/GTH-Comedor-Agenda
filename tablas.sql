USE [GTH]
GO
/****** Object:  Table [dbo].[AEstadoTarea]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AEstadoTarea](
	[idEstadoTarea] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](100) NULL,
	[estado] [int] NULL,
 CONSTRAINT [PK_AEstadoTarea] PRIMARY KEY CLUSTERED 
(
	[idEstadoTarea] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[APath]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[APath](
	[idPath] [int] IDENTITY(1,1) NOT NULL,
	[idTarea] [int] NULL,
	[nombre] [varchar](250) NULL,
	[pathImage] [varchar](max) NULL,
 CONSTRAINT [PK_APath] PRIMARY KEY CLUSTERED 
(
	[idPath] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[APathProcedimiento]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[APathProcedimiento](
	[idPathProcedimiento] [int] IDENTITY(1,1) NOT NULL,
	[idProcedimiento] [int] NULL,
	[nombre] [varchar](300) NULL,
	[pathImage] [varchar](max) NULL,
 CONSTRAINT [PK_APathProcedimiento] PRIMARY KEY CLUSTERED 
(
	[idPathProcedimiento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[AProcedimientoTarea]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AProcedimientoTarea](
	[idProcedimiento] [int] IDENTITY(1,1) NOT NULL,
	[idTarea] [int] NULL,
	[nombre] [varchar](250) NULL,
	[descripcion] [varchar](max) NULL,
	[estado] [int] NULL,
	[fechaRegistro] [date] NULL,
	[fechaActualizacion] [date] NULL,
 CONSTRAINT [PK_AProcedimientoTarea] PRIMARY KEY CLUSTERED 
(
	[idProcedimiento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Area]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Area](
	[Area_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](50) NULL,
	[Posicion] [int] NULL,
	[Estado] [int] NULL,
	[Fecha_creacion] [date] NULL,
 CONSTRAINT [PK_Area] PRIMARY KEY CLUSTERED 
(
	[Area_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ARepeticionTarea]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ARepeticionTarea](
	[idRepeticionTarea] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](250) NULL,
	[sumarDias] [int] NULL,
	[sumarMes] [int] NULL,
	[sumarYear] [int] NULL,
	[estado] [int] NULL,
 CONSTRAINT [PK_ARepeticionTarea] PRIMARY KEY CLUSTERED 
(
	[idRepeticionTarea] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ATarea]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ATarea](
	[idTarea] [int] IDENTITY(1,1) NOT NULL,
	[titulo] [varchar](200) NULL,
	[descripcion] [varchar](max) NULL,
	[color] [varchar](50) NULL,
	[fechaInicio] [date] NULL,
	[fechaFinal] [varchar](25) NULL,
	[estado] [int] NULL,
	[fechaRegistro] [date] NULL,
	[fechaActualizacion] [date] NULL,
	[idUsuarioCrea] [int] NULL,
	[horaInicio] [varchar](25) NULL,
	[horaFinal] [varchar](25) NULL,
	[idRepeticionTarea] [int] NULL,
	[idTipoTarea] [int] NULL,
	[idEstadoTarea] [int] NULL,
	[domingo] [bit] NULL,
	[lunes] [bit] NULL,
	[martes] [bit] NULL,
	[miercoles] [bit] NULL,
	[jueves] [bit] NULL,
	[viernes] [bit] NULL,
	[sabado] [bit] NULL,
 CONSTRAINT [PK_ATarea] PRIMARY KEY CLUSTERED 
(
	[idTarea] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ATipoTarea]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ATipoTarea](
	[idTipoTarea] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](300) NULL,
 CONSTRAINT [PK_ATipoTarea] PRIMARY KEY CLUSTERED 
(
	[idTipoTarea] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Banco_respuestas]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Banco_respuestas](
	[Banco_Respuestas_id] [int] IDENTITY(1,1) NOT NULL,
	[Opcion] [nvarchar](50) NULL,
	[Css] [nvarchar](10) NULL,
	[Seccion] [nvarchar](50) NULL,
	[Tipo_id] [int] NULL,
 CONSTRAINT [PK_Banco_respuestas] PRIMARY KEY CLUSTERED 
(
	[Banco_Respuestas_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cargo]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cargo](
	[Cargo_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](150) NULL,
	[Descripcion] [nvarchar](550) NULL,
	[Estado] [int] NULL,
 CONSTRAINT [PK_Cargo] PRIMARY KEY CLUSTERED 
(
	[Cargo_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CComensalExterno]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CComensalExterno](
	[idComensalExterno] [int] IDENTITY(1,1) NOT NULL,
	[nombreCompleto] [varchar](250) NULL,
	[celular] [int] NULL,
	[fechaRegistro] [date] NULL,
	[fechaActualizar] [date] NULL,
 CONSTRAINT [PK_CComensalExterno] PRIMARY KEY CLUSTERED 
(
	[idComensalExterno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CEmpleado_Reserva]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CEmpleado_Reserva](
	[idEmpleadoReserva] [int] IDENTITY(1,1) NOT NULL,
	[IdTipoComensal] [int] NULL,
	[IdEmpleado] [int] NULL,
	[Fecha] [date] NULL,
	[Cantidad] [int] NULL,
	[Estado] [int] NULL,
	[Observacion] [varchar](100) NULL,
	[Cancelar] [bit] NULL,
	[FechaCancelacion] [date] NULL,
	[IdTipoComida] [int] NULL,
	[fechaRegistro] [date] NULL,
	[fechaActulizacion] [date] NULL,
	[descuento] [decimal](5, 2) NULL,
	[notificacion] [bit] NULL,
	[listarNotificacion] [bit] NULL,
 CONSTRAINT [PK_CEmpleado_Reserva] PRIMARY KEY CLUSTERED 
(
	[idEmpleadoReserva] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ciudad]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ciudad](
	[Ciudad_id] [int] IDENTITY(1,1) NOT NULL,
	[CiudadNombre] [char](50) NULL,
	[CiudadDistrito] [char](30) NULL,
	[Pais_id] [char](3) NULL,
	[CiudadPoblacion] [int] NULL,
 CONSTRAINT [PK5] PRIMARY KEY NONCLUSTERED 
(
	[Ciudad_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cliente](
	[Cliente_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](150) NULL,
	[Correo] [nvarchar](100) NULL,
	[Telefono] [nvarchar](50) NULL,
	[Ci] [nvarchar](50) NULL,
	[Tipo_cliente_id] [int] NULL,
	[Estado] [int] NULL,
 CONSTRAINT [PK_Cliente] PRIMARY KEY CLUSTERED 
(
	[Cliente_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CReservaExterno]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CReservaExterno](
	[idReservaExterno] [int] IDENTITY(1,1) NOT NULL,
	[IdTipoComensal] [int] NULL,
	[IdComensalExterno] [int] NULL,
	[Fecha] [date] NULL,
	[Cantidad] [int] NULL,
	[Estado] [int] NULL,
	[Observacion] [varchar](500) NULL,
	[Cancelar] [bit] NULL,
	[fechaCancelacion] [date] NULL,
	[IdTipoComida] [int] NULL,
	[fechaRegistro] [date] NULL,
	[fechaActualizacion] [date] NULL,
	[descuento] [decimal](5, 2) NULL,
	[notificacion] [bit] NULL,
	[listarNotificacion] [bit] NULL,
 CONSTRAINT [PK_CReservaExterno] PRIMARY KEY CLUSTERED 
(
	[idReservaExterno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTipoComensal]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTipoComensal](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NULL,
	[MinimiDias] [int] NULL,
	[Estado] [int] NULL,
	[fechaRegistro] [date] NULL,
	[UsuarioCrea] [int] NULL,
	[fechaActualizacion] [date] NULL,
	[descuento] [varchar](10) NULL,
	[diasAnticipacion] [int] NULL,
	[descuentoDesayuno] [varchar](10) NULL,
	[descuentoAlmuerzo] [varchar](10) NULL,
	[descuentoCena] [varchar](10) NULL,
 CONSTRAINT [PK_CTipoComensal] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTipoComida]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTipoComida](
	[IdTipoComida] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NULL,
	[Costo] [money] NULL,
	[Estado] [int] NULL,
	[Hora] [varchar](10) NULL,
	[Detalles] [text] NULL,
	[FechaRegistro] [date] NULL,
	[FechaActualizacion] [date] NULL,
	[color] [varchar](50) NULL,
	[horasAnticipacion] [varchar](10) NULL,
 CONSTRAINT [PK_CTipoComida] PRIMARY KEY CLUSTERED 
(
	[IdTipoComida] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cuestioario_evalua]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cuestioario_evalua](
	[Cuestionario_evalua_id] [int] IDENTITY(1,1) NOT NULL,
	[Cuestionario_id] [int] NULL,
	[Evalua_empleado_id] [int] NULL,
	[A_empleado_id] [int] NULL,
	[Estado] [int] NULL,
	[Envio_correo] [int] NULL,
	[Fecha_envio_correo] [date] NULL,
	[LLeno_cuestionario] [int] NULL,
	[Fecha_lleno_cuestionario] [date] NULL,
	[Tipo] [nvarchar](50) NULL,
	[Cuestionario_gestion_id] [int] NULL,
	[Tipo_cliente] [nvarchar](2) NULL,
 CONSTRAINT [PK_Cuestioario_evalua] PRIMARY KEY CLUSTERED 
(
	[Cuestionario_evalua_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cuestionario]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cuestionario](
	[Cuestionario_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](150) NULL,
	[Estado] [int] NULL,
	[Fecha_cracion] [date] NULL,
	[Usuario_crea] [int] NULL,
	[Fecha_actualiza] [date] NULL,
	[Usuario_actualiza] [int] NULL,
	[Detalle] [nvarchar](500) NULL,
 CONSTRAINT [PK_Cuestionario] PRIMARY KEY CLUSTERED 
(
	[Cuestionario_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cuestionario_empleado]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cuestionario_empleado](
	[Cuestionario_empleado_id] [int] IDENTITY(1,1) NOT NULL,
	[Empleado_id] [int] NULL,
	[Cuestionario_id] [int] NULL,
	[Fecha_creacion] [date] NULL,
	[Estado] [int] NULL,
 CONSTRAINT [PK_Cuestionario_empleado] PRIMARY KEY CLUSTERED 
(
	[Cuestionario_empleado_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cuestionario_gestion]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cuestionario_gestion](
	[Cuestionario_gestion_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](50) NULL,
	[Fecha_creacion] [date] NULL,
	[Usuario_crea] [int] NULL,
	[Fecha_actualiza] [date] NULL,
	[Usuario_actualiza] [int] NULL,
	[Estado] [int] NULL,
	[Descripcion] [nvarchar](2000) NULL,
	[Mensaje_correo] [nvarchar](4000) NULL,
	[Titulo_correo] [nvarchar](250) NULL,
	[Gestion] [nchar](10) NULL,
 CONSTRAINT [PK_Cuestionario_gestion] PRIMARY KEY CLUSTERED 
(
	[Cuestionario_gestion_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cuestionario_gestion_empleado]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cuestionario_gestion_empleado](
	[Cuestionario_gestion_empleado_id] [int] IDENTITY(1,1) NOT NULL,
	[Cuestionario_gestion_id] [int] NULL,
	[Empleado_id] [int] NULL,
 CONSTRAINT [PK_Cuestionario_gestion_empleado] PRIMARY KEY CLUSTERED 
(
	[Cuestionario_gestion_empleado_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cuestionario_respuestas]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cuestionario_respuestas](
	[Respuesta_id] [int] IDENTITY(1,1) NOT NULL,
	[Cuestionario_evalua_id] [int] NULL,
	[Pregunta_id] [int] NULL,
	[Nota] [int] NULL,
 CONSTRAINT [PK_Cuestionario_respuestas] PRIMARY KEY CLUSTERED 
(
	[Respuesta_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Departamento]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Departamento](
	[Departamento_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](100) NULL,
	[Estado] [int] NULL,
	[Fecha_creacion] [date] NULL,
	[Departamento_id_aux] [int] NULL,
	[Area_id] [int] NULL,
 CONSTRAINT [PK_Departamento] PRIMARY KEY CLUSTERED 
(
	[Departamento_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Empleado]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Empleado](
	[Empleado_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](50) NULL,
	[Apellido_paterno] [nvarchar](50) NULL,
	[Apellido_materno] [nvarchar](50) NULL,
	[email] [nvarchar](100) NULL,
	[Fecha_nacimiento] [date] NULL,
	[Telefono] [nvarchar](30) NULL,
	[Fecha_creacion] [date] NULL,
	[Estado] [int] NULL,
	[Estado_civil_id] [int] NOT NULL,
	[Pais_id] [char](3) NOT NULL,
	[Foto] [nvarchar](50) NULL,
	[Codigo_SisAcad] [nvarchar](25) NULL,
 CONSTRAINT [PK2] PRIMARY KEY NONCLUSTERED 
(
	[Empleado_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Empleado_cargo]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Empleado_cargo](
	[Empleado_id] [int] NULL,
	[Departamento_id] [int] NULL,
	[Nivel_id] [int] NULL,
	[Cargo] [nvarchar](150) NULL,
	[Fecha_inicio] [date] NULL,
	[Fecha_fin] [date] NULL,
	[Activo] [int] NULL,
	[Fecha_creacion] [date] NULL,
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Cargo_id] [int] NULL,
 CONSTRAINT [PK_Empleado_cargo] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Empleado_docente]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Empleado_docente](
	[Empleado_docente_id] [int] IDENTITY(1,1) NOT NULL,
	[Empleado_id] [int] NULL,
	[Gestion] [nvarchar](70) NULL,
	[Unidad_academica_id] [int] NULL,
	[Fecha_creacion] [datetime] NULL,
	[Usuario_crea] [int] NULL,
	[Fecha_Actualiza] [datetime] NULL,
	[Usuario_actualiza] [int] NULL,
	[Estado] [int] NULL,
	[Codigo_uab] [nvarchar](20) NULL,
 CONSTRAINT [PK_Empleado_docente] PRIMARY KEY CLUSTERED 
(
	[Empleado_docente_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Estado_civil]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Estado_civil](
	[Estado_civil_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](20) NULL,
	[Estado] [int] NULL,
 CONSTRAINT [PK3] PRIMARY KEY NONCLUSTERED 
(
	[Estado_civil_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Evento]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Evento](
	[Evento_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre_evento] [nvarchar](200) NULL,
	[Fecha_creacion] [date] NULL,
	[Fecha_actualizacion] [date] NULL,
	[Empleado_id] [int] NULL,
	[Fecha_inicio] [date] NULL,
	[Fecha_fin] [date] NULL,
	[Estado] [int] NULL,
	[Detalle] [nvarchar](500) NULL,
 CONSTRAINT [PK_Evento] PRIMARY KEY CLUSTERED 
(
	[Evento_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Evento_Actividad]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Evento_Actividad](
	[Evento_Actividad_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre_actividad] [nvarchar](200) NULL,
	[Fecha_creacion] [date] NULL,
	[Fecha_actualizacion] [date] NULL,
	[Empleado_id] [int] NULL,
	[Descripcion] [nvarchar](500) NULL,
	[Fecha_inicio_actividad] [datetime] NULL,
	[Fecha_fin_actividad] [datetime] NULL,
	[Estado] [int] NULL,
	[Evento_id] [int] NULL,
 CONSTRAINT [PK_Evento_Actividad] PRIMARY KEY CLUSTERED 
(
	[Evento_Actividad_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Evento_actividad_participantes]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Evento_actividad_participantes](
	[Evento_Actividad_id] [int] NULL,
	[Empleado_id] [int] NULL,
	[fecha_registro] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Evento_participante_ganador]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Evento_participante_ganador](
	[Empleado_id] [int] NULL,
	[Evento_id] [nchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Evento_participantes]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Evento_participantes](
	[Evento_participate_id] [int] IDENTITY(1,1) NOT NULL,
	[Empleado_id] [int] NULL,
	[Evento_id] [int] NULL,
	[Estado] [int] NULL,
	[Registra_personal_id] [int] NULL,
	[Fecha_registro] [datetime] NULL,
 CONSTRAINT [PK_Evento_participantes] PRIMARY KEY CLUSTERED 
(
	[Evento_participate_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Feedback]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Feedback](
	[Feedback_id] [int] IDENTITY(1,1) NOT NULL,
	[Motivo] [nvarchar](250) NULL,
	[Descripcion] [nvarchar](4000) NULL,
	[Feedback_tipo_id] [int] NULL,
	[Fecha_creacion] [date] NULL,
	[Estado] [int] NULL,
	[Empleado_id] [int] NULL,
	[Admin_id] [int] NULL,
	[Fecha_actualiza] [date] NULL,
	[Admin_actualiza] [int] NULL,
	[Fecha_advertencia] [date] NULL,
 CONSTRAINT [PK_Feedback] PRIMARY KEY CLUSTERED 
(
	[Feedback_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Feedback_tipo]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Feedback_tipo](
	[Feedback_tipo_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](50) NULL,
	[Estado] [int] NOT NULL,
 CONSTRAINT [PK_Feedback_tipo] PRIMARY KEY CLUSTERED 
(
	[Feedback_tipo_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Log]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Log](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Empleado_id] [int] NULL,
	[Ip] [nvarchar](20) NULL,
	[Mac] [nvarchar](20) NULL,
	[Dato_navegador] [nvarchar](150) NULL,
	[Nombre_navegador] [nvarchar](50) NULL,
	[SistemaOperativo] [nvarchar](50) NULL,
	[URL] [nvarchar](250) NULL,
	[Hora] [datetime] NULL,
	[Accion] [nvarchar](250) NULL,
	[Usuario] [nvarchar](50) NULL,
 CONSTRAINT [PK_Log] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Menu]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Menu](
	[Menu_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](100) NULL,
	[Url] [nvarchar](200) NULL,
	[Estado] [int] NULL,
	[Posicion] [int] NULL,
	[Icono] [nvarchar](50) NULL,
 CONSTRAINT [PK6] PRIMARY KEY NONCLUSTERED 
(
	[Menu_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Nivel]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Nivel](
	[Nivel_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](50) NULL,
	[Estado] [int] NULL,
	[Fecha_creacion] [date] NULL,
	[Posicion] [int] NULL,
 CONSTRAINT [PK_Nivel] PRIMARY KEY CLUSTERED 
(
	[Nivel_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Opcion]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Opcion](
	[Opcion_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](100) NULL,
	[Url] [nvarchar](200) NULL,
	[Descriocion] [nvarchar](200) NULL,
	[Estado] [int] NULL,
	[Orden] [int] NULL,
	[Menu_id] [int] NOT NULL,
 CONSTRAINT [PK7] PRIMARY KEY NONCLUSTERED 
(
	[Opcion_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pais]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pais](
	[Pais_id] [char](3) NOT NULL,
	[PaisNombre] [char](100) NULL,
	[PaisContinente] [varchar](50) NULL,
	[PaisRegion] [varchar](30) NULL,
	[PaisArea] [float] NULL,
	[PaisPoblacion] [int] NULL,
	[PaisExpectativaDeVida] [float] NULL,
	[PaisProductoInternoBruto] [float] NULL,
	[PaisProductoInternoBrutoAntiguo] [float] NULL,
	[PaisNombreLocal] [varchar](100) NULL,
	[PaisGobierno] [varchar](100) NULL,
	[PaisJefeDeEstado] [varchar](60) NULL,
	[PaisCapital] [int] NULL,
	[PaisCodigo2] [char](2) NULL,
 CONSTRAINT [PK4] PRIMARY KEY NONCLUSTERED 
(
	[Pais_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Plan_accion]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Plan_accion](
	[Plan_accion_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](500) NULL,
	[Contexto] [nvarchar](500) NULL,
	[Fecha_creacion] [datetime] NULL,
	[Empleado_id] [int] NULL,
	[Fecha_actualizacion] [datetime] NULL,
	[Empleado_actualiza] [int] NULL,
	[Estado] [int] NULL,
	[Plan_subobjetivo_id] [int] NULL,
	[Criterio] [nvarchar](150) NULL,
 CONSTRAINT [PK_Plan_accion] PRIMARY KEY CLUSTERED 
(
	[Plan_accion_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Plan_accion_files]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Plan_accion_files](
	[Plan_accion_files_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](500) NULL,
	[Nombre_archivo] [nvarchar](500) NULL,
	[Fecha_subido] [datetime] NULL,
	[Estado] [int] NULL,
	[Empleado_id] [int] NULL,
	[Fecha_actualiza] [datetime] NULL,
	[Empleado_actualiza] [int] NULL,
	[Plan_accion_id] [int] NULL,
 CONSTRAINT [PK_Plan_accion_files] PRIMARY KEY CLUSTERED 
(
	[Plan_accion_files_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Plan_estado]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Plan_estado](
	[Plan_estado_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](50) NULL,
	[Estado] [int] NULL,
	[Posicion] [int] NULL,
 CONSTRAINT [PK_Plan_estado] PRIMARY KEY CLUSTERED 
(
	[Plan_estado_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Plan_indica_resultado]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Plan_indica_resultado](
	[Plan_indica_resultado_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](150) NULL,
	[Fecha] [date] NULL,
	[Empleado_id] [int] NULL,
	[Fecha_creacion] [datetime] NULL,
	[Fecha_actualiza] [datetime] NULL,
	[Estado] [int] NULL,
	[Empleado_actualiza] [int] NULL,
	[Plan_matriz_id] [int] NULL,
	[Plan_estado_id] [int] NULL,
 CONSTRAINT [PK_Plan_indica_resultado] PRIMARY KEY CLUSTERED 
(
	[Plan_indica_resultado_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Plan_matriz]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Plan_matriz](
	[Plan_matriz_id] [int] IDENTITY(1,1) NOT NULL,
	[Que_hacer] [ntext] NULL,
	[Responsable] [nvarchar](500) NULL,
	[Como] [ntext] NULL,
	[Documento_generadi] [nvarchar](500) NULL,
	[Indicadores_resultado] [nvarchar](500) NULL,
	[Fecha] [date] NULL,
	[Indicador] [nvarchar](150) NULL,
	[Plan_accion_id] [int] NULL,
	[Fecha_cracion] [datetime] NULL,
	[Empleado_id] [int] NULL,
	[Fecha_actualizacion] [datetime] NULL,
	[Empleado_actualiza] [int] NULL,
	[Estado] [int] NULL,
	[Presupuesto] [money] NULL,
 CONSTRAINT [PK_Plan_matriz] PRIMARY KEY CLUSTERED 
(
	[Plan_matriz_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Plan_objetivo]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Plan_objetivo](
	[Plan_objetivo_id] [int] IDENTITY(1,1) NOT NULL,
	[Titulo] [nvarchar](250) NULL,
	[Creditacion] [nvarchar](2000) NULL,
	[Gestion] [int] NULL,
	[Empleado_id] [int] NULL,
	[Fecha_creacion] [datetime] NULL,
	[Fecha_actualizacion] [datetime] NULL,
	[Empleado_actualiza] [int] NULL,
	[Estado] [int] NULL,
 CONSTRAINT [PK_Plan_objetivo] PRIMARY KEY CLUSTERED 
(
	[Plan_objetivo_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Plan_subobjetivo]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Plan_subobjetivo](
	[Plan_subobjetivo_id] [int] IDENTITY(1,1) NOT NULL,
	[Plan_objetivo_id] [int] NULL,
	[Titulo] [nvarchar](500) NULL,
	[Descripcion] [ntext] NULL,
	[Empleado_id] [int] NULL,
	[Fecha_creacion] [datetime] NULL,
	[Fecha_actualizacion] [datetime] NULL,
	[Empleado_actualiza] [int] NULL,
	[Estado] [int] NULL,
 CONSTRAINT [PK_Plan_subobjetivo] PRIMARY KEY CLUSTERED 
(
	[Plan_subobjetivo_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pregunta]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pregunta](
	[Pregunta_id] [int] IDENTITY(1,1) NOT NULL,
	[Cuestionario_id] [int] NULL,
	[Nombre] [nvarchar](350) NULL,
	[Estado] [int] NULL,
	[Orden] [int] NULL,
	[Fecha_creacion] [date] NULL,
	[Usuario_crea] [int] NULL,
	[Fecha_actualiza] [date] NULL,
	[Usuario_actualiza] [int] NULL,
	[Tipo_id] [int] NULL,
 CONSTRAINT [PK_Pregunta] PRIMARY KEY CLUSTERED 
(
	[Pregunta_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pregunta_opcion]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pregunta_opcion](
	[Pregunta_opcion_id] [int] IDENTITY(1,1) NOT NULL,
	[Opcion] [nvarchar](50) NULL,
	[Css] [nvarchar](50) NULL,
	[Seccion] [nvarchar](50) NULL,
	[Pregunta_id] [int] NULL,
 CONSTRAINT [PK_Pregunta_opcion] PRIMARY KEY CLUSTERED 
(
	[Pregunta_opcion_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sector_Cuestionario]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sector_Cuestionario](
	[SectorEncuesta_id] [int] IDENTITY(1,1) NOT NULL,
	[Cuestionario_id] [int] NULL,
	[Area_id] [int] NULL,
	[Sector] [nvarchar](15) NULL,
	[Fecha_creacion] [date] NULL,
 CONSTRAINT [PK_Sector_Encuesta] PRIMARY KEY CLUSTERED 
(
	[SectorEncuesta_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tipo]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tipo](
	[Tipo_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](50) NULL,
	[Html] [nvarchar](50) NULL,
	[Estado] [int] NULL,
 CONSTRAINT [PK_Tipo] PRIMARY KEY CLUSTERED 
(
	[Tipo_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tipo_cliente]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tipo_cliente](
	[Tipo_cliente_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](50) NULL,
	[Estado] [int] NULL,
 CONSTRAINT [PK_Tipo_cliente] PRIMARY KEY CLUSTERED 
(
	[Tipo_cliente_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Uni_acad_area_pre]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Uni_acad_area_pre](
	[Uni_acad_area_pre_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](100) NULL,
	[Estado] [int] NULL,
	[Gestion] [nvarchar](7) NULL,
	[Unidad_academica_id] [int] NULL,
	[Puntuacion] [int] NULL,
	[Promediar] [int] NULL,
 CONSTRAINT [PK_Uni_acad_area_pre] PRIMARY KEY CLUSTERED 
(
	[Uni_acad_area_pre_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Uni_acad_emple_res]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Uni_acad_emple_res](
	[Uni_acad_emple_res] [int] IDENTITY(1,1) NOT NULL,
	[Empleado_docente_id] [int] NULL,
	[Uni_acad_pre] [int] NULL,
	[Puntuacion] [float] NULL,
 CONSTRAINT [PK_Uni_acad_emple_res] PRIMARY KEY CLUSTERED 
(
	[Uni_acad_emple_res] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Uni_acad_pre]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Uni_acad_pre](
	[Uni_acad_pre] [int] IDENTITY(1,1) NOT NULL,
	[Pregunta] [nvarchar](150) NULL,
	[Estado] [int] NULL,
	[Orden] [int] NULL,
	[Uni_acad_area_pre_id] [int] NULL,
	[Nom_bd] [nvarchar](50) NULL,
 CONSTRAINT [PK_Uni_acad_pre] PRIMARY KEY CLUSTERED 
(
	[Uni_acad_pre] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Unidad_academica]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Unidad_academica](
	[Unidad_academica_id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](150) NULL,
	[Descripcion] [nvarchar](150) NULL,
	[Abreviatura] [nvarchar](20) NULL,
	[Estado] [int] NULL,
 CONSTRAINT [PK_Unidad_academica] PRIMARY KEY CLUSTERED 
(
	[Unidad_academica_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuario](
	[User_id] [int] IDENTITY(1,1) NOT NULL,
	[Usuario] [nvarchar](100) NULL,
	[Contrasena] [nvarchar](10) NULL,
	[email] [nvarchar](100) NULL,
	[Fecha_creacion] [date] NULL,
	[Estado] [int] NULL,
	[Empleado_id] [int] NOT NULL,
	[Perfil] [nvarchar](100) NULL,
 CONSTRAINT [PK1] PRIMARY KEY NONCLUSTERED 
(
	[User_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuario_opcion]    Script Date: 04/03/2020 10:51:09 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuario_opcion](
	[Fecha_creacion] [char](10) NULL,
	[User_id] [int] NOT NULL,
	[Opcion_id] [int] NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[APathProcedimiento]  WITH CHECK ADD  CONSTRAINT [FK_APathProcedimiento_AProcedimientoTarea] FOREIGN KEY([idProcedimiento])
REFERENCES [dbo].[AProcedimientoTarea] ([idProcedimiento])
GO
ALTER TABLE [dbo].[APathProcedimiento] CHECK CONSTRAINT [FK_APathProcedimiento_AProcedimientoTarea]
GO
ALTER TABLE [dbo].[AProcedimientoTarea]  WITH CHECK ADD  CONSTRAINT [FK_AProcedimientoTarea_ATarea] FOREIGN KEY([idTarea])
REFERENCES [dbo].[ATarea] ([idTarea])
GO
ALTER TABLE [dbo].[AProcedimientoTarea] CHECK CONSTRAINT [FK_AProcedimientoTarea_ATarea]
GO
ALTER TABLE [dbo].[ATarea]  WITH CHECK ADD  CONSTRAINT [FK_ATarea_AEstadoTarea] FOREIGN KEY([idEstadoTarea])
REFERENCES [dbo].[AEstadoTarea] ([idEstadoTarea])
GO
ALTER TABLE [dbo].[ATarea] CHECK CONSTRAINT [FK_ATarea_AEstadoTarea]
GO
ALTER TABLE [dbo].[ATarea]  WITH CHECK ADD  CONSTRAINT [FK_ATarea_ARepeticionTarea] FOREIGN KEY([idRepeticionTarea])
REFERENCES [dbo].[ARepeticionTarea] ([idRepeticionTarea])
GO
ALTER TABLE [dbo].[ATarea] CHECK CONSTRAINT [FK_ATarea_ARepeticionTarea]
GO
ALTER TABLE [dbo].[ATarea]  WITH CHECK ADD  CONSTRAINT [FK_ATarea_ATipoTarea] FOREIGN KEY([idTipoTarea])
REFERENCES [dbo].[ATipoTarea] ([idTipoTarea])
GO
ALTER TABLE [dbo].[ATarea] CHECK CONSTRAINT [FK_ATarea_ATipoTarea]
GO
ALTER TABLE [dbo].[CEmpleado_Reserva]  WITH CHECK ADD  CONSTRAINT [FK_CEmpleado_Reserva_CTipoComensal] FOREIGN KEY([IdTipoComensal])
REFERENCES [dbo].[CTipoComensal] ([Id])
GO
ALTER TABLE [dbo].[CEmpleado_Reserva] CHECK CONSTRAINT [FK_CEmpleado_Reserva_CTipoComensal]
GO
ALTER TABLE [dbo].[CEmpleado_Reserva]  WITH CHECK ADD  CONSTRAINT [FK_CEmpleado_Reserva_CTipoComida] FOREIGN KEY([IdTipoComida])
REFERENCES [dbo].[CTipoComida] ([IdTipoComida])
GO
ALTER TABLE [dbo].[CEmpleado_Reserva] CHECK CONSTRAINT [FK_CEmpleado_Reserva_CTipoComida]
GO
ALTER TABLE [dbo].[CEmpleado_Reserva]  WITH CHECK ADD  CONSTRAINT [FK_CEmpleado_Reserva_Empleado] FOREIGN KEY([IdEmpleado])
REFERENCES [dbo].[Empleado] ([Empleado_id])
GO
ALTER TABLE [dbo].[CEmpleado_Reserva] CHECK CONSTRAINT [FK_CEmpleado_Reserva_Empleado]
GO
ALTER TABLE [dbo].[Ciudad]  WITH CHECK ADD  CONSTRAINT [RefPais1] FOREIGN KEY([Pais_id])
REFERENCES [dbo].[Pais] ([Pais_id])
GO
ALTER TABLE [dbo].[Ciudad] CHECK CONSTRAINT [RefPais1]
GO
ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD  CONSTRAINT [FK_Cliente_Tipo_cliente] FOREIGN KEY([Tipo_cliente_id])
REFERENCES [dbo].[Tipo_cliente] ([Tipo_cliente_id])
GO
ALTER TABLE [dbo].[Cliente] CHECK CONSTRAINT [FK_Cliente_Tipo_cliente]
GO
ALTER TABLE [dbo].[CReservaExterno]  WITH CHECK ADD  CONSTRAINT [FK_CReservaExterno_CComensalExterno] FOREIGN KEY([IdComensalExterno])
REFERENCES [dbo].[CComensalExterno] ([idComensalExterno])
GO
ALTER TABLE [dbo].[CReservaExterno] CHECK CONSTRAINT [FK_CReservaExterno_CComensalExterno]
GO
ALTER TABLE [dbo].[CReservaExterno]  WITH CHECK ADD  CONSTRAINT [FK_CReservaExterno_CTipoComensal] FOREIGN KEY([IdTipoComensal])
REFERENCES [dbo].[CTipoComensal] ([Id])
GO
ALTER TABLE [dbo].[CReservaExterno] CHECK CONSTRAINT [FK_CReservaExterno_CTipoComensal]
GO
ALTER TABLE [dbo].[CReservaExterno]  WITH CHECK ADD  CONSTRAINT [FK_CReservaExterno_CTipoComida] FOREIGN KEY([IdTipoComida])
REFERENCES [dbo].[CTipoComida] ([IdTipoComida])
GO
ALTER TABLE [dbo].[CReservaExterno] CHECK CONSTRAINT [FK_CReservaExterno_CTipoComida]
GO
ALTER TABLE [dbo].[Cuestioario_evalua]  WITH CHECK ADD  CONSTRAINT [FK_Cuestioario_evalua_Cuestionario] FOREIGN KEY([Cuestionario_id])
REFERENCES [dbo].[Cuestionario] ([Cuestionario_id])
GO
ALTER TABLE [dbo].[Cuestioario_evalua] CHECK CONSTRAINT [FK_Cuestioario_evalua_Cuestionario]
GO
ALTER TABLE [dbo].[Cuestioario_evalua]  WITH CHECK ADD  CONSTRAINT [FK_Cuestioario_evalua_Cuestionario_gestion] FOREIGN KEY([Cuestionario_gestion_id])
REFERENCES [dbo].[Cuestionario_gestion] ([Cuestionario_gestion_id])
GO
ALTER TABLE [dbo].[Cuestioario_evalua] CHECK CONSTRAINT [FK_Cuestioario_evalua_Cuestionario_gestion]
GO
ALTER TABLE [dbo].[Cuestionario_empleado]  WITH CHECK ADD  CONSTRAINT [FK_Cuestionario_empleado_Cuestionario] FOREIGN KEY([Cuestionario_id])
REFERENCES [dbo].[Cuestionario] ([Cuestionario_id])
GO
ALTER TABLE [dbo].[Cuestionario_empleado] CHECK CONSTRAINT [FK_Cuestionario_empleado_Cuestionario]
GO
ALTER TABLE [dbo].[Cuestionario_empleado]  WITH CHECK ADD  CONSTRAINT [FK_Cuestionario_empleado_Empleado] FOREIGN KEY([Empleado_id])
REFERENCES [dbo].[Empleado] ([Empleado_id])
GO
ALTER TABLE [dbo].[Cuestionario_empleado] CHECK CONSTRAINT [FK_Cuestionario_empleado_Empleado]
GO
ALTER TABLE [dbo].[Cuestionario_gestion_empleado]  WITH CHECK ADD  CONSTRAINT [FK_Cuestionario_gestion_empleado_Cuestionario_gestion] FOREIGN KEY([Cuestionario_gestion_id])
REFERENCES [dbo].[Cuestionario_gestion] ([Cuestionario_gestion_id])
GO
ALTER TABLE [dbo].[Cuestionario_gestion_empleado] CHECK CONSTRAINT [FK_Cuestionario_gestion_empleado_Cuestionario_gestion]
GO
ALTER TABLE [dbo].[Cuestionario_gestion_empleado]  WITH CHECK ADD  CONSTRAINT [FK_Cuestionario_gestion_empleado_Empleado] FOREIGN KEY([Empleado_id])
REFERENCES [dbo].[Empleado] ([Empleado_id])
GO
ALTER TABLE [dbo].[Cuestionario_gestion_empleado] CHECK CONSTRAINT [FK_Cuestionario_gestion_empleado_Empleado]
GO
ALTER TABLE [dbo].[Cuestionario_respuestas]  WITH CHECK ADD  CONSTRAINT [FK_Cuestionario_respuestas_Cuestioario_evalua] FOREIGN KEY([Cuestionario_evalua_id])
REFERENCES [dbo].[Cuestioario_evalua] ([Cuestionario_evalua_id])
GO
ALTER TABLE [dbo].[Cuestionario_respuestas] CHECK CONSTRAINT [FK_Cuestionario_respuestas_Cuestioario_evalua]
GO
ALTER TABLE [dbo].[Cuestionario_respuestas]  WITH CHECK ADD  CONSTRAINT [FK_Cuestionario_respuestas_Pregunta] FOREIGN KEY([Pregunta_id])
REFERENCES [dbo].[Pregunta] ([Pregunta_id])
GO
ALTER TABLE [dbo].[Cuestionario_respuestas] CHECK CONSTRAINT [FK_Cuestionario_respuestas_Pregunta]
GO
ALTER TABLE [dbo].[Departamento]  WITH CHECK ADD  CONSTRAINT [FK_Departamento_Area] FOREIGN KEY([Area_id])
REFERENCES [dbo].[Area] ([Area_id])
GO
ALTER TABLE [dbo].[Departamento] CHECK CONSTRAINT [FK_Departamento_Area]
GO
ALTER TABLE [dbo].[Departamento]  WITH CHECK ADD  CONSTRAINT [FK_Departamento_Departamento] FOREIGN KEY([Departamento_id_aux])
REFERENCES [dbo].[Departamento] ([Departamento_id])
GO
ALTER TABLE [dbo].[Departamento] CHECK CONSTRAINT [FK_Departamento_Departamento]
GO
ALTER TABLE [dbo].[Empleado]  WITH CHECK ADD  CONSTRAINT [RefEstado_civil2] FOREIGN KEY([Estado_civil_id])
REFERENCES [dbo].[Estado_civil] ([Estado_civil_id])
GO
ALTER TABLE [dbo].[Empleado] CHECK CONSTRAINT [RefEstado_civil2]
GO
ALTER TABLE [dbo].[Empleado]  WITH CHECK ADD  CONSTRAINT [RefPais3] FOREIGN KEY([Pais_id])
REFERENCES [dbo].[Pais] ([Pais_id])
GO
ALTER TABLE [dbo].[Empleado] CHECK CONSTRAINT [RefPais3]
GO
ALTER TABLE [dbo].[Empleado_cargo]  WITH CHECK ADD  CONSTRAINT [FK_Empleado_cargo_Cargo] FOREIGN KEY([Cargo_id])
REFERENCES [dbo].[Cargo] ([Cargo_id])
GO
ALTER TABLE [dbo].[Empleado_cargo] CHECK CONSTRAINT [FK_Empleado_cargo_Cargo]
GO
ALTER TABLE [dbo].[Empleado_cargo]  WITH CHECK ADD  CONSTRAINT [FK_Empleado_cargo_Departamento] FOREIGN KEY([Departamento_id])
REFERENCES [dbo].[Departamento] ([Departamento_id])
GO
ALTER TABLE [dbo].[Empleado_cargo] CHECK CONSTRAINT [FK_Empleado_cargo_Departamento]
GO
ALTER TABLE [dbo].[Empleado_cargo]  WITH CHECK ADD  CONSTRAINT [FK_Empleado_cargo_Empleado] FOREIGN KEY([Empleado_id])
REFERENCES [dbo].[Empleado] ([Empleado_id])
GO
ALTER TABLE [dbo].[Empleado_cargo] CHECK CONSTRAINT [FK_Empleado_cargo_Empleado]
GO
ALTER TABLE [dbo].[Empleado_cargo]  WITH CHECK ADD  CONSTRAINT [FK_Empleado_cargo_Nivel] FOREIGN KEY([Nivel_id])
REFERENCES [dbo].[Nivel] ([Nivel_id])
GO
ALTER TABLE [dbo].[Empleado_cargo] CHECK CONSTRAINT [FK_Empleado_cargo_Nivel]
GO
ALTER TABLE [dbo].[Empleado_docente]  WITH CHECK ADD  CONSTRAINT [FK_Empleado_docente_Empleado] FOREIGN KEY([Empleado_id])
REFERENCES [dbo].[Empleado] ([Empleado_id])
GO
ALTER TABLE [dbo].[Empleado_docente] CHECK CONSTRAINT [FK_Empleado_docente_Empleado]
GO
ALTER TABLE [dbo].[Empleado_docente]  WITH CHECK ADD  CONSTRAINT [FK_Empleado_docente_Unidad_academica] FOREIGN KEY([Unidad_academica_id])
REFERENCES [dbo].[Unidad_academica] ([Unidad_academica_id])
GO
ALTER TABLE [dbo].[Empleado_docente] CHECK CONSTRAINT [FK_Empleado_docente_Unidad_academica]
GO
ALTER TABLE [dbo].[Evento]  WITH CHECK ADD  CONSTRAINT [FK_Evento_Empleado] FOREIGN KEY([Empleado_id])
REFERENCES [dbo].[Empleado] ([Empleado_id])
GO
ALTER TABLE [dbo].[Evento] CHECK CONSTRAINT [FK_Evento_Empleado]
GO
ALTER TABLE [dbo].[Evento_Actividad]  WITH CHECK ADD  CONSTRAINT [FK_Evento_Actividad_Empleado] FOREIGN KEY([Empleado_id])
REFERENCES [dbo].[Empleado] ([Empleado_id])
GO
ALTER TABLE [dbo].[Evento_Actividad] CHECK CONSTRAINT [FK_Evento_Actividad_Empleado]
GO
ALTER TABLE [dbo].[Evento_Actividad]  WITH CHECK ADD  CONSTRAINT [FK_Evento_Actividad_Evento] FOREIGN KEY([Evento_id])
REFERENCES [dbo].[Evento] ([Evento_id])
GO
ALTER TABLE [dbo].[Evento_Actividad] CHECK CONSTRAINT [FK_Evento_Actividad_Evento]
GO
ALTER TABLE [dbo].[Evento_actividad_participantes]  WITH CHECK ADD  CONSTRAINT [FK_Evento_actividad_participantes_Empleado] FOREIGN KEY([Empleado_id])
REFERENCES [dbo].[Empleado] ([Empleado_id])
GO
ALTER TABLE [dbo].[Evento_actividad_participantes] CHECK CONSTRAINT [FK_Evento_actividad_participantes_Empleado]
GO
ALTER TABLE [dbo].[Evento_actividad_participantes]  WITH CHECK ADD  CONSTRAINT [FK_Evento_actividad_participantes_Evento_Actividad] FOREIGN KEY([Evento_Actividad_id])
REFERENCES [dbo].[Evento_Actividad] ([Evento_Actividad_id])
GO
ALTER TABLE [dbo].[Evento_actividad_participantes] CHECK CONSTRAINT [FK_Evento_actividad_participantes_Evento_Actividad]
GO
ALTER TABLE [dbo].[Evento_participantes]  WITH CHECK ADD  CONSTRAINT [FK_Evento_participantes_Empleado] FOREIGN KEY([Empleado_id])
REFERENCES [dbo].[Empleado] ([Empleado_id])
GO
ALTER TABLE [dbo].[Evento_participantes] CHECK CONSTRAINT [FK_Evento_participantes_Empleado]
GO
ALTER TABLE [dbo].[Evento_participantes]  WITH CHECK ADD  CONSTRAINT [FK_Evento_participantes_Evento] FOREIGN KEY([Evento_id])
REFERENCES [dbo].[Evento] ([Evento_id])
GO
ALTER TABLE [dbo].[Evento_participantes] CHECK CONSTRAINT [FK_Evento_participantes_Evento]
GO
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD  CONSTRAINT [FK_Feedback_Empleado] FOREIGN KEY([Empleado_id])
REFERENCES [dbo].[Empleado] ([Empleado_id])
GO
ALTER TABLE [dbo].[Feedback] CHECK CONSTRAINT [FK_Feedback_Empleado]
GO
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD  CONSTRAINT [FK_Feedback_Feedback_tipo] FOREIGN KEY([Feedback_tipo_id])
REFERENCES [dbo].[Feedback_tipo] ([Feedback_tipo_id])
GO
ALTER TABLE [dbo].[Feedback] CHECK CONSTRAINT [FK_Feedback_Feedback_tipo]
GO
ALTER TABLE [dbo].[Opcion]  WITH CHECK ADD  CONSTRAINT [RefMenu4] FOREIGN KEY([Menu_id])
REFERENCES [dbo].[Menu] ([Menu_id])
GO
ALTER TABLE [dbo].[Opcion] CHECK CONSTRAINT [RefMenu4]
GO
ALTER TABLE [dbo].[Plan_accion]  WITH CHECK ADD  CONSTRAINT [FK_Plan_accion_Empleado] FOREIGN KEY([Empleado_id])
REFERENCES [dbo].[Empleado] ([Empleado_id])
GO
ALTER TABLE [dbo].[Plan_accion] CHECK CONSTRAINT [FK_Plan_accion_Empleado]
GO
ALTER TABLE [dbo].[Plan_accion]  WITH CHECK ADD  CONSTRAINT [FK_Plan_accion_Plan_subobjetivo] FOREIGN KEY([Plan_subobjetivo_id])
REFERENCES [dbo].[Plan_subobjetivo] ([Plan_subobjetivo_id])
GO
ALTER TABLE [dbo].[Plan_accion] CHECK CONSTRAINT [FK_Plan_accion_Plan_subobjetivo]
GO
ALTER TABLE [dbo].[Plan_accion_files]  WITH CHECK ADD  CONSTRAINT [FK_Plan_accion_files_Empleado] FOREIGN KEY([Empleado_id])
REFERENCES [dbo].[Empleado] ([Empleado_id])
GO
ALTER TABLE [dbo].[Plan_accion_files] CHECK CONSTRAINT [FK_Plan_accion_files_Empleado]
GO
ALTER TABLE [dbo].[Plan_accion_files]  WITH CHECK ADD  CONSTRAINT [FK_Plan_accion_files_Plan_accion] FOREIGN KEY([Plan_accion_id])
REFERENCES [dbo].[Plan_accion] ([Plan_accion_id])
GO
ALTER TABLE [dbo].[Plan_accion_files] CHECK CONSTRAINT [FK_Plan_accion_files_Plan_accion]
GO
ALTER TABLE [dbo].[Plan_indica_resultado]  WITH CHECK ADD  CONSTRAINT [FK_Plan_indica_resultado_Plan_estado] FOREIGN KEY([Plan_estado_id])
REFERENCES [dbo].[Plan_estado] ([Plan_estado_id])
GO
ALTER TABLE [dbo].[Plan_indica_resultado] CHECK CONSTRAINT [FK_Plan_indica_resultado_Plan_estado]
GO
ALTER TABLE [dbo].[Plan_indica_resultado]  WITH CHECK ADD  CONSTRAINT [FK_Plan_indica_resultado_Plan_matriz] FOREIGN KEY([Plan_matriz_id])
REFERENCES [dbo].[Plan_matriz] ([Plan_matriz_id])
GO
ALTER TABLE [dbo].[Plan_indica_resultado] CHECK CONSTRAINT [FK_Plan_indica_resultado_Plan_matriz]
GO
ALTER TABLE [dbo].[Plan_matriz]  WITH CHECK ADD  CONSTRAINT [FK_Plan_matriz_Empleado] FOREIGN KEY([Empleado_id])
REFERENCES [dbo].[Empleado] ([Empleado_id])
GO
ALTER TABLE [dbo].[Plan_matriz] CHECK CONSTRAINT [FK_Plan_matriz_Empleado]
GO
ALTER TABLE [dbo].[Plan_matriz]  WITH CHECK ADD  CONSTRAINT [FK_Plan_matriz_Plan_accion] FOREIGN KEY([Plan_accion_id])
REFERENCES [dbo].[Plan_accion] ([Plan_accion_id])
GO
ALTER TABLE [dbo].[Plan_matriz] CHECK CONSTRAINT [FK_Plan_matriz_Plan_accion]
GO
ALTER TABLE [dbo].[Plan_objetivo]  WITH CHECK ADD  CONSTRAINT [FK_Plan_objetivo_Empleado] FOREIGN KEY([Empleado_id])
REFERENCES [dbo].[Empleado] ([Empleado_id])
GO
ALTER TABLE [dbo].[Plan_objetivo] CHECK CONSTRAINT [FK_Plan_objetivo_Empleado]
GO
ALTER TABLE [dbo].[Plan_subobjetivo]  WITH CHECK ADD  CONSTRAINT [FK_Plan_subobjetivo_Empleado] FOREIGN KEY([Empleado_id])
REFERENCES [dbo].[Empleado] ([Empleado_id])
GO
ALTER TABLE [dbo].[Plan_subobjetivo] CHECK CONSTRAINT [FK_Plan_subobjetivo_Empleado]
GO
ALTER TABLE [dbo].[Plan_subobjetivo]  WITH CHECK ADD  CONSTRAINT [FK_Plan_subobjetivo_Plan_objetivo] FOREIGN KEY([Plan_objetivo_id])
REFERENCES [dbo].[Plan_objetivo] ([Plan_objetivo_id])
GO
ALTER TABLE [dbo].[Plan_subobjetivo] CHECK CONSTRAINT [FK_Plan_subobjetivo_Plan_objetivo]
GO
ALTER TABLE [dbo].[Pregunta]  WITH CHECK ADD  CONSTRAINT [FK_Pregunta_Cuestionario] FOREIGN KEY([Cuestionario_id])
REFERENCES [dbo].[Cuestionario] ([Cuestionario_id])
GO
ALTER TABLE [dbo].[Pregunta] CHECK CONSTRAINT [FK_Pregunta_Cuestionario]
GO
ALTER TABLE [dbo].[Pregunta]  WITH CHECK ADD  CONSTRAINT [FK_Pregunta_Tipo] FOREIGN KEY([Tipo_id])
REFERENCES [dbo].[Tipo] ([Tipo_id])
GO
ALTER TABLE [dbo].[Pregunta] CHECK CONSTRAINT [FK_Pregunta_Tipo]
GO
ALTER TABLE [dbo].[Pregunta_opcion]  WITH CHECK ADD  CONSTRAINT [FK_Pregunta_opcion_Pregunta] FOREIGN KEY([Pregunta_id])
REFERENCES [dbo].[Pregunta] ([Pregunta_id])
GO
ALTER TABLE [dbo].[Pregunta_opcion] CHECK CONSTRAINT [FK_Pregunta_opcion_Pregunta]
GO
ALTER TABLE [dbo].[Sector_Cuestionario]  WITH CHECK ADD  CONSTRAINT [FK_Sector_Cuestionario_Cuestionario] FOREIGN KEY([Cuestionario_id])
REFERENCES [dbo].[Cuestionario] ([Cuestionario_id])
GO
ALTER TABLE [dbo].[Sector_Cuestionario] CHECK CONSTRAINT [FK_Sector_Cuestionario_Cuestionario]
GO
ALTER TABLE [dbo].[Uni_acad_area_pre]  WITH CHECK ADD  CONSTRAINT [FK_Uni_acad_area_pre_Unidad_academica] FOREIGN KEY([Unidad_academica_id])
REFERENCES [dbo].[Unidad_academica] ([Unidad_academica_id])
GO
ALTER TABLE [dbo].[Uni_acad_area_pre] CHECK CONSTRAINT [FK_Uni_acad_area_pre_Unidad_academica]
GO
ALTER TABLE [dbo].[Uni_acad_emple_res]  WITH CHECK ADD  CONSTRAINT [FK_Uni_acad_emple_res_Empleado_docente] FOREIGN KEY([Empleado_docente_id])
REFERENCES [dbo].[Empleado_docente] ([Empleado_docente_id])
GO
ALTER TABLE [dbo].[Uni_acad_emple_res] CHECK CONSTRAINT [FK_Uni_acad_emple_res_Empleado_docente]
GO
ALTER TABLE [dbo].[Uni_acad_emple_res]  WITH CHECK ADD  CONSTRAINT [FK_Uni_acad_emple_res_Uni_acad_pre1] FOREIGN KEY([Uni_acad_pre])
REFERENCES [dbo].[Uni_acad_pre] ([Uni_acad_pre])
GO
ALTER TABLE [dbo].[Uni_acad_emple_res] CHECK CONSTRAINT [FK_Uni_acad_emple_res_Uni_acad_pre1]
GO
ALTER TABLE [dbo].[Uni_acad_pre]  WITH CHECK ADD  CONSTRAINT [FK_Uni_acad_pre_Uni_acad_area_pre] FOREIGN KEY([Uni_acad_area_pre_id])
REFERENCES [dbo].[Uni_acad_area_pre] ([Uni_acad_area_pre_id])
GO
ALTER TABLE [dbo].[Uni_acad_pre] CHECK CONSTRAINT [FK_Uni_acad_pre_Uni_acad_area_pre]
GO
ALTER TABLE [dbo].[Usuario]  WITH CHECK ADD  CONSTRAINT [RefEmpleado7] FOREIGN KEY([Empleado_id])
REFERENCES [dbo].[Empleado] ([Empleado_id])
GO
ALTER TABLE [dbo].[Usuario] CHECK CONSTRAINT [RefEmpleado7]
GO
ALTER TABLE [dbo].[Usuario_opcion]  WITH CHECK ADD  CONSTRAINT [RefOpcion6] FOREIGN KEY([Opcion_id])
REFERENCES [dbo].[Opcion] ([Opcion_id])
GO
ALTER TABLE [dbo].[Usuario_opcion] CHECK CONSTRAINT [RefOpcion6]
GO
ALTER TABLE [dbo].[Usuario_opcion]  WITH CHECK ADD  CONSTRAINT [RefUsuario5] FOREIGN KEY([User_id])
REFERENCES [dbo].[Usuario] ([User_id])
GO
ALTER TABLE [dbo].[Usuario_opcion] CHECK CONSTRAINT [RefUsuario5]
GO
