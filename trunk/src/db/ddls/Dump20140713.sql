CREATE DATABASE  IF NOT EXISTS `linkalma` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `linkalma`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win32 (x86)
--
-- Host: localhost    Database: linkalma
-- ------------------------------------------------------
-- Server version	5.6.11-enterprise-commercial-advanced-log

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
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `CommentID` int(11) NOT NULL AUTO_INCREMENT,
  `GroupID` int(20) DEFAULT NULL,
  `TopicID` int(20) DEFAULT NULL,
  `ActiveYN` char(1) DEFAULT NULL,
  `CreateUserID` int(20) DEFAULT NULL,
  `CreateDttm` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `UpdateUserID` int(20) DEFAULT NULL,
  `UpdateDttm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`CommentID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donation`
--

DROP TABLE IF EXISTS `donation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `donation` (
  `DonationID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(20) DEFAULT NULL,
  `SchoolID` int(20) DEFAULT NULL,
  `Amount` int(10) DEFAULT NULL,
  `Currency` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`DonationID`),
  KEY `SchoolID` (`SchoolID`),
  KEY `UserID` (`UserID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donation`
--

LOCK TABLES `donation` WRITE;
/*!40000 ALTER TABLE `donation` DISABLE KEYS */;
/*!40000 ALTER TABLE `donation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friendrequest`
--

DROP TABLE IF EXISTS `friendrequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friendrequest` (
  `FriendRequestID` int(11) NOT NULL AUTO_INCREMENT,
  `FromUserID` int(11) NOT NULL,
  `ToUserID` int(11) DEFAULT NULL,
  `Status` int(1) DEFAULT NULL,
  `RequestSentDTTM` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`FriendRequestID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friendrequest`
--

LOCK TABLES `friendrequest` WRITE;
/*!40000 ALTER TABLE `friendrequest` DISABLE KEYS */;
/*!40000 ALTER TABLE `friendrequest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupmembers`
--

DROP TABLE IF EXISTS `groupmembers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groupmembers` (
  `GroupID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(13) NOT NULL,
  PRIMARY KEY (`GroupID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupmembers`
--

LOCK TABLES `groupmembers` WRITE;
/*!40000 ALTER TABLE `groupmembers` DISABLE KEYS */;
/*!40000 ALTER TABLE `groupmembers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grouprequest`
--

DROP TABLE IF EXISTS `grouprequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grouprequest` (
  `GroupRequestID` int(11) NOT NULL AUTO_INCREMENT,
  `FromUserID` int(11) NOT NULL,
  `ForGroupID` int(11) NOT NULL,
  `Status` int(1) DEFAULT NULL,
  `RequestSentDTTM` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`GroupRequestID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grouprequest`
--

LOCK TABLES `grouprequest` WRITE;
/*!40000 ALTER TABLE `grouprequest` DISABLE KEYS */;
/*!40000 ALTER TABLE `grouprequest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `GroupID` int(11) NOT NULL AUTO_INCREMENT,
  `GroupName` varchar(255) DEFAULT NULL,
  `GroupAdmin` varchar(255) DEFAULT NULL,
  `SchoolID` varchar(255) DEFAULT NULL,
  `GroupType` varchar(255) DEFAULT NULL COMMENT 'Custom OR Alumni',
  `PublicViewYN` char(1) DEFAULT NULL,
  PRIMARY KEY (`GroupID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages` (
  `MessageID` int(13) NOT NULL AUTO_INCREMENT,
  `FromUserID` int(13) NOT NULL,
  `DestinationType` varchar(10) NOT NULL COMMENT 'Group or User',
  `DestinationID` int(13) NOT NULL COMMENT 'GroupID or UserID',
  PRIMARY KEY (`MessageID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referrals`
--

DROP TABLE IF EXISTS `referrals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referrals` (
  `ReferralID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(20) DEFAULT NULL,
  `ReferralEmailID` varchar(40) DEFAULT NULL,
  `ReferralName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ReferralID`),
  KEY `ReferralEmailID` (`ReferralEmailID`),
  KEY `UserID` (`UserID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referrals`
--

LOCK TABLES `referrals` WRITE;
/*!40000 ALTER TABLE `referrals` DISABLE KEYS */;
/*!40000 ALTER TABLE `referrals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school`
--

DROP TABLE IF EXISTS `school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `school` (
  `SchoolID` int(20) NOT NULL AUTO_INCREMENT,
  `SchoolName` varchar(255) DEFAULT NULL,
  `Address1` varchar(255) DEFAULT NULL,
  `Address2` varchar(255) DEFAULT NULL,
  `Branch` varchar(255) DEFAULT NULL,
  `EmailAddress` varchar(40) DEFAULT NULL,
  `WebsiteURL` varchar(255) DEFAULT NULL,
  `LinkAlmaURL` varchar(255) DEFAULT NULL,
  `Approved` char(1) DEFAULT NULL,
  `ActiveYN` char(1) DEFAULT NULL,
  `CreateDttm` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `CreateUserID` int(20) DEFAULT NULL,
  `UpdateDttm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UpdateUserID` int(20) DEFAULT NULL,
  `LogoFileName` varchar(45) DEFAULT NULL,
  `AdminName` varchar(45) DEFAULT NULL,
  `SchoolHistory` varchar(5000) DEFAULT NULL,
  `Phone1` int(13) DEFAULT NULL,
  `Phone2` int(13) DEFAULT NULL,
  PRIMARY KEY (`SchoolID`),
  KEY `CreateUserID` (`CreateUserID`),
  KEY `UpdateUserID` (`UpdateUserID`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES (1,'SVP','SM Road','Kandivali','KandivaliWest','admin@svpvv.com','www.svpvv.com','svpvv','Y','Y','2014-03-23 19:41:04',NULL,'2014-05-31 19:12:07',NULL,NULL,NULL,'Most of human history lies in pre-history, the period before the use of writing, and before written history. In pre-literate societies, education was achieved through demonstration and copying as the young learned from their elders. Rural communities had few resources to expend on education, and there was a lack of commercially available products for schools. At later stages they received instruction of a more structured and formal nature, imparted by people not necessarily related, in the context of initiation, religion or ritual.[2][3][4] Some forms of traditional knowledge were expressed through stories, legends, folklore, rituals, and songs, without the need for a writing system. Tools to aid this process include poetic devices such as rhyme and alliteration. These methods are illustrative of orality. The stories thus preserved are also referred to as part of an oral tradition.[citation needed]',1234,1234),(2,'Francis','IC Colony','Borivali','Borivali West','admin@francis.com','francis.com','francis','Y','Y','2014-03-23 19:41:04',NULL,'2014-05-31 19:12:07',NULL,NULL,NULL,'Saint Francis School, a private Catholic school founded in 1924, provides a college preparatory program. With an enrollment limited to just over 500 in grades PK through 12, Saint Francis School offers an education based on academic promise and does not discriminate based on ethnicity, religion or socioeconomic status. Students from all over Hawaii, the U.S. mainland, Asia and around the world reap the benefits of our academically sound curriculum which develops the whole person: mind, body and spirit',123,33333),(3,'BIT','Worli','Worli',NULL,'admin@bit.com',NULL,NULL,'Y','Y','2014-03-23 20:02:53',NULL,'2014-05-31 19:12:07',NULL,NULL,NULL,NULL,NULL,NULL),(4,'KJ Somaiya','Vidyavihar','Worli',NULL,'admin@kj.com',NULL,NULL,'Y','Y','2014-03-23 20:07:55',NULL,'2014-05-31 19:12:07',NULL,NULL,NULL,NULL,NULL,NULL),(5,'Vartak','Vasai','Vasai',NULL,'admin@vartak.com',NULL,NULL,'Y','Y','2014-03-23 20:10:22',NULL,'2014-05-31 19:12:07',NULL,NULL,NULL,NULL,NULL,NULL),(6,'VJTI','Matunga','Matunga',NULL,'admin@vjti.com',NULL,NULL,'Y','Y','2014-03-23 20:16:40',NULL,'2014-05-31 19:12:07',NULL,NULL,NULL,NULL,NULL,NULL),(9,'St Annes High School','Orlem','Malad',NULL,'ANNES@GMAIL.COM',NULL,NULL,'Y','Y','2014-05-31 19:12:07',0,'2014-05-31 19:12:07',0,NULL,NULL,NULL,NULL,NULL),(11,'Ryan International','Chakan','Chakan - Talegaon Road',NULL,'ryan-pune@ryan.com',NULL,NULL,'Y','Y','2014-05-31 19:12:07',0,'2014-05-31 19:12:07',0,NULL,NULL,NULL,NULL,NULL),(18,'Dajiraj High School','SurendraNagar District ','Gujarat','Wadhwan','admin@dajiraj.com','www.dajiraj.com','dajiraj ','Y','Y','2014-06-08 05:10:45',0,'2014-06-08 05:13:26',0,'LOGO.jpg',NULL,'This is school thing...History of dajiraj highschool\r\nEstd : 1935',NULL,NULL),(17,'VIIT','Camp Road','Cantonment, Pune','Pune','admin@viit.com','www.viit.com','viit','Y','Y','2014-06-02 19:20:51',0,'2014-06-02 19:20:51',0,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolcredentials`
--

DROP TABLE IF EXISTS `schoolcredentials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schoolcredentials` (
  `SchoolID` int(11) NOT NULL,
  `Password` varchar(1024) NOT NULL,
  `EmailAddress` varchar(255) NOT NULL,
  PRIMARY KEY (`SchoolID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolcredentials`
--

LOCK TABLES `schoolcredentials` WRITE;
/*!40000 ALTER TABLE `schoolcredentials` DISABLE KEYS */;
INSERT INTO `schoolcredentials` VALUES (17,'1bb653e920bfaa6b451999ddbb17ee956b856c0f51068f3c024cc41897646ccf711c8b637011132502825507e279520ded0d4fa0e5ec53ab7acaff1f0e8fc0b9','admin@viit.com'),(18,'1bb653e920bfaa6b451999ddbb17ee956b856c0f51068f3c024cc41897646ccf711c8b637011132502825507e279520ded0d4fa0e5ec53ab7acaff1f0e8fc0b9','admin@dajiraj.com');
/*!40000 ALTER TABLE `schoolcredentials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schooldata`
--

DROP TABLE IF EXISTS `schooldata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schooldata` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `SchoolID` int(20) NOT NULL,
  `Type` int(4) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `DocumentName` varchar(255) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `CreateUserID` int(20) DEFAULT NULL,
  `CreateDttm` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `UpdateUserID` int(20) DEFAULT NULL,
  `UpdateDttm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Grade` varchar(45) DEFAULT NULL,
  `Division` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='To Store School Curriculum, Calendar, Exams, Projects etc';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schooldata`
--

LOCK TABLES `schooldata` WRITE;
/*!40000 ALTER TABLE `schooldata` DISABLE KEYS */;
INSERT INTO `schooldata` VALUES (1,1,1,'Syllabus desc','Design Pattern.jpg','Syllabus',NULL,'2014-05-31 19:12:09',0,'0000-00-00 00:00:00',NULL,NULL),(2,1,2,'Calendar DEsc','Design Pattern.jpg','Calendar ',NULL,'2014-05-31 19:12:09',0,'0000-00-00 00:00:00',NULL,NULL),(3,1,3,'MId term exams starting June 1','Design Pattern.jpg','Mid Term Exams',0,'2014-05-23 09:52:29',0,'2014-05-23 09:52:29','8th ','A'),(4,1,1,'','','',0,'2014-06-01 09:51:56',0,'2014-06-01 09:51:56',NULL,NULL),(5,18,1,'Syllabus','LinkAlma (1).pptx','Dajiraj Syllabus',0,'2014-06-08 16:50:37',0,'2014-06-08 16:50:37',NULL,NULL);
/*!40000 ALTER TABLE `schooldata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolgallery`
--

DROP TABLE IF EXISTS `schoolgallery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schoolgallery` (
  `PhotoID` int(11) NOT NULL AUTO_INCREMENT,
  `SchoolID` int(11) NOT NULL,
  `AlbumName` varchar(255) DEFAULT NULL,
  `PhotoName` varchar(255) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `CreateDttm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`PhotoID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolgallery`
--

LOCK TABLES `schoolgallery` WRITE;
/*!40000 ALTER TABLE `schoolgallery` DISABLE KEYS */;
INSERT INTO `schoolgallery` VALUES (1,18,'kenil_album','1601489_752541591430669_1019725964_n.jpg','My first album...','2014-07-02 18:48:31'),(2,18,'kenil_album','1000962_752553311429497_1313399829_n - Copy.jpg','My first album...','2014-07-02 18:48:31'),(3,18,'kenil_album','1798641_752560531428775_168469215_n.jpg','My first album...','2014-07-02 18:48:31'),(4,18,'My Bday Album','95f509c5-ad84-4248-b2f2-3dc13ce4f814.jpg','Bday 2013, 2014','2014-07-05 07:01:13'),(5,18,'My Bday Album','Design Pattern.jpg','Bday 2013, 2014','2014-07-05 07:01:14'),(6,18,'My Bday Album','Rsons.png','Bday 2013, 2014','2014-07-05 07:01:14');
/*!40000 ALTER TABLE `schoolgallery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolupdates`
--

DROP TABLE IF EXISTS `schoolupdates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schoolupdates` (
  `SchoolUpdatesID` int(20) NOT NULL AUTO_INCREMENT,
  `SchoolID` int(20) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Description` varchar(5000) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `CreateUserID` int(20) DEFAULT NULL,
  `CreateDttm` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `UpdateUserID` int(20) DEFAULT NULL,
  `UpdateDttm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`SchoolUpdatesID`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolupdates`
--

LOCK TABLES `schoolupdates` WRITE;
/*!40000 ALTER TABLE `schoolupdates` DISABLE KEYS */;
INSERT INTO `schoolupdates` VALUES (5,1,'Mumbai Mirror','4/25/2013 – Del Mar Times – Solana Beach Residents Leads Ultra Division Team in Long-Distance Ragnar Relay, 10 New San Diego – Monarch School Opens New Campus','2',0,'2014-05-19 16:21:25',0,'2014-05-31 19:12:09'),(6,2,' Hera Hub Online','4/25/2013 – Hera Hub Online – From Inspiration to Action: The Monarch School Opens Doors to New Facility, Fox 5 San Diego – School for Homeless Kids Expands to Meet Growing Need','2',1,'2014-05-19 16:23:05',1,'2014-05-31 19:12:09'),(7,2,'Times Of India','Union Tribune San Diego – New School for Homeless Opens, 4/22/2013 – Union Tribune San Diego – Women’s Foundation Volunteer Cares by Taking Care of Details','2',1,'2014-05-19 16:27:29',1,'2014-05-31 19:12:09'),(8,2,'Newsletter Title 5','Newsletter Desc 5','2',1,'2014-05-19 16:29:18',1,'2014-05-31 19:12:09'),(9,2,'Newsletter Title 6','Newletter Desc 6','2',1,'2014-05-19 16:29:52',1,'2014-05-31 19:12:09'),(10,1,'Lets Start','Lets start','1',1,'2014-05-19 16:31:56',1,'2014-05-31 19:12:09'),(11,1,'Times Of India','4/25/2013 – Hera Hub Online – From Inspiration to Action: The Monarch School Opens Doors to New Facility, Fox 5 San Diego – School for Homeless Kids Expands to Meet Growing Need','2',1,'2014-05-19 16:34:05',1,'2014-05-31 19:12:09'),(12,1,'Mumbai Mirror','4/25/2013 – Hera Hub Online – From Inspiration to Action: The Monarch School Opens Doors to New Facility, Fox 5 San Diego – School for Homeless Kids Expands to Meet Growing Need','2',1,'2014-05-19 18:44:27',1,'2014-05-31 19:12:09'),(13,2,'Lets Start2','Lets start desc 2','3',1,'2014-05-19 18:46:34',1,'2014-05-31 19:12:09'),(14,1,'Yoga “Glow-in-the-Night” Charity Yoga Event','Location: Monarch School Nat and Flora Bosa Campus – 1625 Newton Ave., San Diego, CA 92113  More info: Please join us for a fun-filled charity yoga event to bring out the kid in each of us. 100% of the proceeds benefit Ryan School! ','3',1,'2014-05-21 16:34:04',1,'2014-05-31 19:12:09'),(15,1,'Tango and Malambo Night','1845 Strand Way, Coronado, CA 92118 - The Rotary Club of Coronado cordially invites you to a fundraising night to benefit the children of the BLCI & Monarch School. Join us for a night of food, drinks & Tango!','3',1,'2014-05-21 16:34:18',1,'2014-05-31 19:12:09'),(16,1,'Yoga “Glow-in-the-Night” Charity Yoga Event','Location: Monarch School Nat and Flora Bosa Campus – 1625 Newton Ave., San Diego, CA 92113  More info: Please join us for a fun-filled charity yoga event to bring out the kid in each of us. 100% of the proceeds benefit Ryan School! ','3',1,'2014-05-21 16:34:31',1,'2014-05-31 19:12:09'),(17,1,'Project 2','Roughness is an important aspect of the condition of our highways, as it affects the quality of the ride and the user’s perception of the pavement’s condition. It is important to adequately measure and control the quality of pavement roughness.','1',1,'2014-05-21 16:34:38',1,'2014-05-31 19:12:09'),(18,1,'Project 3','Roughness is an important aspect of the condition of our highways, as it affects the quality of the ride and the user’s perception of the pavement’s condition. It is important to adequately measure and control the quality of pavement roughness.','1',1,'2014-05-21 16:34:47',1,'2014-05-31 19:12:09'),(19,1,'Go Live on Test Server','Live on test server','1',0,'2014-06-01 04:58:14',0,'2014-06-01 04:58:14'),(20,17,'Adding News letter','1st news letter ','1',0,'2014-06-02 19:31:57',0,'2014-06-02 19:31:57'),(21,17,'','','1',0,'2014-06-02 19:32:01',0,'2014-06-02 19:32:01'),(22,17,'','','1',0,'2014-06-02 19:46:00',0,'2014-06-02 19:46:00'),(23,17,'asd','asd','1',0,'2014-06-02 19:46:22',0,'2014-06-02 19:46:22'),(24,17,'wasyp ','wasasdas','2',0,'2014-06-02 19:46:50',0,'2014-06-02 19:46:50'),(25,17,'Really.. news','Good News','1',0,'2014-06-02 19:48:40',0,'2014-06-02 19:48:40'),(26,17,'Adding News letter','kkkkkkkkkkkkkkkk','1',0,'2014-06-02 19:50:58',0,'2014-06-02 19:50:58'),(27,18,'New Newletter','ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;ORDER BY CREATEDTTM DESC;','1',0,'2014-06-23 18:29:58',0,'2014-06-23 18:29:58');
/*!40000 ALTER TABLE `schoolupdates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `StaffID` int(11) NOT NULL AUTO_INCREMENT,
  `SchoolID` int(11) NOT NULL,
  `FacultyName` varchar(255) NOT NULL,
  `FacultyEmail` varchar(255) NOT NULL,
  `SubjectArea` varchar(1024) NOT NULL,
  `PhotoName` varchar(255) DEFAULT NULL,
  `CreateDttm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`StaffID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,18,'Rohini Malhotra New','rohini@gmail.com','Communication Skills','1601021_752570968094398_763432881_n.jpg','2014-07-02 18:55:55'),(2,18,'Sangeeta Srivastava','san_2002@yahoo.com','Social Studies','DSC_0471.jpg','2014-07-07 18:15:49');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staticcodes`
--

DROP TABLE IF EXISTS `staticcodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staticcodes` (
  `CategoryID` int(11) NOT NULL,
  `Code` int(10) NOT NULL,
  `PrimaryDecode` varchar(30) DEFAULT NULL,
  `SecondaryDecode` varchar(60) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staticcodes`
--

LOCK TABLES `staticcodes` WRITE;
/*!40000 ALTER TABLE `staticcodes` DISABLE KEYS */;
INSERT INTO `staticcodes` VALUES (1,1,'SchoolAdmin','Role'),(1,3,'Linkalma Admin','Role'),(1,2,'Alumni','Role'),(2,4,'Exams','SchoolData'),(3,1,'Projects','SchoolUpdates'),(2,2,'Calendar','SchoolData'),(2,1,'Syllabus','SchoolData'),(3,2,'Newsletter','SchoolUpdates'),(3,3,'Events','SchoolUpdates');
/*!40000 ALTER TABLE `staticcodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topics`
--

DROP TABLE IF EXISTS `topics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topics` (
  `TopicID` int(20) NOT NULL AUTO_INCREMENT,
  `TopicTitle` varchar(255) DEFAULT NULL,
  `TopicCategory` varchar(255) DEFAULT NULL,
  `CreateUserID` int(20) DEFAULT NULL,
  `CreateDttm` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `UpdateUserID` int(20) DEFAULT NULL,
  `UpdateDttm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`TopicID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topics`
--

LOCK TABLES `topics` WRITE;
/*!40000 ALTER TABLE `topics` DISABLE KEYS */;
/*!40000 ALTER TABLE `topics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `UserID` int(20) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) NOT NULL,
  `MiddleName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `Address1` varchar(255) DEFAULT NULL,
  `Address2` varchar(255) DEFAULT NULL,
  `CountryCode` varchar(4) DEFAULT NULL,
  `Phone1` bigint(20) DEFAULT NULL,
  `Phone2` bigint(20) DEFAULT NULL,
  `Phone3` bigint(20) DEFAULT NULL,
  `Phone4` bigint(20) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `City` varchar(30) DEFAULT NULL,
  `State` varchar(30) DEFAULT NULL,
  `Country` varchar(30) DEFAULT NULL,
  `EmailAddress` varchar(255) NOT NULL,
  `DOB` date DEFAULT NULL,
  `AboutMe` varchar(255) DEFAULT NULL,
  `RoleID` int(5) DEFAULT NULL,
  `Photo` varchar(255) DEFAULT NULL,
  `Approved` char(1) DEFAULT NULL,
  `ActiveYN` char(1) DEFAULT NULL,
  `CreateDttm` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `UpdateDttm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ZipCode` int(8) DEFAULT NULL,
  `PhoneCode1` int(4) DEFAULT NULL,
  `PhoneCode2` int(4) DEFAULT NULL,
  `PhoneCode3` int(4) DEFAULT NULL,
  `PhoneCode4` int(4) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=MyISAM AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'Kenil',NULL,'Doshi','ddgdfg','gdgfd','0',33,222,111,0,NULL,'fdgfd','gfgdaa','sdfssss','crispykenil@gmail.com',NULL,NULL,2,NULL,NULL,NULL,'2014-06-01 11:09:11','2014-07-12 16:38:24',400067,91,22,22,0),(22,'Kenil',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'kd@yahoo.com',NULL,NULL,2,NULL,NULL,NULL,'2014-06-01 16:32:45','2014-06-01 16:32:45',NULL,NULL,NULL,NULL,NULL),(23,'Mayank',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'mayank@gmail.com',NULL,NULL,2,NULL,NULL,NULL,'2014-06-14 07:39:29','2014-06-14 07:39:29',NULL,NULL,NULL,NULL,NULL),(24,'Jyoti',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'jyoti.doshi@gmail.com',NULL,NULL,2,NULL,NULL,NULL,'2014-06-14 08:13:55','2014-06-14 08:13:55',NULL,NULL,NULL,NULL,NULL),(25,'asd',NULL,'kjh',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'jkh@gmail.com',NULL,NULL,2,NULL,NULL,NULL,'2014-06-14 08:14:27','2014-06-14 08:14:27',NULL,NULL,NULL,NULL,NULL),(26,'asd',NULL,'jhg',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'jjj@gmail.com',NULL,NULL,2,NULL,NULL,NULL,'2014-06-14 08:16:07','2014-06-14 08:16:07',NULL,NULL,NULL,NULL,NULL),(27,'ii',NULL,'kk',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'hh@gmail.com',NULL,NULL,2,NULL,NULL,NULL,'2014-06-14 08:16:53','2014-06-14 08:16:53',NULL,NULL,NULL,NULL,NULL),(28,'aaa',NULL,'kkk',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'ikik@gma.com',NULL,NULL,2,NULL,NULL,NULL,'2014-06-14 08:18:36','2014-06-14 08:18:36',NULL,NULL,NULL,NULL,NULL),(29,'kjh',NULL,'kjh',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'kjk@gmail.com',NULL,NULL,2,NULL,NULL,NULL,'2014-06-14 08:25:35','2014-06-14 08:25:35',NULL,NULL,NULL,NULL,NULL),(30,'KenilEmail',NULL,'DoshiEmail',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'email@gmail.com',NULL,NULL,2,NULL,NULL,NULL,'2014-06-14 09:50:07','2014-06-14 09:50:07',NULL,NULL,NULL,NULL,NULL),(31,'Kenil',NULL,'kjh',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'test@gmail.com',NULL,NULL,2,NULL,NULL,NULL,'2014-06-15 08:49:02','2014-06-15 08:49:02',NULL,NULL,NULL,NULL,NULL),(32,'Kunal',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'doshkunal82@gmail.com',NULL,NULL,2,NULL,NULL,NULL,'2014-06-15 08:52:58','2014-06-15 08:52:58',NULL,NULL,NULL,NULL,NULL),(33,'Kunal',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'doshikunal82@gmail.com',NULL,NULL,2,NULL,NULL,NULL,'2014-06-15 08:55:11','2014-06-15 08:55:11',NULL,NULL,NULL,NULL,NULL),(44,'Kenil',NULL,'kjh',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'kenilkdoshi@gmail.com',NULL,NULL,2,NULL,NULL,NULL,'2014-06-19 15:43:54','2014-06-19 15:43:54',NULL,NULL,NULL,NULL,NULL),(37,'Kiran',NULL,'DOshi',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'crispykenil@gmail.com',NULL,NULL,2,NULL,NULL,NULL,'2014-06-18 18:34:37','2014-06-18 18:34:37',NULL,NULL,NULL,NULL,NULL),(38,'Kiran',NULL,'DOshi',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'crispykenil@gmail.com',NULL,NULL,2,NULL,NULL,NULL,'2014-06-18 18:35:52','2014-06-18 18:35:52',NULL,NULL,NULL,NULL,NULL),(46,'Kenil',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'kenil@gmail.com',NULL,NULL,2,NULL,NULL,NULL,'2014-06-22 16:29:25','2014-06-22 16:29:25',NULL,NULL,NULL,NULL,NULL),(47,'Dishkyaoon',NULL,'DoomDoom',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'crispykenil@yahoo.com',NULL,NULL,2,NULL,NULL,NULL,'2014-07-06 06:52:22','2014-07-06 06:52:22',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usercredentials`
--

DROP TABLE IF EXISTS `usercredentials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usercredentials` (
  `UserID` int(11) NOT NULL,
  `EmailAddress` varchar(45) NOT NULL,
  `Password` varchar(1024) NOT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usercredentials`
--

LOCK TABLES `usercredentials` WRITE;
/*!40000 ALTER TABLE `usercredentials` DISABLE KEYS */;
INSERT INTO `usercredentials` VALUES (2,'crispykenil@gmail.com','4090ff285b0e175d3f13469801ff7760950c8fd6f01c0ed750c8069b141a4afb552b17c7805b6cbad66b7364329909c7bdcf55ce8a8f68a54ba32669de5d8c1a'),(22,'kd@yahoo.com','4090ff285b0e175d3f13469801ff7760950c8fd6f01c0ed750c8069b141a4afb552b17c7805b6cbad66b7364329909c7bdcf55ce8a8f68a54ba32669de5d8c1a'),(23,'mayank@gmail.com','351aa3e6fa0d053b977604efd8a518f7487b1b8763cb2c4e9747125fd67999a35ade2095d00a4d3123a56aae91208259d73a21e7d4e8f307e0d234fc95223313'),(24,'jyoti.doshi@gmail.com','cbe47951026840a86cd7b080f43498cb88f85b0ce216c6c487aea3313427aed557fa1ed11d5540d65cbbc1ff9470c40d221faee6a87dcd844fbed96ddf13cb6b'),(44,'kenilkdoshi@gmail.com','4090ff285b0e175d3f13469801ff7760950c8fd6f01c0ed750c8069b141a4afb552b17c7805b6cbad66b7364329909c7bdcf55ce8a8f68a54ba32669de5d8c1a'),(27,'hh@gmail.com','57c62e72fe4f26e887b50362954457ea057c01a86a5473ea2fd076112e4196f16c910b76b45ebf509bb4f3cf5c9542018946e57268af9cc5bb49cb1f67556b0a'),(28,'ikik@gma.com','09e76fc56eb50d99d89beac73a6affa4f650994ccea36fc3c916a9ebc6e9e17611db5bd24ef2aab9b95a0ac875598b60ae7583114e4f2ffe0b8bc434d2e842a3'),(29,'kjk@gmail.com','09e76fc56eb50d99d89beac73a6affa4f650994ccea36fc3c916a9ebc6e9e17611db5bd24ef2aab9b95a0ac875598b60ae7583114e4f2ffe0b8bc434d2e842a3'),(30,'email@gmail.com','f5f65e75fff35067f989ca995426be86c82da6056744276a0eff72a27b33c0ef7d335ca7600a2c14a009ace8fc48de7adacafd7110a86b3362af6eba054b3e6e'),(33,'doshikunal82@gmail.com','7e6dc4c7556276e30c4b106543a1e609ce263bc8b61d80b478c25d795856f4c05b7795bee80c6c9119b33747e765c761b6abbf084055b62aff648d7fbfebdaa2'),(46,'kenil@gmail.com','4090ff285b0e175d3f13469801ff7760950c8fd6f01c0ed750c8069b141a4afb552b17c7805b6cbad66b7364329909c7bdcf55ce8a8f68a54ba32669de5d8c1a'),(47,'crispykenil@yahoo.com','4090ff285b0e175d3f13469801ff7760950c8fd6f01c0ed750c8069b141a4afb552b17c7805b6cbad66b7364329909c7bdcf55ce8a8f68a54ba32669de5d8c1a');
/*!40000 ALTER TABLE `usercredentials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userhistory`
--

DROP TABLE IF EXISTS `userhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userhistory` (
  `UserID` int(11) NOT NULL,
  `FieldsChanged` varchar(45) NOT NULL,
  `FromValue` varchar(45) DEFAULT NULL,
  `ToValue` varchar(45) DEFAULT NULL,
  `ActionPerformed` char(1) NOT NULL,
  `CreateDTTM` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`UserID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userhistory`
--

LOCK TABLES `userhistory` WRITE;
/*!40000 ALTER TABLE `userhistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `userhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userschool`
--

DROP TABLE IF EXISTS `userschool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userschool` (
  `UserSchoolID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(20) DEFAULT NULL,
  `SchoolID` int(20) DEFAULT NULL,
  `fromyear` int(4) DEFAULT NULL,
  `toyear` int(4) DEFAULT NULL,
  `PassoutBatch` int(4) DEFAULT NULL,
  `CreateUserID` int(20) DEFAULT NULL,
  `CreateDttm` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `UpdateUserID` int(20) DEFAULT NULL,
  `UpdateDttm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`UserSchoolID`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userschool`
--

LOCK TABLES `userschool` WRITE;
/*!40000 ALTER TABLE `userschool` DISABLE KEYS */;
INSERT INTO `userschool` VALUES (9,9,4,2001,2004,1994,1,'2014-04-05 07:46:56',NULL,'2014-05-31 19:12:10'),(13,2,5,1997,1993,1997,1,'2014-04-23 14:16:23',0,'2014-07-12 21:03:35'),(15,2,11,1999,1999,6666,2,'2014-05-24 08:31:51',0,'2014-07-12 21:03:35'),(10,1,1,2004,2007,2007,1,'2014-04-22 18:43:05',NULL,'2014-05-31 19:12:10'),(8,8,6,2001,2004,1994,0,'2014-04-05 06:55:10',NULL,'2014-05-31 19:12:10'),(12,1,9,1988,1998,1998,1,'2014-04-22 19:33:00',NULL,'2014-05-31 19:12:10'),(16,2,17,2033,2033,2033,2,'2014-06-01 12:42:27',0,'2014-07-12 20:53:32'),(17,33,18,1991,2001,2001,33,'2014-06-15 08:58:48',NULL,'2014-06-15 08:58:48'),(18,0,18,1954,1964,1964,0,'2014-07-11 16:28:15',NULL,'2014-07-11 16:28:15'),(19,2,18,1964,1954,1964,2,'2014-07-11 16:35:03',0,'2014-07-12 21:03:35');
/*!40000 ALTER TABLE `userschool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userupdates`
--

DROP TABLE IF EXISTS `userupdates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userupdates` (
  `PostID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(20) DEFAULT NULL,
  `Subject` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `UploadedOn` varchar(255) DEFAULT NULL,
  `CreateUserID` int(20) DEFAULT NULL,
  `CreateDttm` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `UpdateUserID` int(20) DEFAULT NULL,
  `UpdateDttm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`PostID`),
  KEY `CreateUserID` (`CreateUserID`),
  KEY `UserID` (`UserID`),
  KEY `UpdateUserID` (`UpdateUserID`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userupdates`
--

LOCK TABLES `userupdates` WRITE;
/*!40000 ALTER TABLE `userupdates` DISABLE KEYS */;
INSERT INTO `userupdates` VALUES (1,2,'Joined LINKALMA','Created LINKALMA account today. Lets explore','1',1,'2014-04-06 03:56:59',NULL,'2014-05-31 19:12:10'),(2,2,'Neat','The dashboard looks neat, i am loving it...','1',1,'2014-04-06 03:56:59',NULL,'2014-05-31 19:12:10'),(3,2,'School Addition','Oh i can see my school in the list, I will add it to my profile.','1',1,'2014-04-06 03:56:59',NULL,'2014-05-31 19:12:10'),(4,1,'','Ab ki baar Modi Sarkar','1',1,'2014-05-18 18:13:48',1,'2014-05-21 18:13:48'),(5,0,'','My First Post...in Linkalma..\r\nFeeling excited... :)','0',0,'2014-05-19 18:13:48',0,'2014-05-31 19:12:10'),(6,1,'','My First Post from LInklma.... feeling excited...','0',1,'2014-05-19 22:13:48',1,'2014-05-31 19:12:10'),(7,1,'','Oh My God.. the post is posted on my wall... :)','0',1,'2014-05-20 00:13:48',1,'2014-05-31 19:12:10'),(8,1,'','New Post from my after cheking the checkbox','1',1,'2014-05-20 18:13:48',1,'2014-05-31 19:12:10'),(9,1,'','Seriously.. this is getting updated... :D','0',1,'2014-05-21 18:13:48',1,'2014-05-31 19:12:10'),(10,2,'','HI Gautam..how are you','0',2,'2014-05-24 08:16:37',2,'2014-05-31 19:12:10'),(11,2,'','Testing with Mangesh...','0',2,'2014-05-26 13:12:17',2,'2014-05-31 19:12:10'),(12,2,'','Watsup','0',2,'2014-06-01 05:03:36',2,'2014-06-01 05:03:36'),(13,19,'','Hey man how are you...','0',19,'2014-06-01 06:04:04',19,'2014-06-01 06:04:04'),(14,19,'','i am fine .. enjoying weekend.. !','0',19,'2014-06-01 06:04:18',19,'2014-06-01 06:04:18'),(15,20,'','Watsup !','0',20,'2014-06-01 11:07:31',20,'2014-06-01 11:07:31'),(16,2,'','Again.. how are you...','0',2,'2014-06-03 15:17:18',2,'2014-06-03 15:17:18'),(17,2,'','my comment\r\n','0',2,'2014-06-06 11:33:53',2,'2014-06-06 11:33:53'),(18,2,'','Really ?','0',2,'2014-06-13 18:49:47',2,'2014-06-13 18:49:47'),(19,2,'','Wassup !','0',2,'2014-06-14 07:18:25',2,'2014-06-14 07:18:25'),(20,2,'','HI...asdasd','0',2,'2014-06-14 07:22:34',2,'2014-06-14 07:22:34'),(21,0,'','HI...asdasd','0',0,'2014-06-14 07:23:45',0,'2014-06-14 07:23:45'),(22,2,'','ohh cmon...','0',2,'2014-06-14 07:29:02',2,'2014-06-14 07:29:02'),(23,2,'','hiiiisaiasdas','0',2,'2014-06-29 09:05:43',2,'2014-06-29 09:05:43'),(24,2,'','kenildoshi','0',2,'2014-07-05 19:00:50',2,'2014-07-05 19:00:50'),(25,2,'','fine this seems working..','0',2,'2014-07-05 19:01:01',2,'2014-07-05 19:01:01');
/*!40000 ALTER TABLE `userupdates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userworkplace`
--

DROP TABLE IF EXISTS `userworkplace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userworkplace` (
  `UserWorkplaceID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `OrganisationName` varchar(45) NOT NULL,
  `FromMonth` varchar(2) DEFAULT NULL,
  `FromYear` int(4) DEFAULT NULL,
  `ToMonth` varchar(2) DEFAULT NULL,
  `ToYear` int(4) DEFAULT NULL,
  `Designation` varchar(255) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `CreateDttm` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `UpdateDttm` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`UserWorkplaceID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userworkplace`
--

LOCK TABLES `userworkplace` WRITE;
/*!40000 ALTER TABLE `userworkplace` DISABLE KEYS */;
INSERT INTO `userworkplace` VALUES (1,2,'Mindcraft','08',2007,'08',2009,'Consultant','Java/J2EE','0000-00-00 00:00:00','2014-07-06 07:13:26'),(2,2,'Wipro','08',2009,'07',2013,'Sr. Software Engineer','CoreJava','0000-00-00 00:00:00','2014-07-06 07:13:26'),(3,2,'Accenture','08',2013,'09',2013,'Sr. Analyst','Senior Developer','0000-00-00 00:00:00','2014-07-06 07:13:26'),(4,0,'Accenture','8',2013,'8',2009,'SSESSE','sdasd','0000-00-00 00:00:00','2014-07-12 19:32:03'),(5,2,'Cognizant','9',2014,'5',2016,'Sr. Associate','Java Middleware...							\r\n						','0000-00-00 00:00:00','2014-07-12 19:35:51');
/*!40000 ALTER TABLE `userworkplace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verificationlinks`
--

DROP TABLE IF EXISTS `verificationlinks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `verificationlinks` (
  `EmailAddress` varchar(255) NOT NULL,
  `Code` varchar(1024) NOT NULL,
  `CreateDttm` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`EmailAddress`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verificationlinks`
--

LOCK TABLES `verificationlinks` WRITE;
/*!40000 ALTER TABLE `verificationlinks` DISABLE KEYS */;
INSERT INTO `verificationlinks` VALUES ('crispykenil@gmail.com','37575fc24179ddbd3ed04e74efed165f9cf27d627c074ec90e21bd8a89f4307b','2014-06-21 20:10:12'),('kenil@gmail.com','6b69835e59beaeb8cc03c62b862d82d85da5515be36f32b43c7dabf1e7aa52f0','2014-06-22 16:31:43');
/*!40000 ALTER TABLE `verificationlinks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-13  2:39:27
