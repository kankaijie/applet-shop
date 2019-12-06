/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : applet-shop

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-11-13 15:35:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for m_menu
-- ----------------------------
DROP TABLE IF EXISTS `m_menu`;
CREATE TABLE `m_menu` (
  `id` int(11) NOT NULL COMMENT '主键id',
  `pid` varchar(100) DEFAULT NULL COMMENT '父级id',
  `name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `page` varchar(300) DEFAULT NULL COMMENT '指向页面',
  `status` tinyint(1) NOT NULL COMMENT '是否删除 1、正常 2、冻结 3、删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Records of m_menu
-- ----------------------------

-- ----------------------------
-- Table structure for m_role
-- ----------------------------
DROP TABLE IF EXISTS `m_role`;
CREATE TABLE `m_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名字',
  `role_card` varchar(100) DEFAULT NULL COMMENT '（暂时无用）',
  `is_manager` tinyint(1) DEFAULT NULL COMMENT '是否可以登录后台管理',
  `status` tinyint(1) DEFAULT NULL COMMENT '是否删除 1、正常 2、冻结 3、删除',
  `delete_user` int(11) DEFAULT NULL COMMENT '删除操作人',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user` int(11) DEFAULT NULL COMMENT '编辑操作人',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of m_role
-- ----------------------------

-- ----------------------------
-- Table structure for m_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `m_role_menu`;
CREATE TABLE `m_role_menu` (
  `menu_id` int(11) NOT NULL COMMENT '角色菜单id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `status` tinyint(1) NOT NULL COMMENT '是否删除 1、正常    2、冻结  3、删除 ',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_user` int(11) DEFAULT NULL COMMENT '删除编辑人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  KEY `FK_Reference_2` (`role_id`),
  KEY `FK_Reference_3` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

-- ----------------------------
-- Records of m_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for m_role_rule
-- ----------------------------
DROP TABLE IF EXISTS `m_role_rule`;
CREATE TABLE `m_role_rule` (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `rule_id` int(11) NOT NULL COMMENT '权限id',
  `status` tinyint(1) NOT NULL COMMENT '是否删除 1、正常 2、冻结 3、删除',
  `delete_user` int(11) DEFAULT NULL COMMENT '删除操作人',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-权限';

-- ----------------------------
-- Records of m_role_rule
-- ----------------------------

-- ----------------------------
-- Table structure for m_rule
-- ----------------------------
DROP TABLE IF EXISTS `m_rule`;
CREATE TABLE `m_rule` (
  `rule_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `rule_card` varchar(50) DEFAULT NULL COMMENT '(暂时无用)',
  `rule_url` varchar(50) DEFAULT NULL COMMENT '所对应的URI',
  `rule_name` varchar(200) DEFAULT NULL COMMENT '权限名称',
  `status` tinyint(1) DEFAULT NULL COMMENT '是否删除 1、是  2、否 3、删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_user` int(11) DEFAULT NULL COMMENT '删除操作人',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user` int(11) DEFAULT NULL COMMENT '修改人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`rule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of m_rule
-- ----------------------------

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(10) NOT NULL,
  `password` varchar(255) NOT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` tinyint(1) NOT NULL COMMENT '1、正常 2、冻结 3、删除',
  `source` tinyint(1) NOT NULL COMMENT '数据来源 1、前台 2、后台  3、微信 4、app',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `head_image` varchar(255) DEFAULT NULL COMMENT '头像',
  `phone` varchar(30) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of m_user
-- ----------------------------

-- ----------------------------
-- Table structure for m_user_role
-- ----------------------------
DROP TABLE IF EXISTS `m_user_role`;
CREATE TABLE `m_user_role` (
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `status` tinyint(1) DEFAULT NULL COMMENT '是否删除 1、正常 2、冻结 3、删除',
  `delete_user` int(11) DEFAULT NULL COMMENT '删除操作人',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色表';

-- ----------------------------
-- Records of m_user_role
-- ----------------------------
