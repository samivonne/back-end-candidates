-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: heb
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `candidate`
--

DROP TABLE IF EXISTS `candidate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `candidate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `firstName` varchar(20) DEFAULT NULL,
  `lastName` varchar(20) DEFAULT NULL,
  `streetAddress` varchar(50) DEFAULT NULL,
  `zipCode` varchar(10) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `phoneNumber` varchar(12) DEFAULT NULL,
  `githubLink` varchar(50) DEFAULT NULL,
  `resume` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate`
--

LOCK TABLES `candidate` WRITE;
/*!40000 ALTER TABLE `candidate` DISABLE KEYS */;
INSERT INTO `candidate` VALUES (1,'jbutt@gmail.com','100556','James','Butt','6649 N Blue Gum St','70116','LA','New Orleans','504-621-8927','http://www.bentonjohnbjr.com',NULL),(2,'josephine_darakjy@darakjy.org','669829','Josephine','Darakjy','4 B Blue Ridge Blvd','48116','MI','Brighton','810-292-9388','http://www.chanayjeffreyaesq.com',NULL),(3,'art@venere.org','498100','Art','Venere','8 W Cerritos Ave #54','08014','NJ','Bridgeport','856-636-8749','http://www.chemeljameslcpa.com',NULL),(4,'lpaprocki@hotmail.com','560963','Lenna','Paprocki','639 Main St','99501','AK','Anchorage','907-385-4412','http://www.feltzprintingservice.com',NULL),(5,'donette.foller@cox.net','273753','Donette','Foller','34 Center St','45011','OH','Hamilton','513-570-1893','http://www.printingdimensions.com',NULL),(6,'simona@morasca.com','680721','Simona','Morasca','3 Mcauley Dr','44805','OH','Ashland','419-503-2484','http://www.chapmanrosseesq.com',NULL),(7,'mitsue_tollner@yahoo.com','272020','Mitsue','Tollner','7 Eads St','60632','IL','Chicago','773-573-6914','http://www.morlongassociates.com',NULL),(8,'leota@hotmail.com','136788','Leota','Dilliard','7 W Jackson Blvd','95111','CA','San Jose','408-752-3500','http://www.commercialpress.com',NULL),(9,'sage_wieser@cox.net','130019','Sage','Wieser','5 Boston Ave #88','57105','SD','Sioux Falls','605-414-2147','http://www.truhlarandtruhlarattys.com',NULL),(10,'kris@gmail.com','271064','Kris','Marrier','228 Runamuck Pl #2808','21224','MD','Baltimore','410-655-8723','http://www.kingchristopheraesq.com',NULL),(11,'minna_amigon@yahoo.com','634412','Minna','Amigon','2371 Jerrold Ave','19443','PA','Kulpsville','215-874-1229','http://www.dorljamesjesq.com',NULL),(12,'amaclead@gmail.com','221276','Abel','Maclead','37275 St  Rt 17m M','11953','NY','Middle Island','631-335-3414','http://www.rangoniofflorence.com',NULL),(13,'kiley.caldarera@aol.com','401101','Kiley','Caldarera','25 E 75th St #69','90034','CA','Los Angeles','310-498-5651','http://www.feinerbros.com',NULL),(14,'gruta@cox.net','335797','Graciela','Ruta','98 Connecticut Ave Nw','44023','OH','Chagrin Falls','440-780-8425','http://www.buckleymillerwright.com',NULL),(15,'calbares@gmail.com','197745','Cammy','Albares','56 E Morehead St','78045','TX','Laredo','956-537-6195','http://www.rousseauxmichaelesq.com',NULL),(16,'mattie@aol.com','446629','Mattie','Poquette','73 State Road 434 E','85013','AZ','Phoenix','602-277-4385','http://www.centurycommunications.com',NULL),(17,'meaghan@hotmail.com','113386','Meaghan','Garufi','69734 E Carrillo St','37110','TN','Mc Minnville','931-313-9635','http://www.boltonwilburesq.com',NULL),(18,'gladys.rim@rim.org','431248','Gladys','Rim','322 New Horizon Blvd','53207','WI','Milwaukee','414-661-9598','http://www.tmbyxbeecompanypc.com',NULL),(19,'yuki_whobrey@aol.com','634968','Yuki','Whobrey','1 State Route 27','48180','MI','Taylor','313-288-7937','http://www.farmersinsurancegroup.com',NULL),(20,'fletcher.flosi@yahoo.com','565904','Fletcher','Flosi','394 Manchester Blvd','61109','IL','Rockford','815-828-2147','http://www.postboxservicesplus.com',NULL),(21,'bette_nicka@cox.net','146817','Bette','Nicka','6 S 33rd St','19014','PA','Aston','610-545-3615','http://www.sportenart.com',NULL),(22,'vinouye@aol.com','298071','Veronika','Inouye','6 Greenleaf Ave','95111','CA','San Jose','408-540-1785','http://www.cnetworkinc.com',NULL),(23,'willard@hotmail.com','556622','Willard','Kolmetz','618 W Yakima Ave','75062','TX','Irving','972-303-9197','http://www.ingallsdonaldresq.com',NULL),(24,'mroyster@royster.com','632743','Maryann','Royster','74 S Westgate St','12204','NY','Albany','518-966-7987','http://www.franklinpeterlesq.com',NULL),(25,'alisha@slusarski.com','295963','Alisha','Slusarski','3273 State St','08846','NJ','Middlesex','732-658-3154','http://www.wtlzpowerfm.com',NULL),(26,'allene_iturbide@cox.net','930897','Allene','Iturbide','1 Central Ave','54481','WI','Stevens Point','715-662-6764','http://www.ledeckydavidesq.com',NULL),(27,'chanel.caudy@caudy.org','706493','Chanel','Caudy','86 Nw 66th St #8673','66218','KS','Shawnee','913-388-2079','http://www.professionalimageinc.com',NULL),(28,'ezekiel@chui.com','111343','Ezekiel','Chui','2 Cedar Ave #84','21601','MD','Easton','410-669-1642','http://www.siderdonaldcesq.com',NULL),(29,'wkusko@yahoo.com','031835','Willow','Kusko','90991 Thorburn Ave','10011','NY','New York','212-582-4976','http://www.upullit.com',NULL),(30,'bfigeroa@aol.com','556111','Bernardo','Figeroa','386 9th Ave N','77301','TX','Conroe','936-336-3951','http://www.clarkrichardcpa.com',NULL);
/*!40000 ALTER TABLE `candidate` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-18 15:25:49
