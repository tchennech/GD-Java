-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: personal
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `model` (
  `id` char(12) NOT NULL,
  `name` varchar(45) NOT NULL,
  `dataId` char(12) NOT NULL,
  `author` varchar(45) DEFAULT NULL,
  `trainAccuracy` float NOT NULL DEFAULT '1',
  `testAccuracy` float NOT NULL DEFAULT '1',
  `trainLoss` float NOT NULL DEFAULT '0',
  `testLoss` float NOT NULL DEFAULT '0',
  `totalEpochs` float NOT NULL DEFAULT '200',
  `saveTime` datetime DEFAULT NULL,
  `back1` varchar(45) DEFAULT NULL,
  `back2` varchar(45) DEFAULT NULL,
  `dataName` varchar(45) DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` VALUES ('1931545753','测试模型','1931545753','tct',1,1,0,0,100,'2015-01-02 00:00:00',NULL,NULL,'123132',1),('1931545754','测试模型','1931545753','tct',1,1,0,0,100,'2015-01-03 00:00:00',NULL,NULL,'123132',0),('1931545790','论文演示专用','1931401010','tchennech',0.965,0.1,0.001,20,200,'2019-05-16 20:39:32',NULL,NULL,'ASDASD',1),('1931545791','答辩演示专用','1931401010','tchennech',0.87,0.282,0.1,1,100,'2019-05-21 13:45:09',NULL,NULL,'ASDASD',1);
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-30 11:51:40
