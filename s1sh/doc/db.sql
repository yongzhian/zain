-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.14 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.5111
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 luman 的数据库结构
CREATE DATABASE IF NOT EXISTS `luman` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `luman`;

-- 导出  表 luman.sys_node 结构
CREATE TABLE IF NOT EXISTS `sys_node` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '节点父ID',
  `node_code` varchar(50) NOT NULL COMMENT '功能结点代码',
  `node_name` varchar(50) NOT NULL COMMENT '功能结点名称',
  `icon` varchar(50) DEFAULT NULL COMMENT '功能图标class',
  `url` varchar(200) DEFAULT NULL COMMENT '功能URL',
  `create_date` datetime NOT NULL COMMENT '添加时间',
  `is_valid` char(1) NOT NULL DEFAULT 'T' COMMENT '是否有效，T：有效、F：无效',
  `order_no` int(6) NOT NULL DEFAULT '0' COMMENT '节点序号',
  PRIMARY KEY (`id`),
  KEY `FK_PARENT_ID_REF_ID` (`parent_id`),
  CONSTRAINT `FK_PARENT_ID_REF_ID` FOREIGN KEY (`parent_id`) REFERENCES `sys_node` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='系统后台功能菜单';

-- 正在导出表  luman.sys_node 的数据：~9 rows (大约)
/*!40000 ALTER TABLE `sys_node` DISABLE KEYS */;
INSERT INTO `sys_node` (`id`, `parent_id`, `node_code`, `node_name`, `icon`, `url`, `create_date`, `is_valid`, `order_no`) VALUES
	(3, NULL, 'sys_mng', '系统管理', 'am-icon-linux', NULL, '2016-08-02 17:06:23', 'T', 8000),
	(4, 3, 'sys_user_mng', '系统用户管理', 'am-icon-child', '/sysmng/user/list/init.do', '2016-08-02 17:06:23', 'T', 8010),
	(5, 3, 'sys_node_mng', '系统功能管理', 'am-icon-cogs', '/sysmng/node/list/init.do', '2016-08-02 17:10:24', 'T', 8020),
	(6, 3, 'sys_role_mng', '系统角色管理', 'am-icon-group', '/sysmng/role/list/init.do', '2016-08-02 17:11:18', 'T', 8030),
	(7, NULL, 'robot_mng', '机器人管理', 'am-icon-android', NULL, '2016-08-04 15:37:14', 'T', 1000),
	(8, 7, 'robot_list', '机器人信息管理', 'am-icon-list', '/robot/list/init.do', '2016-08-04 15:38:15', 'T', 1010),
	(9, 7, 'robot_online_list', '在线机器人列表', 'am-icon-signal', '/robot/online/list.do', '2016-08-04 15:39:42', 'T', 1020),
	(10, 7, 'robot_alarm_list', '机器人报警信息', 'am-icon-phone', '/robot/alarm/list/init.do', '2016-08-04 15:41:09', 'T', 1030),
	(11, 7, 'robot_add_batch', '批量添加机器人', 'am-icon-pencil-square-o', '/robot/add_multi.jsp', '2016-08-04 15:45:04', 'T', 1040),
	(12, 7, 'robot_add', '添加机器人', 'am-icon-pencil-square-o', '/robot/add/init.do', '2016-08-04 15:46:34', 'T', 1050),
	(13, 7, 'robot_music_list', '机器人音乐管理', 'am-icon-music', '/robot/music/list/init.do', '2016-08-04 15:47:29', 'T', 1060),
	(14, 7, 'robot_usestate', '机器人使用情况', 'am-icon-line-chart', '/robot/usestate/list/init.do', '2016-08-04 15:48:50', 'T', 1070),
	(15, 7, 'zhumu_list', '机器人ZHUMU信息', 'am-icon-list', '/zhumu/server/conn/init.do', '2016-08-04 15:49:42', 'T', 1080),
	(16, NULL, 'user_mng', '用户管理', 'am-icon-users', NULL, '2016-08-04 15:51:03', 'T', 2000),
	(17, 16, 'user_list', '用户信息管理', 'am-icon-user', '/user/list/init.do', '2016-08-04 15:51:50', 'T', 2010),
	(18, 16, 'captcha_list', '短信验证码管理', 'am-icon-key', '/user/captcha/list/init.do', '2016-08-04 15:53:04', 'T', 2020),
	(19, 16, 'user_dev_list', '用户设备管理', 'am-icon-hdd-o', '/user/dev/list/init.do', '2016-08-04 15:54:01', 'T', 2030),
	(20, 16, 'user_add', '添加用户', 'am-icon-pencil-square-o', '/user/add/init.do', '2016-08-04 15:54:52', 'T', 2040),
	(21, NULL, 'version_mng', '版本管理', 'am-icon-cogs', NULL, '2016-08-04 15:55:55', 'T', 3000),
	(22, 21, 'version_list', '版本信息管理', 'am-icon-list', '/version/list/init.do', '2016-08-04 15:57:00', 'T', 3010),
	(23, 21, 'version_last_list', '当前最新版本信息', 'am-icon-th-large', '/version/last/list.do', '2016-08-04 15:57:55', 'T', 3020),
	(24, 21, 'version_robot_add', '添加机器版本', 'am-icon-pencil-square-o', '/version/robot/add/init.do', '2016-08-04 15:58:51', 'T', 3030),
	(25, 21, 'version_app_add', '添加手机APP版本', 'am-icon-mobile', '/version/app/add/init.do', '2016-08-04 16:00:18', 'T', 3040),
	(26, 21, 'version_update_his', '版本更新历史记录', 'am-icon-table', '/version/update/his/init.do', '2016-08-04 16:01:06', 'T', 3050),
	(27, NULL, 'community_mng', '社区管理', 'am-icon-slideshare', NULL, '2016-08-04 16:02:06', 'T', 4000),
	(28, 27, 'management_list', '小区管理', 'am-icon-th-large', '/community/management/list/init.do', '2016-08-04 16:03:06', 'T', 4010),
	(29, 27, 'buiding_list', '小区楼栋管理', 'am-icon-th-list', '/community/buiding/list/init.do', '2016-08-04 16:05:43', 'T', 4020),
	(30, 27, 'room_list', '小区门牌管理', 'am-icon-th-list', '/community/room/list/init.do', '2016-08-04 16:06:17', 'T', 4030),
	(31, 27, 'room_robot_list', '房间机器人信息', 'am-icon-android', '/community/room/robot/list/init.do', '2016-08-04 16:06:58', 'T', 4040),
	(32, NULL, 'sys_log', '系统日志', 'am-icon-file', NULL, '2016-08-04 16:08:27', 'T', 5000),
	(33, 32, 'api_log', 'API日志', 'am-icon-info-circle', '/log/api/index.do', '2016-08-04 16:09:32', 'T', 5010),
	(34, 32, 'push_log', '手机APP推送日志', 'am-icon-mobile', '/log/push/list/init.do', '2016-08-04 16:10:18', 'T', 5020),
	(35, 32, 'music_log', '音乐播放日志', 'am-icon-music', '/log/music/list/init.do', '2016-08-04 16:11:00', 'T', 5030),
	(36, 32, 'speech_log', '语音交互日志', 'am-icon-microphone', '/log/speech/list/init.do', '2016-08-04 16:11:23', 'T', 5040),
	(37, 32, 'rtc_room_log', 'RTC房间使用日志', 'am-icon-video-camera', '/log/rtcroom/list/init.do', '2016-08-04 16:12:47', 'T', 5050),
	(38, 32, 'xmpp_ext_log', 'XMPP登录日志', 'am-icon-sign-in', '/log/xmppext/list/init.do', '2016-08-04 16:13:41', 'T', 5060),
	(39, 32, 'xmpp_plugin_log', 'XMPP会话日志', 'am-icon-plug', '/log/xmppplugin/list/init.do', '2016-08-04 16:14:44', 'T', 5070),
	(40, NULL, 'rtc_server_mng', 'RTC服务器管理', 'am-icon-video-camera', NULL, '2016-08-04 16:15:26', 'T', 6000),
	(41, 40, 'rtc_server_list', 'RTC服务器信息', 'am-icon-list', '/rtc/server/list/init.do', '2016-08-04 16:16:46', 'T', 6010),
	(42, 40, 'rtc_server_add', '添加RTC服务器', 'am-icon-pencil-square-o', '/rtc/server/add/init.do', '2016-08-04 16:17:56', 'T', 6020),
	(43, 40, 'rtc_server_check_log', 'RTC服务器状态日志', 'am-icon-server', '/rtc/server/check/log/list/init.do', '2016-08-04 16:19:55', 'T', 6030),
	(44, 40, 'rtc_server_check_chart', 'RTC服务器运行状态', 'am-icon-line-chart', '/rtc/server/check/log/chart.do', '2016-08-04 16:20:24', 'T', 6040),
	(45, 40, 'rtc_server_conn_chart', 'RTC服务器连接历史', 'am-icon-line-chart', '/rtc/server/check/log/chart/conn.do', '2016-08-04 16:21:53', 'T', 6050),
	(46, NULL, 'as_service', '售后服务', 'am-icon-users', NULL, '2016-08-04 16:23:00', 'T', 7000),
	(47, 46, 'repair_list', '维修预约管理', 'am-icon-user', '/service/repair/list/init.do', '2016-08-04 16:23:37', 'T', 7010),
	(48, 46, 'install_list', '安装预约管理', 'am-icon-pencil-square-o', '/service/install/list/init.do', '2016-08-04 16:24:28', 'T', 7020),
	(49, 46, 'take_list', '领用信息管理', 'am-icon-key', '/service/take/list/init.do', '2016-08-04 16:25:01', 'T', 7030),
	(50, 16, 'user_feedback', '用户反馈', 'am-icon-envelope', '/community/management/list/init.do', '2016-08-04 16:28:05', 'T', 2050),
	(51, 3, 'sys_cache_mng', '系统缓存管理', 'am-icon-cubes', '/rediscache/list/init.do', '2016-08-04 16:30:39', 'T', 8040),
	(52, NULL, 'statistic_analysis', '统计分析', 'am-icon-line-chart', NULL, '2016-08-19 10:41:00', 'T', 9000),
	(53, 52, 'usage_stat', '机器人使用情况统计', 'am-icon-line-chart', '/statistics/robot/usage/init.do', '2016-08-22 15:08:49', 'T', 9010),
	(54, 52, 'active_stat', '机器人在线情况统计', 'am-icon-line-chart', '/statistics/robot/active/init.do', '2016-08-23 09:03:32', 'T', 9020),
	(55, 52, 'activation_reg_stat', '机器人激活及用户注册', 'am-icon-line-chart', '/statistics/activation/reg/init.do', '2016-08-23 16:28:24', 'T', 9030),
	(56, 52, 'svc_invoke_stat', '各服务被调用情况', 'am-icon-line-chart', '/statistics/service/invoke/init.do', '2016-08-24 16:36:16', 'T', 9040),
	(57, 52, 'speech_stat', '语音交互情况统计', 'am-icon-line-chart', '/statistics/speech/stat/init.do', '2016-08-31 18:43:02', 'T', 9050);
