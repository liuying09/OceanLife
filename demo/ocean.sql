-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ocean
-- ------------------------------------------------------
-- Server version	5.7.40-log

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
-- Table structure for table `ocean_activity`
--

use heroku_895d9448560c022;

DROP TABLE IF EXISTS `ocean_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `ocean_activity` (
  `activityID` int(11) NOT NULL AUTO_INCREMENT,
  `activityTitle` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `activityContent` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `activityDate` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `activityTime` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `activityImg` mediumblob,
  `activityRemark` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`activityID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocean_activity`
--

LOCK TABLES `ocean_activity` WRITE;
/*!40000 ALTER TABLE `ocean_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `ocean_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocean_article`
--

DROP TABLE IF EXISTS `ocean_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `ocean_article` (
  `articleID` int(11) NOT NULL AUTO_INCREMENT,
  `valueEN` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `articleImg` mediumblob,
  `articleTitle` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `articleContent` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `articleRemark` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `articleStatus` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`articleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocean_article`
--

LOCK TABLES `ocean_article` WRITE;
/*!40000 ALTER TABLE `ocean_article` DISABLE KEYS */;
/*!40000 ALTER TABLE `ocean_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocean_bill`
--

DROP TABLE IF EXISTS `ocean_bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `ocean_bill` (
  `billID` int(11) NOT NULL AUTO_INCREMENT,
  `billType` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vehicle` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `barcode` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`billID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocean_bill`
--

LOCK TABLES `ocean_bill` WRITE;
/*!40000 ALTER TABLE `ocean_bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `ocean_bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocean_discount`
--

DROP TABLE IF EXISTS `ocean_discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `ocean_discount` (
  `discountID` int(11) NOT NULL AUTO_INCREMENT,
  `discountTitle` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `discountMethod` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `discountThreshold` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `discountCoupon` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `discountPay` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`discountID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocean_discount`
--

LOCK TABLES `ocean_discount` WRITE;
/*!40000 ALTER TABLE `ocean_discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `ocean_discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocean_favorite`
--

DROP TABLE IF EXISTS `ocean_favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `ocean_favorite` (
  `favoriteID` int(11) NOT NULL AUTO_INCREMENT,
  `productID` int(11) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`favoriteID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocean_favorite`
--

LOCK TABLES `ocean_favorite` WRITE;
/*!40000 ALTER TABLE `ocean_favorite` DISABLE KEYS */;
/*!40000 ALTER TABLE `ocean_favorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocean_order`
--

DROP TABLE IF EXISTS `ocean_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `ocean_order` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) DEFAULT NULL,
  `productId` int(11) DEFAULT NULL,
  `receiveID` int(11) DEFAULT NULL,
  `payID` int(11) DEFAULT NULL,
  `billID` int(11) DEFAULT NULL,
  `orderPayStatus` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `orderStatus` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `orderDelivered` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `orderShip` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocean_order`
--

LOCK TABLES `ocean_order` WRITE;
/*!40000 ALTER TABLE `ocean_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `ocean_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocean_pay`
--

DROP TABLE IF EXISTS `ocean_pay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `ocean_pay` (
  `payID` int(11) NOT NULL AUTO_INCREMENT,
  `deliveryMethod` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `deliveryAdress` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `payMethod` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`payID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocean_pay`
--

LOCK TABLES `ocean_pay` WRITE;
/*!40000 ALTER TABLE `ocean_pay` DISABLE KEYS */;
/*!40000 ALTER TABLE `ocean_pay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocean_product`
--

DROP TABLE IF EXISTS `ocean_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `ocean_product` (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `productPrice` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `productPriceSale` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `productImg` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `productType` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `productNum` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `productContent` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `productSpenMaterial` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `productSpenSize` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `productSpenMF` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `productRemark` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocean_product`
--

LOCK TABLES `ocean_product` WRITE;
/*!40000 ALTER TABLE `ocean_product` DISABLE KEYS */;
INSERT INTO `ocean_product` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'金魚','','','','','','','','','','',NULL,NULL),(4,'金魚','100','','1','布偶','10','很棒的金魚布偶','布','','','',NULL,NULL),(5,'鯊魚','1000','','2','布偶','1','棉花','鯊魚很酷','','','限量一隻',NULL,NULL),(6,'魟魚','500','','','布偶','5','很棒的魟魚','','','','',NULL,NULL),(7,'錘頭鯊','850','','','布偶','5','很棒的錘頭鯊','','','','',NULL,NULL),(8,'大白鯊','2500','','','布偶','5','很棒的大白鯊','','','','',NULL,NULL),(9,'鯨鯊','1850','','','布偶','5','很棒的鯨鯊','','','','',NULL,NULL);
/*!40000 ALTER TABLE `ocean_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocean_productimg`
--

DROP TABLE IF EXISTS `ocean_productimg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `ocean_productimg` (
  `productImgID` int(11) NOT NULL AUTO_INCREMENT,
  `productImg` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `productImgBlob` mediumblob,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`productImgID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocean_productimg`
--

LOCK TABLES `ocean_productimg` WRITE;
/*!40000 ALTER TABLE `ocean_productimg` DISABLE KEYS */;
/*!40000 ALTER TABLE `ocean_productimg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocean_publiccode`
--

DROP TABLE IF EXISTS `ocean_publiccode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `ocean_publiccode` (
  `publicCodeID` int(11) NOT NULL AUTO_INCREMENT,
  `typeCN` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `typeID` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `valueCN` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `valueEN` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`publicCodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocean_publiccode`
--

LOCK TABLES `ocean_publiccode` WRITE;
/*!40000 ALTER TABLE `ocean_publiccode` DISABLE KEYS */;
/*!40000 ALTER TABLE `ocean_publiccode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocean_receive`
--

DROP TABLE IF EXISTS `ocean_receive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `ocean_receive` (
  `receiveID` int(11) NOT NULL AUTO_INCREMENT,
  `receiveName` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `receivePhone` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `receiveMail` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `receiveRemark` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`receiveID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocean_receive`
--

LOCK TABLES `ocean_receive` WRITE;
/*!40000 ALTER TABLE `ocean_receive` DISABLE KEYS */;
/*!40000 ALTER TABLE `ocean_receive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocean_user`
--

DROP TABLE IF EXISTS `ocean_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `ocean_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userAccount` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userPass` int(30) DEFAULT NULL,
  `userName` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userGender` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userStatus` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userBirth` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userAderss` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userImg` mediumblob,
  `userPhone` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userSub` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `favoriteID` int(30) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `uodate_date` date DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocean_user`
--

LOCK TABLES `ocean_user` WRITE;
/*!40000 ALTER TABLE `ocean_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `ocean_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-28 16:25:11
