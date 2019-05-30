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
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `result` (
  `id` char(12) NOT NULL,
  `dataId` char(12) NOT NULL,
  `dataName` varchar(45) NOT NULL,
  `goodNum` int(11) NOT NULL,
  `badNum` int(11) NOT NULL,
  `imgPath` varchar(45) NOT NULL,
  `xmlPath` varchar(45) NOT NULL,
  `detectorPath` varchar(45) NOT NULL,
  `author` varchar(45) DEFAULT 'tchennech',
  `saveTime` datetime NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  `modelName` varchar(45) NOT NULL,
  `modelId` char(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES ('1941611569','194167404','论文演示专用',3,0,'C:\\resultImgs\\1941611569\\','C:\\resultXml\\1941611569\\','C:\\detectorImgs\\1941611569\\','tchennech','2019-05-16 23:57:49',1,'测试模型','1931545754'),('1942112852','1931401010','ASDASD',0,0,'C:\\resultImgs\\1942112852\\','C:\\resultXml\\1942112852\\','C:\\detectorImgs\\1942112852\\','tchennech','2019-05-21 13:29:00',1,'测试模型','1931545754'),('1942115330','1942115145','答辩演示专用',13,6,'C:\\resultImgs\\1942115330\\','C:\\resultXml\\1942115330\\','C:\\detectorImgs\\1942115330\\','tchennech','2019-05-21 13:55:19',1,'测试模型','1931545754'),('194212150','1942121344','答辩演示专用',13,6,'C:\\resultImgs\\194212150\\','C:\\resultXml\\194212150\\','C:\\detectorImgs\\194212150\\','tchennech','2019-05-21 14:16:48',1,'测试模型','1931545754'),('1942813459','194281346','演示5.28',13,6,'C:\\resultImgs\\1942813459\\','C:\\resultXml\\1942813459\\','C:\\detectorImgs\\1942813459\\','tchennech','2019-05-28 13:36:34',1,'测试模型','1931545753');
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
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
