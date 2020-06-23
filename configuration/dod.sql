# Host: localhost  (Version 5.7.27)
# Date: 2020-06-23 23:08:48
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "documentinfo"
#

DROP TABLE IF EXISTS `documentinfo`;
CREATE TABLE `documentinfo` (
  `docId` int(11) NOT NULL AUTO_INCREMENT,
  `sn` varchar(20) NOT NULL DEFAULT '' COMMENT '编号',
  `fileName` varchar(20) NOT NULL DEFAULT '',
  `absolutePath` varchar(255) NOT NULL DEFAULT '',
  `description` varchar(255) NOT NULL DEFAULT '',
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `userId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`docId`),
  KEY `userId_1` (`userId`),
  CONSTRAINT `userId_1` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "documentinfo"
#


#
# Structure for table "userinfo"
#

DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(20) NOT NULL DEFAULT '',
  `role` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "userinfo"
#


#
# Structure for table "archiveinfo"
#

DROP TABLE IF EXISTS `archiveinfo`;
CREATE TABLE `archiveinfo` (
  `arId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL DEFAULT '',
  `keyword` varchar(20) NOT NULL DEFAULT '',
  `fileName` varchar(20) NOT NULL DEFAULT '',
  `catalogue` varchar(255) DEFAULT NULL COMMENT '目录',
  `securityClassfication` varchar(2) NOT NULL DEFAULT '',
  `absolutePath` varchar(255) NOT NULL DEFAULT '',
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `userId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`arId`),
  KEY `userId` (`userId`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "archiveinfo"
#

