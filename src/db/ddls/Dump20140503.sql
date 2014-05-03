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
  `CreateDttm` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdateUserID` int(20) DEFAULT NULL,
  `UpdateDttm` datetime DEFAULT NULL,
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
  `RequestSentDTTM` datetime DEFAULT CURRENT_TIMESTAMP,
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
  `RequestSentDTTM` datetime DEFAULT CURRENT_TIMESTAMP,
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
  `CreateDttm` datetime DEFAULT CURRENT_TIMESTAMP,
  `CreateUserID` int(20) DEFAULT NULL,
  `UpdateDttm` datetime DEFAULT NULL,
  `UpdateUserID` int(20) DEFAULT NULL,
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
INSERT INTO `school` VALUES (1,'SVP','SM Road','Kandivali','KandivaliWest','admin@svpvv.com','www.svpvv.com','svpvv','Y','Y','2014-03-24 01:11:04',NULL,NULL,NULL),(2,'Francis','IC Colony','Borivali','Borivali West','admin@francis.com','francis.com','francis','Y','Y','2014-03-24 01:11:04',NULL,NULL,NULL),(3,'BIT','Worli','Worli',NULL,'admin@bit.com',NULL,NULL,'Y','Y','2014-03-24 01:32:53',NULL,NULL,NULL),(4,'KJ Somaiya','Vidyavihar','Worli',NULL,'admin@kj.com',NULL,NULL,'Y','Y','2014-03-24 01:37:55',NULL,NULL,NULL),(5,'Vartak','Vasai','Vasai',NULL,'admin@vartak.com',NULL,NULL,'Y','Y','2014-03-24 01:40:22',NULL,NULL,NULL),(6,'VJTI','Matunga','Matunga',NULL,'admin@vjti.com',NULL,NULL,'Y','Y','2014-03-24 01:46:40',NULL,NULL,NULL),(7,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Y','Y','2014-03-30 14:42:58',NULL,NULL,NULL),(8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Y','Y','2014-03-30 15:15:14',NULL,NULL,NULL),(9,'St Annes High School','Orlem','Malad',NULL,'ANNES@GMAIL.COM',NULL,NULL,'Y','Y',NULL,0,NULL,0),(10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Y','Y',NULL,0,NULL,0),(11,'Ryan International','Chakan','Chakan - Talegaon Road',NULL,'ryan-pune@ryan.com',NULL,NULL,'Y','Y',NULL,0,NULL,0);
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
-- Table structure for table `schoolnews`
--

DROP TABLE IF EXISTS `schoolnews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schoolnews` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `SchoolID` int(20) DEFAULT NULL,
  `NewsDescription` varchar(255) DEFAULT NULL,
  `NewsType` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolnews`
--

LOCK TABLES `schoolnews` WRITE;
/*!40000 ALTER TABLE `schoolnews` DISABLE KEYS */;
/*!40000 ALTER TABLE `schoolnews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolupdates`
--

DROP TABLE IF EXISTS `schoolupdates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schoolupdates` (
  `PostID` int(11) NOT NULL AUTO_INCREMENT,
  `SchoolID` int(20) DEFAULT NULL,
  `Subject` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `CreateUserID` int(20) DEFAULT NULL,
  `CreateDttm` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdateUserID` int(20) DEFAULT NULL,
  `UpdateDttm` datetime DEFAULT NULL,
  PRIMARY KEY (`PostID`),
  KEY `CreateUserID` (`CreateUserID`),
  KEY `SchoolID` (`SchoolID`),
  KEY `UpdateUserID` (`UpdateUserID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolupdates`
--

LOCK TABLES `schoolupdates` WRITE;
/*!40000 ALTER TABLE `schoolupdates` DISABLE KEYS */;
INSERT INTO `schoolupdates` VALUES (1,4,'Annual Function','Annual Function organised for Alumni Batch 2007, Annual Function organised for Alumni Batch 2007, Annual Function organised for Alumni Batch 2007','Event',1,'2014-04-05 23:53:23',1,NULL),(2,4,'Huge Donation Received','Gautam Sharma donated 1.5 lacs to VJTI foundation, Gautam Sharma donated 1.5 lacs to VJTI foundation, Gautam Sharma donated 1.5 lacs to VJTI foundation, Gautam Sharma donated 1.5 lacs to VJTI foundation','News',1,'2014-04-05 23:53:23',1,NULL),(3,4,'New Branch Started','Started ICSE B,Started ICSE B,Started ICSE B,Started ICSE B,Started ICSE BStarted ICSE B,Started ICSE B,Started ICSE BStarted ICSE B','News',1,'2014-04-05 23:53:23',1,NULL),(4,1,'Started On Capus Placements','Campus Placements started, Campus Placements started, Campus Placements started, Campus Placements started, Campus Placements started, Campus Placements started, Campus Placements started','News',1,'2014-04-05 23:53:23',1,'2014-04-05 23:53:23');
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
INSERT INTO `staticcodes` VALUES (1,1,'SchoolAdmin','Role'),(1,3,'Linkalma Admin','Role'),(1,2,'Alumni','Role');
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
  `TopicStartDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `TopicCategory` varchar(255) DEFAULT NULL,
  `CreateUserID` int(20) DEFAULT NULL,
  `CreateDttm` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdateUserID` int(20) DEFAULT NULL,
  `UpdateDttm` datetime DEFAULT NULL,
  PRIMARY KEY (`TopicID`),
  KEY `TopicStartDate` (`TopicStartDate`)
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
  `CreateDttm` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdateDttm` datetime DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (11,'Doshi',NULL,'KENIL',NULL,NULL,NULL,0,0,0,0,'Male',NULL,NULL,NULL,'kenil@gmail.com','0012-01-02',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'KEnil',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'Male',NULL,NULL,NULL,'kenil@gmail.com','0012-01-02',NULL,1,NULL,NULL,NULL,NULL,NULL),(3,'Kunal',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'Male',NULL,NULL,NULL,'kenilkdoshi@gmail.com','2013-01-02',NULL,2,NULL,NULL,NULL,NULL,NULL),(4,'Kunal',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'Male',NULL,NULL,NULL,'kenilkdohi@gmail.com','2013-01-02',NULL,2,NULL,NULL,NULL,NULL,NULL),(5,'Kunal',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'Male',NULL,NULL,NULL,'kenlkdoshi@gmail.com','2013-01-04',NULL,1,NULL,NULL,NULL,NULL,NULL),(6,'KD',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'Male',NULL,NULL,NULL,'knilkdoshi@gmail.com','2013-01-24',NULL,3,NULL,NULL,NULL,NULL,NULL),(7,'KD',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'Male',NULL,NULL,NULL,'kilkdoshi@gmail.com','2013-01-24',NULL,2,NULL,NULL,NULL,NULL,NULL),(8,'KDDDDD',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'Male',NULL,NULL,NULL,'kendoshi@gmail.com','2013-01-24',NULL,3,NULL,NULL,NULL,NULL,NULL),(9,'Kiran',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'Male',NULL,NULL,NULL,'rscdoshi@gmail.com','1946-01-20',NULL,4,NULL,NULL,NULL,NULL,NULL),(2,'Kenil',NULL,'Doshi','MG Road - asasass','Kandivali W','0',234234,2807956211,9619673630,0,'F','Mumbai','Maharashtra','Indiaaaqqq','crispykenil@gmail.com',NULL,NULL,1,'kkd','Y','Y',NULL,'2014-04-27 12:55:25'),(13,'Pratik',NULL,'Shah',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'pratik@gmail.com','2014-04-04',NULL,1,NULL,NULL,NULL,NULL,NULL),(14,'Dhyey',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'livelydhyey@gmail.com',NULL,NULL,2,NULL,NULL,NULL,NULL,NULL),(15,'Binny',NULL,'Doshi',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'binny@gmail.com',NULL,NULL,3,NULL,NULL,NULL,NULL,NULL),(16,'Mayank',NULL,'DOshi',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'mayank@gmail.com',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL),(17,'KKD',NULL,'DDK',NULL,NULL,NULL,0,0,0,0,'',NULL,NULL,NULL,'test@liferay.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1,'Gautamgggg',NULL,'Sharma','Upper Goving Nagar','Malad East','0',9324445952,91919191,9898989,0,'M','Mumbai','Maharashtra','India','gautam@gmail.com',NULL,NULL,1,NULL,'Y','Y','2014-04-29 23:11:57','2014-04-29 23:55:51');
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
  `Password` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usercredentials`