/*!40000 ALTER TABLE `sys_node` ENABLE KEYS */;

-- 导出  表 luman.sys_role 结构
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) NOT NULL COMMENT '角色代码',
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `is_valid` char(1) NOT NULL DEFAULT 'T' COMMENT '是否有效，T：有效、F：无效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='系统后台角色';

-- 正在导出表  luman.sys_role 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`id`, `role_code`, `role_name`, `is_valid`, `create_time`) VALUES
	(1, 'server_team', '服务器组', 'T', '2016-07-14 14:44:40'),
	(5, 'test_team', '测试组', 'T', '2016-08-05 11:26:13'),
	(6, 'product_team', '产品组', 'T', '2016-08-05 11:26:34'),
	(7, 'robot_team', '机器人组', 'T', '2016-08-05 11:26:54'),
	(8, 'app_team', '手机APP组', 'T', '2016-08-05 11:29:06'),
	(9, 'after_sale_team', '售后服务组', 'T', '2016-08-05 11:30:36');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;

-- 导出  表 luman.sys_role_node 结构
CREATE TABLE IF NOT EXISTS `sys_role_node` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sys_node_id` bigint(20) NOT NULL COMMENT '系统功能结点id',
  `sys_role_id` bigint(20) NOT NULL COMMENT '系统角色id',
  PRIMARY KEY (`id`),
  KEY `FK_SRN_REF_SYSNODE` (`sys_node_id`),
  KEY `FK_SRN_REF_SYSROLE` (`sys_role_id`),
  CONSTRAINT `FK_SRN_REF_SYSNODE` FOREIGN KEY (`sys_node_id`) REFERENCES `sys_node` (`id`),
  CONSTRAINT `FK_SRN_REF_SYSROLE` FOREIGN KEY (`sys_role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='系统后台角色功能关联表';

