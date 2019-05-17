-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mygarage
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `bodystyles`
--

LOCK TABLES `bodystyles` WRITE;
DROP TABLE IF EXISTS `bodystyles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bodystyles` (
  `bodystyleId` int(11) NOT NULL AUTO_INCREMENT,
  `bodystyleName` varchar(255) NOT NULL,
  PRIMARY KEY (`bodystyleId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bodystyles`
--

LOCK TABLES `bodystyles` WRITE;
/*!40000 ALTER TABLE `bodystyles` DISABLE KEYS */;
INSERT INTO `bodystyles` (`bodystyleId`, `bodystyleName`) VALUES (1,'4x4'),(2,'convertible'),(3,'coupe'),(4,'estate'),(5,'hatchback'),(6,'people-carrier'),(7,'pick-up'),(8,'saloon');
/*!40000 ALTER TABLE `bodystyles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cars` (
  `carId` int(11) NOT NULL AUTO_INCREMENT,
  `VIN` VARCHAR(17) NOT NULL,
	`rrPrice` INT(11),
	`price` INT(11) NOT NULL,
  `colorId` int(11) NOT NULL,
  `mileage` int(11),
	`complectationId` INT(11) NOT NULL,
  `image` longtext,
  `description` text,
  PRIMARY KEY (`carId`),
  KEY `fk_cars_colors_idx` (`colorId`),
  KEY `fk_cars_complectations_idx` (`complectationId`),
  CONSTRAINT `fk_cars_colors` FOREIGN KEY (`colorId`) REFERENCES `colors` (`colorId`),
  CONSTRAINT `fk_cars_complectations` FOREIGN KEY (`complectationId`) REFERENCES `complectations` (`complectationId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` (`carId`, `VIN`, `rrPrice`, `price`, `colorId`, `mileage`, `complectationId`, `image`, `description`) 
VALUES 
(1,'4F4CR16UXRTM62412',100000,95000,1,NULL,1,'/img/car-default.jpg','Insurance Group 31, Adjustable steering column, Alarm, Anti lock braking system, Central locking, Climate control, Drivers airbag, Electric mirrors, Front Electric windows, Front fog lights, Passenger airbag, Power assisted steering, Radio/CD, Rear Electric windows, Remote Central Locking, Side airbag,This car is in lovely condition and has been really looked after ,viewing essential . GOOGLE OUR PHONE NUMBER !! '),
(2,'JH4DA9360NS008662',NULL,12000,2,230000,2,'/img/car-default.jpg','car car car.'),
(3,'2C3HD46R4WH170262',50000,45600,3,NULL,3,'/img/car-default.jpg','hi'),
(4,'JH4KA2650HC000268',10000,9800,4,NULL,4,'/img/car-default.jpg','very expensive!!'),
(5,'JH4KA4560KC018749',NULL,4500,5,350400,5,'/img/car-default.jpg','^_^'),
(6,'1C4BJWKGXDL508578',60000,57330,6,NULL,6,'/img/car-default.jpg','tvybiuno'),
(7,'3G4AG54N9NS614902',NULL,18890,7,228823,7,'/img/car-default.jpg','-------->      $_$'),
(8,'1FAFP53U7XA192769',28500,27000,8,NULL,8,'/img/car-default.jpg','car caaaaaar'),
(9,'2BCHV81S4JB533621',17400,16500,9,NULL,9,'/img/car-default.jpg','ini'),
(10,'WAUDK84AXRN029130',9900,9000,10,NULL,4,'/img/car-default.jpg','cool');
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colors`
--

DROP TABLE IF EXISTS `colors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colors` (
  `colorId` int(11) NOT NULL AUTO_INCREMENT,
  `colorName` varchar(255) NOT NULL,
  PRIMARY KEY (`colorId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colors`
--

LOCK TABLES `colors` WRITE;
/*!40000 ALTER TABLE `colors` DISABLE KEYS */;
INSERT INTO `colors` (`colorId`, `colorName`) 
VALUES 
(1,'beige'),
(2,'black'),
(3,'blue'),
(4,'green'),
(5,'gray'),
(6,'orange'),
(7,'pink'),
(8,'purple'),
(9,'red'),
(10,'silver');
/*!40000 ALTER TABLE `colors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fueltypes`
--

DROP TABLE IF EXISTS `fueltypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fueltypes` (
  `fuelTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `fuelTypeName` varchar(255) NOT NULL,
  PRIMARY KEY (`fuelTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fueltypes`
--

LOCK TABLES `fueltypes` WRITE;
/*!40000 ALTER TABLE `fueltypes` DISABLE KEYS */;
INSERT INTO `fueltypes` (`fuelTypeId`, `fuelTypeName`) VALUES (1,'petrol'),(2,'petrol-electric-hybrid'),(3,'diesel'),(4,'diesel-electric-hybrid'),(5,'electric');
/*!40000 ALTER TABLE `fueltypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `headlights`
--

DROP TABLE IF EXISTS `headlights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `headlights` (
  `headlightId` int(11) NOT NULL AUTO_INCREMENT,
  `headlightName` varchar(255) NOT NULL,
  PRIMARY KEY (`headlightId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `headlights`
--

LOCK TABLES `headlights` WRITE;
/*!40000 ALTER TABLE `headlights` DISABLE KEYS */;
INSERT INTO `headlights` (`headlightId`, `headlightName`)
VALUES
(1,'Xenon'),
(2,'Laser'),
(3,'LED');
/*!40000 ALTER TABLE `headlights` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `makes`
--

DROP TABLE IF EXISTS `makes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `makes` (
  `makeId` int(11) NOT NULL AUTO_INCREMENT,
  `makeName` varchar(255) NOT NULL,
  PRIMARY KEY (`makeId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `makes`
--

LOCK TABLES `makes` WRITE;
/*!40000 ALTER TABLE `makes` DISABLE KEYS */;
INSERT INTO `makes` (`makeId`, `makeName`) VALUES (1,'Audi'),(2,'Ford'),(3,'Mazda'),(4,'Nissan'),(5,'Opel'),(6,'Pegeout'),(7,'Renault'),(8,'Tesla');
/*!40000 ALTER TABLE `makes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `models`
--

DROP TABLE IF EXISTS `models`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `models` (
  `modelId` int(11) NOT NULL AUTO_INCREMENT,
  `makeId` int(11) NOT NULL,
  `modelName` varchar(45) NOT NULL,
  PRIMARY KEY (`modelId`),
  KEY `fk_models_makes_idx` (`makeId`),
  CONSTRAINT `fk_models_makes` FOREIGN KEY (`makeId`) REFERENCES `makes` (`makeId`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `models`
--

LOCK TABLES `models` WRITE;
/*!40000 ALTER TABLE `models` DISABLE KEYS */;
INSERT INTO `models` (`modelId`, `makeId`, `modelName`) VALUES (1,1,'A4'),(2,1,'A6'),(3,1,'A7'),(4,1,'Q7'),(5,1,'TT'),(6,2,'Escort'),(7,2,'Fiesta'),(8,2,'Focus'),(9,2,'GT'),(10,2,'Mustang'),(11,3,'3'),(12,3,'6'),(13,3,'CX-5'),(14,4,'Patrol'),(15,4,'Skyline'),(16,4,'Qashqai'),(17,4,'Micra'),(18,4,'Leaf'),(19,5,'Astra'),(20,5,'Frontera'),(21,5,'Mokka'),(22,5,'Corsa'),(23,6,'Boxer'),(24,6,'807'),(25,6,'407'),(26,7,'Logan'),(27,7,'Megane'),(28,7,'Master'),(29,7,'Captur'),(30,7,'Clio'),(31,8,'Model S'),(32,8,'Model X');
/*!40000 ALTER TABLE `models` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `carId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`orderId`),
  KEY `fk_orders_cars_idx` (`carId`),
  KEY `fk_orders_users_idx` (`userId`),
  CONSTRAINT `fk_orders_cars` FOREIGN KEY (`carId`) REFERENCES `cars` (`carId`),
  CONSTRAINT `fk_orders_users` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ads`
--

DROP TABLE IF EXISTS `ads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ads` (
  `adId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `carId` int(11) NOT NULL,
	`dateAdd` DATETIME DEFAULT CURRENT_TIMESTAMP,
	`dateDelete` DATETIME,
  PRIMARY KEY (`adId`),
  KEY `fk_ads_cars_idx` (`carId`),
  KEY `fk_ads_users_idx` (`userId`),
  CONSTRAINT `fk_ads_cars` FOREIGN KEY (`carId`) REFERENCES `cars` (`carId`),
  CONSTRAINT `fk_ads_users` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ads`
--

LOCK TABLES `ads` WRITE;
/*!40000 ALTER TABLE `ads` DISABLE KEYS */;
/*!40000 ALTER TABLE `ads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(255) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`roleId`, `roleName`) 
VALUES 
(1,'ROLE_ADMIN'),
(2,'ROLE_USER'),
(3,'ROLE_DEALER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complectations`
--

DROP TABLE IF EXISTS `complectations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `complectations` (
  `complectationId` INT(11) NOT NULL AUTO_INCREMENT,
	`complectationName` varchar(255) NOT NULL,
	`modelId` INT(11) NOT NULL,
	`bodystyleId` INT(11) NOT NULL,
	`fueltypeId` INT(11) NOT NULL,
	`transmissionId` INT(11) NOT NULL,
	`drivetypeId` INT(11) NOT NULL,
	`year` INT(11) NOT NULL,
	`enginevolume` FLOAT NOT NULL,
	`horsepower` INT(11) NOT NULL,
	`acceleration` FLOAT,
	`commonconsumption` FLOAT,
	`cityconsumption` FLOAT,
	`routeconsumption` FLOAT,
	`length` INT(11),
	`width` INT(11),
	`maxspeed` INT(11),
	`headlightId` INT(11),

	`Electricheatingofthewindshield` Bool,
	`Electricheatingofsidemirrors` Bool,
	`Headlightwashersystem` Bool,
	`Rainsensor` Bool,
	`Foglight` Bool,
	`Bluetooth` Bool,
	`USB` Bool,
	`AUX` Bool,
	`Navigationsystem` Bool,
	`Cruisecontrol` Bool,
	`Parktronic` Bool,
	`Climatecontrol` Bool,
	`PowerWindows` Bool,
	`steeringadjustment` Bool,

  PRIMARY KEY (`complectationId`),
  KEY `fk_complectations_bodystyles_idx` (`bodystyleId`),
  KEY `fk_complectations_colors_idx` (`drivetypeId`),
  KEY `fk_complectations_fueltypes_idx` (`fuelTypeId`),
  KEY `fk_complectations_models_idx` (`modelId`),
  KEY `fk_complectations_transmissions_idx` (`transmissionId`),
  KEY `fk_complectations_headlights_idx` (`headlightId`),
  CONSTRAINT `fk_complectations_bodystyles` FOREIGN KEY (`bodystyleId`) REFERENCES `bodystyles` (`bodystyleId`),
  CONSTRAINT `fk_complectations_drivetypes` FOREIGN KEY (`drivetypeId`) REFERENCES `drivetypes` (`drivetypeId`),
  CONSTRAINT `fk_complectations_fueltypes` FOREIGN KEY (`fuelTypeId`) REFERENCES `fueltypes` (`fuelTypeId`),
  CONSTRAINT `fk_complectations_models` FOREIGN KEY (`modelId`) REFERENCES `models` (`modelId`),
  CONSTRAINT `fk_complectations_transmissions` FOREIGN KEY (`transmissionId`) REFERENCES `transmissions` (`transmissionId`),
  CONSTRAINT `fk_complectations_headlights` FOREIGN KEY (`headlightId`) REFERENCES `headlights` (`headlightId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complectations`
--

LOCK TABLES `complectations` WRITE;
/*!40000 ALTER TABLE `complectations` DISABLE KEYS */;
INSERT INTO `complectations` (`complectationId`,
	`complectationName`,
	`modelId`,
	`bodystyleId`,
	`fueltypeId`,
	`transmissionId`,
	`drivetypeId`,
	`year`,
	`enginevolume`,
	`horsepower`,
	`acceleration`,
	`commonconsumption`,
	`cityconsumption`,
	`routeconsumption`,
	`length`,
	`width`,
	`maxspeed`,
	`headlightId`,

	`Electricheatingofthewindshield`,
	`Electricheatingofsidemirrors`,
	`Headlightwashersystem`,
	`Rainsensor`,
	`Foglight`,
	`Bluetooth`,
	`USB`,
	`AUX`,
	`Navigationsystem`,
	`Cruisecontrol`,
	`Parktronic`,
	`Climatecontrol` ,
	`PowerWindows`,
	`steeringadjustment`)
VALUES 
(1,'Basic',2,1,1,1,1,2018,1600,112,9.0,6.6,10.5,5.1,4333,1813,220,1,   1,0,1,0,1,0,1,0,1,0,1,0,1,0),
(2,'Drive',4,2,2,2,2,2011,2000,150,6.2,5.5,11.8,4.2,4222,1766,180,2,   0,1,0,1,0,1,0,1,0,1,0,1,0,1),
(3,'XXXXX',6,3,3,3,3,2012,1400,200,5.3,7.7,12.3,5.5,4111,1815,152,3,   1,0,1,0,1,0,1,0,1,0,1,0,1,0),
(4,'Life',7,4,4,1,1,2013,1500,102,11.2,8.8,14.7,6.0,4242,1788,166,1,   0,1,0,1,0,1,0,1,0,1,0,1,0,1),
(5,'Access',8,5,5,2,2,2013,2200,220,10.0,8.5,13.9,6.4,4343,1795,238,2, 1,0,1,0,1,0,1,0,1,0,1,0,1,0),
(6,'Style',9,6,1,2,3,2015,1800,110,9.8,7.6,12.8,4.2,4000,1800,146,3,   0,1,0,1,0,1,0,1,0,1,0,1,0,1),
(7,'Premium',23,7,2,3,1,2017,1900,168,7.8,9.9,12.0,5.1,4141,1759,166,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0),
(8,'Extreme',30,8,2,3,2,2017,2500,143,8.9,5.8,14.5,4.9,4500,1805,185,2,0,1,0,1,0,1,0,1,0,1,0,1,0,1),
(9,'Play',17,5,4,1,3,2018,2000,209,5.5,7.9,15.1,6.2,4312,1784,199,3,   1,0,1,0,1,0,1,0,1,0,1,0,1,0);
/*!40000 ALTER TABLE `complectations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addresses` (
  `addressId` int(11) NOT NULL AUTO_INCREMENT,
  `addressName` varchar(255) NOT NULL,
	`userId` INT(11) NOT NULL,
  PRIMARY KEY (`addressId`),
  KEY `fk_addresses_users_idx` (`userId`),
  CONSTRAINT `fk_addresses_users` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` (`addressId`, `addressName`, `userId`) 
VALUES 
(1,'address1',1),
(2,'address2',1),
(3,'address3',3);
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phones`
--

DROP TABLE IF EXISTS `phones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phones` (
  `phoneId` int(11) NOT NULL AUTO_INCREMENT,
  `phoneName` varchar(255) NOT NULL,
	`addressId` INT(11) NOT NULL,
  PRIMARY KEY (`phoneId`),
  KEY `fk_phones_addresses_idx` (`addressId`),
  CONSTRAINT `fk_phones_addresses` FOREIGN KEY (`addressId`) REFERENCES `addresses` (`addressId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phones`
--

LOCK TABLES `phones` WRITE;
/*!40000 ALTER TABLE `phones` DISABLE KEYS */;
INSERT INTO `phones` (`phoneId`, `phoneName`, `addressId`) 
VALUES 
(1,'123123123',1),
(2,'456456456',1),
(3,'789789789',2);
/*!40000 ALTER TABLE `phones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drivetypes`
--

DROP TABLE IF EXISTS `drivetypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drivetypes` (
  `drivetypeId` int(11) NOT NULL AUTO_INCREMENT,
  `drivetypeName` varchar(255) NOT NULL,
  PRIMARY KEY (`drivetypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drivetypes`
--

LOCK TABLES `drivetypes` WRITE;
/*!40000 ALTER TABLE `drivetypes` DISABLE KEYS */;
INSERT INTO `drivetypes` (`drivetypeId`, `drivetypeName`) 
VALUES 
(1,'full'),
(2,'front'),
(3,'back');
/*!40000 ALTER TABLE `drivetypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `optioncategories`
--

DROP TABLE IF EXISTS `optioncategories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `optioncategories` (
  `optioncategoryId` int(11) NOT NULL AUTO_INCREMENT,
  `optioncategoryName` varchar(255) NOT NULL,
  PRIMARY KEY (`optioncategoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `optioncategories`
--

LOCK TABLES `optioncategories` WRITE;
/*!40000 ALTER TABLE `optioncategories` DISABLE KEYS */;
INSERT INTO `optioncategories` (`optioncategoryId`, `optioncategoryName`) 
VALUES 
(1,'Электростеклоподъёмники задние'),
(2,'456456456'),
(3,'789789789'),
(4,'789789789'),
(5,'789789789'),
(6,'789789789'),
(7,'789789789');
/*!40000 ALTER TABLE `optioncategories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `options`
--

DROP TABLE IF EXISTS `options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `options` (
  `optionId` int(11) NOT NULL AUTO_INCREMENT,
  `optionName` varchar(255) NOT NULL,
	`optioncategoryId` INT(11) NOT NULL,
  PRIMARY KEY (`optionId`),
  KEY `fk_options_optioncategories_idx` (`optioncategoryId`),
  CONSTRAINT `fk_options_optioncategories` FOREIGN KEY (`optioncategoryId`) REFERENCES `optioncategories` (`optioncategoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `options`
--


LOCK TABLES `options` WRITE;
/*!40000 ALTER TABLE `options` DISABLE KEYS */;
INSERT INTO `options` (`optionId`, `optionName`, `optioncategoryId`) 
VALUES 
(1,'123123123',1),
(2,'456456456',1),
(3,'789789789',2),
(4,'789789789',2),
(5,'789789789',3),
(6,'789789789',3),
(7,'789789789',4),
(8,'789789789',5),
(9,'789789789',5);
/*!40000 ALTER TABLE `options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transmissions`
--

DROP TABLE IF EXISTS `transmissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transmissions` (
  `transmissionId` int(11) NOT NULL AUTO_INCREMENT,
  `transmissionName` varchar(255) NOT NULL,
  PRIMARY KEY (`transmissionId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transmissions`
--

LOCK TABLES `transmissions` WRITE;
/*!40000 ALTER TABLE `transmissions` DISABLE KEYS */;
INSERT INTO `transmissions` (`transmissionId`, `transmissionName`) VALUES (1,'automatic'),(2,'manual'),(3,'semi-automatic');
/*!40000 ALTER TABLE `transmissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`userId`),
  KEY `fk_users_roles_idx` (`roleId`),
  CONSTRAINT `fk_users_roles` FOREIGN KEY (`roleId`) REFERENCES `roles` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`userId`, `firstname`, `lastname`, `password`, `phone`, `username`, `email`, `roleId`) 
VALUES 
(1,'vgbhnj','vgbuhnjk','$2a$10$LGvWpOoFja/2gLBbPp/DQO.XTYlKfkF1RggMB3gj.kyGjU6r9y7by','3754851648','user','sdfsd@ef.th',2),
(3,'admin','admin','$2a$10$fGyOLUoXvi7sw/NP.ebZ1Obn5PkogN1PTvFru9k3qV62qRmIhaaVW','123456789','admin','sdsdv@dfg.yj',1),
(4,'Alex','Vino','$2a$10$bn6tstwYzUm2Gtr1cLlypet79fo27hks3COkj1shUzVZSwoNcfQ7m','6666666','vino','fhjhgj@df.yt',2);
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

-- Dump completed on 2018-05-24 16:28:57
