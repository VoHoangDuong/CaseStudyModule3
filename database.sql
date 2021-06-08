CREATE DATABASE  IF NOT EXISTS `shop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shop`;
-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(250) NOT NULL,
  `pass` varchar(250) NOT NULL,
  `isSell` int DEFAULT NULL,
  `isAdmin` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'Khanh','123',1,1),(2,'duong','12345',0,1),(3,'phong','abc123',1,0),(4,'han','123456',0,0),(5,'Vo Hoang Duong','123',1,1),(6,'Duy Han','abc123',0,0),(7,'Dang Phong','abc125',0,0),(8,'admin2','123',1,0),(9,'Quang Tran','123456',0,0),(10,'admin1','123',1,0),(11,'Tran Quang','123',0,0),(12,'binhhu','123',0,0),(13,'long','123',0,0),(14,'admin3','123',0,0),(15,'admin','123',0,0),(16,'quangtran','123',0,0),(17,'phong123','123',0,0),(18,'duong123','123',0,0);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL,
  `category_name` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Đồng hồ Casio'),(2,'Đồng hồ Orient'),(3,'Đồng hồ Citizen'),(4,'Đồng hồ Seiko');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id_item` int NOT NULL,
  `quantity` double DEFAULT NULL,
  `id_product` int DEFAULT NULL,
  `id_user` int DEFAULT NULL,
  KEY `id_product` (`id_product`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`),
  CONSTRAINT `item_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (2,2,2,16);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `img` text,
  `price` double NOT NULL,
  `title` varchar(250) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `sell_ID` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  KEY `sell_ID` (`sell_ID`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`sell_ID`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (2,'Casio MTP-1384BUL','https://cdn.watchstore.vn/uploads/images/dong-ho-casio-mtp-1384bul-1a_2-ims.jpg',199,'Đồng Hồ Nam Casio MTP-1384BUL-1AVDF Dây Da','Đồng Hồ Nam Casio mặt kính saphire',1,1),(9,'Orient RA-AR0005Y10B','https://cdn.watchstore.vn/uploads/images/dong-ho-orient-ra-ar0005y10b_1-ims.jpg',199,'Đồng Hồ Nam - Máy Cơ Automatic - Size Mặt 41mm','Kính Sapphire - Dây Da - Chống Nước 5ATM',2,3),(10,'Orient RA-AC0F05B10B','https://cdn.watchstore.vn/uploads/images/dong-ho-orient-ra-ac0f05b10b_3-ims.jpg',129,'Đồng Hồ Nam - Máy Cơ Automatic - Size Mặt 41.6mm',' Kính Khoáng - Dây Da - Chống Nước 5ATM',2,8),(11,'Orient FAC00005W0','https://cdn.watchstore.vn/uploads/images/dong-ho-orient-fac00005w0_1-ims.jpg',149,'Đồng Hồ Nam - Pin - Quartz - Size Mặt 40.5mm','Kính Cong - Dây Da - Chống Nước 3ATM ',2,3),(12,'Orient FEV0U003BH','https://cdn.watchstore.vn/uploads/images/dong-ho-orient-fev0u003bh_1-ims.jpg',139,'Đồng Hồ Nam - Máy Cơ Automatic - Size Mặt 42mm','Kính Khoáng - Dây Da - Chống Nước 5ATM',2,8),(13,'Citizen CA7003-06E ','https://cdn.watchstore.vn/uploads/images/CITIZEN-CA7003-06E-1.jpg',139,'Đồng Hồ Nam - Eco Drive - Size Mặt 43mm','Kính Khoáng - Dây Da - Chống Nước 10ATM',3,1),(14,'Citizen AW1591-01L','https://cdn.watchstore.vn/uploads/images/CITIZEN-AW1591-01L-1-min.jpg',159,'Đồng Hồ Nam - Eco Drive - Size Mặt 43mm','Kính Khoáng - Dây Da - Mới 100%',3,8),(15,'Citizen BF2018-52H','https://cdn.watchstore.vn/uploads/images/BF2018-52H-1.jpg',99,'Đồng Hồ Nam - Pin - Quartz - Size Mặt 41mm','Kính Khoáng - Dây Kim Loại - Chống Nước 5ATM',3,1),(16,'Citizen AW0078-08LXG','https://cdn.watchstore.vn/uploads/images/CITIZEN-AW0078-08LXG-1.jpg',129,'Đồng Hồ Nam - Eco Drive - Size Mặt 44mm','Kính Khoáng - Dây Da - Chống Nước 10ATM',3,8),(17,'Citizen BF2023-01A','https://cdn.watchstore.vn/uploads/images/dong-ho-citizen-bf2023-01a_1-ims.jpg',99,'Đồng Hồ Nam - Pin - Quartz - Size Mặt 41mm','Kính Khoáng - Dây Da - Chống Nước 5ATM',3,8),(19,'Seiko SRPD41J1','https://cdn.watchstore.vn/uploads/images/SRPD41J1.jpg',299,'Đồng Hồ Nam - Máy Cơ Automatic - Size Mặt 41.6mm','Kính Sapphire - Dây Kim Loại - Chống Nước 3ATM',4,1),(20,'SEIKO SRPE55K1','https://cdn.watchstore.vn/uploads/images/dong-ho-seiko-srpe55k1_1-ims.jpg',199,'Đồng Hồ Nam - Máy Cơ Automatic - Size Mặt 40mm','Hardlex Crystal - Dây Kim Loại - Chống Nước 10ATM',4,3),(21,'Seiko SRPB43J1','https://cdn.watchstore.vn/uploads/images/SRPB43J1.jpg',239,'Đồng Hồ Nam - Máy Cơ Automatic - Size Mặt 40.5mm','Hardlex Crystal - Dây Da - Chống Nước 5ATM',4,1),(22,'Seiko SRN062P1','https://cdn.watchstore.vn/uploads/images/dong-ho-seiko-srn062p1_1-ims.jpg',189,'Đồng Hồ Nam - Kinetic - Size Mặt 42mm','Kính Khoáng - Dây Da - Chống Nước 10ATM',4,3),(24,'Seiko SSB296P1','https://cdn.watchstore.vn/uploads/images/dong-ho-seiko-ssb296p1_1-ims.jpg',259,'Đồng Hồ Nam - Pin - Quartz - Size Mặt 42.5mm','Hardlex Crystal - Dây Da - Chống Nước 10ATM',4,1),(25,'Orient RA-AG0029N10B','https://cdn.watchstore.vn/uploads/images/RA-AG0029N10B-1.jpg',199,'Đồng Hồ Nam - Máy Cơ Automatic - Size Mặt 41mm','Kính Cong - Dây Kim Loại - Chống Nước 3ATM',2,8),(28,'Casio MTP-1375D-1A','https://cdn.watchstore.vn/uploads/images/dong-ho-casio-mtp-1375d-1a_1-ims.jpg',89,'Đồng Hồ Nam - Pin - Quartz - Size Mặt 42mm','Kính Khoáng - Dây Kim Loại - Chống Nước 5ATM - Mới 100%',1,1),(29,'Orient RA-AC0F03B10B','https://cdn.watchstore.vn/uploads/images/dong-ho-orient-ra-ac0f03b10b_1-ims.jpg',119,'Đồng Hồ Nam - Máy Cơ Automatic - Size Mặt 41.6mm','Đồng Hồ Nam - Máy Cơ Automatic - Size Mặt 41.6mm',2,8);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-08 15:36:31
