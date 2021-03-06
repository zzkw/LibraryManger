USE [lib_book]
GO
/****** Object:  Table [dbo].[l_book]    Script Date: 2019/6/5 0:42:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[l_book](
	[id] [int] NOT NULL,
	[bookName] [varchar](255) NOT NULL,
	[author] [varchar](255) NULL,
	[press] [varchar](255) NULL,
	[version] [varchar](255) NULL,
	[price] [real] NULL,
	[booktypeId] [int] NOT NULL,
	[bookDesc] [varchar](255) NULL,
 CONSTRAINT [PK__l_book__3213E83F981366CF] PRIMARY KEY CLUSTERED 
(
	[bookName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[l_booktype]    Script Date: 2019/6/5 0:42:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[l_booktype](
	[id] [int] NOT NULL,
	[bookTypename] [varchar](255) NULL,
	[bookTypeDesc] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[l_borrow]    Script Date: 2019/6/5 0:42:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[l_borrow](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[bookname] [varchar](255) NOT NULL,
	[borrowname] [varchar](255) NULL,
	[phonenumber] [varchar](255) NULL,
 CONSTRAINT [PK_l_borrow_1] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[l_user]    Script Date: 2019/6/5 0:42:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[l_user](
	[id] [int] NOT NULL,
	[users] [varchar](255) NULL,
	[passwd] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[l_book] ([id], [bookName], [author], [press], [version], [price], [booktypeId], [bookDesc]) VALUES (2, N'Java网络程序设计', N'朱辉', N'西安电子科技大学出版社', N'第一版', 19.1, 1, N'怎样利用Java进行网络程序设计')
INSERT [dbo].[l_book] ([id], [bookName], [author], [press], [version], [price], [booktypeId], [bookDesc]) VALUES (1, N'think in java', N'Bruce Eckel', N'图灵出版社', N'第五版', 67.8, 1, N'编程技术')
INSERT [dbo].[l_book] ([id], [bookName], [author], [press], [version], [price], [booktypeId], [bookDesc]) VALUES (4, N'陌上花开', N'安意如', N'万卷出版公司', N'第二版', 21.8, 3, N'陌上花开可缓缓归~')
INSERT [dbo].[l_book] ([id], [bookName], [author], [press], [version], [price], [booktypeId], [bookDesc]) VALUES (3, N'三体', N'刘慈欣', N'重庆出版社', N'第三版', 69.21, 2, N'第73届雨果奖最佳长篇小说奖，贼好看')
INSERT [dbo].[l_booktype] ([id], [bookTypename], [bookTypeDesc]) VALUES (1, N'计算机类', N'计算机相关图书等')
INSERT [dbo].[l_booktype] ([id], [bookTypename], [bookTypeDesc]) VALUES (2, N'科幻类', N'全球科幻小说')
INSERT [dbo].[l_booktype] ([id], [bookTypename], [bookTypeDesc]) VALUES (3, N'散文类', N'著名散文选集')
SET IDENTITY_INSERT [dbo].[l_borrow] ON 

INSERT [dbo].[l_borrow] ([id], [bookname], [borrowname], [phonenumber]) VALUES (1, N'三体', N'张康', N'10724472321')
INSERT [dbo].[l_borrow] ([id], [bookname], [borrowname], [phonenumber]) VALUES (2, N'陌上花开', N'思诺', N'1357484621')
SET IDENTITY_INSERT [dbo].[l_borrow] OFF
INSERT [dbo].[l_user] ([id], [users], [passwd]) VALUES (1, N'admin', N'123456')
ALTER TABLE [dbo].[l_book]  WITH CHECK ADD  CONSTRAINT [l_book_ibfk_1] FOREIGN KEY([booktypeId])
REFERENCES [dbo].[l_booktype] ([id])
GO
ALTER TABLE [dbo].[l_book] CHECK CONSTRAINT [l_book_ibfk_1]
GO
ALTER TABLE [dbo].[l_borrow]  WITH CHECK ADD  CONSTRAINT [FK_l_borrow_l_book] FOREIGN KEY([bookname])
REFERENCES [dbo].[l_book] ([bookName])
GO
ALTER TABLE [dbo].[l_borrow] CHECK CONSTRAINT [FK_l_borrow_l_book]
GO
