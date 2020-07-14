-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th7 14, 2020 lúc 08:39 PM
-- Phiên bản máy phục vụ: 10.4.6-MariaDB
-- Phiên bản PHP: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `store`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account_customer`
--

CREATE TABLE `account_customer` (
  `ID` int(11) NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `account_customer`
--

INSERT INTO `account_customer` (`ID`, `username`, `password`) VALUES
(1, 'customer1', '123456'),
(2, 'customer2', '123456'),
(3, 'customer3', '123456');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account_employee`
--

CREATE TABLE `account_employee` (
  `ID` int(11) NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `account_employee`
--

INSERT INTO `account_employee` (`ID`, `username`, `password`, `phone`) VALUES
(1, 'employee1', '123456', NULL),
(2, 'employee2', '123456', NULL),
(3, 'admin1', '123456', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `address`
--

CREATE TABLE `address` (
  `ID` int(10) NOT NULL,
  `Province` varchar(255) DEFAULT NULL,
  `District` varchar(255) DEFAULT NULL,
  `Ward` varchar(255) DEFAULT NULL,
  `Street` varchar(255) DEFAULT NULL,
  `HomeNumber` varchar(255) DEFAULT NULL,
  `NameReceiver` varchar(255) DEFAULT NULL,
  `PhoneReceiver` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `address`
--

INSERT INTO `address` (`ID`, `Province`, `District`, `Ward`, `Street`, `HomeNumber`, `NameReceiver`, `PhoneReceiver`) VALUES
(1, 'Hồ Chí Minh', 'Quận 1', 'Phường Bến Thành', 'Tran Hung Dao', '18', 'Nguyễn Văn A', '0398984666'),
(2, 'Hồ Chí Minh', 'Quận 2', 'Phường An Phú', 'Binh Loc', '312', 'Nguyễn Văn A', '0398984666'),
(3, 'Ha Noi', 'Thanh Xuan', 'Thanh Xuan Nam', 'Nguyen Trai', '445', NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

CREATE TABLE `cart` (
  `ID` int(11) NOT NULL,
  `customerID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `cart`
--

INSERT INTO `cart` (`ID`, `customerID`) VALUES
(1, 1),
(2, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `ID` int(10) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `AccountID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`ID`, `Name`, `Email`, `Phone`, `AccountID`) VALUES
(1, 'Nguyễn Thị Phương', 'phuongnt@gmail.com', '0967356112', 1),
(2, 'Trần Đức Chuyên', 'chuyentd@gmail.com', '0398984666', 2),
(3, 'Nguyễn Thị Hồng Ngọc', 'ngocnth@gmail.com', '0989206132', 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customeraddress`
--

CREATE TABLE `customeraddress` (
  `ID` int(10) NOT NULL,
  `CustomerID` int(10) DEFAULT NULL,
  `AddressID` int(10) DEFAULT NULL,
  `isDefault` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `customeraddress`
--

INSERT INTO `customeraddress` (`ID`, `CustomerID`, `AddressID`, `isDefault`) VALUES
(1, 1, 1, 1),
(2, 1, 2, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `delivery`
--

CREATE TABLE `delivery` (
  `ID` int(10) NOT NULL,
  `OrderID` int(10) NOT NULL,
  `Method` int(10) DEFAULT NULL,
  `ReciverInfo` varchar(255) DEFAULT NULL,
  `AddressID` int(10) NOT NULL,
  `DeliveryMethodID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `deliverymethod`
--

CREATE TABLE `deliverymethod` (
  `ID` int(10) NOT NULL,
  `DeliveryName` varchar(255) DEFAULT NULL,
  `Note` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `detail`
--

CREATE TABLE `detail` (
  `ID` int(10) NOT NULL,
  `Provider` varchar(255) DEFAULT NULL,
  `Memory` varchar(255) DEFAULT NULL,
  `Model` varchar(255) DEFAULT NULL,
  `Color` varchar(255) DEFAULT NULL,
  `Image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `detail`
--

INSERT INTO `detail` (`ID`, `Provider`, `Memory`, `Model`, `Color`, `Image`) VALUES
(1, 'Xiaomi', '16', 'Xiaomi', 'Black', 'XRN7.jpg'),
(2, 'Xiaomi', '32', 'Xiaomi', 'White', 'XRN8.jpg'),
(3, 'Xiaomi', '64', 'Xiaomi', 'Yellow', 'XM09.jpg'),
(4, 'Xiaomi', '16', 'Xiaomi', 'Black', 'XRK20P.jpg'),
(5, 'Samsung', '32', 'Samsung', 'Black', 'SSN8.jpg'),
(6, 'Samsung', '64', 'Samsung', 'White', 'SSN10P.jpg'),
(7, 'Samsung', '16', 'Samsung', 'Yellow', 'SSS10P.jpg'),
(8, 'Iphone', '32', 'Iphone', 'Black', 'IP70.jpg'),
(9, 'Iphone', '64', 'Iphone', 'White', 'IP80.jpg'),
(10, 'Iphone', '128', 'Iphone', 'Yellow', 'IP100.jpg'),
(11, 'Oppo', '16', 'Oppo', 'Black', 'OPR2.jpg'),
(12, 'Oppo', '32', 'Oppo', 'White', 'OPR10.jpg'),
(13, 'Oppo', '64', 'Oppo', 'White', 'OPF11.jpg'),
(14, 'Vsmart', '16', 'Vsmart', 'Black', 'VSL.jpg'),
(15, 'Vsmart', '32', 'Vsmart', 'White', 'VSA1.jpg'),
(16, 'Vsmart', '64', 'Vsmart', 'Blue', 'VSA1P.jpg'),
(17, 'Apple', '128', 'Airpods', 'Black', 'APPRO.jpg'),
(18, 'Apple', '64', 'Airpods', 'White', 'AP02.jpg'),
(19, 'Apple', '128', 'Watch', 'Black', 'AWS5.jpg'),
(20, 'Apple', '64', 'Watch', 'Black', 'AWS4.jpg'),
(21, 'Apple', '64', 'Watch', 'Black', 'AWS3.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `district`
--

CREATE TABLE `district` (
  `DistrictID` int(10) NOT NULL,
  `ProvinceID` int(10) DEFAULT NULL,
  `DistrictName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employee`
--

CREATE TABLE `employee` (
  `ID` int(10) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `Discriminator` varchar(255) NOT NULL,
  `AccountID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`ID`, `Name`, `Phone`, `Address`, `Discriminator`, `AccountID`) VALUES
(1, 'lan anh', '0326476060', 'ha noi', 'admin', 1),
(2, 'phuong', '0325836964', 'ha noi', 'admin', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invoice`
--

CREATE TABLE `invoice` (
  `ID` int(10) NOT NULL,
  `SubTotal` double NOT NULL,
  `PreTotal` double NOT NULL,
  `Total` double NOT NULL,
  `FeeExtra` double NOT NULL,
  `Discount` double NOT NULL,
  `PromotionCodeID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `item`
--

CREATE TABLE `item` (
  `ID` int(10) NOT NULL,
  `nameItem` varchar(255) NOT NULL,
  `price` double(100,0) NOT NULL,
  `quantity` int(10) NOT NULL,
  `category` varchar(50) NOT NULL,
  `status` int(10) DEFAULT NULL,
  `ItemRateID` int(10) NOT NULL,
  `idDetail` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `item`
--

INSERT INTO `item` (`ID`, `nameItem`, `price`, `quantity`, `category`, `status`, `ItemRateID`, `idDetail`) VALUES
(1, 'Xiaomi Redmi Note 7', 3200000, 12, 'Xiaomi', 1, 1, 1),
(2, 'Xiaomi Redmi Note 8', 3600000, 10, 'Xiaomi', 1, 2, 2),
(3, 'Xiaomi Mi 9', 7500000, 2, 'Xiaomi', 1, 3, 3),
(4, 'Redmi K20 Pro', 7500000, 3, 'Xiaomi', 1, 4, 4),
(5, 'Samsung Note 8', 7500000, 4, 'Samsung', 1, 2, 5),
(6, 'Samsung Note 10+', 22990000, 9, 'Samsung', 1, 3, 6),
(7, 'Samsung S10+', 22990000, 9, 'Samsung', 1, 3, 7),
(8, 'iphone 7', 7000000, 4, 'Iphone', 1, 1, 8),
(9, 'iPhone 8', 10000000, 8, 'Iphone', 1, 4, 9),
(10, 'iPhone X', 10000000, 6, 'Iphone', 1, 3, 10),
(11, 'Oppo Reno 2', 14990000, 6, 'Oppo', 1, 1, 11),
(12, 'Oppo Reno 10x Zoom', 18990000, 24, 'Oppo', 1, 2, 12),
(13, 'Oppo F11 Pro', 6690000, 56, 'Oppo', 1, 4, 13),
(14, 'Vsmart Live', 3790000, 23, 'Vsmart', 1, 4, 14),
(15, 'Vsmart Active 1', 3990000, 5, 'Vsmart', 1, 3, 15),
(16, 'Vsmart Active 1+', 4990000, 2, 'Vsmart', 1, 2, 16),
(17, 'Apple Airpods Pro', 7390000, 5, 'Another', 1, 1, 17),
(18, 'Apple Airpods 2', 4990000, 7, 'Another', 1, 4, 18),
(19, 'Apple watch series 5', 11650000, 7, 'Another', 1, 4, 19),
(20, 'Apple watch series 4', 9950000, 7, 'Another', 1, 4, 20),
(21, 'Apple watch series 3', 6990000, 7, 'Another', 1, 4, 21);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `itemrate`
--

CREATE TABLE `itemrate` (
  `ID` int(10) NOT NULL,
  `Comment` varchar(255) DEFAULT NULL,
  `Star` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `itemrate`
--

INSERT INTO `itemrate` (`ID`, `Comment`, `Star`) VALUES
(1, 'Hình thức xấu', 2),
(2, 'Bình thường', 3),
(3, 'Cấu hình ổn', 4),
(4, 'Xuất sắc', 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `itemsession`
--

CREATE TABLE `itemsession` (
  `ID` int(10) NOT NULL,
  `EmployeeID` int(10) NOT NULL,
  `ItemID` int(10) NOT NULL,
  `Saler` int(10) DEFAULT NULL,
  `Items` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lineitem`
--

CREATE TABLE `lineitem` (
  `ID` int(10) NOT NULL,
  `quantity` int(10) DEFAULT NULL,
  `ItemID` int(10) DEFAULT NULL,
  `CartID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order`
--

CREATE TABLE `order` (
  `ID` int(10) NOT NULL,
  `CartID` int(10) NOT NULL,
  `OrderDate` date DEFAULT NULL,
  `Delivery` int(10) DEFAULT NULL,
  `PromotionCode` int(10) DEFAULT NULL,
  `OrderStatus` int(10) DEFAULT NULL,
  `InvoiceID` int(10) NOT NULL,
  `PromotionCodeID` int(10) NOT NULL,
  `OrderStatusID` int(10) NOT NULL,
  `PaymentID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderstatus`
--

CREATE TABLE `orderstatus` (
  `ID` int(10) NOT NULL,
  `Status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `payment`
--

CREATE TABLE `payment` (
  `ID` int(10) NOT NULL,
  `Method` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `province`
--

CREATE TABLE `province` (
  `ProvinceID` int(10) NOT NULL,
  `ProvinceName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Code` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `province`
--

INSERT INTO `province` (`ProvinceID`, `ProvinceName`, `Code`) VALUES
(201, 'Hà Nội', '4'),
(202, 'Hồ Chí Minh', '8'),
(203, 'Đà Nẵng', '511'),
(204, 'Đồng Nai', '61'),
(205, 'Bình Dương', '065'),
(206, 'Bà Rịa - Vũng Tàu', '64'),
(207, 'Gia Lai', '59'),
(208, 'Khánh Hòa', '58'),
(209, 'Lâm Đồng', '63'),
(210, 'Đắk Lắk', '500'),
(211, 'Long An', '72'),
(212, 'Tiền Giang', '73'),
(213, 'Bến Tre', '75'),
(214, 'Trà Vinh', '74'),
(215, 'Vĩnh Long', '70'),
(216, 'Đồng Tháp', '67'),
(217, 'An Giang', '76'),
(218, 'Sóc Trăng', '79'),
(219, 'Kiên Giang', '77'),
(220, 'Cần Thơ', '710'),
(221, 'Vĩnh Phúc', '211'),
(223, 'Thừa Thiên - Huế', '54'),
(224, 'Hải Phòng', '31'),
(225, 'Hải Dương', '320'),
(226, 'Thái Bình', '36'),
(227, 'Hà Giang', '219'),
(228, 'Tuyên Quang', '27'),
(229, 'Phú Thọ', '210'),
(230, 'Quảng Ninh', '33'),
(231, 'Nam Định', '350'),
(232, 'Hà Nam', '351'),
(233, 'Ninh Bình', '30'),
(234, 'Thanh Hóa', '37'),
(235, 'Nghệ An', '38'),
(236, 'Hà Tĩnh', '39'),
(237, 'Quảng Bình', '52'),
(238, 'Quảng Trị', '53'),
(239, 'Bình Phước', '651'),
(240, 'Tây Ninh', '66'),
(241, 'Đắk Nông', '501'),
(242, 'Quảng Ngãi', '55'),
(243, 'Quảng Nam', '510'),
(244, 'Thái Nguyên', '280'),
(245, 'Bắc Kạn', '281'),
(246, 'Cao Bằng', '26'),
(247, 'Lạng Sơn', '25'),
(248, 'Bắc Giang', '240'),
(249, 'Bắc Ninh', '241'),
(250, 'Hậu Giang', '711'),
(252, 'Cà Mau', '780'),
(253, 'Bạc Liêu', '781'),
(258, 'Bình Thuận', '62'),
(259, 'Kon Tum', '60'),
(260, 'Phú Yên', '57'),
(261, 'Ninh Thuận', '68'),
(262, 'Bình Định', '56'),
(263, 'Yên Bái', '29'),
(264, 'Lai Châu', '231'),
(265, 'Điện Biên', '230'),
(266, 'Sơn La', '22'),
(267, 'Hòa Bình', '218'),
(268, 'Hưng Yên', '321'),
(269, 'Lào Cai', '20');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ward`
--

CREATE TABLE `ward` (
  `WardCode` int(10) NOT NULL,
  `DistrictID` int(10) DEFAULT NULL,
  `WardName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account_customer`
--
ALTER TABLE `account_customer`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `account_employee`
--
ALTER TABLE `account_employee`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `customerID` (`customerID`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKCustomer95365` (`AccountID`);

--
-- Chỉ mục cho bảng `customeraddress`
--
ALTER TABLE `customeraddress`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `CustomerID` (`CustomerID`),
  ADD KEY `AddressID` (`AddressID`);

--
-- Chỉ mục cho bảng `delivery`
--
ALTER TABLE `delivery`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKDelivery111412` (`OrderID`),
  ADD KEY `FKDelivery381529` (`AddressID`),
  ADD KEY `FKDelivery20666` (`DeliveryMethodID`);

--
-- Chỉ mục cho bảng `deliverymethod`
--
ALTER TABLE `deliverymethod`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `detail`
--
ALTER TABLE `detail`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `district`
--
ALTER TABLE `district`
  ADD PRIMARY KEY (`DistrictID`),
  ADD KEY `ProvinceID` (`ProvinceID`);

--
-- Chỉ mục cho bảng `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKEmployee390368` (`AccountID`);

--
-- Chỉ mục cho bảng `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKInvoice145149` (`PromotionCodeID`);

--
-- Chỉ mục cho bảng `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKItem48976` (`ItemRateID`),
  ADD KEY `fkitemproduct` (`idDetail`);

--
-- Chỉ mục cho bảng `itemrate`
--
ALTER TABLE `itemrate`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `itemsession`
--
ALTER TABLE `itemsession`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKItemSessio437057` (`ItemID`),
  ADD KEY `FKItemSessio383246` (`EmployeeID`);

--
-- Chỉ mục cho bảng `lineitem`
--
ALTER TABLE `lineitem`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `cartToItem` (`CartID`),
  ADD KEY `lineITem` (`ItemID`);

--
-- Chỉ mục cho bảng `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKOrder795597` (`CartID`),
  ADD KEY `FKOrder134347` (`InvoiceID`),
  ADD KEY `FKOrder424334` (`PromotionCodeID`),
  ADD KEY `FKOrder582424` (`OrderStatusID`),
  ADD KEY `FKOrder92191` (`PaymentID`);

--
-- Chỉ mục cho bảng `orderstatus`
--
ALTER TABLE `orderstatus`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`ProvinceID`);

--
-- Chỉ mục cho bảng `ward`
--
ALTER TABLE `ward`
  ADD PRIMARY KEY (`WardCode`),
  ADD KEY `DistrictID` (`DistrictID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `address`
--
ALTER TABLE `address`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `customeraddress`
--
ALTER TABLE `customeraddress`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `delivery`
--
ALTER TABLE `delivery`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `deliverymethod`
--
ALTER TABLE `deliverymethod`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `detail`
--
ALTER TABLE `detail`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT cho bảng `employee`
--
ALTER TABLE `employee`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `invoice`
--
ALTER TABLE `invoice`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `item`
--
ALTER TABLE `item`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT cho bảng `itemrate`
--
ALTER TABLE `itemrate`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `itemsession`
--
ALTER TABLE `itemsession`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `lineitem`
--
ALTER TABLE `lineitem`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `order`
--
ALTER TABLE `order`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `orderstatus`
--
ALTER TABLE `orderstatus`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `payment`
--
ALTER TABLE `payment`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `customer` (`ID`);

--
-- Các ràng buộc cho bảng `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `FKCustomer95365` FOREIGN KEY (`AccountID`) REFERENCES `account_customer` (`ID`);

--
-- Các ràng buộc cho bảng `customeraddress`
--
ALTER TABLE `customeraddress`
  ADD CONSTRAINT `customeraddress_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`ID`),
  ADD CONSTRAINT `customeraddress_ibfk_2` FOREIGN KEY (`AddressID`) REFERENCES `address` (`ID`);

--
-- Các ràng buộc cho bảng `delivery`
--
ALTER TABLE `delivery`
  ADD CONSTRAINT `FKDelivery111412` FOREIGN KEY (`OrderID`) REFERENCES `order` (`ID`),
  ADD CONSTRAINT `FKDelivery20666` FOREIGN KEY (`DeliveryMethodID`) REFERENCES `deliverymethod` (`ID`);

--
-- Các ràng buộc cho bảng `district`
--
ALTER TABLE `district`
  ADD CONSTRAINT `district_ibfk_1` FOREIGN KEY (`ProvinceID`) REFERENCES `province` (`ProvinceID`);

--
-- Các ràng buộc cho bảng `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `FKEmployee390368` FOREIGN KEY (`AccountID`) REFERENCES `account_employee` (`ID`);

--
-- Các ràng buộc cho bảng `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `fkitemrate` FOREIGN KEY (`ItemRateID`) REFERENCES `itemrate` (`ID`),
  ADD CONSTRAINT `item_ibfk_1` FOREIGN KEY (`idDetail`) REFERENCES `detail` (`ID`);

--
-- Các ràng buộc cho bảng `itemsession`
--
ALTER TABLE `itemsession`
  ADD CONSTRAINT `FKItemSessio383246` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`),
  ADD CONSTRAINT `FKItemSessio437057` FOREIGN KEY (`ItemID`) REFERENCES `item` (`ID`);

--
-- Các ràng buộc cho bảng `lineitem`
--
ALTER TABLE `lineitem`
  ADD CONSTRAINT `cartToItem` FOREIGN KEY (`CartID`) REFERENCES `cart` (`ID`),
  ADD CONSTRAINT `lineITem` FOREIGN KEY (`ItemID`) REFERENCES `item` (`ID`);

--
-- Các ràng buộc cho bảng `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `FKOrder134347` FOREIGN KEY (`InvoiceID`) REFERENCES `invoice` (`ID`),
  ADD CONSTRAINT `FKOrder582424` FOREIGN KEY (`OrderStatusID`) REFERENCES `orderstatus` (`ID`),
  ADD CONSTRAINT `FKOrder795597` FOREIGN KEY (`CartID`) REFERENCES `cart` (`ID`),
  ADD CONSTRAINT `FKOrder92191` FOREIGN KEY (`PaymentID`) REFERENCES `payment` (`ID`);

--
-- Các ràng buộc cho bảng `ward`
--
ALTER TABLE `ward`
  ADD CONSTRAINT `ward_ibfk_1` FOREIGN KEY (`DistrictID`) REFERENCES `district` (`DistrictID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
