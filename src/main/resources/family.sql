/*
Navicat MySQL Data Transfer

Source Server         : MyCon
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : family

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-02-05 11:25:15
*/
CREATE DATABASE `family` DEFAULT CHARACTER SET utf8;

USE `family`;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hr
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'userID',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `image` varchar(255) DEFAULT NULL COMMENT '头像',
  `memberId` int(11) DEFAULT '0' COMMENT 'memberID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `memberId` int(11) NOT NULL AUTO_INCREMENT COMMENT 'memberID',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `sex` tinyint(1) DEFAULT '1' COMMENT '性别',
  `image` varchar(255) DEFAULT NULL COMMENT '头像',
  `age` varchar(8) DEFAULT NULL COMMENT '年龄',
  `identity` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
  `address` varchar(64) DEFAULT NULL COMMENT '联系地址',
  `birthday` varchar(11) DEFAULT NULL COMMENT '生日',
  `rangName` char(11) DEFAULT NULL COMMENT '辈分',
  `occupy` char(11) DEFAULT NULL COMMENT '职业',
  `education` char(11) DEFAULT NULL COMMENT '学历',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `confirm` tinyint(1) DEFAULT '0',
  `disable` tinyint(1) DEFAULT '0',

  `fatherId` int(11) DEFAULT '0' COMMENT '父亲Id',
  `motherId` int(11) DEFAULT '0' COMMENT '母亲Id',
  `spouseId` int(11) DEFAULT '0' COMMENT '配偶Id',
  `fathersId` int(11) DEFAULT '0' COMMENT '养父亲Id',
  `mothersId` int(11) DEFAULT '0' COMMENT '养母亲Id',
  PRIMARY KEY (`memberId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hr
-- ----------------------------
INSERT INTO `member` VALUES ('1001', '乔峰', '1', 'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', '10', '42098219865562311', '100000000', '少林寺', '1122', '9','帮主','自学','丐帮','0','0','0','0','0','0','0');
INSERT INTO `user` VALUES ('1001', '18565391020', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', '0');


SET FOREIGN_KEY_CHECKS=1;
