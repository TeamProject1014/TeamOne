CREATE DATABASE  IF NOT EXISTS `quantities` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `quantities`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: quantities
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `architect`
--

DROP TABLE IF EXISTS `architect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `architect` (
  `Arch_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) DEFAULT NULL,
  `Address` varchar(20) DEFAULT NULL,
  `Address2` varchar(20) DEFAULT NULL,
  `Town` varchar(20) DEFAULT NULL,
  `County` varchar(20) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Arch_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `architect`
--

LOCK TABLES `architect` WRITE;
/*!40000 ALTER TABLE `architect` DISABLE KEYS */;
INSERT INTO `architect` VALUES (1,'Austin Sammon','LYIT','Port Road','Letterkenny','Donegal','0715648794','austin.sammon@lyit.ie'),(2,'Lee Tamplin','Tir Chonail St','','Donegal Town','Donegal','854564567','lee.tamplin@architect.ie'),(3,'Paul Corey','LYIT','Port Road','Letterkenny','Donegal','871234564','paul.corey@lyit.ie'),(4,'Declan McCabe','Ardeskin','Old Laghey Road','Donegal Town','Donegal','749712345','dmccabe@architect.ie'),(5,'Martin Fowler','St. Josephs Avenue','','Donegal Town','Donegal','749765432','martin.fowler@architect.ie');
/*!40000 ALTER TABLE `architect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `builder`
--

DROP TABLE IF EXISTS `builder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `builder` (
  `Builder_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) DEFAULT NULL,
  `Address` varchar(20) DEFAULT NULL,
  `Address2` varchar(20) DEFAULT NULL,
  `Town` varchar(20) DEFAULT NULL,
  `County` varchar(20) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Builder_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `builder`
--

LOCK TABLES `builder` WRITE;
/*!40000 ALTER TABLE `builder` DISABLE KEYS */;
INSERT INTO `builder` VALUES (1,'Frank Lawne Builders','Lurganboy','','Donegal Town','Donegal','0871234567','frank.lawne@builders.ie'),(2,'Paddy Doherty','Bridge Street','','Kilcar','Donegal','874545454','paddydoh@builder.ie'),(3,'Seán MacSuibhne','Shore Road','','Carrick','Donegal','875959595','seanmac@builder.ie'),(4,'Richard Selby','Selby Builders Ltd','High Road','Letterkenny','Donegal','749198765','info@selbybuild.ie'),(5,'Stephen Margolis','SM Builders','Main Street','Convoy','Donegal','749156498','smbuild@build.ie');
/*!40000 ALTER TABLE `builder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`category_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Substructure'),(2,'External Walls'),(3,'Internal Walls'),(4,'Upper Floors'),(5,'Stairs'),(6,'Roof Structure'),(7,'External Walls Completion'),(8,'Internal Walls Completion'),(9,'Roof Completion'),(10,'External Wall Finishes'),(11,'Internal Wall Finishes'),(12,'Floor Finishes'),(13,'Stair Finishes'),(14,'Ceiling Finishes'),(15,'Roof Finishes'),(16,'Mechanical Services'),(17,'Electrical Services'),(18,'Building Fittings'),(19,'siteworks');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_material`
--

DROP TABLE IF EXISTS `category_material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_material` (
  `category_ID` int(11) NOT NULL DEFAULT '0',
  `material_ID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`category_ID`,`material_ID`),
  KEY `material_ID` (`material_ID`),
  CONSTRAINT `category_material_ibfk_2` FOREIGN KEY (`material_ID`) REFERENCES `material` (`Material_ID`),
  CONSTRAINT `category_material_ibfk_3` FOREIGN KEY (`category_ID`) REFERENCES `category` (`category_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_material`
--

LOCK TABLES `category_material` WRITE;
/*!40000 ALTER TABLE `category_material` DISABLE KEYS */;
INSERT INTO `category_material` VALUES (1,1),(1,2),(1,3),(1,4),(1,6),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(2,22),(2,23),(2,24),(2,25),(2,26),(2,27),(3,28),(5,29);
/*!40000 ALTER TABLE `category_material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `Client_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) NOT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Address2` varchar(30) DEFAULT NULL,
  `Town` varchar(30) DEFAULT NULL,
  `County` varchar(30) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Client_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Joe Bloggs','Main Street','','Donegal Town','Donegal','871234567','joebloggs@lyit.com'),(2,'John Doe','The Mall',NULL,'Ballyshannon','Donegal','877654321','johndoe@lyit.ie'),(4,'Pat Murphy','Bridge Street',NULL,'Ramelton','Donegal','878901234','patmurphy@lyit.ie'),(5,'Fred West','Pearse Road','','Letterkenny','Donegal','126171511','fredwest@lyit.ie'),(6,'Fr. Ted Crilly','Parochial House','','Craggy Island','Clare','651234567','frted@lyit.ie'),(7,'Christopher Negus','Random Road','','Donegal Town','Donegal','0751236542','chrisneg@client.ie'),(8,'Joel Murach','12 Castle Street','','Donegal Town','Donegal','749798765','joel.murach@client.ie'),(9,'Roisin Eccles','3 Middle Drumrooske','','Donegal Town','Donegal','863761519','roshec@gmail.com');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `engineer`
--

DROP TABLE IF EXISTS `engineer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `engineer` (
  `Eng_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) DEFAULT NULL,
  `Address` varchar(20) DEFAULT NULL,
  `Address2` varchar(20) DEFAULT NULL,
  `Town` varchar(20) DEFAULT NULL,
  `County` varchar(20) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Eng_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `engineer`
--

LOCK TABLES `engineer` WRITE;
/*!40000 ALTER TABLE `engineer` DISABLE KEYS */;
INSERT INTO `engineer` VALUES (1,'McDaid Associates','The Diamond','','Donegla Town','Donegal','0741234567','mcdaidassoc@eng.ie'),(2,'Brendan Gallagher','The Glebe',NULL,'Kilmacrennan','Donegal','877878787','brengall@builder.ie'),(3,'Fred O\'Donnell','Tír Chonail St',NULL,'Ballybofey','Donegal','871212121','fredod@builder.ie'),(4,'Michael Cusunamo','M.C. Engineers','Pearse Road','Letterkenny','Donegal','749112345','mcengineers@engineers.ie'),(5,'Martyn Farr','32 Welsh Road','Welsh Town','Ballybofey','Donegal','871234568','m.farr@eng.ie');
/*!40000 ALTER TABLE `engineer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `Job_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Status` varchar(10) DEFAULT NULL,
  `Total_Cost` decimal(10,2) DEFAULT NULL,
  `Arch_ID` int(11) DEFAULT NULL,
  `Eng_ID` int(11) DEFAULT NULL,
  `Build_ID` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `User_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`Job_ID`),
  KEY `Build_ID` (`Build_ID`),
  KEY `Arch_ID` (`Arch_ID`),
  KEY `Eng_ID` (`Eng_ID`),
  KEY `job_ibfk_3_idx` (`User_ID`),
  CONSTRAINT `job_ibfk_1` FOREIGN KEY (`Build_ID`) REFERENCES `builder` (`Builder_ID`),
  CONSTRAINT `job_ibfk_2` FOREIGN KEY (`Arch_ID`) REFERENCES `architect` (`Arch_ID`),
  CONSTRAINT `job_ibfk_3` FOREIGN KEY (`Eng_ID`) REFERENCES `engineer` (`Eng_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,'Open',41979.01,1,3,2,'Proposed Health Centre in downtown Ramelton',1),(2,'Open',14694.00,2,2,3,'Proposed development in uptown Ballyshannon',2),(8,'Open',10935.00,4,5,4,'Proposed Dwelling at Ballybofey',3),(9,'Open',15153.00,4,2,3,'Propsed Shed at Laghey',4),(11,'Open',10859.00,2,1,3,'Proposed Health Centre at Port Road, Letterkenny',1),(12,'Open',NULL,5,5,5,'Proposed Development up the Road',1),(14,'Open',NULL,NULL,NULL,NULL,'Test Development',2),(15,'Open',NULL,NULL,NULL,NULL,'Test Development',3),(16,'Open',NULL,2,2,2,'test\n',4),(17,'Open',NULL,5,2,5,'Another test',3),(18,'Pending',134.55,3,4,3,'New Job',2),(19,'Open',NULL,3,1,4,'Brand New Development',2),(20,'Open',NULL,1,1,1,'Another Bloggs Job',3),(21,'Open',NULL,2,2,2,'Another Doe Job',4),(22,'Open',NULL,3,3,3,'PM Job',1),(23,'Open',23940.00,3,2,3,'Proposed Development at Middle Drumrroske',4),(24,'Open',0.00,1,1,1,'hjkl',NULL),(25,'Open',0.00,2,1,5,'hkl',NULL);
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_client`
--

DROP TABLE IF EXISTS `job_client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_client` (
  `Job_ID` int(11) NOT NULL,
  `Client_ID` int(11) NOT NULL,
  PRIMARY KEY (`Job_ID`,`Client_ID`),
  KEY `Client_ID` (`Client_ID`),
  CONSTRAINT `job_client_ibfk_1` FOREIGN KEY (`Job_ID`) REFERENCES `job` (`Job_ID`),
  CONSTRAINT `job_client_ibfk_2` FOREIGN KEY (`Client_ID`) REFERENCES `client` (`Client_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_client`
--

LOCK TABLES `job_client` WRITE;
/*!40000 ALTER TABLE `job_client` DISABLE KEYS */;
INSERT INTO `job_client` VALUES (1,1),(20,1),(23,1),(24,1),(2,2),(16,2),(21,2),(25,2),(8,4),(22,4),(17,5),(18,5),(15,6),(11,7),(19,7),(9,8),(12,8);
/*!40000 ALTER TABLE `job_client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_material`
--

DROP TABLE IF EXISTS `job_material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_material` (
  `Job_ID` int(11) NOT NULL,
  `Material_ID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Price` decimal(7,2) DEFAULT NULL,
  `TotalPrice` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`Job_ID`,`Material_ID`),
  KEY `Material_ID` (`Material_ID`),
  CONSTRAINT `job_material_ibfk_1` FOREIGN KEY (`Job_ID`) REFERENCES `job` (`Job_ID`),
  CONSTRAINT `job_material_ibfk_2` FOREIGN KEY (`Material_ID`) REFERENCES `material` (`Material_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_material`
--

LOCK TABLES `job_material` WRITE;
/*!40000 ALTER TABLE `job_material` DISABLE KEYS */;
INSERT INTO `job_material` VALUES (1,1,8900,1.00,8900.00),(1,2,15,40.00,600.00),(1,3,61,17.00,1037.00),(1,4,10,30.00,300.00),(1,10,6,32.00,192.00),(1,12,85,36.00,3060.00),(1,13,57,38.00,2166.00),(1,14,6,95.00,570.00),(1,15,30,15.00,450.00),(1,16,200,8.00,1600.00),(1,22,320,42.00,13440.00),(1,23,5123,1.87,9580.01),(1,24,3,28.00,84.00),(2,2,41,40.00,1640.00),(2,3,61,17.00,1037.00),(2,4,77,13.00,1001.00),(2,5,50,95.00,4750.00),(2,6,2,200.00,400.00),(2,10,6,32.00,192.00),(2,12,115,36.00,4140.00),(2,14,6,95.00,570.00),(2,16,44,6.00,264.00),(2,18,2,200.00,400.00),(2,19,1,300.00,300.00),(8,21,243,45.00,10935.00),(9,1,1,8900.00,8900.00),(9,2,21,40.00,840.00),(9,14,6,95.00,570.00),(9,16,644,6.00,3864.00),(9,25,23,23.00,529.00),(9,27,25,18.00,450.00),(11,1,1,6500.00,6500.00),(11,2,35,45.00,1575.00),(11,3,45,38.00,1710.00),(11,14,58,13.00,754.00),(11,19,4,80.00,320.00),(18,23,23,5.85,134.55),(23,1,8900,1.00,8900.00),(23,2,40,40.00,1600.00),(23,22,320,42.00,13440.00);
/*!40000 ALTER TABLE `job_material` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER after_insert_trigger AFTER INSERT ON job_material
	FOR EACH ROW BEGIN
		SET @job_id = new.job_id;

		UPDATE job SET Total_Cost = (
			SELECT SUM(job_material.quantity * job_material.price)
			FROM job_material
			WHERE job_material.job_id = @job_id)
			WHERE job.Job_ID = @job_id;
	END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER after_update_trigger AFTER UPDATE ON job_material
	FOR EACH ROW BEGIN
		SET @job_id = new.job_id;

		UPDATE job SET Total_Cost = (
			SELECT SUM(job_material.quantity * job_material.price)
			FROM job_material
			WHERE job_material.job_id = @job_id)
			WHERE job.Job_ID = @job_id;
	END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER after_delete_trigger AFTER DELETE ON job_material
	FOR EACH ROW BEGIN
		#SET @job_id = new.job_id;

		UPDATE job SET Total_Cost = (
			SELECT SUM(job_material.quantity * job_material.price)
			FROM job_material
			WHERE job_material.job_id = job.job_id);
			
	END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `job_user`
--

DROP TABLE IF EXISTS `job_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_user` (
  `User_ID` int(11) NOT NULL,
  `Job_ID` int(11) NOT NULL,
  PRIMARY KEY (`User_ID`,`Job_ID`),
  KEY `Job_ID` (`Job_ID`),
  CONSTRAINT `job_user_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`),
  CONSTRAINT `job_user_ibfk_2` FOREIGN KEY (`Job_ID`) REFERENCES `job` (`Job_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_user`
--

LOCK TABLES `job_user` WRITE;
/*!40000 ALTER TABLE `job_user` DISABLE KEYS */;
INSERT INTO `job_user` VALUES (1,1),(1,2);
/*!40000 ALTER TABLE `job_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `job_view`
--

DROP TABLE IF EXISTS `job_view`;
/*!50001 DROP VIEW IF EXISTS `job_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `job_view` (
  `Client` tinyint NOT NULL,
  `Description` tinyint NOT NULL,
  `Status` tinyint NOT NULL,
  `Total` tinyint NOT NULL,
  `Architect` tinyint NOT NULL,
  `Engineer` tinyint NOT NULL,
  `Builder` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material` (
  `Material_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Material_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,'PC sum for driven piles'),(2,'Cutting top of piles'),(3,'Hardcore over site for piling, 250th'),(4,'exec trenches & disposal'),(5,'Reinforced Concrete Ground Beam'),(6,'Ditto Pads'),(8,'prov r\'ment'),(9,'r\'ment @ 42kg/m3'),(10,'blinding'),(11,'Working Space'),(12,'300 Rising Cavity Blockwork'),(13,'215 Rising Blockwork'),(14,'Cavity Fill'),(15,'H\'core b\'fill'),(16,'DPC\'s'),(17,'Radon Barrier'),(18,'Sumps'),(19,'Sump Pipes'),(20,'250 thick h\'core to make up levels'),(21,'200 PCC Slabs on 60 Ins on Blinding'),(22,'Cavity Wall'),(23,'Blocks'),(24,'Cement'),(25,'Sand'),(26,'Wall Ties'),(27,'Insulation'),(28,'100mm Thick Walls'),(29,'Grabrail');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `User_ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`User_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Liam','password'),(2,'Cathal','password'),(3,'Eamon','password'),(4,'Luke','password');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `job_view`
--

/*!50001 DROP TABLE IF EXISTS `job_view`*/;
/*!50001 DROP VIEW IF EXISTS `job_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `job_view` AS select `c`.`Name` AS `Client`,`j`.`description` AS `Description`,`j`.`Status` AS `Status`,`j`.`Total_Cost` AS `Total`,`a`.`Name` AS `Architect`,`e`.`Name` AS `Engineer`,`b`.`Name` AS `Builder` from ((((`client` `c` join `job` `j`) join `architect` `a`) join `engineer` `e`) join (`builder` `b` join `job_client` `jc`)) where ((`jc`.`Job_ID` = `j`.`Job_ID`) and (`jc`.`Client_ID` = `c`.`Client_ID`) and (`a`.`Arch_ID` = `j`.`Arch_ID`) and (`e`.`Eng_ID` = `j`.`Eng_ID`) and (`b`.`Builder_ID` = `j`.`Build_ID`) and (`jc`.`Client_ID` = 1)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-10  1:13:04
