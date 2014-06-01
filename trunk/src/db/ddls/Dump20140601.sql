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
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES (1,'SVP','SM Road','Kandivali','KandivaliWest','admin@svpvv.com','www.svpvv.com','svpvv','Y','Y','2014-03-23 19:41:04',NULL,'2014-05-31 19:12:07',NULL,NULL,NULL,'Most of human history lies in pre-history, the period before the use of writing, and before written history. In pre-literate societies, education was achieved through demonstration and copying as the young learned from their elders. Rural communities had few resources to expend on education, and there was a lack of commercially available products for schools. At later stages they received instruction of a more structured and formal nature, imparted by people not necessarily related, in the context of initiation, religion or ritual.[2][3][4] Some forms of traditional knowledge were expressed through stories, legends, folklore, rituals, and songs, without the need for a writing system. Tools to aid this process include poetic devices such as rhyme and alliteration. These methods are illustrative of orality. The stories thus preserved are also referred to as part of an oral tradition.[citation needed]',1234,1234),(2,'Francis','IC Colony','Borivali','Borivali West','admin@francis.com','francis.com','francis','Y','Y','2014-03-23 19:41:04',NULL,'2014-05-31 19:12:07',NULL,NULL,NULL,'Saint Francis School, a private Catholic school founded in 1924, provides a college preparatory program. With an enrollment limited to just over 500 in grades PK through 12, Saint Francis School offers an education based on academic promise and does not discriminate based on ethnicity, religion or socioeconomic status. Students from all over Hawaii, the U.S. mainland, Asia and around the world reap the benefits of our academically sound curriculum which develops the whole person: mind, body and spirit',123,33333),(3,'BIT','Worli','Worli',NULL,'admin@bit.com',NULL,NULL,'Y','Y','2014-03-23 20:02:53',NULL,'2014-05-31 19:12:07',NULL,NULL,NULL,NULL,NULL,NULL),(4,'KJ Somaiya','Vidyavihar','Worli',NULL,'admin@kj.com',NULL,NULL,'Y','Y','2014-03-23 20:07:55',NULL,'2014-05-31 19:12:07',NULL,NULL,NULL,NULL,NULL,NULL),(5,'Vartak','Vasai','Vasai',NULL,'admin@vartak.com',NULL,NULL,'Y','Y','2014-03-23 20:10:22',NULL,'2014-05-31 19:12:07',NULL,NULL,NULL,NULL,NULL,NULL),(6,'VJTI','Matunga','Matunga',NULL,'admin@vjti.com',NULL,NULL,'Y','Y','2014-03-23 20:16:40',NULL,'2014-05-31 19:12:07',NULL,NULL,NULL,NULL,NULL,NULL),(7,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Y','Y','2014-03-30 09:12:58',NULL,'2014-05-31 19:12:07',NULL,NULL,NULL,NULL,NULL,NULL),(8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Y','Y','2014-03-30 09:45:14',NULL,'2014-05-31 19:12:07',NULL,NULL,NULL,NULL,NULL,NULL),(9,'St Annes High School','Orlem','Malad',NULL,'ANNES@GMAIL.COM',NULL,NULL,'Y','Y','2014-05-31 19:12:07',0,'2014-05-31 19:12:07',0,NULL,NULL,NULL,NULL,NULL),(10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Y','Y','2014-05-31 19:12:07',0,'2014-05-31 19:12:07',0,NULL,NULL,NULL,NULL,NULL),(11,'Ryan International','Chakan','Chakan - Talegaon Road',NULL,'ryan-pune@ryan.com',NULL,NULL,'Y','Y','2014-05-31 19:12:07',0,'2014-05-31 19:12:07',0,NULL,NULL,NULL,NULL,NULL);
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
  `Password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`SchoolID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolcredentials`
--

LOCK TABLES `schoolcredentials` WRITE;
/*!40000 ALTER TABLE `schoolcredentials` DISABLE KEYS */;
INSERT INTO `schoolcredentials` VALUES (1,'admin'),(2,'admin');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='To Store School Curriculum, Calendar, Exams, Projects etc';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schooldata`
--

LOCK TABLES `schooldata` WRITE;
/*!40000 ALTER TABLE `schooldata` DISABLE KEYS */;
INSERT INTO `schooldata` VALUES (1,1,1,'Syllabus desc','Design Pattern.jpg','Syllabus',NULL,'2014-05-31 19:12:09',0,'0000-00-00 00:00:00',NULL,NULL),(2,1,2,'Calendar DEsc','Design Pattern.jpg','Calendar ',NULL,'2014-05-31 19:12:09',0,'0000-00-00 00:00:00',NULL,NULL),(3,1,3,'MId term exams starting June 1','Design Pattern.jpg','Mid Term Exams',0,'2014-05-23 09:52:29',0,'2014-05-23 09:52:29','8th ','A');
/*!40000 ALTER TABLE `schooldata` ENABLE KEYS */;
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
  `Description` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `CreateUserID` int(20) DEFAULT NULL,
  `CreateDttm` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `UpdateUserID` int(20) DEFAULT NULL,
  `UpdateDttm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`SchoolUpdatesID`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolupdates`
--

LOCK TABLES `schoolupdates` WRITE;
/*!40000 ALTER TABLE `schoolupdates` DISABLE KEYS */;
INSERT INTO `schoolupdates` VALUES (5,1,'Mumbai Mirror','4/25/2013 – Del Mar Times – Solana Beach Residents Leads Ultra Division Team in Long-Distance Ragnar Relay, 10 New San Diego – Monarch School Opens New Campus','2',0,'2014-05-19 16:21:25',0,'2014-05-31 19:12:09'),(6,2,' Hera Hub Online','4/25/2013 – Hera Hub Online – From Inspiration to Action: The Monarch School Opens Doors to New Facility, Fox 5 San Diego – School for Homeless Kids Expands to Meet Growing Need','2',1,'2014-05-19 16:23:05',1,'2014-05-31 19:12:09'),(7,2,'Times Of India','Union Tribune San Diego – New School for Homeless Opens, 4/22/2013 – Union Tribune San Diego – Women’s Foundation Volunteer Cares by Taking Care of Details','2',1,'2014-05-19 16:27:29',1,'2014-05-31 19:12:09'),(8,2,'Newsletter Title 5','Newsletter Desc 5','2',1,'2014-05-19 16:29:18',1,'2014-05-31 19:12:09'),(9,2,'Newsletter Title 6','Newletter Desc 6','2',1,'2014-05-19 16:29:52',1,'2014-05-31 19:12:09'),(10,1,'Lets Start','Lets start','1',1,'2014-05-19 16:31:56',1,'2014-05-31 19:12:09'),(11,1,'Times Of India','4/25/2013 – Hera Hub Online – From Inspiration to Action: The Monarch School Opens Doors to New Facility, Fox 5 San Diego – School for Homeless Kids Expands to Meet Growing Need','2',1,'2014-05-19 16:34:05',1,'2014-05-31 19:12:09'),(12,1,'Mumbai Mirror','4/25/2013 – Hera Hub Online – From Inspiration to Action: The Monarch School Opens Doors to New Facility, Fox 5 San Diego – School for Homeless Kids Expands to Meet Growing Need','2',1,'2014-05-19 18:44:27',1,'2014-05-31 19:12:09'),(13,2,'Lets Start2','Lets start desc 2','3',1,'2014-05-19 18:46:34',1,'2014-05-31 19:12:09'),(14,1,'Yoga “Glow-in-the-Night” Charity Yoga Event','Location: Monarch School Nat and Flora Bosa Campus – 1625 Newton Ave., San Diego, CA 92113  More info: Please join us for a fun-filled charity yoga event to bring out the kid in each of us. 100% of the proceeds benefit Ryan School! ','3',1,'2014-05-21 16:34:04',1,'2014-05-31 19:12:09'),(15,1,'Tango and Malambo Night','1845 Strand Way, Coronado, CA 92118 - The Rotary Club of Coronado cordially invites you to a fundraising night to benefit the children of the BLCI & Monarch School. Join us for a night of food, drinks & Tango!','3',1,'2014-05-21 16:34:18',1,'2014-05-31 19:12:09'),(16,1,'Yoga “Glow-in-the-Night” Charity Yoga Event','Location: Monarch School Nat and Flora Bosa Campus – 1625 Newton Ave., San Diego, CA 92113  More info: Please join us for a fun-filled charity yoga event to bring out the kid in each of us. 100% of the proceeds benefit Ryan School! ','3',1,'2014-05-21 16:34:31',1,'2014-05-31 19:12:09'),(17,1,'Project 2','Roughness is an important aspect of the condition of our highways, as it affects the quality of the ride and the user’s perception of the pavement’s condition. It is important to adequately measure and control the quality of pavement roughness.','1',1,'2014-05-21 16:34:38',1,'2014-05-31 19:12:09'),(18,1,'Project 3','Roughness is an important aspect of the condition of our highways, as it affects the quality of the ride and the user’s perception of the pavement’s condition. It is important to adequately measure and control the quality of pavement roughness.','1',1,'2014-05-21 16:34:47',1,'2014-05-31 19:12:09'),(19,1,'Go Live on Test Server','Live on test server','1',0,'2014-06-01 04:58:14',0,'2014-06-01 04:58:14');
/*!40000 ALTER TABLE `schoolupdates` ENABLE KEYS */;
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
  PRIMARY KEY (`UserID`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (11,'Doshi',NULL,'KENIL',NULL,NULL,NULL,0,0,0,0,'Male',NULL,NULL,NULL,'kenil@gmail.com','0012-01-02',NULL,NULL,NULL,NULL,NULL,'2014-05-31 19:12:10','2014-05-31 19:12:10'),(10,'KEnil',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'Male',NULL,NULL,NULL,'kenil@gmail.com','0012-01-02',NULL,1,NULL,NULL,NULL,'2014-05-31 19:12:10','2014-05-31 19:12:10'),(3,'Kunal',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'Male',NULL,NULL,NULL,'kenilkdoshi@gmail.com','2013-01-02',NULL,2,NULL,NULL,NULL,'2014-05-31 19:12:10','2014-05-31 19:12:10'),(4,'Kunal',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'Male',NULL,NULL,NULL,'kenilkdohi@gmail.com','2013-01-02',NULL,2,NULL,NULL,NULL,'2014-05-31 19:12:10','2014-05-31 19:12:10'),(5,'Kunal',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'Male',NULL,NULL,NULL,'kenlkdoshi@gmail.com','2013-01-04',NULL,1,NULL,NULL,NULL,'2014-05-31 19:12:10','2014-05-31 19:12:10'),(6,'KD',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'Male',NULL,NULL,NULL,'knilkdoshi@gmail.com','2013-01-24',NULL,3,NULL,NULL,NULL,'2014-05-31 19:12:10','2014-05-31 19:12:10'),(7,'KD',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'Male',NULL,NULL,NULL,'kilkdoshi@gmail.com','2013-01-24',NULL,2,NULL,NULL,NULL,'2014-05-31 19:12:10','2014-05-31 19:12:10'),(8,'KDDDDD',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'Male',NULL,NULL,NULL,'kendoshi@gmail.com','2013-01-24',NULL,3,NULL,NULL,NULL,'2014-05-31 19:12:10','2014-05-31 19:12:10'),(9,'Kiran',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'Male',NULL,NULL,NULL,'rscdoshi@gmail.com','1946-01-20',NULL,4,NULL,NULL,NULL,'2014-05-31 19:12:10','2014-05-31 19:12:10'),(2,'Kenil222',NULL,'Doshi2222','MG Road - kkekek','Kandivali W','0',1111,2807956211,9619673630,0,'F','Mumbai','Maharashtra','Indiaaaqqq','crispykenil@gmail.com',NULL,NULL,1,'kkd','Y','Y','2014-05-31 19:12:10','2014-05-10 16:51:25'),(13,'Pratik',NULL,'Shah',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'pratik@gmail.com','2014-04-04',NULL,1,NULL,NULL,NULL,'2014-05-31 19:12:10','2014-05-31 19:12:10'),(14,'Dhyey',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'livelydhyey@gmail.com',NULL,NULL,2,NULL,NULL,NULL,'2014-05-31 19:12:10','2014-05-31 19:12:10'),(15,'Binny',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'binny@gmail.com',NULL,NULL,3,NULL,NULL,NULL,'2014-05-31 19:12:10','2014-05-31 19:12:10'),(16,'Mayank',NULL,'DOshi',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'mayank@gmail.com',NULL,NULL,1,NULL,NULL,NULL,'2014-05-31 19:12:10','2014-05-31 19:12:10'),(17,'KKD',NULL,'DDK',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'test@liferay.com',NULL,NULL,NULL,NULL,NULL,NULL,'2014-05-31 19:12:10','2014-05-31 19:12:10'),(1,'Gautamgggg',NULL,'Sharma','Upper Goving Nagar','Malad East','0',9324445952,91919191,9898989,0,'M','Mumbai','Maharashtra','India','gautam@gmail.com',NULL,NULL,1,NULL,'Y','Y','2014-04-29 17:41:57','2014-04-29 18:25:51'),(18,'MANGESH',NULL,'KAIJKAR',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'mangesk@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL,'2014-06-01 05:41:36','2014-06-01 05:41:36'),(19,'Kenil',NULL,'Doshi','Worli','malad','0',0,0,0,0,NULL,'mumbai','','India','kenil@gmail.com',NULL,NULL,2,NULL,NULL,NULL,'2014-06-01 06:03:37','2014-06-01 06:04:52');
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
INSERT INTO `usercredentials` VALUES (1,'','kenildoshi'),(2,'','ke'),(3,'','ke'),(4,'','asd'),(5,'','asd'),(6,'','asd'),(7,'','asd'),(9,'','kirandoshi'),(10,'','kenildoshi'),(11,'','kenildoshi'),(12,'','kenildoshi'),(13,'','pratik'),(14,'','kenildoshi'),(15,'','binny'),(16,'','Mayank'),(17,'','KKD'),(18,'mangesk@gmail.com','asd'),(19,'kenil@gmail.com','kenil');
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
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userschool`
--

LOCK TABLES `userschool` WRITE;
/*!40000 ALTER TABLE `userschool` DISABLE KEYS */;
INSERT INTO `userschool` VALUES (9,9,4,2001,2004,1994,1,'2014-04-05 07:46:56',NULL,'2014-05-31 19:12:10'),(14,2,9,1985,1995,1995,1,'2014-04-26 19:49:55',NULL,'2014-05-31 19:12:10'),(13,2,5,1993,1997,1997,1,'2014-04-23 14:16:23',NULL,'2014-05-31 19:12:10'),(15,2,3,2020,2020,2020,2,'2014-05-24 08:31:51',NULL,'2014-05-31 19:12:10'),(10,1,1,2004,2007,2007,1,'2014-04-22 18:43:05',NULL,'2014-05-31 19:12:10'),(8,8,6,2001,2004,1994,0,'2014-04-05 06:55:10',NULL,'2014-05-31 19:12:10'),(12,1,9,1988,1998,1998,1,'2014-04-22 19:33:00',NULL,'2014-05-31 19:12:10');
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
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userupdates`
--

LOCK TABLES `userupdates` WRITE;
/*!40000 ALTER TABLE `userupdates` DISABLE KEYS */;
INSERT INTO `userupdates` VALUES (1,2,'Joined LINKALMA','Created LINKALMA account today. Lets explore','1',1,'2014-04-06 03:56:59',NULL,'2014-05-31 19:12:10'),(2,2,'Neat','The dashboard looks neat, i am loving it...','1',1,'2014-04-06 03:56:59',NULL,'2014-05-31 19:12:10'),(3,2,'School Addition','Oh i can see my school in the list, I will add it to my profile.','1',1,'2014-04-06 03:56:59',NULL,'2014-05-31 19:12:10'),(4,1,'','Ab ki baar Modi Sarkar','1',1,'2014-05-18 18:13:48',1,'2014-05-21 18:13:48'),(5,0,'','My First Post...in Linkalma..\r\nFeeling excited... :)','0',0,'2014-05-19 18:13:48',0,'2014-05-31 19:12:10'),(6,1,'','My First Post from LInklma.... feeling excited...','0',1,'2014-05-19 22:13:48',1,'2014-05-31 19:12:10'),(7,1,'','Oh My God.. the post is posted on my wall... :)','0',1,'2014-05-20 00:13:48',1,'2014-05-31 19:12:10'),(8,1,'','New Post from my after cheking the checkbox','1',1,'2014-05-20 18:13:48',1,'2014-05-31 19:12:10'),(9,1,'','Seriously.. this is getting updated... :D','0',1,'2014-05-21 18:13:48',1,'2014-05-31 19:12:10'),(10,2,'','HI Gautam..how are you','0',2,'2014-05-24 08:16:37',2,'2014-05-31 19:12:10'),(11,2,'','Testing with Mangesh...','0',2,'2014-05-26 13:12:17',2,'2014-05-31 19:12:10'),(12,2,'','Watsup','0',2,'2014-06-01 05:03:36',2,'2014-06-01 05:03:36'),(13,19,'','Hey man how are you...','0',19,'2014-06-01 06:04:04',19,'2014-06-01 06:04:04'),(14,19,'','i am fine .. enjoying weekend.. !','0',19,'2014-06-01 06:04:18',19,'2014-06-01 06:04:18');
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
  PRIMARY KEY (`UserWorkplaceID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userworkplace`
--

LOCK TABLES `userworkplace` WRITE;
/*!40000 ALTER TABLE `userworkplace` DISABLE KEYS */;
INSERT INTO `userworkplace` VALUES (1,2,'Mindcraft','08',2007,'08',2009,'Consultant','Java/J2EE'),(2,2,'Wipro','08',2009,'07',2013,'Sr. Software Engineer','CoreJava');
/*!40000 ALTER TABLE `userworkplace` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-01 15:01:40