--

LOCK TABLES `usercredentials` WRITE;
/*!40000 ALTER TABLE `usercredentials` DISABLE KEYS */;
INSERT INTO `usercredentials` VALUES (1,'kenildoshi'),(2,'ke'),(3,'ke'),(4,'asd'),(5,'asd'),(6,'asd'),(7,'asd'),(9,'kirandoshi'),(10,'kenildoshi'),(11,'kenildoshi'),(12,'kenildoshi'),(13,'pratik'),(14,'kenildoshi'),(15,'binny'),(16,'Mayank'),(17,'KKD');
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
  `CreateDTTM` datetime DEFAULT NULL,
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
  `CreateDttm` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdateUserID` int(20) DEFAULT NULL,
  `UpdateDttm` datetime DEFAULT NULL,
  PRIMARY KEY (`UserSchoolID`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userschool`
--

LOCK TABLES `userschool` WRITE;
/*!40000 ALTER TABLE `userschool` DISABLE KEYS */;
INSERT INTO `userschool` VALUES (9,9,4,2001,2004,1994,1,'2014-04-05 13:16:56',NULL,NULL),(14,1,9,1985,1995,1995,1,'2014-04-27 01:19:55',NULL,NULL),(13,1,5,1993,1997,1997,1,'2014-04-23 19:46:23',NULL,NULL),(10,1,2,2004,2007,2007,1,'2014-04-23 00:13:05',NULL,NULL),(8,8,6,2001,2004,1994,0,'2014-04-05 12:25:10',NULL,NULL),(12,1,9,1988,1998,1998,1,'2014-04-23 01:03:00',NULL,NULL);
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
  `CreateDttm` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdateUserID` int(20) DEFAULT NULL,
  `UpdateDttm` datetime DEFAULT NULL,
  PRIMARY KEY (`PostID`),
  KEY `CreateUserID` (`CreateUserID`),
  KEY `UserID` (`UserID`),
  KEY `UpdateUserID` (`UpdateUserID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userupdates`
--

LOCK TABLES `userupdates` WRITE;
/*!40000 ALTER TABLE `userupdates` DISABLE KEYS */;
INSERT INTO `userupdates` VALUES (1,11,'Joined LINKALMA','Created LINKALMA account today. Lets explore','1',1,'2014-04-06 09:26:59',NULL,NULL),(2,11,'Neat','The dashboard looks neat, i am loving it...','1',1,'2014-04-06 09:26:59',NULL,NULL),(3,11,'School Addition','Oh i can see my school in the list, I will add it to my profile.','1',1,'2014-04-06 09:26:59',NULL,NULL);
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
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UserWorkplaceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userworkplace`
--

LOCK TABLES `userworkplace` WRITE;
/*!40000 ALTER TABLE `userworkplace` DISABLE KEYS */;
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

-- Dump completed on 2014-05-03 18:51:48
