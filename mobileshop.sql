USE [TestEcommerce]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 21/12/2022 10:00:48 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaChiTietHD] [int] IDENTITY(1,1) NOT NULL,
	[MaHoaDon] [int] NOT NULL,
	[MaDienThoai] [int] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[MaChiTietHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 21/12/2022 10:00:48 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKhachHang] [int] IDENTITY(1,1) NOT NULL,
	[TenKhachHang] [nvarchar](100) NOT NULL,
	[DiaChi] [nvarchar](100) NOT NULL,
	[SoDienThoai] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[TaiKhoan] [varchar](50) NOT NULL,
	[DaXoa] [bit] NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 21/12/2022 10:00:48 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[MaKhachHang] [int] NOT NULL,
	[NgayTao] [date] NOT NULL,
	[TrangThai] [bit] NOT NULL,
	[NgayHoanThanh] [date] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DienThoai]    Script Date: 21/12/2022 10:00:48 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DienThoai](
	[MaDienThoai] [int] IDENTITY(1,1) NOT NULL,
	[TenDienThoai] [nvarchar](50) NOT NULL,
	[MaHang] [nvarchar](50) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[Gia] [money] NOT NULL,
	[MoTa] [nvarchar](max) NULL,
	[NgayNhap] [date] NOT NULL,
	[Anh] [nvarchar](100) NOT NULL,
	[DaXoa] [bit] NOT NULL,
	[Ram] [int] NULL,
	[DungLuong] [int] NULL,
	[KichThuoc] [float] NULL,
 CONSTRAINT [PK_DienThoai] PRIMARY KEY CLUSTERED 
(
	[MaDienThoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  View [dbo].[V_ChiTiet]    Script Date: 21/12/2022 10:00:48 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[V_ChiTiet] as
select dt.MaDienThoai, dt.TenDienThoai, dt.Gia, ct.SoLuong, sum(dt.Gia * ct.SoLuong) as ThanhTien, hd.MaHoaDon
from KhachHang as kh join HoaDon as hd on kh.MaKhachHang = hd.MaKhachHang
					join ChiTietHoaDon as ct on hd.MaHoaDon = ct.MaHoaDon
					join DienThoai as dt on ct.MaDienThoai = dt.MaDienThoai
group by dt.MaDienThoai, dt.TenDienThoai, dt.Gia, ct.SoLuong, hd.MaHoaDon
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 21/12/2022 10:00:48 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[TaiKhoan] [varchar](50) NOT NULL,
	[MatKhau] [varchar](50) NOT NULL,
	[Quyen] [bit] NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[TaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[V_KhachHang]    Script Date: 21/12/2022 10:00:48 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[V_KhachHang] as 
select kh.MaKhachHang, kh.TenKhachHang, kh.DiaChi, kh.SoDienThoai, kh.Email, kh.TaiKhoan, tk.MatKhau
from KhachHang as kh
	inner join TaiKhoan as tk on kh.TaiKhoan = tk.TaiKhoan
where tk.Quyen = 0
GO
/****** Object:  View [dbo].[V_LichSuMuaHang]    Script Date: 21/12/2022 10:00:48 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_LichSuMuaHang]
AS
SELECT        dbo.DienThoai.TenDienThoai, dbo.ChiTietHoaDon.SoLuong, dbo.DienThoai.Gia, dbo.ChiTietHoaDon.SoLuong * dbo.DienThoai.Gia AS ThanhTien, dbo.HoaDon.NgayTao, dbo.HoaDon.MaKhachHang, dbo.HoaDon.TrangThai
FROM            dbo.ChiTietHoaDon INNER JOIN
                         dbo.DienThoai ON dbo.ChiTietHoaDon.MaDienThoai = dbo.DienThoai.MaDienThoai INNER JOIN
                         dbo.HoaDon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.HoaDon.MaHoaDon INNER JOIN
                         dbo.KhachHang ON dbo.HoaDon.MaKhachHang = dbo.KhachHang.MaKhachHang
GO
/****** Object:  View [dbo].[V_DonHang]    Script Date: 21/12/2022 10:00:48 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[V_DonHang] as
select hd.MaHoaDon, kh.TenKhachHang, hd.NgayTao, hd.TrangThai, sum(ct.SoLuong) as SoLuongMua, sum(dt.Gia * ct.SoLuong) as TongTien
from KhachHang as kh join HoaDon as hd on kh.MaKhachHang = hd.MaKhachHang
					join ChiTietHoaDon as ct on hd.MaHoaDon = ct.MaHoaDon
					join DienThoai as dt on ct.MaDienThoai = dt.MaDienThoai
group by  hd.MaHoaDon, kh.TenKhachHang, hd.NgayTao, hd.TrangThai
GO
/****** Object:  View [dbo].[V_DonHangChoDuyet]    Script Date: 21/12/2022 10:00:48 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[V_DonHangChoDuyet] as
select hd.MaHoaDon, kh.TenKhachHang, kh.SoDienThoai, hd.NgayTao, hd.TrangThai, sum(ct.SoLuong) as SoLuongMua, sum(dt.Gia * ct.SoLuong) as TongTien
from KhachHang as kh join HoaDon as hd on kh.MaKhachHang = hd.MaKhachHang
					join ChiTietHoaDon as ct on hd.MaHoaDon = ct.MaHoaDon
					join DienThoai as dt on ct.MaDienThoai = dt.MaDienThoai
group by  hd.MaHoaDon, kh.TenKhachHang, kh.SoDienThoai, hd.NgayTao, hd.TrangThai
GO
/****** Object:  Table [dbo].[Hang]    Script Date: 21/12/2022 10:00:48 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hang](
	[MaHang] [nvarchar](50) NOT NULL,
	[TenHang] [nvarchar](50) NOT NULL,
	[DaXoa] [bit] NOT NULL,
 CONSTRAINT [PK_Hang] PRIMARY KEY CLUSTERED 
(
	[MaHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] ON 

INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaHoaDon], [MaDienThoai], [SoLuong], [GhiChu]) VALUES (2, 2, 10, 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaHoaDon], [MaDienThoai], [SoLuong], [GhiChu]) VALUES (3, 3, 7, 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaHoaDon], [MaDienThoai], [SoLuong], [GhiChu]) VALUES (4, 4, 13, 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaHoaDon], [MaDienThoai], [SoLuong], [GhiChu]) VALUES (5, 4, 14, 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaHoaDon], [MaDienThoai], [SoLuong], [GhiChu]) VALUES (6, 5, 7, 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaHoaDon], [MaDienThoai], [SoLuong], [GhiChu]) VALUES (7, 6, 1, 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaHoaDon], [MaDienThoai], [SoLuong], [GhiChu]) VALUES (8, 7, 7, 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaHoaDon], [MaDienThoai], [SoLuong], [GhiChu]) VALUES (9, 7, 9, 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaHoaDon], [MaDienThoai], [SoLuong], [GhiChu]) VALUES (10, 8, 7, 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaHoaDon], [MaDienThoai], [SoLuong], [GhiChu]) VALUES (11, 9, 10, 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaHoaDon], [MaDienThoai], [SoLuong], [GhiChu]) VALUES (12, 9, 13, 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaHoaDon], [MaDienThoai], [SoLuong], [GhiChu]) VALUES (13, 10, 1, 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaHoaDon], [MaDienThoai], [SoLuong], [GhiChu]) VALUES (14, 11, 7, 3, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaHoaDon], [MaDienThoai], [SoLuong], [GhiChu]) VALUES (15, 11, 13, 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaHoaDon], [MaDienThoai], [SoLuong], [GhiChu]) VALUES (16, 12, 7, 1, NULL)
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[DienThoai] ON 

INSERT [dbo].[DienThoai] ([MaDienThoai], [TenDienThoai], [MaHang], [SoLuong], [Gia], [MoTa], [NgayNhap], [Anh], [DaXoa], [Ram], [DungLuong], [KichThuoc]) VALUES (1, N'SamSung A23', N'SS', 1000, 10000000.0000, N'', CAST(N'2022-09-18' AS Date), N'images/samsunga23.jpg', 0, 4, 128, 5.5999999046325684)
INSERT [dbo].[DienThoai] ([MaDienThoai], [TenDienThoai], [MaHang], [SoLuong], [Gia], [MoTa], [NgayNhap], [Anh], [DaXoa], [Ram], [DungLuong], [KichThuoc]) VALUES (7, N'SamSung A73', N'SS', 100, 15000000.0000, N'', CAST(N'2022-11-30' AS Date), N'images/samsunga73.jpg', 0, 6, 128, 6.1999998092651367)
INSERT [dbo].[DienThoai] ([MaDienThoai], [TenDienThoai], [MaHang], [SoLuong], [Gia], [MoTa], [NgayNhap], [Anh], [DaXoa], [Ram], [DungLuong], [KichThuoc]) VALUES (8, N'SamSung Note 10', N'SS', 100, 20000000.0000, N'', CAST(N'2022-12-04' AS Date), N'images/samsungnote10.jpg', 0, 8, 256, 6.1999998092651367)
INSERT [dbo].[DienThoai] ([MaDienThoai], [TenDienThoai], [MaHang], [SoLuong], [Gia], [MoTa], [NgayNhap], [Anh], [DaXoa], [Ram], [DungLuong], [KichThuoc]) VALUES (9, N'SamSung Note 10 Plus', N'SS', 100, 25000000.0000, N'', CAST(N'2022-12-06' AS Date), N'images/samsungnote10plus.jpg', 0, 10, 256, 6.5)
INSERT [dbo].[DienThoai] ([MaDienThoai], [TenDienThoai], [MaHang], [SoLuong], [Gia], [MoTa], [NgayNhap], [Anh], [DaXoa], [Ram], [DungLuong], [KichThuoc]) VALUES (10, N'Xoami Mi 11T', N'XM', 100, 15000000.0000, N'', CAST(N'2022-12-08' AS Date), N'images/mi11t.jpg', 0, 8, 128, 6.1999998092651367)
INSERT [dbo].[DienThoai] ([MaDienThoai], [TenDienThoai], [MaHang], [SoLuong], [Gia], [MoTa], [NgayNhap], [Anh], [DaXoa], [Ram], [DungLuong], [KichThuoc]) VALUES (11, N'Oppo Reno 6', N'OP', 100, 15000000.0000, N'', CAST(N'2022-12-12' AS Date), N'images/opporeno6.jpg', 0, 6, 128, 6.5)
INSERT [dbo].[DienThoai] ([MaDienThoai], [TenDienThoai], [MaHang], [SoLuong], [Gia], [MoTa], [NgayNhap], [Anh], [DaXoa], [Ram], [DungLuong], [KichThuoc]) VALUES (12, N'Oppo Reno 7', N'OP', 100, 17000000.0000, N'', CAST(N'2022-12-12' AS Date), N'images/opporeno7.jpg', 0, 8, 256, 6.5)
INSERT [dbo].[DienThoai] ([MaDienThoai], [TenDienThoai], [MaHang], [SoLuong], [Gia], [MoTa], [NgayNhap], [Anh], [DaXoa], [Ram], [DungLuong], [KichThuoc]) VALUES (13, N'Iphone 11', N'A', 100, 20000000.0000, N'', CAST(N'2022-12-12' AS Date), N'images/iphone11.jpg', 0, 4, 256, 6.7)
INSERT [dbo].[DienThoai] ([MaDienThoai], [TenDienThoai], [MaHang], [SoLuong], [Gia], [MoTa], [NgayNhap], [Anh], [DaXoa], [Ram], [DungLuong], [KichThuoc]) VALUES (14, N'Iphone 12', N'A', 100, 25000000.0000, N'', CAST(N'2022-12-10' AS Date), N'images/iphone12.jpg', 0, 4, 256, 6.6999998092651367)
SET IDENTITY_INSERT [dbo].[DienThoai] OFF
GO
INSERT [dbo].[Hang] ([MaHang], [TenHang], [DaXoa]) VALUES (N'A', N'Apple', 0)
INSERT [dbo].[Hang] ([MaHang], [TenHang], [DaXoa]) VALUES (N'OP', N'Oppo', 0)
INSERT [dbo].[Hang] ([MaHang], [TenHang], [DaXoa]) VALUES (N'SS', N'Samsung', 0)
INSERT [dbo].[Hang] ([MaHang], [TenHang], [DaXoa]) VALUES (N'XM', N'Xiaomi', 0)
GO
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [NgayTao], [TrangThai], [NgayHoanThanh]) VALUES (1, 1, CAST(N'2022-12-16' AS Date), 0, CAST(N'2022-12-16' AS Date))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [NgayTao], [TrangThai], [NgayHoanThanh]) VALUES (2, 1, CAST(N'2022-12-16' AS Date), 1, CAST(N'2022-12-16' AS Date))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [NgayTao], [TrangThai], [NgayHoanThanh]) VALUES (3, 1, CAST(N'2022-12-16' AS Date), 1, CAST(N'2022-12-16' AS Date))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [NgayTao], [TrangThai], [NgayHoanThanh]) VALUES (4, 3, CAST(N'2022-12-18' AS Date), 1, CAST(N'2022-12-18' AS Date))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [NgayTao], [TrangThai], [NgayHoanThanh]) VALUES (5, 1, CAST(N'2022-12-18' AS Date), 1, CAST(N'2022-12-18' AS Date))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [NgayTao], [TrangThai], [NgayHoanThanh]) VALUES (6, 1, CAST(N'2022-12-20' AS Date), 0, CAST(N'2022-12-20' AS Date))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [NgayTao], [TrangThai], [NgayHoanThanh]) VALUES (7, 1, CAST(N'2022-12-20' AS Date), 0, CAST(N'2022-12-20' AS Date))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [NgayTao], [TrangThai], [NgayHoanThanh]) VALUES (8, 6, CAST(N'2022-12-20' AS Date), 0, CAST(N'2022-12-20' AS Date))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [NgayTao], [TrangThai], [NgayHoanThanh]) VALUES (9, 6, CAST(N'2022-12-20' AS Date), 1, CAST(N'2022-12-20' AS Date))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [NgayTao], [TrangThai], [NgayHoanThanh]) VALUES (10, 7, CAST(N'2022-12-21' AS Date), 1, CAST(N'2022-12-21' AS Date))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [NgayTao], [TrangThai], [NgayHoanThanh]) VALUES (11, 7, CAST(N'2022-12-21' AS Date), 1, CAST(N'2022-12-21' AS Date))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [NgayTao], [TrangThai], [NgayHoanThanh]) VALUES (12, 8, CAST(N'2022-12-21' AS Date), 1, CAST(N'2022-12-21' AS Date))
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [DiaChi], [SoDienThoai], [Email], [TaiKhoan], [DaXoa]) VALUES (1, N'Khach Hang 1', N'Hue', N'23213', N'khachhang12gmail.com', N'khachhang1', 0)
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [DiaChi], [SoDienThoai], [Email], [TaiKhoan], [DaXoa]) VALUES (2, N'dsadsad', N'dsasad', N'321321', N'abc@gmail.com', N'abc@gmail.com', 0)
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [DiaChi], [SoDienThoai], [Email], [TaiKhoan], [DaXoa]) VALUES (3, N'Nguyễn Thiện Giao', N'Huế', N'321331321', N'giao@gmail.com', N'toilagiao', 0)
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [DiaChi], [SoDienThoai], [Email], [TaiKhoan], [DaXoa]) VALUES (4, N'Mobile', N'Hue', N'32132131', N'dsadada@gmail.com', N'mobile', 0)
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [DiaChi], [SoDienThoai], [Email], [TaiKhoan], [DaXoa]) VALUES (5, N'dad', N'dsad', N'da', N'sada', N'dasd', 0)
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [DiaChi], [SoDienThoai], [Email], [TaiKhoan], [DaXoa]) VALUES (6, N'Nguyễn Thiện Giao', N'Huế', N'321321', N'abc123@gmail.com', N'mobile1', 0)
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [DiaChi], [SoDienThoai], [Email], [TaiKhoan], [DaXoa]) VALUES (7, N'Nguyễn Thiện Giao', N'Huế', N'321321321', N'giao@gmail.com', N'thiengiao', 0)
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [DiaChi], [SoDienThoai], [Email], [TaiKhoan], [DaXoa]) VALUES (8, N'giao', N'hue', N'3213213', N'19t1021062@husc.edu.vn', N'giao1', 0)
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [Quyen]) VALUES (N'abc@gmail.com', N'dsada', 0)
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [Quyen]) VALUES (N'admin', N'123', 1)
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [Quyen]) VALUES (N'dasd', N'5ca2aa845c8cd5ace6b016841f100d82', 0)
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [Quyen]) VALUES (N'giao1', N'202cb962ac59075b964b07152d234b70', 0)
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [Quyen]) VALUES (N'giao123', N'123456', 1)
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [Quyen]) VALUES (N'khachhang1', N'12345', 0)
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [Quyen]) VALUES (N'lam123', N'123456', 1)
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [Quyen]) VALUES (N'mobile', N'202cb962ac59075b964b07152d234b70', 0)
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [Quyen]) VALUES (N'mobile1', N'202cb962ac59075b964b07152d234b70', 0)
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [Quyen]) VALUES (N'thiengiao', N'202cb962ac59075b964b07152d234b70', 0)
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [Quyen]) VALUES (N'toilagiao', N'123', 0)
GO
ALTER TABLE [dbo].[DienThoai] ADD  CONSTRAINT [DF_DienThoai_DaXoa]  DEFAULT ((0)) FOR [DaXoa]
GO
ALTER TABLE [dbo].[Hang] ADD  CONSTRAINT [DF_Hang_DaXoa]  DEFAULT ((0)) FOR [DaXoa]
GO
ALTER TABLE [dbo].[HoaDon] ADD  CONSTRAINT [DF_HoaDon_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[HoaDon] ADD  CONSTRAINT [DF_HoaDon_TrangThai]  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[HoaDon] ADD  CONSTRAINT [DF_HoaDon_NgayHoanThanh]  DEFAULT (getdate()) FOR [NgayHoanThanh]
GO
ALTER TABLE [dbo].[KhachHang] ADD  CONSTRAINT [DF_KhachHang_DaXoa]  DEFAULT ((0)) FOR [DaXoa]
GO
ALTER TABLE [dbo].[TaiKhoan] ADD  CONSTRAINT [DF_TaiKhoan_Quyen]  DEFAULT ((0)) FOR [Quyen]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_DienThoai] FOREIGN KEY([MaDienThoai])
REFERENCES [dbo].[DienThoai] ([MaDienThoai])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_DienThoai]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDon] ([MaHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[DienThoai]  WITH CHECK ADD  CONSTRAINT [FK_DienThoai_Hang] FOREIGN KEY([MaHang])
REFERENCES [dbo].[Hang] ([MaHang])
GO
ALTER TABLE [dbo].[DienThoai] CHECK CONSTRAINT [FK_DienThoai_Hang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKhachHang])
REFERENCES [dbo].[KhachHang] ([MaKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [FK_KhachHang_TaiKhoan] FOREIGN KEY([TaiKhoan])
REFERENCES [dbo].[TaiKhoan] ([TaiKhoan])
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [FK_KhachHang_TaiKhoan]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[44] 4[17] 2[14] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "ChiTietHoaDon"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 168
               Right = 208
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "DienThoai"
            Begin Extent = 
               Top = 6
               Left = 246
               Bottom = 290
               Right = 416
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "HoaDon"
            Begin Extent = 
               Top = 6
               Left = 454
               Bottom = 210
               Right = 633
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "KhachHang"
            Begin Extent = 
               Top = 6
               Left = 671
               Bottom = 214
               Right = 841
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1830
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      E' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'V_LichSuMuaHang'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane2', @value=N'nd
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'V_LichSuMuaHang'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=2 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'V_LichSuMuaHang'
GO
