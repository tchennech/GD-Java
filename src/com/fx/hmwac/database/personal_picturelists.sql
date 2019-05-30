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
-- Table structure for table `picturelists`
--

DROP TABLE IF EXISTS `picturelists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picturelists` (
  `id` char(12) NOT NULL,
  `flodName` varchar(45) NOT NULL,
  `num` int(11) DEFAULT NULL,
  `path` varchar(45) NOT NULL,
  `author` varchar(45) DEFAULT NULL,
  `saveTime` date DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picturelists`
--

LOCK TABLES `picturelists` WRITE;
/*!40000 ALTER TABLE `picturelists` DISABLE KEYS */;
INSERT INTO `picturelists` VALUES ('19313115745','sgk',3,'E:\\myPictures\\19313115745\\','tchennech','2019-04-13',0),('1931401010','ASDASD',2,'E:\\myPictures\\1931401010\\','tchennech','2019-04-14',1),('1931401216','ASDASD',2,'E:\\myPictures\\1931401216\\','tchennech','2019-04-14',0),('1931401522','ASDASD',3,'E:\\myPictures\\1931401522\\','tchennech','2019-04-14',1),('1931401728','asdas',3,'E:\\myPictures\\1931401728\\','tchennech','2019-04-14',1),('1931402022','asdsdf',3,'E:\\myPictures\\1931402022\\','tchennech','2019-04-14',1),('193140215','ssd',3,'E:\\myPictures\\193140215\\','tchennech','2019-04-14',1),('193140314','asda',3,'E:\\myPictures\\193140314\\','tchennech','2019-04-14',1),('19318105756','测试预览功能',9,'C:\\myPictures\\19318105756\\','tchennech','2019-04-18',1),('193181177','啊实打实',1,'C:\\myPictures\\193181177\\','tchennech','2019-04-18',1),('19321113338','测试流程专用',3,'C:\\myPictures\\19321113338\\','tchennech','2019-04-21',1),('193221631','测试专用',3,'C:\\myPictures\\193221631\\','tchennech','2019-04-22',0),('194167404','论文演示专用',4,'C:\\myPictures\\194167404\\','tchennech','2019-05-16',1),('1942114951','答辩演示专用',4,'C:\\myPictures\\1942114951\\','tchennech','2019-05-21',1),('1942115145','答辩演示专用',5,'C:\\myPictures\\1942115145\\','tchennech','2019-05-21',1),('1942121344','答辩演示专用',5,'C:\\myPictures\\1942121344\\','tchennech','2019-05-21',1),('194281346','演示5.28',5,'C:\\myPictures\\194281346\\','tchennech','2019-05-28',1);
/*!40000 ALTER TABLE `picturelists` ENABLE KEYS */;
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
