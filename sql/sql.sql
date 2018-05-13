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
INSERT INTO `bodystyles` (`bodystyleId`, `bodystyleName`) VALUES
  (1,'4x4'),(2,'convertible'),(3,'coupe'),(4,'estate'),
  (5,'hatchback'),(6,'people-carrier'),(7,'pick-up'),(8,'saloon');
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
  `mileage` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `bodystyleId` int(11) NOT NULL,
  `colorId` int(11) NOT NULL,
  `fuelTypeId` int(11) NOT NULL,
  `modelId` int(11) NOT NULL,
  `transmissionId` int(11) NOT NULL,
  `engine` FLOAT(11) NOT NULL,
  `image` MEDIUMBLOB,
  `description` TEXT,
  PRIMARY KEY (`carId`),
  KEY `fk_cars_bodystyles_idx` (`bodystyleId`),
  KEY `fk_cars_colors_idx` (`colorId`),
  KEY `fk_cars_fueltypes_idx` (`fuelTypeId`),
  KEY `fk_cars_models_idx` (`modelId`),
  KEY `fk_cars_transmissions_idx` (`transmissionId`),
  CONSTRAINT `fk_cars_bodystyles` FOREIGN KEY (`bodystyleId`) REFERENCES `bodystyles` (`bodystyleId`),
  CONSTRAINT `fk_cars_colors` FOREIGN KEY (`colorId`) REFERENCES `colors` (`colorId`),
  CONSTRAINT `fk_cars_fueltypes` FOREIGN KEY (`fuelTypeId`) REFERENCES `fueltypes` (`fuelTypeId`),
  CONSTRAINT `fk_cars_models` FOREIGN KEY (`modelId`) REFERENCES `models` (`modelId`),
  CONSTRAINT `fk_cars_transmissions` FOREIGN KEY (`transmissionId`) REFERENCES `transmissions` (`transmissionId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` (`mileage`, `price`, `year`, `bodystyleId`, `colorId`, `fuelTypeId`,
                    `modelId`, `transmissionId`, `engine`, `description`) VALUES
  (500,2000,2001,1,2,3,4,1,1,'Insurance Group 31, Adjustable steering column, Alarm, Anti lock braking system, Central locking, Climate control, Drivers airbag, Electric mirrors, Front Electric windows, Front fog lights, Passenger airbag, Power assisted steering, Radio/CD, Rear Electric windows, Remote Central Locking, Side airbag,This car is in lovely condition and has been really looked after ,viewing essential . GOOGLE OUR PHONE NUMBER !! '),
  (200,1000,1998,1,3,1,2,2,2.2,'car maybe'),
  (300,1500,2003,1,2,3,4,1,3.2,'car car car.'),
  (1000,1500,2003,1,2,3,28,1,2.2,'hi'),
  (300,5000,2004,2,3,2,26,1,1.8,'very expensive!!'),
  (300,1500,2005,3,8,1,15,3,1.5,'^_^'),
  (300,1500,2006,4,10,3,10,1,2.2,'rdftugyiunkml'),
  (300,1500,2006,5,2,4,3,3,1.8,'tvybiuno'),
  (300,1500,2003,6,6,5,16,1,5,'-------->      $_$'),
  (300,1500,2002,7,8,3,20,2,2.2,'car caaaaaar'),
  (300,1500,1998,8,7,1,7,1,2,'Insurance Group 31, Adjustable steering column, Alarm, Anti lock braking system, Central locking, Climate control, Drivers airbag, Electric mirrors, Front Electric windows, Front fog lights, Passenger airbag, Power assisted steering, Radio/CD, Rear Electric windows, Remote Central Locking, Side airbag,This car is in lovely condition and has been really looked after ,viewing essential . GOOGLE OUR PHONE NUMBER !! ');
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
INSERT INTO `colors` (`colorId`, `colorName`) VALUES (1,'beige'),(2,'black'),(3,'blue'),(4,'green'),(5,'gray'),(6,'orange'),(7,'pink'),(8,'purple'),(9,'red'),(10,'silver');
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
INSERT INTO `fueltypes` (`fuelTypeId`, `fuelTypeName`) VALUES
  (1,'petrol'),(2,'petrol-electric-hybrid'),(3,'diesel'),(4,'diesel-electric-hybrid'),(5,'electric');
/*!40000 ALTER TABLE `fueltypes` ENABLE KEYS */;
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
INSERT INTO `makes` (`makeId`, `makeName`) VALUES
  (1,'Audi'),(2,'Ford'),(3,'Mazda'),(4,'Nissan'),(5,'Opel'),(6,'Pegeout'),(7,'Renault'),(8,'Tesla');
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `models`
--

LOCK TABLES `models` WRITE;
/*!40000 ALTER TABLE `models` DISABLE KEYS */;
INSERT INTO `models` (`modelId`, `makeId`, `modelName`) VALUES
  (1,1,'A4'),(2,1,'A6'),(3,1,'A7'),(4,1,'Q7'),(5,1,'TT'),
  (6,2,'Escort'),(7,2,'Fiesta'),(8,2,'Focus'),(9,2,'GT'),(10,2,'Mustang'),
  (11,3,'3'),(12,3,'6'),(13,3,'CX-5'),
  (14,4,'Patrol'),(15,4,'Skyline'),(16,4,'Qashqai'),(17,4,'Micra'),(18,4,'Leaf'),
  (19,5,'Astra'),(20,5,'Frontera'),(21,5,'Mokka'),(22,5,'Corsa'),
  (23,6,'Boxer'),(24,6,'807'),(25,6,'407'),
  (26,7,'Logan'),(27,7,'Megane'),(28,7,'Master'),(29,7,'Captur'),(30,7,'Clio'),
  (31,8,'Model S'),(32,8,'Model X');
/*!40000 ALTER TABLE `models` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_orders_cars_idx` (`carId`),
  KEY `fk_orders_users_idx` (`userId`),
  CONSTRAINT `fk_orders_cars` FOREIGN KEY (`carId`) REFERENCES `cars` (`carId`),
  CONSTRAINT `fk_orders_users` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`roleId`, `roleName`) VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
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
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`userId`),
  KEY `fk_users_roles_idx` (`roleId`),
  CONSTRAINT `fk_users_roles` FOREIGN KEY (`roleId`) REFERENCES `roles` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`userId`, `firstname`, `lastname`, `password`, `phone`, `username`, `roleId`) VALUES
  (1,'vgbhnj','vgbuhnjk','$2a$10$LGvWpOoFja/2gLBbPp/DQO.XTYlKfkF1RggMB3gj.kyGjU6r9y7by','3754851648','user',2),
  (3,'admin','admin','$2a$10$fGyOLUoXvi7sw/NP.ebZ1Obn5PkogN1PTvFru9k3qV62qRmIhaaVW','123456789','admin',2);
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

-- Dump completed on 2018-05-11 17:27:10
