/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : mybatis_plus

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 03/01/2022 23:40:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for USER
-- ----------------------------
DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER` (
  `id` bigint NOT NULL COMMENT '主键ID',
  `NAME` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `version` int DEFAULT NULL,
  `deleted` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of USER
-- ----------------------------
BEGIN;
INSERT INTO `USER` VALUES (1, '张四', 18, 'test1@baomidou.com', NULL, '2022-01-03 17:30:48', 2, 1);
INSERT INTO `USER` VALUES (2, 'Jack', 20, 'test2@baomidou.com', NULL, NULL, NULL, 0);
INSERT INTO `USER` VALUES (3, 'Tom', 28, 'test3@baomidou.com', NULL, NULL, NULL, 0);
INSERT INTO `USER` VALUES (4, 'Sandy', 21, 'test4@baomidou.com', NULL, NULL, NULL, 0);
INSERT INTO `USER` VALUES (5, 'Billie', 24, 'test5@baomidou.com', NULL, NULL, NULL, 0);
INSERT INTO `USER` VALUES (1477912194359250945, 'lucymary', 20, '1243@qq.com', NULL, NULL, NULL, 0);
INSERT INTO `USER` VALUES (1477912194359250946, 'lucy1', 20, '1243@qq.com', NULL, NULL, NULL, 0);
INSERT INTO `USER` VALUES (1477927860105670657, 'lucy1', 20, '1243@qq.com', NULL, NULL, NULL, 0);
INSERT INTO `USER` VALUES (1477927972148088834, 'lucy1', 20, '1243@qq.com', '2022-01-03 17:01:02', '2022-01-03 17:01:02', NULL, 0);
INSERT INTO `USER` VALUES (1477934278519029761, 'lucy1', 20, '1243@qq.com', '2022-01-03 17:26:05', '2022-01-03 17:26:05', 1, 0);
INSERT INTO `USER` VALUES (1477934349021093889, 'lucy1', 20, '1243@qq.com', '2022-01-03 17:26:22', '2022-01-03 17:26:22', 1, 0);
INSERT INTO `USER` VALUES (1478021459275796481, 'lucy1', 20, '1243@qq.com', '2022-01-03 23:12:31', '2022-01-03 23:12:31', 1, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
