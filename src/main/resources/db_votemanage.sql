/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : db_votemanage

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2018-02-13 18:53:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_channel
-- ----------------------------
DROP TABLE IF EXISTS `tb_channel`;
CREATE TABLE `tb_channel` (
  `channelID` int(11) NOT NULL AUTO_INCREMENT,
  `channelName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`channelID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_channel
-- ----------------------------
INSERT INTO `tb_channel` VALUES ('1', 'NBA');
INSERT INTO `tb_channel` VALUES ('2', 'CBA');
INSERT INTO `tb_channel` VALUES ('3', '足球世界杯');
INSERT INTO `tb_channel` VALUES ('4', '中超');
INSERT INTO `tb_channel` VALUES ('5', '英超');
INSERT INTO `tb_channel` VALUES ('6', 'F1');

-- ----------------------------
-- Table structure for tb_vote
-- ----------------------------
DROP TABLE IF EXISTS `tb_vote`;
CREATE TABLE `tb_vote` (
  `voteID` int(11) NOT NULL AUTO_INCREMENT,
  `voteName` varchar(255) DEFAULT NULL,
  `channelID` int(11) DEFAULT NULL,
  PRIMARY KEY (`voteID`),
  KEY `channelID` (`channelID`),
  CONSTRAINT `tb_vote_ibfk_1` FOREIGN KEY (`channelID`) REFERENCES `tb_channel` (`channelID`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_vote
-- ----------------------------

-- ----------------------------
-- Table structure for tb_voteoption
-- ----------------------------
DROP TABLE IF EXISTS `tb_voteoption`;
CREATE TABLE `tb_voteoption` (
  `voteOptionID` int(11) NOT NULL AUTO_INCREMENT,
  `voteID` int(11) DEFAULT NULL,
  `voteOptionName` varchar(255) DEFAULT NULL,
  `ticketNum` int(11) DEFAULT '0',
  PRIMARY KEY (`voteOptionID`),
  KEY `voteID` (`voteID`),
  CONSTRAINT `tb_voteoption_ibfk_1` FOREIGN KEY (`voteID`) REFERENCES `tb_vote` (`voteID`)
) ENGINE=InnoDB AUTO_INCREMENT=215 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_voteoption
-- ----------------------------
