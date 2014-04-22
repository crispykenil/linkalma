
DROP TABLE `userupdates`;
CREATE TABLE IF NOT EXISTS `userupdates` (
  `PostID` int(20) NOT NULL AUTO_INCREMENT,
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


DROP TABLE `comments`;
CREATE TABLE IF NOT EXISTS `comments` (
  `CommentID` int(20) NOT NULL AUTO_INCREMENT,
  `GroupID` int(20) DEFAULT NULL,
  `TopicID` int(20) DEFAULT NULL,
  `ActiveYN` char(1) DEFAULT NULL,
  `CreateUserID` int(20) DEFAULT NULL,
  `CreateDttm` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdateUserID` int(20) DEFAULT NULL,
  `UpdateDttm` datetime DEFAULT NULL,
  PRIMARY KEY (`CommentID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

DROP TABLE `credentials`;
CREATE TABLE IF NOT EXISTS `credentials` (
  `UserID` int(11) NOT NULL,
  `Password` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

DROP TABLE `donation`;
CREATE TABLE IF NOT EXISTS `donation` (
  `DonationID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(20) DEFAULT NULL,
  `SchoolID` int(20) DEFAULT NULL,
  `Amount` int(10) DEFAULT NULL,
  `Currency` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`DonationID`),
  KEY `SchoolID` (`SchoolID`),
  KEY `UserID` (`UserID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

DROP TABLE `groups`;
CREATE TABLE IF NOT EXISTS `groups` (
  `GroupID` int(20) NOT NULL AUTO_INCREMENT,
  `GroupName` varchar(255) DEFAULT NULL,
  `GroupAdmin` varchar(255) DEFAULT NULL,
  `SchoolID` varchar(255) DEFAULT NULL,
  `GroupType` varchar(255) DEFAULT NULL comment "Custom OR Alumni",
  `PublicViewYN` char(1) DEFAULT NULL,
  PRIMARY KEY (`GroupID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


DROP TABLE `referrals`;
CREATE TABLE IF NOT EXISTS `referrals` (
  `ReferralID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(20) DEFAULT NULL,
  `ReferralEmailID` varchar(40) DEFAULT NULL,
  `ReferralName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ReferralID`),
  KEY `ReferralEmailID` (`ReferralEmailID`),
  KEY `UserID` (`UserID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

DROP TABLE `school`;
CREATE TABLE IF NOT EXISTS `school` (
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

DROP TABLE `schoolnews`;
CREATE TABLE IF NOT EXISTS `schoolnews` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `SchoolID` int(20) DEFAULT NULL,
  `NewsDescription` varchar(255) DEFAULT NULL,
  `NewsType` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

DROP TABLE `schoolupdates`;
CREATE TABLE IF NOT EXISTS `schoolupdates` (
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

DROP TABLE `topics`;
CREATE TABLE IF NOT EXISTS `topics` (
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


 

DROP TABLE `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `UserID` int(20) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) NOT NULL,
  `MiddleName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `Address1` varchar(255) DEFAULT NULL,
  `Address2` varchar(255) DEFAULT NULL,
  `Phone1` int(11) DEFAULT NULL,
  `Phone2` int(11) DEFAULT NULL,
  `Phone3` int(11) DEFAULT NULL,
  `Phone4` int(11) DEFAULT NULL,
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

DROP TABLE `userschool`;
CREATE TABLE IF NOT EXISTS `userschool` (
  `UserSchoolID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(20) DEFAULT NULL,
  `SchoolID` int(20) DEFAULT NULL,
  `FromYear` date DEFAULT NULL,
  `ToYear` date DEFAULT NULL,
  `PassoutBatch` int(4) DEFAULT NULL,
  `CreateUserID` int(20) DEFAULT NULL,
  `CreateDttm` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdateUserID` int(20) DEFAULT NULL,
  `UpdateDttm` datetime DEFAULT NULL,
  PRIMARY KEY (`UserSchoolID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


DROP TABLE `StaticCodes`;
CREATE TABLE IF NOT EXISTS `StaticCodes` (  `CategoryID` INTEGER NOT NULL ,
`Code` int(10) NOT NULL,  
`PrimaryDecode` VARCHAR(30),  
`SecondaryDecode` VARCHAR(60))
ENGINE=myisam DEFAULT CHARSET=utf8;


CREATE TABLE `userhistory` (
  `UserID` int(11) NOT NULL,
  `FieldsChanged` varchar(45) NOT NULL,
  `FromValue` varchar(45) DEFAULT NULL,
  `ToValue` varchar(45) DEFAULT NULL,
  `ActionPerformed` char(1) NOT NULL,
  `CreateDTTM` datetime DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;



CREATE TABLE `friendrequest` (
  `FriendRequestID` int(11) NOT NULL AUTO_INCREMENT,
  `FromUserID` int(11) NOT NULL,
  `ToUserID` int(11) DEFAULT NULL,
  `Status` int(1) DEFAULT NULL,
  `RequestSentDTTM` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`FriendRequestID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `grouprequest` (
  `GroupRequestID` int(11) NOT NULL AUTO_INCREMENT,
  `FromUserID` int(11) NOT NULL,
  `ForGroupID` int(11) NOT NULL,
  `Status` int(1) DEFAULT NULL,
  `RequestSentDTTM` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`GroupRequestID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