-- 正在导出表  luman.sys_role_node 的数据：~99 rows (大约)
/*!40000 ALTER TABLE `sys_role_node` DISABLE KEYS */;
INSERT INTO `sys_role_node` (`id`, `sys_node_id`, `sys_role_id`) VALUES
	(1, 7, 5),
	(2, 9, 5),
	(3, 10, 5),
	(4, 13, 5),
	(5, 7, 1),
	(6, 8, 1),
	(7, 9, 1),
	(8, 10, 1),
	(9, 11, 1),
	(10, 12, 1),
	(11, 13, 1),
	(12, 14, 1),
	(13, 15, 1),
	(14, 3, 1),
	(15, 4, 1),
	(16, 5, 1),
	(17, 6, 1),
	(18, 51, 1),
	(19, 27, 1),
	(20, 28, 1),
	(21, 29, 1),
	(22, 30, 1),
	(23, 31, 1),
	(24, 16, 1),
	(25, 17, 1),
	(26, 18, 1),
	(27, 19, 1),
	(28, 20, 1),
	(29, 50, 1),
	(30, 21, 5),
	(31, 23, 5),
	(32, 27, 5),
	(33, 30, 5),
	(34, 31, 5),
	(35, 32, 5),
	(36, 35, 5),
	(37, 36, 5),
	(38, 38, 5),
	(39, 46, 9),
	(40, 49, 9),
	(41, 7, 6),
	(42, 9, 6),
	(43, 10, 6),
	(44, 13, 6),
	(45, 21, 6),
	(46, 23, 6),
	(47, 27, 6),
	(48, 30, 6),
	(49, 31, 6),
	(50, 32, 6),
	(51, 35, 6),
	(52, 36, 6),
	(53, 27, 9),
	(54, 30, 9),
	(55, 31, 9),
	(56, 38, 6),
	(57, 21, 1),
	(58, 22, 1),
	(59, 23, 1),
	(60, 24, 1),
	(61, 25, 1),
	(62, 26, 1),
	(63, 32, 1),
	(64, 33, 1),
	(65, 34, 1),
	(66, 35, 1),
	(67, 36, 1),
	(68, 37, 1),
	(69, 38, 1),
	(70, 39, 1),
	(71, 40, 1),
	(72, 41, 1),
	(73, 42, 1),
	(74, 43, 1),
	(75, 44, 1),
	(76, 45, 1),
	(77, 46, 1),
	(78, 47, 1),
	(79, 48, 1),
	(80, 49, 1),
	(81, 7, 7),
	(82, 9, 7),
	(83, 10, 7),
	(84, 21, 7),
	(85, 23, 7),
	(86, 32, 7),
	(87, 33, 7),
	(88, 35, 7),
	(89, 36, 7),
	(90, 38, 7),
	(91, 39, 7),
	(92, 7, 9),
	(93, 9, 9),
	(94, 52, 1),
	(95, 53, 1),
	(96, 54, 1),
	(97, 55, 1),
	(98, 56, 1),
	(99, 57, 1);
