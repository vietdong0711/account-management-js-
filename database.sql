-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: testingsystem
-- ------------------------------------------------------
-- Server version	8.0.28

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
  `AccountID` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `Email` varchar(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `FullName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DepartmentID` tinyint unsigned NOT NULL,
  `PositionID` tinyint unsigned NOT NULL,
  `CreateDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `Password` varchar(800) DEFAULT NULL,
  PRIMARY KEY (`AccountID`),
  UNIQUE KEY `Email` (`Email`),
  UNIQUE KEY `Username` (`Username`),
  KEY `DepartmentID` (`DepartmentID`),
  KEY `PositionID` (`PositionID`),
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`DepartmentID`) REFERENCES `department` (`DepartmentID`),
  CONSTRAINT `account_ibfk_2` FOREIGN KEY (`PositionID`) REFERENCES `position` (`PositionID`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (3,'Email3@gmail.com','Username3','Fullname3_update1',10,1,'2020-03-07 00:00:00','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'),(4,'Email4@gmail.com','Username4','Fullname4_update',3,4,'2020-03-08 00:00:00','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'),(5,'Email5@gmail.com','Username5','Fullname5',4,4,'2020-03-10 00:00:00','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'),(6,'Email6@gmail.com','Username6','Fullname6',6,3,'2020-04-05 00:00:00','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'),(7,'Email7@gmail.com','Username7','Fullname7',2,2,'2020-04-05 00:00:00','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'),(8,'Email8@gmail.com','Username8','Fullname8',8,1,'2020-04-07 00:00:00','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'),(9,'Email9@gmail.com','Username9','Fullname9',2,2,'2020-04-07 00:00:00','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'),(10,'Email10@gmail.com','Username10','Fullname10',10,1,'2020-04-09 00:00:00','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'),(11,'Email112@gmail.com','Username12','Fullname2',1,1,'2022-06-10 21:50:01','$2a$10$bJyvplUevrzy5EElbUT20eiLob5I9zmJYeA3KyKIcP6Zhk.KYXhbW'),(12,'a111@gmail.com','Username1a','FullName 1_update',1,1,'2022-06-10 22:06:03',NULL),(13,'Email1111@gmail.com','Username1111','Fullname1111',10,2,'2022-06-15 19:05:30',NULL),(75,'nguyenvietdong9e@gmail.com','Username1aa','Fullname1a',10,1,'2022-07-20 15:47:25','$2a$10$TlAVHa5PSN/6cML3f7Yz0Ol..zUiLHAqAJFvocN06riuBXmaAZVXO'),(76,'nguyenvietdong9aaae@gmail.com','Username1aaaaa','Fullname3_update1',10,1,'2022-07-20 15:47:52','$2a$10$iKLlk/plF4m./buC1pGnDeOKf1VRgYGs6nAPDBAOAXGnzj54YiADa'),(77,'nguyenvietdong9eaaaaa@gmail.com','Username1aaaaad','aaaaaaa',10,1,'2022-07-20 15:48:30','$2a$10$mtBJrZZpK1BwJc.7v5Rq.eX.s1c3OftQrPa0GiteFJk6hQ4h3yqB2'),(78,'nguyenvietdongeq9e@gmail.com','Username1eqr','Fullname1a',10,1,'2022-07-20 17:12:00','$2a$10$g2GwH0Q0/d2LbURIUWvn6OZNCyKyG.OjwLzuaAhRu5M1p8MetiGmO'),(84,'nguyenvietdong9dde1@gmail.com','usernamedong','dong12',10,1,'2022-07-28 21:10:57',NULL),(85,'Email112111@gmail.com','Username211111','Fullname21',1,1,'2022-07-28 21:39:18',NULL),(86,'Email11211111111@gmail.com','Username211111111','Fullname21',1,1,'2022-07-28 21:40:29',NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `DepartmentID` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `DepartmentName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`DepartmentID`),
  UNIQUE KEY `DepartmentName` (`DepartmentName`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (10,'Bán hàng'),(3,'Bảo vệ'),(8,'Giám đốc'),(5,'Kỹ thuật'),(1,'Marketing'),(4,'Nhân sự'),(7,'Phó giám đốc'),(2,'Sale'),(6,'Tài chính'),(9,'Thư kí');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `PositionID` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `PositionName` enum('Dev','Test','Scrum_Master','PM') NOT NULL,
  PRIMARY KEY (`PositionID`),
  UNIQUE KEY `PositionName` (`PositionName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Dev'),(2,'Test'),(3,'Scrum_Master'),(4,'PM');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-29 11:00:25
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: banhang
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Điện thoại','1'),(2,'Laptop','2');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `content` text,
  `image` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `short_description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `note` varchar(255) NOT NULL,
  `status` int NOT NULL,
  `user_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_detail`
--

DROP TABLE IF EXISTS `orders_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_detail` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `amount` int NOT NULL,
  `price` int NOT NULL,
  `quantity` int NOT NULL,
  `order_id` int unsigned NOT NULL,
  `product_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `orders_detail_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `orders_detail_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_detail`
--

LOCK TABLES `orders_detail` WRITE;
/*!40000 ALTER TABLE `orders_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `description` text,
  `image` varchar(255) NOT NULL,
  `pin` tinyint(1) NOT NULL,
  `title` varchar(255) NOT NULL,
  `category_id` int unsigned NOT NULL,
  `supply_id` int unsigned NOT NULL,
  `price` decimal(19,2) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_name` (`product_name`),
  KEY `category_id` (`category_id`),
  KEY `supply_id` (`supply_id`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
  CONSTRAINT `products_ibfk_2` FOREIGN KEY (`supply_id`) REFERENCES `supplys` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplys`
--

DROP TABLE IF EXISTS `supplys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplys` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `supply_name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplys`
--

LOCK TABLES `supplys` WRITE;
/*!40000 ALTER TABLE `supplys` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `active` int NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi','ADMIN','admin',1,'HN','admin@gmail.com','admin','23456789');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-29 11:00:26
