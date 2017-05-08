/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50634
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-03-15 16:14:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for shop_discuss
-- ----------------------------
DROP TABLE IF EXISTS `shop_discuss`;
CREATE TABLE `shop_discuss` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `parentId` int(11) DEFAULT '0',
  `creatTime` datetime DEFAULT NULL,
  `detail` varchar(500) DEFAULT NULL,
  `stars` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_discuss
-- ----------------------------
INSERT INTO `shop_discuss` VALUES ('2', '1', '0', '2017-03-15 16:05:57', '测试评论2', '3');

-- ----------------------------
-- Table structure for shop_order
-- ----------------------------
DROP TABLE IF EXISTS `shop_order`;
CREATE TABLE `shop_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total` double DEFAULT NULL,
  `creatTime` datetime DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_order
-- ----------------------------
INSERT INTO `shop_order` VALUES ('1', '205', '2017-03-15 16:08:01', '2');
INSERT INTO `shop_order` VALUES ('2', '205', '2017-03-15 16:08:41', '2');

-- ----------------------------
-- Table structure for shop_orderandproducts
-- ----------------------------
DROP TABLE IF EXISTS `shop_orderandproducts`;
CREATE TABLE `shop_orderandproducts` (
  `orderId` int(11) NOT NULL,
  `productsId` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`orderId`,`productsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_orderandproducts
-- ----------------------------
INSERT INTO `shop_orderandproducts` VALUES ('1', '8', '3');

-- ----------------------------
-- Table structure for shop_products
-- ----------------------------
DROP TABLE IF EXISTS `shop_products`;
CREATE TABLE `shop_products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double(100,0) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `imgUrl` varchar(300) DEFAULT NULL,
  `info` varchar(500) DEFAULT NULL,
  `number` int(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_products
-- ----------------------------
INSERT INTO `shop_products` VALUES ('2', '测试的菜', '28', '1', '1.png', '测试数据', '1');

-- ----------------------------
-- Table structure for shop_productstype
-- ----------------------------
DROP TABLE IF EXISTS `shop_productstype`;
CREATE TABLE `shop_productstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(45) DEFAULT NULL,
  `typeInfo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_productstype
-- ----------------------------
INSERT INTO `shop_productstype` VALUES ('1', '测试3', '测试2');

-- ----------------------------
-- Table structure for shop_user
-- ----------------------------
DROP TABLE IF EXISTS `shop_user`;
CREATE TABLE `shop_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(300) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `imgUrl` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_user
-- ----------------------------
INSERT INTO `shop_user` VALUES ('1', '测试222', '123', '1', '1', '女');
INSERT INTO `shop_user` VALUES ('2', '九儿', 'b0fee69a6e5827d3d57ccf0132bdd2604e9580b62462f5fa8047d9c700bf66febe9ab5cac3941cb4', '0', 'logo.jpg', '女');
