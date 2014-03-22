 

CREATE TABLE `userupdates` (
  `PostID` int(11) NOT NULL AUTO_INCREMENT,
  `UserlID` varchar(255) DEFAULT NULL,
  `Subject` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `UploadedOn` varchar(255) DEFAULT NULL,
  `CreateUserID` varchar(255) DEFAULT NULL,
  `CreateDttm` varchar(255) DEFAULT NULL,
  `UpdateUserID` varchar(255) DEFAULT NULL,
  `UpdateDttm` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PostID`),
  KEY `CreateUserID` (`CreateUserID`),
  KEY `UserlID` (`UserlID`),
  KEY `UpdateUserID` (`UpdateUserID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

CREATE TABLE `comments` (
  `CommentID` int(11) NOT NULL AUTO_INCREMENT,
  `GroupID` varchar(255) DEFAULT NULL,
  `TopicID` varchar(255) DEFAULT NULL,
  `ActiveYN` varchar(255) DEFAULT NULL,
  `CreateUserID` varchar(255) DEFAULT NULL,
  `CreateDttm` varchar(255) DEFAULT NULL,
  `UpdateUserID` varchar(255) DEFAULT NULL,
  `UpdateDttm` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CommentID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

CREATE TABLE `credentials` (
  `UserID` int(11) NOT NULL,
  `Password` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

CREATE TABLE `donation` (
  `DonationID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` varchar(255) DEFAULT NULL,
  `SchoolID` varchar(255) DEFAULT NULL,
  `Amount` varchar(255) DEFAULT NULL,
  `Currency` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`DonationID`),
  KEY `SchoolID` (`SchoolID`),
  KEY `UserID` (`UserID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

CREATE TABLE `groups` (
  `GroupID` int(11) NOT NULL AUTO_INCREMENT,
  `GroupName` varchar(255) DEFAULT NULL,
  `GroupAdmin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`GroupID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

CREATE TABLE `referrals` (
  `ReferralID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` varchar(255) DEFAULT NULL,
  `EmailID` varchar(255) DEFAULT NULL,
  `ReferralName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ReferralID`),
  KEY `EmailID` (`EmailID`),
  KEY `UserID` (`UserID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

CREATE TABLE `school` (
  `SchoolID` int(11) NOT NULL AUTO_INCREMENT,
  `SchoolName` varchar(255) DEFAULT NULL,
  `SchoolAddress1` varchar(255) DEFAULT NULL,
  `SchoolAddress2` varchar(255) DEFAULT NULL,
  `Branch` varchar(255) DEFAULT NULL,
  `WebsiteAddress` varchar(255) DEFAULT NULL,
  `Approved` varchar(255) DEFAULT NULL,
  `CreateDttm` varchar(255) DEFAULT NULL,
  `CreateUserID` varchar(255) DEFAULT NULL,
  `UpdateDttm` varchar(255) DEFAULT NULL,
  `UpdateUserID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`SchoolID`),
  KEY `CreateUserID` (`CreateUserID`),
  KEY `UpdateUserID` (`UpdateUserID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

CREATE TABLE `schoolnews` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SchoolID` varchar(255) DEFAULT NULL,
  `NewsDescription` varchar(255) DEFAULT NULL,
  `NewsType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

CREATE TABLE `schoolupdates` (
  `PostID` int(11) NOT NULL AUTO_INCREMENT,
  `SchoolID` varchar(255) DEFAULT NULL,
  `Subject` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `CreateUserID` varchar(255) DEFAULT NULL,
  `CreateDttm` varchar(255) DEFAULT NULL,
  `UpdateUserID` varchar(255) DEFAULT NULL,
  `UpdateDttm` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PostID`),
  KEY `CreateUserID` (`CreateUserID`),
  KEY `SchoolID` (`SchoolID`),
  KEY `UpdateUserID` (`UpdateUserID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

CREATE TABLE `topics` (
  `TopicID` int(11) NOT NULL AUTO_INCREMENT,
  `Topic` varchar(255) DEFAULT NULL,
  `TopicDate` varchar(255) DEFAULT NULL,
  `TopicCategory` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`TopicID`),
  KEY `TopicDate` (`TopicDate`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

CREATE TABLE `user` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) NOT NULL,
  `MiddleName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `Address1` varchar(255) DEFAULT NULL,
  `Address2` varchar(255) DEFAULT NULL,
  `Phone1` int(11) DEFAULT NULL,
  `Phone2` int(11) DEFAULT NULL,
  `Phone3` int(11) DEFAULT NULL,
  `Phone4` int(11) DEFAULT NULL,
  `Gender` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `State` varchar(255) DEFAULT NULL,
  `Country` varchar(255) DEFAULT NULL,
  `EmailAddress` varchar(255) NOT NULL,
  `DOB` varchar(255) DEFAULT NULL,
  `AboutMe` varchar(255) DEFAULT NULL,
  `Photo` varchar(255) DEFAULT NULL,
  `Approved` varchar(255) DEFAULT NULL,
  `CreateDttm` varchar(255) DEFAULT NULL,
  `UpdateDttm` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

CREATE TABLE `userschool` (
  `UserSchoolID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` varchar(255) DEFAULT NULL,
  `SchoolID` varchar(255) DEFAULT NULL,
  `FromYear` varchar(255) DEFAULT NULL,
  `ToYear` varchar(255) DEFAULT NULL,
  `PassoutBatch` varchar(255) DEFAULT NULL,
  `CreateUserID` varchar(255) DEFAULT NULL,
  `CreateDttm` varchar(255) DEFAULT NULL,
  `UpdateUserID` varchar(255) DEFAULT NULL,
  `UpdateDttm` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UserSchoolID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

CREATE TABLE `topics` (
  `TopicID` int(11) NOT NULL AUTO_INCREMENT,
  `Topic` varchar(255) DEFAULT NULL,
  `TopicDate` varchar(255) DEFAULT NULL,
  `TopicCategory` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`TopicID`),
  KEY `TopicDate` (`TopicDate`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


 

CREATE TABLE `userupdates` (
  `PostID` int(11) NOT NULL AUTO_INCREMENT,
  `UserlID` varchar(255) DEFAULT NULL,
  `Subject` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `UploadedOn` varchar(255) DEFAULT NULL,
  `CreateUserID` varchar(255) DEFAULT NULL,
  `CreateDttm` varchar(255) DEFAULT NULL,
  `UpdateUserID` varchar(255) DEFAULT NULL,
  `UpdateDttm` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PostID`),
  KEY `CreateUserID` (`CreateUserID`),
  KEY `UserlID` (`UserlID`),
  KEY `UpdateUserID` (`UpdateUserID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