/*!40000 ALTER TABLE `sys_role_node` ENABLE KEYS */;

-- 导出  表 luman.sys_user 结构
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `full_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `email` varchar(50) DEFAULT NULL,
  `is_valid` char(1) NOT NULL DEFAULT 'T' COMMENT '是否有效，T：有效、F：无效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `last_login` datetime DEFAULT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(50) DEFAULT NULL COMMENT '最后登录IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='系统后台用户';

-- 正在导出表  luman.sys_user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`id`, `username`, `password`, `full_name`, `email`, `is_valid`, `create_time`, `last_login`, `last_login_ip`) VALUES
	(1, 'frank', '8ccb0a1b4209616ad379fa91766989bf', '管理员', NULL, 'T', '2015-08-12 16:16:15', '2016-07-29 17:26:51', '192.168.1.1'),
	(2, 'astest', '93279e3308bdbbeed946fc965017f67a', '售后测试账号', NULL, 'T', '2016-06-29 15:13:00', '2016-07-07 14:17:15', '192.168.1.1'),
	(3, 'test05', 'defa50a7babc2b727c44fe4e03905bf4', '产品测试账号', NULL, 'T', '2016-07-07 13:53:48', '2016-07-23 21:17:04', '112.65.1.164'),
	(4, 'jiangmei', 'defa50a7babc2b727c44fe4e03905bf4', '姜美', NULL, 'T', '2016-07-07 14:18:03', '2016-07-07 14:20:14', '192.168.1.1'),
	(5, 'yanxd', '71946d6f6c5fd7e031f49b5191910e8b', '颜小冬', NULL, 'T', '2016-07-07 14:19:05', '2016-07-07 14:25:48', '192.168.1.1'),
	(6, 'yongza', 'f209d8a04a494e3dac779ec0b4b1195f', '雍工', NULL, 'T', '2016-07-29 17:53:15', NULL, NULL);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;

-- 导出  表 luman.sys_user_role 结构
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sys_user_id` bigint(20) DEFAULT NULL,
  `sys_role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SUR_REF_SYSUSER` (`sys_user_id`),
  KEY `FK_SUR_REF_SYSROLE` (`sys_role_id`),
  CONSTRAINT `FK_SUR_REF_SYSROLE` FOREIGN KEY (`sys_role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `FK_SUR_REF_SYSUSER` FOREIGN KEY (`sys_user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='系统后台用户角色关联表';

-- 正在导出表  luman.sys_user_role 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`id`, `sys_user_id`, `sys_role_id`) VALUES
	(1, 1, 1),
	(2, 6, 1),
	(3, 3, 6),
	(4, 2, 5);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
