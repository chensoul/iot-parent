/*
SQLyog Professional v12.09 (64 bit)
MySQL - 8.0.26 : Database - db_iot
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_iot` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `db_iot`;

/*Table structure for table `device_atrr_data` */

DROP TABLE IF EXISTS `device_atrr_data`;

CREATE TABLE `device_atrr_data` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `message_id` varchar(50) DEFAULT NULL,
  `product_id` bigint DEFAULT NULL COMMENT '产品id',
  `device_id` bigint NOT NULL DEFAULT '0' COMMENT '设备id',
  `model_attr_id` bigint NOT NULL DEFAULT '0' COMMENT '物模型属性Id',
  `data_type_id` bigint DEFAULT NULL COMMENT '数据类型id',
  `data_value` varchar(255) DEFAULT NULL COMMENT '属性值',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态（1正常 0停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='设备属性数据表';

/*Data for the table `device_atrr_data` */

insert  into `device_atrr_data`(`id`,`message_id`,`product_id`,`device_id`,`model_attr_id`,`data_type_id`,`data_value`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'120cdllaw5',7,5,7,1,'5','1','0','','2024-07-24 10:40:44','',NULL,NULL),(2,'ulbjolbl2f',7,5,7,1,'3','1','0','','2024-07-24 10:50:40','',NULL,NULL),(3,'ao91xqe3jx',7,5,7,1,'4','1','0','','2024-07-24 10:55:47','',NULL,NULL),(4,'uoqgvgind8',7,5,7,1,'5','1','0','','2024-07-24 10:57:47','',NULL,NULL),(5,'oohaml16nv',7,5,7,1,'4','1','0','','2024-07-24 10:58:27','',NULL,NULL),(6,'3n3jx2n353',7,5,7,1,'4','1','0','','2024-07-24 11:07:09','',NULL,NULL),(7,'sudrzh5r9t',7,5,7,1,'4','1','0','','2024-07-24 11:12:48','',NULL,NULL),(8,'4vwipo3u5o',7,5,7,1,'5','1','0','','2024-07-24 11:15:25','',NULL,NULL),(9,'jnl3rwylbj',7,5,7,1,'4','1','0','','2024-07-24 11:16:23','',NULL,NULL),(10,'97basyfdts',7,5,7,1,'5','1','0','','2024-07-24 11:16:48','',NULL,NULL),(11,'ea3jsdz64r',7,5,7,1,'3','1','0','','2024-07-24 11:17:00','',NULL,NULL),(12,'u9qtdombiw',7,5,7,1,'3','1','0','','2024-07-24 11:17:52','',NULL,NULL),(13,'g0j0jw6ury',7,5,7,1,'3','1','0','','2024-07-24 11:18:28','',NULL,NULL),(14,'p6gvqansg3',7,5,7,1,'3','1','0','','2024-07-24 11:19:56','',NULL,NULL),(15,'yqx66sao7d',7,5,11,1,'3','1','0','','2024-07-24 11:20:27','',NULL,NULL);

/*Table structure for table `device_connect_count` */

DROP TABLE IF EXISTS `device_connect_count`;

CREATE TABLE `device_connect_count` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `dimension_time` datetime DEFAULT NULL COMMENT '统计维度时间（到小时）',
  `num` int NOT NULL DEFAULT '1' COMMENT '统计个数',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8553 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='设备连接统计表';

/*Data for the table `device_connect_count` */

insert  into `device_connect_count`(`id`,`dimension_time`,`num`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (8528,'2024-05-03 15:00:00',1,'0','',NULL,'',NULL,NULL),(8529,'2024-05-10 15:00:00',2,'0','',NULL,'',NULL,NULL),(8530,'2024-05-15 15:00:00',1,'0','',NULL,'',NULL,NULL),(8531,'2024-05-20 10:00:00',3,'0','',NULL,'',NULL,NULL),(8532,'2024-05-25 15:00:00',1,'0','',NULL,'',NULL,NULL),(8533,'2024-06-11 15:00:00',2,'0','',NULL,'',NULL,NULL),(8534,'2024-06-12 14:00:00',2,'0','',NULL,'',NULL,NULL),(8535,'2024-06-26 10:00:00',1,'0','',NULL,'',NULL,NULL),(8536,'2024-06-26 11:00:00',1,'0','',NULL,'',NULL,NULL),(8537,'2024-06-28 14:00:00',1,'0','',NULL,'',NULL,NULL),(8538,'2024-06-28 17:00:00',1,'0','',NULL,'',NULL,NULL),(8539,'2024-06-28 19:00:00',1,'0','',NULL,'',NULL,NULL),(8540,'2024-06-29 13:00:00',1,'0','',NULL,'',NULL,NULL),(8541,'2024-07-01 18:00:00',1,'0','',NULL,'',NULL,NULL),(8542,'2024-07-03 16:00:00',1,'0','',NULL,'',NULL,NULL),(8543,'2024-07-04 00:00:00',1,'0','',NULL,'',NULL,NULL),(8544,'2024-07-05 15:00:00',2,'0','',NULL,'',NULL,NULL),(8545,'2024-07-05 16:00:00',2,'0','',NULL,'',NULL,NULL),(8546,'2024-07-08 10:00:00',1,'0','',NULL,'',NULL,NULL),(8547,'2024-07-24 17:00:00',1,'0','',NULL,'',NULL,NULL),(8548,'2024-07-24 17:00:00',1,'0','',NULL,'',NULL,NULL),(8549,'2024-07-25 09:00:00',1,'0','',NULL,'',NULL,NULL),(8550,'2024-07-25 14:00:00',1,'0','',NULL,'',NULL,NULL),(8551,'2024-07-31 00:00:00',1,'0','',NULL,'',NULL,NULL),(8552,'2024-07-31 00:00:00',1,'0','',NULL,'',NULL,NULL);

/*Table structure for table `device_connect_log` */

DROP TABLE IF EXISTS `device_connect_log`;

CREATE TABLE `device_connect_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_id` bigint NOT NULL DEFAULT '0' COMMENT '产品id',
  `device_id` bigint NOT NULL DEFAULT '0' COMMENT '设备id',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态（1连接 0断开）',
  `dimension_time` datetime DEFAULT NULL COMMENT '统计维度时间（到小时）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='设备连接日志表';

/*Data for the table `device_connect_log` */

insert  into `device_connect_log`(`id`,`product_id`,`device_id`,`status`,`dimension_time`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:34','',NULL,NULL),(2,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:34','',NULL,NULL),(3,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:35','',NULL,NULL),(4,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:35','',NULL,NULL),(5,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:36','',NULL,NULL),(6,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:36','',NULL,NULL),(7,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:38','',NULL,NULL),(8,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:38','',NULL,NULL),(9,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:39','',NULL,NULL),(10,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:39','',NULL,NULL),(11,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:41','',NULL,NULL),(12,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:41','',NULL,NULL),(13,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:42','',NULL,NULL),(14,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:42','',NULL,NULL),(15,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:43','',NULL,NULL),(16,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:44','',NULL,NULL),(17,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:45','',NULL,NULL),(18,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:45','',NULL,NULL),(19,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:46','',NULL,NULL),(20,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:47','',NULL,NULL),(21,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:47','',NULL,NULL),(22,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:47','',NULL,NULL),(23,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:48','',NULL,NULL),(24,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:48','',NULL,NULL),(25,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:50','',NULL,NULL),(26,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:50','',NULL,NULL),(27,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:51','',NULL,NULL),(28,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:51','',NULL,NULL),(29,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:53','',NULL,NULL),(30,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:53','',NULL,NULL),(31,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:53','',NULL,NULL),(32,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:53','',NULL,NULL),(33,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:55','',NULL,NULL),(34,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:55','',NULL,NULL),(35,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:56','',NULL,NULL),(36,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:56','',NULL,NULL),(37,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:58','',NULL,NULL),(38,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:58','',NULL,NULL),(39,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:31:59','',NULL,NULL),(40,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:31:59','',NULL,NULL),(41,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:00','',NULL,NULL),(42,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:01','',NULL,NULL),(43,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:02','',NULL,NULL),(44,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:02','',NULL,NULL),(45,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:02','',NULL,NULL),(46,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:02','',NULL,NULL),(47,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:04','',NULL,NULL),(48,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:04','',NULL,NULL),(49,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:05','',NULL,NULL),(50,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:06','',NULL,NULL),(51,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:07','',NULL,NULL),(52,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:07','',NULL,NULL),(53,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:08','',NULL,NULL),(54,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:09','',NULL,NULL),(55,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:10','',NULL,NULL),(56,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:10','',NULL,NULL),(57,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:11','',NULL,NULL),(58,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:11','',NULL,NULL),(59,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:13','',NULL,NULL),(60,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:13','',NULL,NULL),(61,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:14','',NULL,NULL),(62,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:14','',NULL,NULL),(63,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:14','',NULL,NULL),(64,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:15','',NULL,NULL),(65,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:16','',NULL,NULL),(66,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:16','',NULL,NULL),(67,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:17','',NULL,NULL),(68,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:18','',NULL,NULL),(69,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:18','',NULL,NULL),(70,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:18','',NULL,NULL),(71,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:19','',NULL,NULL),(72,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:19','',NULL,NULL),(73,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:21','',NULL,NULL),(74,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:21','',NULL,NULL),(75,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:22','',NULL,NULL),(76,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:22','',NULL,NULL),(77,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:24','',NULL,NULL),(78,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:24','',NULL,NULL),(79,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:25','',NULL,NULL),(80,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:25','',NULL,NULL),(81,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:27','',NULL,NULL),(82,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:27','',NULL,NULL),(83,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:28','',NULL,NULL),(84,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:28','',NULL,NULL),(85,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:29','',NULL,NULL),(86,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:30','',NULL,NULL),(87,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:31','',NULL,NULL),(88,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:31','',NULL,NULL),(89,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:32','',NULL,NULL),(90,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:32','',NULL,NULL),(91,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:33','',NULL,NULL),(92,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:33','',NULL,NULL),(93,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:33','',NULL,NULL),(94,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:33','',NULL,NULL),(95,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:34','',NULL,NULL),(96,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:34','',NULL,NULL),(97,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:34','',NULL,NULL),(98,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:34','',NULL,NULL),(99,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:36','',NULL,NULL),(100,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:36','',NULL,NULL),(101,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:37','',NULL,NULL),(102,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:37','',NULL,NULL),(103,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:38','',NULL,NULL),(104,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:38','',NULL,NULL),(105,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:40','',NULL,NULL),(106,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:40','',NULL,NULL),(107,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:41','',NULL,NULL),(108,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:41','',NULL,NULL),(109,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:43','',NULL,NULL),(110,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:43','',NULL,NULL),(111,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:44','',NULL,NULL),(112,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:44','',NULL,NULL),(113,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:46','',NULL,NULL),(114,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:46','',NULL,NULL),(115,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:47','',NULL,NULL),(116,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:47','',NULL,NULL),(117,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:49','',NULL,NULL),(118,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:49','',NULL,NULL),(119,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:50','',NULL,NULL),(120,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:50','',NULL,NULL),(121,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:51','',NULL,NULL),(122,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:52','',NULL,NULL),(123,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:53','',NULL,NULL),(124,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:53','',NULL,NULL),(125,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:54','',NULL,NULL),(126,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:54','',NULL,NULL),(127,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:56','',NULL,NULL),(128,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:56','',NULL,NULL),(129,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:57','',NULL,NULL),(130,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:57','',NULL,NULL),(131,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:32:59','',NULL,NULL),(132,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:32:59','',NULL,NULL),(133,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:00','',NULL,NULL),(134,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:00','',NULL,NULL),(135,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:01','',NULL,NULL),(136,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:02','',NULL,NULL),(137,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:03','',NULL,NULL),(138,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:03','',NULL,NULL),(139,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:04','',NULL,NULL),(140,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:05','',NULL,NULL),(141,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:06','',NULL,NULL),(142,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:06','',NULL,NULL),(143,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:07','',NULL,NULL),(144,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:08','',NULL,NULL),(145,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:09','',NULL,NULL),(146,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:09','',NULL,NULL),(147,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:09','',NULL,NULL),(148,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:09','',NULL,NULL),(149,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:10','',NULL,NULL),(150,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:11','',NULL,NULL),(151,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:12','',NULL,NULL),(152,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:12','',NULL,NULL),(153,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:13','',NULL,NULL),(154,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:13','',NULL,NULL),(155,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:15','',NULL,NULL),(156,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:15','',NULL,NULL),(157,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:16','',NULL,NULL),(158,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:16','',NULL,NULL),(159,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:18','',NULL,NULL),(160,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:18','',NULL,NULL),(161,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:19','',NULL,NULL),(162,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:19','',NULL,NULL),(163,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:21','',NULL,NULL),(164,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:21','',NULL,NULL),(165,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:22','',NULL,NULL),(166,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:22','',NULL,NULL),(167,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:23','',NULL,NULL),(168,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:24','',NULL,NULL),(169,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:25','',NULL,NULL),(170,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:25','',NULL,NULL),(171,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:33:26','',NULL,NULL),(172,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:33:26','',NULL,NULL),(173,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:34:14','',NULL,NULL),(174,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:34:14','',NULL,NULL),(175,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:34:15','',NULL,NULL),(176,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:34:15','',NULL,NULL),(177,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:34:16','',NULL,NULL),(178,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:34:17','',NULL,NULL),(179,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:34:18','',NULL,NULL),(180,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:34:18','',NULL,NULL),(181,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:34:19','',NULL,NULL),(182,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:34:19','',NULL,NULL),(183,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:34:21','',NULL,NULL),(184,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:34:21','',NULL,NULL),(185,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:39:36','',NULL,NULL),(186,1,2,'0','2024-07-24 10:00:00','0','','2024-07-24 10:55:37','',NULL,NULL),(187,1,2,'1','2024-07-24 10:00:00','0','','2024-07-24 10:55:37','',NULL,NULL),(188,7,5,'0','2024-07-24 11:00:00','0','','2024-07-24 11:21:00','',NULL,NULL),(189,2,3,'1','2024-07-24 11:00:00','0','','2024-07-24 11:21:41','',NULL,NULL),(190,2,3,'0','2024-07-24 11:00:00','0','','2024-07-24 11:27:06','',NULL,NULL),(191,1,2,'1','2024-07-24 13:00:00','0','','2024-07-24 13:45:34','',NULL,NULL),(192,1,2,'1','2024-07-24 13:00:00','0','','2024-07-24 13:52:19','',NULL,NULL),(193,1,2,'0','2024-07-24 13:00:00','0','','2024-07-24 13:52:25','',NULL,NULL),(194,1,2,'1','2024-07-24 13:00:00','0','','2024-07-24 13:56:34','',NULL,NULL),(195,1,2,'0','2024-07-24 13:00:00','0','','2024-07-24 13:56:35','',NULL,NULL),(196,1,2,'1','2024-07-24 15:00:00','0','','2024-07-24 15:13:37','',NULL,NULL),(197,1,2,'0','2024-07-24 15:00:00','0','','2024-07-24 15:13:39','',NULL,NULL),(198,1,2,'1','2024-07-24 15:00:00','0','','2024-07-24 15:56:54','',NULL,NULL),(199,1,2,'0','2024-07-24 15:00:00','0','','2024-07-24 15:57:28','',NULL,NULL),(200,1,2,'1','2024-07-24 15:00:00','0','','2024-07-24 15:57:29','',NULL,NULL),(201,1,2,'1','2024-07-24 16:00:00','0','','2024-07-24 16:03:06','',NULL,NULL),(202,1,2,'0','2024-07-24 16:00:00','0','','2024-07-24 16:03:08','',NULL,NULL),(203,1,2,'1','2024-07-24 16:00:00','0','','2024-07-24 16:21:51','',NULL,NULL),(204,1,2,'0','2024-07-24 16:00:00','0','','2024-07-24 16:21:56','',NULL,NULL),(205,1,2,'1','2024-07-24 17:00:00','0','','2024-07-24 17:26:36','',NULL,NULL),(206,1,2,'0','2024-07-24 17:00:00','0','','2024-07-24 17:26:39','',NULL,NULL),(207,1,2,'1','2024-07-25 09:00:00','0','','2024-07-25 09:11:29','',NULL,NULL),(208,1,2,'0','2024-07-25 09:00:00','0','','2024-07-25 09:16:29','',NULL,NULL),(209,1,2,'1','2024-07-25 09:00:00','0','','2024-07-25 09:16:30','',NULL,NULL),(210,1,2,'0','2024-07-25 14:00:00','0','','2024-07-25 14:36:18','',NULL,NULL),(211,1,2,'1','2024-07-25 14:00:00','0','','2024-07-25 14:36:19','',NULL,NULL),(212,1,2,'0','2024-07-31 00:00:00','0','','2024-07-31 00:59:35','',NULL,NULL),(213,1,2,'1','2024-07-31 00:00:00','0','','2024-07-31 00:59:36','',NULL,NULL);

/*Table structure for table `device_event_data` */

DROP TABLE IF EXISTS `device_event_data`;

CREATE TABLE `device_event_data` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `message_id` varchar(50) DEFAULT NULL,
  `product_id` bigint DEFAULT NULL COMMENT '产品id',
  `device_id` bigint NOT NULL DEFAULT '0' COMMENT '设备id',
  `model_event_id` bigint NOT NULL DEFAULT '0' COMMENT '物模型事件Id',
  `output_values` varchar(255) DEFAULT NULL COMMENT '输出参数值',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态（1正常 0停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='设备事件数据表';

/*Data for the table `device_event_data` */

insert  into `device_event_data`(`id`,`message_id`,`product_id`,`device_id`,`model_event_id`,`output_values`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'112233445566',7,5,6,'{\"KeyID\":\"222\",\"LockType\":\"1\"}','1','0','','2024-07-05 15:51:02','',NULL,NULL),(2,'112233445577',7,5,6,'{\"KeyID\":\"222\",\"LockType\":\"1\"}','1','0','','2024-07-05 15:58:27','',NULL,NULL),(3,'1122334455797',7,5,6,'{\"KeyID\":\"222\",\"LockType\":\"1\"}','1','0','','2024-07-05 16:03:15','',NULL,NULL),(4,'1122334488797',7,5,6,'{\"KeyID\":\"222\",\"LockType\":\"1\"}','1','0','','2024-07-05 16:21:32','',NULL,NULL),(5,'1122355488797',7,5,6,'{\"KeyID\":\"22233\",\"LockType\":\"2\"}','1','0','','2024-07-05 16:35:37','',NULL,NULL);

/*Table structure for table `device_info` */

DROP TABLE IF EXISTS `device_info`;

CREATE TABLE `device_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '设备ID',
  `product_id` bigint NOT NULL DEFAULT '0' COMMENT '产品id',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '设备名称',
  `last_connect_time` datetime DEFAULT NULL COMMENT '最后连接时间',
  `client_id` varchar(100) NOT NULL DEFAULT '0' COMMENT '设备id',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `is_superuser` char(1) NOT NULL DEFAULT '0' COMMENT '是否超级用户',
  `run_status` char(1) NOT NULL DEFAULT '0' COMMENT '运行状态【0：否 1：是】',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态（0正常 1停用）',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='设备信息表';

/*Data for the table `device_info` */

insert  into `device_info`(`id`,`product_id`,`name`,`last_connect_time`,`client_id`,`username`,`password`,`is_superuser`,`run_status`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,1,'虚拟设备01','2024-07-18 11:21:16','k9d712dr91skz1t','iesslrb0','111111','1','1','1','0','admin','2024-05-16 10:21:21','',NULL,'虚拟设备'),(2,1,'虚拟设备02','2024-07-31 00:59:36','l1lbr242zelodx2','bmjjxhwf','111111','1','1','1','0','admin','2024-05-16 10:24:12','',NULL,'智能锁001'),(3,2,'智能锁001','2024-07-24 11:21:41','ehm36zc1rqa3wxr','cqp5j01v','111111','0','0','1','0','admin','2024-05-20 16:22:19','',NULL,NULL),(4,2,'智能锁002','2024-07-01 18:33:19','n8l85e60993pphp','r47feu3x','111111','0','0','1','0','admin','2024-06-05 16:44:23','',NULL,'智能锁003'),(5,7,'GuThings-Iot','2024-07-24 10:02:20','cm32bh2si0e9zu5','kqk9xxdc','111111','0','0','1','0','admin','2024-07-05 15:25:54','',NULL,NULL),(6,1,'测试',NULL,'rjxj1a6ikdx3uom','awa8xiwc','111111','0','0','1','2','1','2024-07-30 02:12:04','',NULL,NULL),(7,8,'机库',NULL,'5wm9dhqttmjqujr','qfhlkscl','111111','0','0','1','0','1','2024-07-30 15:28:04','',NULL,'机库');

/*Table structure for table `device_message_count` */

DROP TABLE IF EXISTS `device_message_count`;

CREATE TABLE `device_message_count` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `dimension_time` datetime DEFAULT NULL COMMENT '统计维度时间（到小时）',
  `num` int NOT NULL DEFAULT '1' COMMENT '统计个数',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8531 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='设备消息统计表';

/*Data for the table `device_message_count` */

insert  into `device_message_count`(`id`,`dimension_time`,`num`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (8528,'2024-05-23 18:00:00',2,'0','',NULL,'',NULL,NULL),(8529,'2024-05-27 11:00:00',1,'0','',NULL,'',NULL,NULL),(8530,'2024-06-07 11:00:00',3,'0','',NULL,'',NULL,NULL);

/*Table structure for table `device_option_log` */

DROP TABLE IF EXISTS `device_option_log`;

CREATE TABLE `device_option_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_id` bigint NOT NULL DEFAULT '0' COMMENT '产品id',
  `device_id` bigint NOT NULL DEFAULT '0' COMMENT '设备id',
  `message_id` varchar(50) NOT NULL DEFAULT '0' COMMENT '消息id',
  `option_type` varchar(255) DEFAULT NULL COMMENT '操作类型【1：属性 2：服务 3：事件】',
  `topic` varchar(255) DEFAULT NULL,
  `response_code` varchar(10) NOT NULL DEFAULT '0' COMMENT '返回码',
  `request_params` json DEFAULT NULL COMMENT '请求参数',
  `response_data` json DEFAULT NULL COMMENT '响应数据',
  `request_time` datetime DEFAULT NULL COMMENT '请求时间',
  `response_time` datetime DEFAULT NULL COMMENT '响应时间',
  `is_finish` char(1) DEFAULT NULL COMMENT '是否完成',
  `dimension_time` datetime DEFAULT NULL COMMENT '统计维度时间（到小时）',
  `status` char(1) NOT NULL DEFAULT '' COMMENT '状态（1正常 0停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='产品物模型服务表';

/*Data for the table `device_option_log` */

/*Table structure for table `device_service_data` */

DROP TABLE IF EXISTS `device_service_data`;

CREATE TABLE `device_service_data` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `message_id` varchar(50) DEFAULT NULL,
  `product_id` bigint DEFAULT NULL COMMENT '产品id',
  `device_id` bigint NOT NULL DEFAULT '0' COMMENT '设备id',
  `model_service_id` bigint NOT NULL DEFAULT '0' COMMENT '物模型服务Id',
  `input_values` varchar(255) DEFAULT NULL COMMENT '传入参数值',
  `output_values` varchar(255) DEFAULT NULL COMMENT '输出参数值',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态（1正常 0停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='设备服务数据表';

/*Data for the table `device_service_data` */

insert  into `device_service_data`(`id`,`message_id`,`product_id`,`device_id`,`model_service_id`,`input_values`,`output_values`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'fr8p0867lv',2,2,1,'{\"LockType\":\"0\"}',NULL,'1','0','','2024-05-23 18:03:38','',NULL,NULL),(2,'5wd79nep0c',2,2,1,'{\"LockType\":\"0\"}','{\"KeyID\":\"123\",\"IsValid\":1}','1','0','','2024-05-28 10:09:28','',NULL,NULL),(3,'j7nw8zuiwg',2,2,1,'{\"LockType\":\"0\"}','{\"KeyID\":\"123\",\"IsValid\":1}','1','0','','2024-05-29 10:47:49','',NULL,NULL),(4,'uuif31m6d7',2,3,1,'{\"LockType\":\"0\"}','{\"KeyID\":\"123\",\"IsValid\":1}','1','0','','2024-07-24 11:25:54','',NULL,NULL);

/*Table structure for table `device_subscribe_topic` */

DROP TABLE IF EXISTS `device_subscribe_topic`;

CREATE TABLE `device_subscribe_topic` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_id` bigint NOT NULL DEFAULT '0' COMMENT '产品id',
  `device_id` bigint NOT NULL DEFAULT '0' COMMENT '设备id',
  `topic_id` bigint DEFAULT NULL COMMENT '商品topic的id',
  `topic_template` varchar(255) DEFAULT NULL COMMENT '产品topic模板',
  `topic` varchar(255) DEFAULT NULL COMMENT '设备订阅的topic',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态（1正常 0停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='设备订阅的topic表';

/*Data for the table `device_subscribe_topic` */

insert  into `device_subscribe_topic`(`id`,`product_id`,`device_id`,`topic_id`,`topic_template`,`topic`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,3,2,NULL,NULL,'sys/oyhju8e3h8/l1lbr242zelodx2/property/post','1','2','',NULL,'',NULL,NULL),(2,3,3,NULL,NULL,'sys/oyhju8e3h8/ehm36zc1rqa3wxr/property/post','1','0','',NULL,'',NULL,NULL),(3,3,3,NULL,NULL,'sys/oyhju8e3h8/ehm36zc1rqa3wxr/property/post_reply','1','0','',NULL,'',NULL,NULL),(4,3,2,NULL,NULL,'sys/oyhju8e3h8/l1lbr242zelodx2/event/DoorUnlockedAlarm/post','1','2','',NULL,'',NULL,NULL),(5,3,2,NULL,NULL,'sys/oyhju8e3h8/l1lbr242zelodx2/event/DoorUnlockedAlarm/post','1','2','',NULL,'',NULL,NULL),(6,3,2,NULL,NULL,'sys/oyhju8e3h8/l1lbr242zelodx2/event/DoorUnlockedAlarm/post_reply','1','0','',NULL,'',NULL,NULL),(7,2,2,NULL,NULL,'sys/oyhju8e3h8/l1lbr242zelodx2/service/GetKeyList','1','2','',NULL,'',NULL,NULL),(8,2,2,NULL,NULL,'sys/oyhju8e3h8/l1lbr242zelodx2/service/GetKeyList','1','2','',NULL,'',NULL,NULL),(9,2,2,NULL,NULL,'sys/oyhju8e3h8/l1lbr242zelodx2/service/GetKeyList','1','2','',NULL,'',NULL,NULL),(10,2,3,NULL,NULL,'sys/oyhju8e3h8/ehm36zc1rqa3wxr/service/GetKeyList','1','2','',NULL,'',NULL,NULL),(11,2,2,NULL,NULL,'sys/oyhju8e3h8/l1lbr242zelodx2/service/GetKeyList','1','2','',NULL,'',NULL,NULL),(12,2,2,NULL,NULL,'sys/oyhju8e3h8/l1lbr242zelodx2/service/GetKeyList','1','2','',NULL,'',NULL,NULL),(13,2,2,NULL,NULL,'sys/oyhju8e3h8/l1lbr242zelodx2/service/GetKeyList','1','2','',NULL,'',NULL,NULL),(14,2,2,NULL,NULL,'sys/oyhju8e3h8/l1lbr242zelodx2/service/GetKeyList','1','2','',NULL,'',NULL,NULL),(15,2,3,NULL,NULL,'sys/oyhju8e3h8/ehm36zc1rqa3wxr/service/GetKeyList','1','0','',NULL,'',NULL,NULL),(16,2,4,NULL,NULL,'sys/oyhju8e3h8/n8l85e60993pphp/property/set','1','0','',NULL,'',NULL,NULL);

/*Table structure for table `lock_attr_data` */

DROP TABLE IF EXISTS `lock_attr_data`;

CREATE TABLE `lock_attr_data` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `client_id` varchar(50) DEFAULT NULL COMMENT '锁设备id',
  `identifier` varchar(50) NOT NULL DEFAULT '0' COMMENT '属性标识符',
  `data_value` varchar(255) DEFAULT NULL COMMENT '属性值',
  `status` char(1) DEFAULT NULL COMMENT '状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='锁属性数据表';

/*Data for the table `lock_attr_data` */

insert  into `lock_attr_data`(`id`,`client_id`,`identifier`,`data_value`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'cm32bh2si0e9zu5','Electric','80','1','0','',NULL,'',NULL,NULL);

/*Table structure for table `lock_option_log` */

DROP TABLE IF EXISTS `lock_option_log`;

CREATE TABLE `lock_option_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `client_id` varchar(255) DEFAULT NULL COMMENT '设备clientid',
  `content` varchar(200) DEFAULT NULL COMMENT '日志内容',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态：1为正常，0为禁止',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='智能锁操作日志表';

/*Data for the table `lock_option_log` */

insert  into `lock_option_log`(`id`,`client_id`,`content`,`status`,`create_time`,`create_by`,`update_time`,`update_by`,`del_flag`,`remark`) values (1,'cm32bh2si0e9zu5','指纹开门',1,'2024-07-05 16:32:05',NULL,'2024-07-08 09:36:14',NULL,'0','{\"id\":\"1122334488797\",\"params\":{\"KeyID\":\"222\",\"LockType\":\"1\"},\"topic\":\"sys/5hwic51o6w/cm32bh2si0e9zu5/event/DoorOpenNotification/post\"}'),(2,'cm32bh2si0e9zu5','已关门',1,'2024-07-05 16:32:15',NULL,'2024-07-08 09:36:33',NULL,'0',NULL),(3,'cm32bh2si0e9zu5','钥匙开门',1,'2024-07-05 16:35:38',NULL,'2024-07-05 16:35:37',NULL,'0','{\"id\":\"1122355488797\",\"params\":{\"KeyID\":\"22233\",\"LockType\":\"2\"},\"topic\":\"sys/5hwic51o6w/cm32bh2si0e9zu5/event/DoorOpenNotification/post\"}'),(5,'cm32bh2si0e9zu5','已关门',1,'2024-07-05 16:35:58',NULL,'2024-07-08 09:36:56',NULL,'0',NULL),(6,'cm32bh2si0e9zu5','指纹开门',1,'2024-07-08 09:37:04',NULL,'2024-07-08 09:37:31',NULL,'0',''),(7,'cm32bh2si0e9zu5','已关门',1,'2024-07-08 09:37:09',NULL,'2024-07-08 09:37:39',NULL,'0',''),(8,'cm32bh2si0e9zu5','指纹开门',1,'2024-07-08 09:37:53',NULL,'2024-07-08 09:38:01',NULL,'0',NULL),(9,'cm32bh2si0e9zu5','已关门',1,'2024-07-08 09:37:56',NULL,'2024-07-08 09:38:04',NULL,'0',NULL),(10,'cm32bh2si0e9zu5','指纹开门',1,'2024-07-15 16:35:11',NULL,'2024-07-15 16:35:40',NULL,'0',NULL),(11,'cm32bh2si0e9zu5','已关门',1,'2024-07-15 16:35:15',NULL,'2024-07-15 16:35:43',NULL,'0',NULL),(12,'cm32bh2si0e9zu5','密码开门',1,'2024-07-15 16:35:17',NULL,'2024-07-15 16:35:55',NULL,'0',NULL),(13,'cm32bh2si0e9zu5','已关门',1,'2024-07-15 16:35:20',NULL,'2024-07-15 16:35:57',NULL,'0',NULL),(14,'cm32bh2si0e9zu5','密码开门',1,'2024-07-15 16:36:06',NULL,'2024-07-15 16:36:15',NULL,'0',NULL),(15,'cm32bh2si0e9zu5','已关门',1,'2024-07-15 16:36:08',NULL,'2024-07-15 16:36:21',NULL,'0',NULL);

/*Table structure for table `product_info` */

DROP TABLE IF EXISTS `product_info`;

CREATE TABLE `product_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '产品ID',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '产品名称',
  `product_key` varchar(100) NOT NULL DEFAULT '' COMMENT '产品key',
  `node_type` char(1) NOT NULL DEFAULT '0' COMMENT '节点类型',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '产品状态（1正常 0停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='产品信息表';

/*Data for the table `product_info` */

insert  into `product_info`(`id`,`name`,`product_key`,`node_type`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'虚拟产品','5uszpkmmoj','1','1','0','admin','2024-05-16 10:21:06','',NULL,'虚拟产品'),(2,'智能锁（测试）','oyhju8e3h8','1','1','0','admin','2024-05-16 10:23:39','',NULL,'智能锁'),(7,'智能锁','5hwic51o6w','1','1','0','admin','2024-06-17 14:53:00','',NULL,'尚硅谷ESP32智能锁'),(8,'测试','y2kvp0v5lk','1','1','0','1','2024-07-30 15:27:49','',NULL,'测试设别');

/*Table structure for table `product_model_attr` */

DROP TABLE IF EXISTS `product_model_attr`;

CREATE TABLE `product_model_attr` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_id` bigint NOT NULL DEFAULT '0' COMMENT '产品id',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '功能名称',
  `identifier` varchar(50) NOT NULL DEFAULT '0' COMMENT '标识符',
  `data_type_id` bigint DEFAULT NULL COMMENT '数据类型id',
  `type_params` varchar(2000) DEFAULT NULL COMMENT '数据类型参数',
  `data_unit` varchar(50) DEFAULT NULL COMMENT '单位',
  `option_status` char(1) DEFAULT NULL COMMENT '读写状态【1：读写 2：只读】',
  `status` char(1) NOT NULL DEFAULT '' COMMENT '状态（1正常 0停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='产品物模型属性表';

/*Data for the table `product_model_attr` */

insert  into `product_model_attr`(`id`,`product_id`,`name`,`identifier`,`data_type_id`,`type_params`,`data_unit`,`option_status`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,2,'电量','Electric',1,'{\"step\":\"1\",\"min\":\"1\",\"max\":\"100\",\"enumList\":[{\"id\":1,\"name\":\"\",\"value\":\"\"}]}','%','2','','0','','2024-05-23 17:40:47','',NULL,NULL),(2,2,'门锁状态','LockState',4,'{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"打开状态\",\"value\":\"1\"},{\"id\":113,\"name\":\"关闭状态\",\"value\":\"0\"}]}',' ','2','','0','','2024-05-23 17:42:32','',NULL,NULL),(3,2,'勿扰开关','NodDisSwitch',4,'{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"未开启\",\"value\":\"0\"},{\"id\":786,\"name\":\"已开启\",\"value\":\"1\"}]}',' ','1','','0','','2024-05-24 08:51:32','',NULL,NULL),(4,2,'清晰度','Clarity',4,'{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"低\",\"value\":\"0\"},{\"id\":899,\"name\":\"中\",\"value\":\"1\"},{\"id\":949,\"name\":\"高\",\"value\":\"2\"}]}',' ','1','','0','','2024-05-24 08:52:20','',NULL,NULL),(5,2,'灵敏度','Sensitivity',4,'{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"低\",\"value\":\"0\"},{\"id\":733,\"name\":\"中\",\"value\":\"1\"},{\"id\":217,\"name\":\"高\",\"value\":\"2\"}]}',' ','1','','0','','2024-05-24 08:53:01','',NULL,NULL),(6,2,'离家布防','ArmingSwitch',4,'{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"关闭\",\"value\":\"0\"},{\"id\":817,\"name\":\"开启\",\"value\":\"1\"}]}',' ','1','','0','','2024-05-24 08:53:48','',NULL,NULL),(7,7,'电量','Electric',1,'{\"step\":\"1\",\"min\":\"0\",\"max\":\"100\",\"enumList\":[{\"id\":1,\"name\":\"\",\"value\":\"\"}]}',' ','1','','0','','2024-06-17 14:56:57','',NULL,'智能锁电量'),(8,7,'门锁状态','LockStatus',4,'{\"step\":\"1\",\"min\":\"0\",\"max\":\"1\",\"enumList\":[{\"id\":1,\"name\":\"门已锁\",\"value\":\"0\"},{\"id\":283,\"name\":\"门已开\",\"value\":\"1\"}]}',' ','1','','0','','2024-06-17 14:57:59','','2024-06-17 15:01:38','门锁状态：0，门已锁。1，门已开。'),(9,7,'指纹状态','FingerPrintStatus',4,'{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"识别失败\",\"value\":\"0\"},{\"id\":554,\"name\":\"识别成功\",\"value\":\"1\"},{\"id\":814,\"name\":\"开始录入指纹\",\"value\":\"2\"},{\"id\":379,\"name\":\"录入指纹结束\",\"value\":\"3\"}]}',' ','1','','0','','2024-06-17 15:03:22','',NULL,NULL),(10,7,'密码状态','PasswordStatus',4,'{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"密码输入错误\",\"value\":\"0\"},{\"id\":835,\"name\":\"密码输入正确\",\"value\":\"1\"},{\"id\":836,\"name\":\"密码修改成功\",\"value\":\"2\"},{\"id\":601,\"name\":\"密码修改失败\",\"value\":\"3\"}]}',' ','1','','0','','2024-06-17 15:04:27','',NULL,NULL),(11,7,'电量','ElectricStatus',1,'{\"step\":\"1\",\"min\":\"0\",\"max\":\"100\",\"enumList\":[{\"id\":1,\"name\":\"\",\"value\":\"\"}]}',' ','1','','0','','2024-06-17 15:04:50','',NULL,NULL),(12,7,'蓝牙状态','BTStatus',4,'{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"蓝牙开锁成功\",\"value\":\"0\"},{\"id\":263,\"name\":\"蓝牙开锁失败\",\"value\":\"1\"},{\"id\":203,\"name\":\"蓝牙连接失败\",\"value\":\"2\"},{\"id\":205,\"name\":\"蓝牙连接成功\",\"value\":\"3\"}]}',' ','1','','0','','2024-06-17 15:06:57','',NULL,NULL);

/*Table structure for table `product_model_event` */

DROP TABLE IF EXISTS `product_model_event`;

CREATE TABLE `product_model_event` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_id` bigint NOT NULL DEFAULT '0' COMMENT '产品id',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '属性名称',
  `identifier` varchar(50) NOT NULL DEFAULT '0' COMMENT '标识符',
  `event_type` char(1) DEFAULT NULL COMMENT '事件类型【1：信息 2：告警 3：故障】',
  `output_params` varchar(2000) DEFAULT NULL COMMENT '输出参数',
  `status` char(1) NOT NULL DEFAULT '' COMMENT '状态（1正常 0停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='产品物模型事件表';

/*Data for the table `product_model_event` */

insert  into `product_model_event`(`id`,`product_id`,`name`,`identifier`,`event_type`,`output_params`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,2,'门未锁好报警','DoorUnlockedAlarm','1','[]','','0','','2024-05-23 17:43:16','',NULL,NULL),(2,2,'低电量报警','LowElectricityAlarm','1','[]','','0','','2024-05-23 17:43:38','',NULL,NULL),(3,2,'防撬报警','TamperAlarm','1','[]','','0','','2024-05-23 17:44:07','',NULL,NULL),(4,2,'开门通知','DoorOpenNotification','1','[{\"id\":514,\"name\":\"钥匙ID\",\"identifier\":\"KeyID\",\"dataTypeId\":3,\"typeParams\":{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"\",\"value\":\"\"}]}},{\"id\":223,\"name\":\"开锁方式\",\"identifier\":\"LockType\",\"dataTypeId\":4,\"typeParams\":{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"指纹\",\"value\":\"1\"},{\"id\":867,\"name\":\"密码\",\"value\":\"2\"},{\"id\":97,\"name\":\"卡\",\"value\":\"3\"},{\"id\":283,\"name\":\"机械钥匙\",\"value\":\"4\"}]}}]','','0','','2024-05-23 17:45:10','','2024-05-23 17:46:11',NULL),(5,2,'故障上报','Error','1','[{\"id\":171,\"name\":\"故障代码\",\"identifier\":\"ErrorCode\",\"dataTypeId\":4,\"typeParams\":{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"正常\",\"value\":\"0\"},{\"id\":248,\"name\":\"设备故障\",\"value\":\"1\"}]}}]','','0','','2024-05-23 17:49:51','',NULL,NULL),(6,7,'开门通知','DoorOpenNotification','1','[{\"id\":881,\"name\":\"开锁方式\",\"identifier\":\"LockType\",\"dataTypeId\":4,\"typeParams\":{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"指纹\",\"value\":\"1\"},{\"id\":2,\"name\":\"卡\",\"value\":\"2\"},{\"id\":3,\"name\":\"密码\",\"value\":\"3\"},{\"id\":4,\"name\":\"钥匙\",\"value\":\"4\"}]}},{\"id\":143,\"name\":\"钥匙ID\",\"identifier\":\"KeyID\",\"dataTypeId\":3,\"typeParams\":{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"\",\"value\":\"\"}]}}]','','0','','2024-07-05 15:24:20','',NULL,NULL);

/*Table structure for table `product_model_service` */

DROP TABLE IF EXISTS `product_model_service`;

CREATE TABLE `product_model_service` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_id` bigint NOT NULL DEFAULT '0' COMMENT '产品id',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '属性名称',
  `identifier` varchar(50) NOT NULL DEFAULT '0' COMMENT '标识符',
  `call_type` char(1) DEFAULT NULL COMMENT '调用类型【1：异步 2：同步】',
  `input_params` varchar(2000) DEFAULT NULL COMMENT '输入参数',
  `output_params` varchar(2000) DEFAULT NULL COMMENT '输出参数',
  `status` char(1) NOT NULL DEFAULT '' COMMENT '状态（1正常 0停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='产品物模型服务表';

/*Data for the table `product_model_service` */

insert  into `product_model_service`(`id`,`product_id`,`name`,`identifier`,`call_type`,`input_params`,`output_params`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,2,'获取钥匙列表','GetKeyList','2','[{\"id\":921,\"name\":\"开锁方式\",\"identifier\":\"LockType\",\"dataTypeId\":4,\"typeParams\":{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"全部\",\"value\":\"0\"}]}}]','[{\"id\":579,\"name\":\"钥匙ID\",\"identifier\":\"KeyID\",\"dataTypeId\":3,\"typeParams\":{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"\",\"value\":\"\"}]}},{\"id\":569,\"name\":\"用户权限\",\"identifier\":\"UserLimit\",\"dataTypeId\":4,\"typeParams\":{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"普通用户\",\"value\":\"0\"}]}},{\"id\":789,\"name\":\"是否有效\",\"identifier\":\"IsValid\",\"dataTypeId\":4,\"typeParams\":{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"无效\",\"value\":\"0\"},{\"id\":136,\"name\":\"有效\",\"value\":\"1\"}]}}]','','0','','2024-05-23 17:52:58','',NULL,NULL),(2,2,'删除钥匙','DeleteKey','1','[{\"id\":471,\"name\":\"钥匙ID\",\"identifier\":\"KeyID\",\"dataTypeId\":3,\"typeParams\":{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"\",\"value\":\"\"}]}}]','[]','','0','','2024-05-23 17:54:41','',NULL,NULL),(3,2,'添加钥匙','AddKey','1','[{\"id\":330,\"name\":\"开锁方式\",\"identifier\":\"LockType\",\"dataTypeId\":4,\"typeParams\":{\"step\":null,\"min\":null,\"max\":null,\"enumList\":[{\"id\":1,\"name\":\"指纹\",\"value\":\"1\"},{\"id\":262,\"name\":\"密码\",\"value\":\"2\"},{\"id\":477,\"name\":\"卡\",\"value\":\"3\"},{\"id\":893,\"name\":\"机械钥匙\",\"value\":\"4\"}]}}]','[]','','0','','2024-05-23 17:55:59','',NULL,NULL);

/*Table structure for table `product_topic` */

DROP TABLE IF EXISTS `product_topic`;

CREATE TABLE `product_topic` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_id` bigint NOT NULL DEFAULT '0' COMMENT '产品Id',
  `topic_type` char(1) DEFAULT NULL COMMENT 'topic类型【1：基础类 2：物模型类 3：自定义】',
  `topic` varchar(200) NOT NULL DEFAULT '' COMMENT 'topic',
  `group_name` varchar(100) DEFAULT '0' COMMENT '功能名称',
  `option_type` char(1) DEFAULT NULL COMMENT '操作类型【1：发布 2：订阅】',
  `status` char(1) NOT NULL DEFAULT '' COMMENT '状态（1正常 0停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='产品Topic表';

/*Data for the table `product_topic` */

insert  into `product_topic`(`id`,`product_id`,`topic_type`,`topic`,`group_name`,`option_type`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,2,'1','ota/device/inform/oyhju8e3h8/${clientId}','OTA 升级','1','1','0','admin','2024-05-16 10:23:39','',NULL,'设备上报固件升级信息'),(2,2,'1','ota/device/upgrade/oyhju8e3h8/${clientId}','OTA 升级','2','1','0','admin','2024-05-16 10:23:39','',NULL,'固件升级信息下行'),(3,2,'2','sys/oyhju8e3h8/${clientId}/property/post','属性上报','1','1','0','admin','2024-05-16 10:23:39','',NULL,'设备属性上报'),(4,2,'2','sys/oyhju8e3h8/${clientId}/property/post_reply','属性上报','2','1','0','admin','2024-05-16 10:23:39','',NULL,'云端响应属性上报'),(5,2,'2','sys/oyhju8e3h8/${clientId}/property/set','属性设置','2','1','0','admin','2024-05-16 10:23:39','',NULL,'设备属性设置'),(6,2,'2','sys/oyhju8e3h8/${clientId}/event/${tsl.event.identifier}/post','事件上报','1','1','0','admin','2024-05-16 10:23:39','',NULL,'设备事件上报'),(7,2,'2','sys/oyhju8e3h8/${clientId}/event/${tsl.event.identifier}/post_reply','事件上报','2','1','0','admin','2024-05-16 10:23:39','',NULL,'云端响应事件上报'),(8,2,'2','sys/oyhju8e3h8/${clientId}/service/${tsl.service.identifier}','服务调用','2','1','0','admin','2024-05-16 10:23:39','',NULL,'设备服务调用'),(9,2,'2','sys/oyhju8e3h8/${clientId}/service/${tsl.service.identifier}/reply','服务调用','1','1','0','admin','2024-05-16 10:23:39','',NULL,'设备端响应服务调用'),(10,5,'1','ota/device/inform/vpypmilnzs/${clientId}','OTA 升级','1','1','0','admin','2024-05-20 16:46:45','',NULL,'设备上报固件升级信息'),(11,5,'1','ota/device/upgrade/vpypmilnzs/${clientId}','OTA 升级','2','1','0','admin','2024-05-20 16:46:45','',NULL,'固件升级信息下行'),(12,5,'2','sys/vpypmilnzs/${clientId}/property/post','属性上报','1','1','0','admin','2024-05-20 16:46:45','',NULL,'设备属性上报'),(13,5,'2','sys/vpypmilnzs/${clientId}/property/post_reply','属性上报','2','1','0','admin','2024-05-20 16:46:45','',NULL,'云端响应属性上报'),(14,5,'2','sys/vpypmilnzs/${clientId}/property/set','属性设置','2','1','0','admin','2024-05-20 16:46:45','',NULL,'设备属性设置'),(15,5,'2','sys/vpypmilnzs/${clientId}/event/${tsl.event.identifier}/post','事件上报','1','1','0','admin','2024-05-20 16:46:45','',NULL,'设备事件上报'),(16,5,'2','sys/vpypmilnzs/${clientId}/event/${tsl.event.identifier}/post_reply','事件上报','2','1','0','admin','2024-05-20 16:46:45','',NULL,'云端响应事件上报'),(17,5,'2','sys/vpypmilnzs/${clientId}/service/${tsl.service.identifier}','服务调用','2','1','0','admin','2024-05-20 16:46:45','',NULL,'设备服务调用'),(18,5,'2','sys/vpypmilnzs/${clientId}/service/${tsl.service.identifier}/reply','服务调用','1','1','0','admin','2024-05-20 16:46:45','',NULL,'设备端响应服务调用'),(19,6,'1','ota/device/inform/1rrz3kx1cx/${clientId}','OTA 升级','1','1','0','admin','2024-05-23 08:20:39','',NULL,'设备上报固件升级信息'),(20,6,'1','ota/device/upgrade/1rrz3kx1cx/${clientId}','OTA 升级','2','1','0','admin','2024-05-23 08:20:39','',NULL,'固件升级信息下行'),(21,6,'2','sys/1rrz3kx1cx/${clientId}/property/post','属性上报','1','1','0','admin','2024-05-23 08:20:39','',NULL,'设备属性上报'),(22,6,'2','sys/1rrz3kx1cx/${clientId}/property/post_reply','属性上报','2','1','0','admin','2024-05-23 08:20:39','',NULL,'云端响应属性上报'),(23,6,'2','sys/1rrz3kx1cx/${clientId}/property/set','属性设置','2','1','0','admin','2024-05-23 08:20:39','',NULL,'设备属性设置'),(24,6,'2','sys/1rrz3kx1cx/${clientId}/event/${tsl.event.identifier}/post','事件上报','1','1','0','admin','2024-05-23 08:20:39','',NULL,'设备事件上报'),(25,6,'2','sys/1rrz3kx1cx/${clientId}/event/${tsl.event.identifier}/post_reply','事件上报','2','1','0','admin','2024-05-23 08:20:39','',NULL,'云端响应事件上报'),(26,6,'2','sys/1rrz3kx1cx/${clientId}/service/${tsl.service.identifier}','服务调用','2','1','0','admin','2024-05-23 08:20:39','',NULL,'设备服务调用'),(27,6,'2','sys/1rrz3kx1cx/${clientId}/service/${tsl.service.identifier}/reply','服务调用','1','1','0','admin','2024-05-23 08:20:39','',NULL,'设备端响应服务调用'),(30,2,'3','cs','cs','1','1','2','',NULL,'',NULL,NULL),(31,2,'3','custom/oyhju8e3h8/${clientId}/cs','测试','1','1','0','',NULL,'',NULL,'测试'),(32,2,'3','custom/oyhju8e3h8/${clientId}/test','test','3','1','2','',NULL,'',NULL,'test'),(33,7,'1','ota/device/inform/5hwic51o6w/${clientId}','OTA 升级','1','1','0','admin','2024-06-17 14:53:00','',NULL,'设备上报固件升级信息'),(34,7,'1','ota/device/upgrade/5hwic51o6w/${clientId}','OTA 升级','2','1','0','admin','2024-06-17 14:53:00','',NULL,'固件升级信息下行'),(35,7,'2','sys/5hwic51o6w/${clientId}/property/post','属性上报','1','1','0','admin','2024-06-17 14:53:00','',NULL,'设备属性上报'),(36,7,'2','sys/5hwic51o6w/${clientId}/property/post_reply','属性上报','2','1','0','admin','2024-06-17 14:53:00','',NULL,'云端响应属性上报'),(37,7,'2','sys/5hwic51o6w/${clientId}/property/set','属性设置','2','1','0','admin','2024-06-17 14:53:00','',NULL,'设备属性设置'),(38,7,'2','sys/5hwic51o6w/${clientId}/event/${tsl.event.identifier}/post','事件上报','1','1','0','admin','2024-06-17 14:53:00','',NULL,'设备事件上报'),(39,7,'2','sys/5hwic51o6w/${clientId}/event/${tsl.event.identifier}/post_reply','事件上报','2','1','0','admin','2024-06-17 14:53:00','',NULL,'云端响应事件上报'),(40,7,'2','sys/5hwic51o6w/${clientId}/service/${tsl.service.identifier}','服务调用','2','1','0','admin','2024-06-17 14:53:00','',NULL,'设备服务调用'),(41,7,'2','sys/5hwic51o6w/${clientId}/service/${tsl.service.identifier}/reply','服务调用','1','1','0','admin','2024-06-17 14:53:00','',NULL,'设备端响应服务调用'),(42,8,'1','ota/device/inform/y2kvp0v5lk/${clientId}','OTA 升级','1','1','0','1','2024-07-30 15:27:49','',NULL,'设备上报固件升级信息'),(43,8,'1','ota/device/upgrade/y2kvp0v5lk/${clientId}','OTA 升级','2','1','0','1','2024-07-30 15:27:49','',NULL,'固件升级信息下行'),(44,8,'2','sys/y2kvp0v5lk/${clientId}/property/post','属性上报','1','1','0','1','2024-07-30 15:27:49','',NULL,'设备属性上报'),(45,8,'2','sys/y2kvp0v5lk/${clientId}/property/post_reply','属性上报','2','1','0','1','2024-07-30 15:27:49','',NULL,'云端响应属性上报'),(46,8,'2','sys/y2kvp0v5lk/${clientId}/property/set','属性设置','2','1','0','1','2024-07-30 15:27:49','',NULL,'设备属性设置'),(47,8,'2','sys/y2kvp0v5lk/${clientId}/event/${tsl.event.identifier}/post','事件上报','1','1','0','1','2024-07-30 15:27:49','',NULL,'设备事件上报'),(48,8,'2','sys/y2kvp0v5lk/${clientId}/event/${tsl.event.identifier}/post_reply','事件上报','2','1','0','1','2024-07-30 15:27:49','',NULL,'云端响应事件上报'),(49,8,'2','sys/y2kvp0v5lk/${clientId}/service/${tsl.service.identifier}','服务调用','2','1','0','1','2024-07-30 15:27:49','',NULL,'设备服务调用'),(50,8,'2','sys/y2kvp0v5lk/${clientId}/service/${tsl.service.identifier}/reply','服务调用','1','1','0','1','2024-07-30 15:27:49','',NULL,'设备端响应服务调用'),(51,8,'3','custom/y2kvp0v5lk/${clientId}/test','test','1','1','2','',NULL,'',NULL,NULL);

/*Table structure for table `sys_login_log` */

DROP TABLE IF EXISTS `sys_login_log`;

CREATE TABLE `sys_login_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `username` varchar(50) DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) DEFAULT '' COMMENT '登录IP地址',
  `status` tinyint(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示信息',
  `access_time` datetime DEFAULT NULL COMMENT '访问时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(64) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `del_flag` tinyint NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb3 COMMENT='系统用户登录记录';

/*Data for the table `sys_login_log` */

insert  into `sys_login_log`(`id`,`username`,`ipaddr`,`status`,`msg`,`access_time`,`create_time`,`create_by`,`update_time`,`update_by`,`del_flag`,`remark`) values (1,'admin','221.182.10.112',1,'登录成功','2024-07-25 09:16:24','2024-07-25 09:16:23',NULL,NULL,NULL,0,NULL),(2,'admin','221.182.10.112',1,'登录成功','2024-07-25 11:42:45','2024-07-25 11:42:45',NULL,NULL,NULL,0,NULL),(3,'admin','114.225.239.116',1,'登录成功','2024-07-25 14:01:26','2024-07-25 14:01:26',NULL,NULL,NULL,0,NULL),(4,'admin','221.182.10.112',1,'登录成功','2024-07-25 16:36:12','2024-07-25 16:36:11',NULL,NULL,NULL,0,NULL),(5,'admin','120.235.173.153',1,'登录成功','2024-07-25 16:36:12','2024-07-25 16:36:12',NULL,NULL,NULL,0,NULL),(6,'admin','221.182.10.112',1,'登录成功','2024-07-25 16:47:52','2024-07-25 16:47:52',NULL,NULL,NULL,0,NULL),(7,'admin','39.144.38.92',1,'登录成功','2024-07-25 17:02:31','2024-07-25 17:02:31',NULL,NULL,NULL,0,NULL),(8,'admin','175.8.161.127',1,'登录成功','2024-07-26 10:42:26','2024-07-26 10:42:25',NULL,NULL,NULL,0,NULL),(9,'admin','115.194.184.239',1,'登录成功','2024-07-26 11:53:33','2024-07-26 11:53:32',NULL,NULL,NULL,0,NULL),(10,'admin','117.13.139.39',1,'登录成功','2024-07-26 16:11:05','2024-07-26 16:11:05',NULL,NULL,NULL,0,NULL),(11,'admin','123.138.132.128',1,'登录成功','2024-07-26 18:58:20','2024-07-26 18:58:19',NULL,NULL,NULL,0,NULL),(12,'admin','117.174.104.51',1,'登录成功','2024-07-26 19:50:41','2024-07-26 19:50:41',NULL,NULL,NULL,0,NULL),(13,'admin','223.104.40.65',1,'登录成功','2024-07-26 20:32:11','2024-07-26 20:32:11',NULL,NULL,NULL,0,NULL),(14,'admin','117.174.104.51',1,'登录成功','2024-07-26 20:49:36','2024-07-26 20:49:36',NULL,NULL,NULL,0,NULL),(15,'admin','183.199.185.164',1,'登录成功','2024-07-27 18:44:38','2024-07-27 18:44:38',NULL,NULL,NULL,0,NULL),(16,'admin','120.242.171.102',1,'登录成功','2024-07-27 20:42:21','2024-07-27 20:42:21',NULL,NULL,NULL,0,NULL),(17,'admin','60.222.118.65',1,'登录成功','2024-07-27 21:23:17','2024-07-27 21:23:16',NULL,NULL,NULL,0,NULL),(18,'admin','61.54.163.49',1,'登录成功','2024-07-27 21:43:36','2024-07-27 21:43:35',NULL,NULL,NULL,0,NULL),(19,'admin','221.217.48.101',1,'登录成功','2024-07-28 13:58:02','2024-07-28 13:58:02',NULL,NULL,NULL,0,NULL),(20,'admin','58.37.87.17',1,'登录成功','2024-07-28 15:54:12','2024-07-28 15:54:12',NULL,NULL,NULL,0,NULL),(21,'admin','120.231.22.126',1,'登录成功','2024-07-28 18:14:44','2024-07-28 18:14:44',NULL,NULL,NULL,0,NULL),(22,'admin','222.90.166.208',1,'登录成功','2024-07-28 19:05:03','2024-07-28 19:05:03',NULL,NULL,NULL,0,NULL),(23,'admin','112.10.228.202',1,'登录成功','2024-07-28 20:44:42','2024-07-28 20:44:42',NULL,NULL,NULL,0,NULL),(24,'admin','120.84.9.46',1,'登录成功','2024-07-28 20:59:39','2024-07-28 20:59:38',NULL,NULL,NULL,0,NULL),(25,'admin','183.186.119.244',1,'登录成功','2024-07-28 20:59:53','2024-07-28 20:59:52',NULL,NULL,NULL,0,NULL),(26,'admin','120.207.78.70',1,'登录成功','2024-07-28 22:20:51','2024-07-28 22:20:50',NULL,NULL,NULL,0,NULL),(27,'admin','125.46.162.246',1,'登录成功','2024-07-29 14:08:42','2024-07-29 14:08:41',NULL,NULL,NULL,0,NULL),(28,'admin','221.217.50.151',1,'登录成功','2024-07-29 15:49:31','2024-07-29 15:49:30',NULL,NULL,NULL,0,NULL),(29,'admin','117.36.132.216',1,'登录成功','2024-07-29 18:24:55','2024-07-29 18:24:54',NULL,NULL,NULL,0,NULL),(30,'admin','117.36.132.216',1,'登录成功','2024-07-29 18:25:37','2024-07-29 18:25:36',NULL,NULL,NULL,0,NULL),(31,'admin','123.113.243.254',1,'登录成功','2024-07-29 18:53:01','2024-07-29 18:53:00',NULL,NULL,NULL,0,NULL),(32,'admin','125.84.100.40',1,'登录成功','2024-07-30 01:59:24','2024-07-30 01:59:24',NULL,NULL,NULL,0,NULL),(33,'admin','125.84.100.40',1,'登录成功','2024-07-30 02:02:34','2024-07-30 02:02:33',NULL,NULL,NULL,0,NULL),(34,'admin','125.84.100.40',1,'登录成功','2024-07-30 02:07:38','2024-07-30 02:07:37',NULL,NULL,NULL,0,NULL),(35,'admin','223.104.40.55',1,'登录成功','2024-07-30 10:19:20','2024-07-30 10:19:19',NULL,NULL,NULL,0,NULL),(36,'admin','1.84.215.97',1,'登录成功','2024-07-30 12:23:47','2024-07-30 12:23:47',NULL,NULL,NULL,0,NULL),(37,'admin','222.209.109.189',1,'登录成功','2024-07-30 14:41:20','2024-07-30 14:41:19',NULL,NULL,NULL,0,NULL),(38,'admin','1.80.197.9',1,'登录成功','2024-07-30 15:25:25','2024-07-30 15:25:25',NULL,NULL,NULL,0,NULL),(39,'admin','125.123.66.20',1,'登录成功','2024-07-30 16:29:51','2024-07-30 16:29:51',NULL,NULL,NULL,0,NULL),(40,'admin','1.80.197.9',1,'登录成功','2024-07-30 16:36:11','2024-07-30 16:36:11',NULL,NULL,NULL,0,NULL),(41,'admin','1.80.197.9',1,'登录成功','2024-07-30 16:51:56','2024-07-30 16:51:56',NULL,NULL,NULL,0,NULL),(42,'admin','221.234.130.253',1,'登录成功','2024-07-30 17:27:52','2024-07-30 17:27:52',NULL,NULL,NULL,0,NULL),(43,'admin','123.120.37.129',1,'登录成功','2024-07-30 23:14:38','2024-07-30 23:14:38',NULL,NULL,NULL,0,NULL),(44,'admin','39.64.254.68',1,'登录成功','2024-07-31 09:33:21','2024-07-31 09:33:20',NULL,NULL,NULL,0,NULL),(45,'admin','223.85.244.94',1,'登录成功','2024-07-31 10:11:50','2024-07-31 10:11:49',NULL,NULL,NULL,0,NULL),(46,'admin','116.26.137.112',1,'登录成功','2024-07-31 13:42:38','2024-07-31 13:42:37',NULL,NULL,NULL,0,NULL),(47,'admin','171.15.156.59',1,'登录成功','2024-07-31 15:44:51','2024-07-31 15:44:51',NULL,NULL,NULL,0,NULL),(48,'admin','172.17.0.108',1,'登录成功','2024-07-31 15:51:39','2024-07-31 15:51:38',NULL,NULL,NULL,0,NULL),(49,'admin','0:0:0:0:0:0:0:1',1,'登录成功','2024-07-31 15:51:45','2024-07-31 15:51:44',NULL,NULL,NULL,0,NULL),(50,'admin','172.17.0.108',1,'登录成功','2024-07-31 15:51:55','2024-07-31 15:51:55',NULL,NULL,NULL,0,NULL),(51,'admin','223.104.41.194',1,'登录成功','2024-07-31 18:13:59','2024-07-31 18:13:58',NULL,NULL,NULL,0,NULL),(52,'admin','36.113.70.12',1,'登录成功','2024-07-31 20:48:52','2024-07-31 20:48:52',NULL,NULL,NULL,0,NULL),(53,'admin','223.104.153.116',1,'登录成功','2024-07-31 23:48:25','2024-07-31 23:48:25',NULL,NULL,NULL,0,NULL),(54,'admin','113.57.237.68',1,'登录成功','2024-08-01 10:19:30','2024-08-01 10:19:29',NULL,NULL,NULL,0,NULL),(55,'admin','120.243.168.77',1,'登录成功','2024-08-01 12:03:15','2024-08-01 12:03:15',NULL,NULL,NULL,0,NULL),(56,'admin','125.84.100.40',1,'登录成功','2024-08-01 20:23:25','2024-08-01 20:23:24',NULL,NULL,NULL,0,NULL),(57,'admin','39.171.252.132',1,'登录成功','2024-08-01 21:23:17','2024-08-01 21:23:17',NULL,NULL,NULL,0,NULL),(58,'admin','113.110.215.107',1,'登录成功','2024-08-01 21:40:26','2024-08-01 21:40:26',NULL,NULL,NULL,0,NULL),(59,'admin','103.192.59.249',1,'登录成功','2024-08-01 23:56:17','2024-08-01 23:56:17',NULL,NULL,NULL,0,NULL);

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` bigint NOT NULL DEFAULT '0' COMMENT '所属上级',
  `type` tinyint DEFAULT NULL COMMENT '类型(1:菜单,2:按钮)',
  `title` varchar(20) NOT NULL DEFAULT '' COMMENT '菜单标题',
  `component` varchar(100) DEFAULT NULL COMMENT '组件名称',
  `perms` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `sort_value` int NOT NULL DEFAULT '1' COMMENT '排序',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态(0:禁止,1:正常)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `del_flag` tinyint NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`parent_id`,`type`,`title`,`component`,`perms`,`sort_value`,`status`,`create_time`,`create_by`,`update_time`,`update_by`,`del_flag`,`remark`) values (1,0,1,'系统管理','system',NULL,1,1,'2023-05-04 10:46:47',NULL,'2024-07-25 14:01:06',NULL,0,NULL),(2,1,1,'用户管理','sysUser','sysUser.list',1,1,'2023-05-04 10:47:13',NULL,'2024-07-25 14:01:07',NULL,0,NULL),(3,1,1,'角色管理','sysRole','sysRole.list',2,1,'2023-05-04 10:47:19',NULL,'2024-07-25 14:01:07',NULL,0,NULL),(4,1,1,'菜单管理','sysMenu','sysMenu.list',3,1,'2023-05-04 10:47:26',NULL,'2024-07-25 14:01:08',NULL,0,NULL),(5,1,1,'日志管理','log',NULL,4,1,'2023-05-05 12:25:07',NULL,'2024-07-25 14:01:10',NULL,0,NULL),(6,5,1,'操作日志','sysOperLog','sysOperLog.list',1,1,'2023-06-02 09:04:13',NULL,'2024-07-25 14:01:10',NULL,0,NULL),(7,5,1,'登录日志','sysLoginLog','sysLoginLog.list',2,1,'2024-07-23 15:31:26',NULL,'2024-07-25 14:01:11',NULL,0,NULL),(24,2,2,'添加',NULL,'sysUser.add',1,1,'2024-07-23 15:43:27',NULL,'2024-07-25 14:01:12',NULL,0,NULL),(25,2,2,'修改',NULL,'sysUser.edit',2,1,'2024-07-23 15:43:30',NULL,'2024-07-25 14:01:12',NULL,0,NULL),(26,2,2,'删除',NULL,'sysUser.remove',3,1,'2024-07-23 15:44:35',NULL,'2024-07-25 14:01:13',NULL,0,NULL),(27,2,2,'分配角色',NULL,'sysUser.assignRole',4,1,'2024-07-23 15:45:25',NULL,'2024-07-25 14:01:13',NULL,0,NULL),(28,3,2,'添加',NULL,'sysRole.add',1,1,'2024-07-23 15:46:40',NULL,'2024-07-25 14:01:14',NULL,0,NULL),(29,3,2,'修改',NULL,'sysRole.edit',2,1,'2024-07-23 15:46:55',NULL,'2024-07-25 14:01:14',NULL,0,NULL),(30,3,2,'删除',NULL,'sysRole.remove',3,1,'2024-07-23 15:47:12',NULL,'2024-07-25 14:01:15',NULL,0,NULL),(31,3,2,'分配权限',NULL,'sysRole.assignMenu',4,1,'2024-07-23 15:48:12',NULL,'2024-07-25 14:01:16',NULL,0,NULL),(32,4,2,'添加',NULL,'sysMenu.add',1,1,'2024-07-23 15:48:39',NULL,'2024-07-25 14:01:17',NULL,0,NULL),(33,4,2,'修改',NULL,'sysMenu.edit',2,1,'2024-07-23 15:49:01',NULL,'2024-07-25 14:01:17',NULL,0,NULL),(34,4,2,'删除',NULL,'sysMenu.remove',3,1,'2024-07-23 15:49:12',NULL,'2024-07-25 14:01:18',NULL,0,NULL),(35,0,1,'设备管理','device','device.list',2,1,'2024-07-23 16:32:01',NULL,'2024-07-25 14:01:21',NULL,0,NULL),(36,35,1,'产品','productInfo','productInfo.list',1,1,'2024-07-23 16:32:34',NULL,'2024-07-25 14:01:31',NULL,0,NULL),(37,35,1,'设备','deviceInfo','deviceInfo.list',2,1,'2024-07-23 16:33:07',NULL,'2024-07-25 14:01:27',NULL,0,NULL),(38,36,2,'添加',NULL,'productInfo.add',1,1,'2024-07-23 16:33:35',NULL,'2024-07-25 14:01:33',NULL,0,NULL),(39,36,2,'修改',NULL,'productInfo.edit',2,1,'2024-07-23 16:35:07',NULL,'2024-07-25 14:01:33',NULL,0,NULL),(40,36,2,'删除',NULL,'productInfo.remove',2,1,'2024-07-23 16:33:57',NULL,'2024-07-25 14:01:34',NULL,0,NULL),(41,36,2,'查看','productShow','productInfo.show',3,1,'2024-07-23 16:34:27',NULL,'2024-08-02 11:16:34',NULL,2,NULL),(42,37,2,'添加',NULL,'deviceInfo.add',1,1,'2024-07-23 16:36:40',NULL,'2024-07-25 14:01:36',NULL,0,NULL),(43,37,2,'删除',NULL,'deviceInfo.remove',2,1,'2024-07-23 16:37:23',NULL,'2024-07-25 14:01:37',NULL,0,NULL),(44,37,2,'查看','deviceShow','deviceInfo.show',3,1,'2024-07-23 16:37:57',NULL,'2024-08-02 11:16:31',NULL,2,NULL),(45,0,1,'监控运维','devops','devops.list',3,1,'2024-07-23 16:40:09',NULL,'2024-08-02 09:44:11',NULL,0,NULL),(46,45,1,'在线调试','debug','debug.list',1,1,'2024-07-23 16:40:50',NULL,'2024-07-25 14:01:40',NULL,0,NULL),(47,45,1,'日志服务','deviceOptionLog','deviceOptionLog.list',2,1,'2024-07-23 16:41:37',NULL,'2024-07-25 14:01:41',NULL,0,NULL),(48,45,1,'数据统计','dataCount','dataCount.list',3,1,'2024-07-25 11:42:19',NULL,'2024-07-25 14:01:41',NULL,0,NULL),(49,2,2,'导出',NULL,'sysUser.export',5,1,'2024-07-31 11:42:12',NULL,'2024-07-31 11:42:12',NULL,0,NULL);

/*Table structure for table `sys_oper_log` */

DROP TABLE IF EXISTS `sys_oper_log`;

CREATE TABLE `sys_oper_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operator_type` varchar(20) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) DEFAULT '' COMMENT '主机地址',
  `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` int DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(64) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `del_flag` tinyint NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8mb3 COMMENT='操作日志记录';

/*Data for the table `sys_oper_log` */

insert  into `sys_oper_log`(`id`,`title`,`method`,`request_method`,`operator_type`,`oper_name`,`oper_url`,`oper_ip`,`oper_param`,`json_result`,`status`,`error_msg`,`create_time`,`create_by`,`update_time`,`update_by`,`del_flag`,`remark`) values (64,'角色管理:修改','com.atguigu.spzx.system.controller.SysRoleController.updateById()','PUT','MANAGE',NULL,'/admin/system/sysRole/updateById','0:0:0:0:0:0:0:1','{\"createTime\":1683196582000,\"roleCode\":\"yhgly\",\"roleName\":\"用户管理员\",\"description\":\"用户管理员\",\"id\":10}','{\"code\":200,\"message\":\"成功\"}',1,NULL,'2023-06-02 08:53:25',NULL,NULL,NULL,0,NULL),(65,'角色管理:修改','com.atguigu.spzx.system.controller.SysRoleController.updateById()','PUT','MANAGE','admin','/admin/system/sysRole/updateById','0:0:0:0:0:0:0:1','{\"createTime\":1683196566000,\"roleCode\":\"ptgly\",\"roleName\":\"平台管理员\",\"description\":\"平台管理员\",\"id\":9}','{\"code\":200,\"message\":\"成功\"}',1,NULL,'2023-06-02 09:03:31',NULL,NULL,NULL,0,NULL),(66,'品牌管理:修改','com.atguigu.spzx.product.controller.BrandController.updateById()','PUT','MANAGE','admin','/admin/product/brand/updateById','117.173.208.34','{\"createTime\":1683365427000,\"name\":\"小米\",\"logo\":\"http://139.198.127.41:9000/sph/20230506/小米.png\",\"id\":1}','{\"code\":200,\"message\":\"成功\"}',1,NULL,'2023-06-02 09:40:24',NULL,NULL,NULL,0,NULL),(67,'角色管理:新增','com.atguigu.spzx.system.controller.SysRoleController.save()','POST','MANAGE','admin','/admin/system/sysRole/save','0:0:0:0:0:0:0:1','{\"roleCode\":\"1\",\"roleName\":\"1\",\"description\":\"1\",\"id\":27}','{\"code\":200,\"message\":\"成功\"}',1,NULL,'2023-06-25 10:13:43',NULL,NULL,NULL,0,NULL),(68,'角色管理:新增','com.atguigu.spzx.system.controller.SysRoleController.save()','POST','MANAGE','admin','/admin/system/sysRole/save','0:0:0:0:0:0:0:1','{\"roleCode\":\"12\",\"roleName\":\"12\",\"description\":\"12\",\"id\":28}','{\"code\":200,\"message\":\"成功\"}',1,NULL,'2023-06-25 10:14:54',NULL,NULL,NULL,0,NULL),(69,'角色管理:修改','com.atguigu.spzx.system.controller.SysRoleController.updateById()','PUT','MANAGE','admin','/admin/system/sysRole/updateById','0:0:0:0:0:0:0:1','{\"roleCode\":\"112\",\"roleName\":\"112\",\"description\":\"112\",\"id\":28}',NULL,0,NULL,'2023-06-25 10:15:38',NULL,NULL,NULL,0,NULL),(70,'角色管理:修改','com.atguigu.spzx.system.controller.SysRoleController.updateById()','PUT','MANAGE','admin','/admin/system/sysRole/updateById','0:0:0:0:0:0:0:1','{\"roleCode\":\"112\",\"roleName\":\"112\",\"description\":\"112\",\"id\":28}',NULL,0,NULL,'2023-06-25 10:16:36',NULL,NULL,NULL,0,NULL),(71,'角色管理:修改','com.atguigu.spzx.system.controller.SysRoleController.updateById()','PUT','MANAGE','admin','/admin/system/sysRole/updateById','0:0:0:0:0:0:0:1','{\"roleCode\":\"112\",\"roleName\":\"112\",\"description\":\"112\",\"id\":28}','{\"code\":200,\"message\":\"成功\"}',1,NULL,'2023-06-25 10:23:35',NULL,NULL,NULL,0,NULL),(72,'角色管理：修改','com.atguigu.iot.controller.system.SysRoleController.edit()','PUT','MANAGE','1','/system/sysRole','0:0:0:0:0:0:0:1','{\"createTime\":\"2024-07-22 09:10:51\",\"delFlag\":\"0\",\"id\":29,\"params\":{},\"roleCode\":\"test\",\"roleName\":\"test\",\"updateTime\":\"2024-07-22 09:10:51\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-22 15:24:42',NULL,NULL,NULL,0,NULL),(73,'角色管理：修改','com.atguigu.iot.controller.system.SysRoleController.edit()','PUT','MANAGE','1','/system/sysRole','0:0:0:0:0:0:0:1','{\"createTime\":\"2024-07-22 09:10:51\",\"delFlag\":\"0\",\"id\":29,\"params\":{},\"roleCode\":\"test\",\"roleName\":\"test\",\"updateTime\":\"2024-07-22 09:10:51\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 11:30:50',NULL,NULL,NULL,0,NULL),(74,'角色管理：修改','com.atguigu.iot.controller.system.SysRoleController.edit()','PUT','MANAGE','1','/system/sysRole','0:0:0:0:0:0:0:1','{\"createTime\":\"2024-07-22 09:10:51\",\"delFlag\":\"0\",\"id\":29,\"params\":{},\"roleCode\":\"test\",\"roleName\":\"test\",\"updateTime\":\"2024-07-22 09:10:51\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 11:31:25',NULL,NULL,NULL,0,NULL),(75,'角色管理：修改','com.atguigu.iot.controller.system.SysRoleController.edit()','PUT','MANAGE','1','/system/sysRole','0:0:0:0:0:0:0:1','{\"createTime\":\"2024-07-22 09:10:51\",\"delFlag\":\"0\",\"id\":29,\"params\":{},\"roleCode\":\"test\",\"roleName\":\"test\",\"updateTime\":\"2024-07-22 09:10:51\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 11:32:30',NULL,NULL,NULL,0,NULL),(76,'菜单管理：修改','com.atguigu.iot.controller.system.SysMenuController.edit()','PUT','MANAGE','admin','/system/sysMenu','0:0:0:0:0:0:0:1','{\"component\":\"sysOperLog\",\"createTime\":\"2023-06-02 09:04:13\",\"delFlag\":\"0\",\"id\":6,\"params\":{},\"parentId\":5,\"perms\":\"sysOperLog.list\",\"select\":false,\"sortValue\":1,\"status\":1,\"title\":\"操作日志\",\"type\":1,\"updateTime\":\"2024-07-23 15:33:01\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 16:03:04',NULL,NULL,NULL,0,NULL),(77,'菜单管理：修改','com.atguigu.iot.controller.system.SysMenuController.edit()','PUT','MANAGE','admin','/system/sysMenu','0:0:0:0:0:0:0:1','{\"component\":\"sysLoginLog\",\"createTime\":\"2024-07-23 15:31:26\",\"delFlag\":\"0\",\"id\":7,\"params\":{},\"parentId\":5,\"perms\":\"sysLoginLog.list\",\"select\":false,\"sortValue\":2,\"status\":1,\"title\":\"登录日志\",\"type\":1,\"updateTime\":\"2024-07-23 15:32:55\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 16:03:12',NULL,NULL,NULL,0,NULL),(78,'菜单管理：添加','com.atguigu.iot.controller.system.SysMenuController.add()','POST','MANAGE','admin','/system/sysMenu','0:0:0:0:0:0:0:1','{\"component\":\"device\",\"id\":35,\"params\":{},\"perms\":\"device.list\",\"select\":false,\"sortValue\":2,\"status\":1,\"title\":\"设备管理\",\"type\":1}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 16:32:02',NULL,NULL,NULL,0,NULL),(79,'菜单管理：添加','com.atguigu.iot.controller.system.SysMenuController.add()','POST','MANAGE','admin','/system/sysMenu','0:0:0:0:0:0:0:1','{\"component\":\"productInfo\",\"id\":36,\"params\":{},\"parentId\":35,\"perms\":\"productInfo.list\",\"select\":false,\"sortValue\":1,\"status\":1,\"title\":\"产品\",\"type\":1}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 16:32:34',NULL,NULL,NULL,0,NULL),(80,'菜单管理：添加','com.atguigu.iot.controller.system.SysMenuController.add()','POST','MANAGE','admin','/system/sysMenu','0:0:0:0:0:0:0:1','{\"component\":\"deviceInfo\",\"id\":37,\"params\":{},\"parentId\":35,\"perms\":\"deviceInfo.list\",\"select\":false,\"sortValue\":2,\"status\":1,\"title\":\"设备\",\"type\":1}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 16:33:07',NULL,NULL,NULL,0,NULL),(81,'菜单管理：添加','com.atguigu.iot.controller.system.SysMenuController.add()','POST','MANAGE','admin','/system/sysMenu','0:0:0:0:0:0:0:1','{\"id\":38,\"params\":{},\"parentId\":36,\"perms\":\"productInfo.add\",\"select\":false,\"sortValue\":1,\"status\":1,\"title\":\"添加\",\"type\":2}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 16:33:35',NULL,NULL,NULL,0,NULL),(82,'菜单管理：添加','com.atguigu.iot.controller.system.SysMenuController.add()','POST','MANAGE','admin','/system/sysMenu','0:0:0:0:0:0:0:1','{\"id\":39,\"params\":{},\"parentId\":36,\"perms\":\"productInfo.remove\",\"select\":false,\"sortValue\":2,\"status\":1,\"title\":\"删除\",\"type\":2}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 16:33:57',NULL,NULL,NULL,0,NULL),(83,'菜单管理：添加','com.atguigu.iot.controller.system.SysMenuController.add()','POST','MANAGE','admin','/system/sysMenu','0:0:0:0:0:0:0:1','{\"id\":40,\"params\":{},\"parentId\":36,\"perms\":\"productInfo.show\",\"select\":false,\"sortValue\":3,\"status\":1,\"title\":\"查看\",\"type\":2}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 16:34:27',NULL,NULL,NULL,0,NULL),(84,'菜单管理：添加','com.atguigu.iot.controller.system.SysMenuController.add()','POST','MANAGE','admin','/system/sysMenu','0:0:0:0:0:0:0:1','{\"id\":41,\"params\":{},\"parentId\":36,\"perms\":\"productInfo.edit\",\"select\":false,\"sortValue\":2,\"status\":1,\"title\":\"修改\",\"type\":2}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 16:35:07',NULL,NULL,NULL,0,NULL),(85,'菜单管理：添加','com.atguigu.iot.controller.system.SysMenuController.add()','POST','MANAGE','admin','/system/sysMenu','0:0:0:0:0:0:0:1','{\"id\":42,\"params\":{},\"parentId\":37,\"perms\":\"deviceInfo.add\",\"select\":false,\"sortValue\":1,\"status\":1,\"title\":\"添加\",\"type\":2}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 16:36:40',NULL,NULL,NULL,0,NULL),(86,'菜单管理：添加','com.atguigu.iot.controller.system.SysMenuController.add()','POST','MANAGE','admin','/system/sysMenu','0:0:0:0:0:0:0:1','{\"id\":43,\"params\":{},\"parentId\":37,\"perms\":\"deviceInfo.remove\",\"select\":false,\"sortValue\":2,\"status\":1,\"title\":\"删除\",\"type\":2}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 16:37:23',NULL,NULL,NULL,0,NULL),(87,'菜单管理：添加','com.atguigu.iot.controller.system.SysMenuController.add()','POST','MANAGE','admin','/system/sysMenu','0:0:0:0:0:0:0:1','{\"id\":44,\"params\":{},\"parentId\":37,\"perms\":\"deviceInfo.show\",\"select\":false,\"sortValue\":3,\"status\":1,\"title\":\"查看\",\"type\":2}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 16:37:57',NULL,NULL,NULL,0,NULL),(88,'菜单管理：添加','com.atguigu.iot.controller.system.SysMenuController.add()','POST','MANAGE','admin','/system/sysMenu','0:0:0:0:0:0:0:1','{\"component\":\"devops\",\"id\":45,\"params\":{},\"perms\":\"devops.list\",\"select\":false,\"sortValue\":1,\"status\":1,\"title\":\"监控运维\",\"type\":1}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 16:40:10',NULL,NULL,NULL,0,NULL),(89,'菜单管理：添加','com.atguigu.iot.controller.system.SysMenuController.add()','POST','MANAGE','admin','/system/sysMenu','0:0:0:0:0:0:0:1','{\"component\":\"debug\",\"id\":46,\"params\":{},\"parentId\":45,\"perms\":\"debug.list\",\"select\":false,\"sortValue\":1,\"status\":1,\"title\":\"在线调试\",\"type\":1}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 16:40:50',NULL,NULL,NULL,0,NULL),(90,'菜单管理：添加','com.atguigu.iot.controller.system.SysMenuController.add()','POST','MANAGE','admin','/system/sysMenu','0:0:0:0:0:0:0:1','{\"component\":\"deviceOptionLog\",\"id\":47,\"params\":{},\"parentId\":45,\"perms\":\"deviceOptionLog.list\",\"select\":false,\"sortValue\":2,\"status\":1,\"title\":\"日志服务\",\"type\":1}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 16:41:38',NULL,NULL,NULL,0,NULL),(91,'菜单管理：修改','com.atguigu.iot.controller.system.SysMenuController.edit()','PUT','MANAGE','admin','/system/sysMenu','0:0:0:0:0:0:0:1','{\"component\":\"productShow\",\"createTime\":\"2024-07-23 16:34:27\",\"delFlag\":\"0\",\"id\":41,\"params\":{},\"parentId\":36,\"perms\":\"productInfo.show\",\"select\":false,\"sortValue\":3,\"status\":1,\"title\":\"查看\",\"type\":2,\"updateTime\":\"2024-07-23 16:39:30\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 16:44:42',NULL,NULL,NULL,0,NULL),(92,'菜单管理：修改','com.atguigu.iot.controller.system.SysMenuController.edit()','PUT','MANAGE','admin','/system/sysMenu','0:0:0:0:0:0:0:1','{\"component\":\"deviceShow\",\"createTime\":\"2024-07-23 16:37:57\",\"delFlag\":\"0\",\"id\":44,\"params\":{},\"parentId\":37,\"perms\":\"deviceInfo.show\",\"select\":false,\"sortValue\":3,\"status\":1,\"title\":\"查看\",\"type\":2,\"updateTime\":\"2024-07-23 16:37:57\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-23 16:44:54',NULL,NULL,NULL,0,NULL),(93,'菜单管理：分配权限','com.atguigu.iot.controller.system.SysMenuController.doAssign()','POST','MANAGE','admin','/system/sysMenu/doAssign','0:0:0:0:0:0:0:1','{\"menuIdList\":[24,2,1,28,3],\"roleId\":29}','{\"code\":200,\"message\":\"成功\"}',1,'','2024-07-23 17:07:47',NULL,NULL,NULL,0,NULL),(94,'角色管理：分配角色','com.atguigu.iot.controller.system.SysRoleController.doAssign()','POST','MANAGE','admin','/system/sysRole/doAssign','0:0:0:0:0:0:0:1','{\"roleIdList\":[29],\"userId\":6}','{\"code\":200,\"message\":\"成功\"}',1,'','2024-07-23 17:07:58',NULL,NULL,NULL,0,NULL),(95,'菜单管理：添加','com.atguigu.iot.controller.system.SysMenuController.add()','POST','MANAGE','admin','/system/sysMenu','221.182.10.112','{\"component\":\"dataCount\",\"id\":48,\"params\":{},\"parentId\":45,\"perms\":\"dataCount.list\",\"select\":false,\"sortValue\":3,\"status\":1,\"title\":\"数据统计\",\"type\":2}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-25 11:42:20',NULL,NULL,NULL,0,NULL),(96,'菜单管理：添加','com.atguigu.iot.controller.system.SysMenuController.add()','POST','MANAGE','admin','/system/sysMenu','221.182.10.112','{\"id\":49,\"params\":{},\"parentId\":0,\"select\":false,\"sortValue\":5,\"status\":1,\"title\":\"一级测试\",\"type\":1}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-25 13:48:21',NULL,NULL,NULL,0,NULL),(97,'菜单管理：修改','com.atguigu.iot.controller.system.SysMenuController.edit()','PUT','MANAGE','admin','/system/sysMenu','221.182.10.112','{\"component\":\"11\",\"createTime\":\"2024-07-25 13:48:21\",\"delFlag\":\"0\",\"id\":49,\"params\":{},\"parentId\":0,\"perms\":\"11.1\",\"select\":false,\"sortValue\":5,\"status\":1,\"title\":\"一级测试\",\"type\":1,\"updateTime\":\"2024-07-25 13:48:21\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-25 13:48:44',NULL,NULL,NULL,0,NULL),(98,'菜单管理：添加','com.atguigu.iot.controller.system.SysMenuController.add()','POST','MANAGE','admin','/system/sysMenu','221.182.10.112','{\"component\":\"22\",\"id\":50,\"params\":{},\"parentId\":49,\"perms\":\"22.2\",\"select\":false,\"sortValue\":2,\"status\":1,\"title\":\"二级菜单\",\"type\":1}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-25 13:50:47',NULL,NULL,NULL,0,NULL),(99,'菜单管理：添加','com.atguigu.iot.controller.system.SysMenuController.add()','POST','MANAGE','admin','/system/sysMenu','221.182.10.112','{\"id\":51,\"params\":{},\"parentId\":50,\"perms\":\"11\",\"select\":false,\"sortValue\":1,\"status\":1,\"title\":\"添加\",\"type\":1}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-25 13:51:16',NULL,NULL,NULL,0,NULL),(100,'菜单管理：修改','com.atguigu.iot.controller.system.SysMenuController.edit()','PUT','MANAGE','admin','/system/sysMenu','221.182.10.112','{\"createTime\":\"2024-07-25 13:51:16\",\"delFlag\":\"0\",\"id\":51,\"params\":{},\"parentId\":50,\"perms\":\"11\",\"select\":false,\"sortValue\":1,\"status\":0,\"title\":\"添加\",\"type\":1,\"updateTime\":\"2024-07-25 13:51:16\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-25 13:51:48',NULL,NULL,NULL,0,NULL),(101,'菜单管理：修改','com.atguigu.iot.controller.system.SysMenuController.edit()','PUT','MANAGE','admin','/system/sysMenu','221.182.10.112','{\"createTime\":\"2024-07-23 15:45:25\",\"delFlag\":\"0\",\"id\":27,\"params\":{},\"parentId\":2,\"perms\":\"sysUser.assignRole\",\"select\":false,\"sortValue\":0,\"status\":1,\"title\":\"分配角色\",\"type\":2,\"updateTime\":\"2024-07-25 14:01:13\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-25 14:23:39',NULL,NULL,NULL,0,NULL),(102,'菜单管理：修改','com.atguigu.iot.controller.system.SysMenuController.edit()','PUT','MANAGE','admin','/system/sysMenu','221.182.10.112','{\"createTime\":\"2024-07-23 15:45:25\",\"delFlag\":\"0\",\"id\":27,\"params\":{},\"parentId\":2,\"perms\":\"sysUser.assignRole\",\"select\":false,\"sortValue\":4,\"status\":1,\"title\":\"分配角色\",\"type\":2,\"updateTime\":\"2024-07-25 14:01:13\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-25 14:23:50',NULL,NULL,NULL,0,NULL),(103,'菜单管理：修改','com.atguigu.iot.controller.system.SysMenuController.edit()','PUT','MANAGE','admin','/system/sysMenu','221.182.10.112','{\"createTime\":\"2024-07-23 15:45:25\",\"delFlag\":\"0\",\"id\":27,\"params\":{},\"parentId\":2,\"perms\":\"sysUser.assignRole\",\"select\":false,\"sortValue\":0,\"status\":1,\"title\":\"分配角色\",\"type\":2,\"updateTime\":\"2024-07-25 14:01:13\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-25 17:08:50',NULL,NULL,NULL,0,NULL),(104,'菜单管理：修改','com.atguigu.iot.controller.system.SysMenuController.edit()','PUT','MANAGE','admin','/system/sysMenu','221.182.10.112','{\"createTime\":\"2024-07-23 15:45:25\",\"delFlag\":\"0\",\"id\":27,\"params\":{},\"parentId\":2,\"perms\":\"sysUser.assignRole\",\"select\":false,\"sortValue\":4,\"status\":1,\"title\":\"分配角色\",\"type\":2,\"updateTime\":\"2024-07-25 14:01:13\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-25 17:08:57',NULL,NULL,NULL,0,NULL),(105,'菜单管理：修改','com.atguigu.iot.controller.system.SysMenuController.edit()','PUT','MANAGE','admin','/system/sysMenu','221.182.10.112','{\"component\":\"devops\",\"createTime\":\"2024-07-23 16:40:09\",\"delFlag\":\"0\",\"id\":45,\"params\":{},\"parentId\":0,\"perms\":\"devops.list\",\"select\":false,\"sortValue\":3,\"status\":1,\"title\":\"监控运维\",\"type\":1,\"updateTime\":\"2024-07-25 14:01:39\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-26 11:12:39',NULL,NULL,NULL,0,NULL),(106,'产品物模型属性：添加','com.atguigu.iot.controller.mqtt.ProductModelController.add()','POST','MANAGE','admin','/mqtt/productModel','125.84.100.40','{\"callType\":\"1\",\"dataTypeId\":2,\"dataUnit\":\" \",\"eventType\":\"1\",\"identifier\":\"test\",\"inputParams\":\"[]\",\"modelType\":1,\"name\":\"test\",\"optionStatus\":\"1\",\"outputParams\":\"[]\",\"productId\":2,\"typeParams\":\"{\\\"step\\\":\\\"1\\\",\\\"min\\\":null,\\\"max\\\":null,\\\"enumList\\\":[{\\\"id\\\":1,\\\"name\\\":\\\"\\\",\\\"value\\\":\\\"\\\"}]}\"}','{\"code\":201,\"data\":\"系统数据不能操作\",\"message\":\"失败\"}',1,'','2024-07-30 02:11:13',NULL,NULL,NULL,0,NULL),(107,'产品信息：删除','com.atguigu.iot.controller.mqtt.ProductInfoController.remove()','DELETE','MANAGE','admin','/mqtt/productInfo/2','125.84.100.40','','{\"code\":201,\"data\":\"系统数据不能操作\",\"message\":\"失败\"}',1,'','2024-07-30 02:11:29',NULL,NULL,NULL,0,NULL),(108,'产品信息：删除','com.atguigu.iot.controller.mqtt.ProductInfoController.remove()','DELETE','MANAGE','admin','/mqtt/productInfo/1','125.84.100.40','','{\"code\":201,\"data\":\"系统数据不能操作\",\"message\":\"失败\"}',1,'','2024-07-30 02:11:32',NULL,NULL,NULL,0,NULL),(109,'设备信息：添加','com.atguigu.iot.controller.mqtt.DeviceInfoController.add()','POST','MANAGE','admin','/mqtt/deviceInfo','125.84.100.40','{\"clientId\":\"rjxj1a6ikdx3uom\",\"createBy\":\"1\",\"createTime\":\"2024-07-30 02:12:04\",\"id\":6,\"name\":\"测试\",\"params\":{},\"password\":\"111111\",\"productId\":1,\"username\":\"awa8xiwc\"}','{\"code\":200,\"data\":1,\"message\":\"成功\"}',1,'','2024-07-30 02:12:04',NULL,NULL,NULL,0,NULL),(110,'设备信息：删除','com.atguigu.iot.controller.mqtt.DeviceInfoController.remove()','DELETE','MANAGE','admin','/mqtt/deviceInfo/6','125.84.100.40','','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-30 02:12:09',NULL,NULL,NULL,0,NULL),(111,'菜单管理：修改','com.atguigu.iot.controller.system.SysMenuController.edit()','PUT','MANAGE','admin','/system/sysMenu','223.85.244.94','{\"component\":\"sysUser\",\"createTime\":\"2023-05-04 10:47:13\",\"delFlag\":\"0\",\"id\":2,\"params\":{},\"parentId\":1,\"perms\":\"sysUser.list\",\"select\":false,\"sortValue\":1,\"status\":1,\"title\":\"用户管理\",\"type\":1,\"updateTime\":\"2024-07-25 14:01:07\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-30 08:42:40',NULL,NULL,NULL,0,NULL),(112,'产品信息：添加','com.atguigu.iot.controller.mqtt.ProductInfoController.add()','POST','MANAGE','admin','/mqtt/productInfo','1.80.197.9','{\"createBy\":\"1\",\"createTime\":\"2024-07-30 15:27:49\",\"id\":8,\"name\":\"测试\",\"nodeType\":\"1\",\"params\":{},\"productKey\":\"y2kvp0v5lk\",\"remark\":\"测试设别\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-30 15:27:49',NULL,NULL,NULL,0,NULL),(113,'设备信息：添加','com.atguigu.iot.controller.mqtt.DeviceInfoController.add()','POST','MANAGE','admin','/mqtt/deviceInfo','1.80.197.9','{\"clientId\":\"5wm9dhqttmjqujr\",\"createBy\":\"1\",\"createTime\":\"2024-07-30 15:28:04\",\"id\":7,\"name\":\"机库\",\"params\":{},\"password\":\"111111\",\"productId\":8,\"remark\":\"机库\",\"username\":\"qfhlkscl\"}','{\"code\":200,\"data\":1,\"message\":\"成功\"}',1,'','2024-07-30 15:28:04',NULL,NULL,NULL,0,NULL),(114,'菜单管理：添加','com.atguigu.iot.controller.system.SysMenuController.add()','POST','MANAGE','admin','/system/sysMenu','223.85.244.94','{\"id\":49,\"params\":{},\"parentId\":2,\"perms\":\"sysUser.export\",\"select\":false,\"sortValue\":5,\"status\":1,\"title\":\"导出\",\"type\":2}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-31 11:42:12',NULL,NULL,NULL,0,NULL),(115,'用户管理：修改','com.atguigu.iot.controller.system.SysUserController.edit()','PUT','MANAGE','admin','/system/sysUser','171.15.156.59','{\"avatar\":\"https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg\",\"createTime\":\"2023-05-04 10:17:18\",\"delFlag\":\"0\",\"id\":1,\"name\":\"admin\",\"params\":{},\"password\":\"96e79218965eb72c92a549dd5a330112\",\"phone\":\"15011113652\",\"status\":1,\"updateTime\":\"2023-08-05 09:40:53\",\"username\":\"admin\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-31 15:45:52',NULL,NULL,NULL,0,NULL),(116,'用户管理：修改','com.atguigu.iot.controller.system.SysUserController.edit()','PUT','MANAGE','admin','/system/sysUser','0:0:0:0:0:0:0:1','{\"avatar\":\"https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg\",\"createTime\":\"2023-05-04 10:38:30\",\"delFlag\":\"0\",\"description\":\"\",\"id\":2,\"name\":\"张三\",\"params\":{},\"password\":\"96e79218965eb72c92a549dd5a330112\",\"phone\":\"13589658968\",\"status\":1,\"updateTime\":\"2023-08-05 09:40:53\",\"username\":\"zhangsan\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-07-31 15:53:42',NULL,NULL,NULL,0,NULL),(117,'产品Topic：添加','com.atguigu.iot.controller.mqtt.ProductTopicController.add()','POST','MANAGE','admin','/mqtt/productTopic','223.85.244.94','{\"groupName\":\"test\",\"id\":51,\"optionType\":\"1\",\"params\":{},\"productId\":8,\"status\":\"1\",\"topic\":\"custom/y2kvp0v5lk/${clientId}/test\",\"topicType\":\"3\"}','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-08-02 10:25:04',NULL,NULL,NULL,0,NULL),(118,'产品Topic：删除','com.atguigu.iot.controller.mqtt.ProductTopicController.remove()','DELETE','MANAGE','admin','/mqtt/productTopic/51','223.85.244.94','','{\"code\":200,\"data\":true,\"message\":\"成功\"}',1,'','2024-08-02 10:26:18',NULL,NULL,NULL,0,NULL);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(20) NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_code` varchar(20) DEFAULT NULL COMMENT '角色编码',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `del_flag` tinyint NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3 COMMENT='角色';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`role_name`,`role_code`,`description`,`create_time`,`create_by`,`update_time`,`update_by`,`del_flag`,`remark`) values (9,'平台管理员','ptgly','平台管理员','2023-05-04 10:36:06',NULL,'2023-06-02 09:03:31',NULL,0,NULL),(10,'用户管理员','yhgly','用户管理员','2023-05-04 10:36:22',NULL,'2023-06-02 08:53:25',NULL,0,NULL),(29,'test','test',NULL,'2024-07-22 09:10:51',NULL,'2024-07-22 09:10:51',NULL,0,NULL),(30,'测试角色','test','测试角色','2024-07-29 16:20:46',NULL,'2024-07-29 16:20:46',NULL,0,NULL);

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NOT NULL DEFAULT '0',
  `menu_id` bigint NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `del_flag` tinyint NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_menu_id` (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COMMENT='角色菜单';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`create_time`,`create_by`,`update_time`,`update_by`,`del_flag`,`remark`) values (1,10,16,'2024-07-19 15:21:20',NULL,'2024-07-19 15:23:56',NULL,2,NULL),(2,10,17,'2024-07-19 15:21:20',NULL,'2024-07-19 15:23:56',NULL,2,NULL),(3,10,18,'2024-07-19 15:21:20',NULL,'2024-07-19 15:23:56',NULL,2,NULL),(4,10,17,'2024-07-19 15:23:57',NULL,'2024-07-19 15:23:56',NULL,0,NULL),(5,10,18,'2024-07-19 15:23:57',NULL,'2024-07-19 15:23:57',NULL,0,NULL),(6,10,14,'2024-07-19 15:23:57',NULL,'2024-07-19 15:23:57',NULL,0,NULL),(7,10,15,'2024-07-19 15:23:57',NULL,'2024-07-19 15:23:57',NULL,0,NULL),(8,29,24,'2024-07-23 17:07:46','1','2024-07-23 17:07:46',NULL,0,NULL),(9,29,2,'2024-07-23 17:07:47','1','2024-07-23 17:07:47',NULL,0,NULL),(10,29,1,'2024-07-23 17:07:47','1','2024-07-23 17:07:47',NULL,0,NULL),(11,29,28,'2024-07-23 17:07:47','1','2024-07-23 17:07:47',NULL,0,NULL),(12,29,3,'2024-07-23 17:07:47','1','2024-07-23 17:07:47',NULL,0,NULL);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态（1：正常 0：停用）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `del_flag` tinyint NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`password`,`name`,`phone`,`avatar`,`description`,`status`,`create_time`,`create_by`,`update_time`,`update_by`,`del_flag`,`remark`) values (1,'admin','96e79218965eb72c92a549dd5a330112','admin','15011113652','https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg',NULL,1,'2023-05-04 10:17:18',NULL,'2023-08-05 09:40:53',NULL,0,NULL),(2,'zhangsan','96e79218965eb72c92a549dd5a330112','张三','13589658968','https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg','',1,'2023-05-04 10:38:30',NULL,'2023-08-05 09:40:53',NULL,0,NULL),(6,'test1','96e79218965eb72c92a549dd5a330112','test1','15010245632','http://139.198.127.41:9000/sph/20230505/default_handsome.jpg','test1',1,'2023-05-05 11:03:48',NULL,'2024-07-29 15:26:18',NULL,2,NULL),(7,'test2','123456','测试用户1','15012345678','https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg','测试用户',1,'2024-07-29 15:10:30',NULL,'2024-07-29 15:26:18',NULL,2,NULL);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint NOT NULL DEFAULT '0' COMMENT '角色id',
  `user_id` bigint NOT NULL DEFAULT '0' COMMENT '用户id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `del_flag` tinyint NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_admin_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='用户角色';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`role_id`,`user_id`,`create_time`,`create_by`,`update_time`,`update_by`,`del_flag`,`remark`) values (1,10,1,'2023-05-29 16:37:43',NULL,'2023-08-04 10:47:44',NULL,0,NULL),(2,9,1,'2023-08-04 10:47:39',NULL,'2023-08-04 10:47:48',NULL,0,NULL),(3,29,6,'2024-07-23 17:07:58',NULL,'2024-07-23 17:07:58',NULL,0,NULL);

/*Table structure for table `topic_template` */

DROP TABLE IF EXISTS `topic_template`;

CREATE TABLE `topic_template` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `topic_type` char(1) DEFAULT NULL COMMENT 'topic类型【1：基础类 2：物模型类 3：自定义】',
  `group_name` varchar(100) NOT NULL DEFAULT '0' COMMENT '功能名称',
  `topic` varchar(200) NOT NULL DEFAULT '' COMMENT 'topic',
  `option_type` char(1) DEFAULT NULL COMMENT '操作类型【1：发布 2：订阅】',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态（1正常 0停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Topic模板表';

/*Data for the table `topic_template` */

insert  into `topic_template`(`id`,`topic_type`,`group_name`,`topic`,`option_type`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'1','OTA 升级','ota/device/inform/${productKey}/${clientId}','1','1','0','',NULL,'',NULL,'设备上报固件升级信息'),(2,'1','OTA 升级','ota/device/upgrade/${productKey}/${clientId}','2','1','0','',NULL,'',NULL,'固件升级信息下行'),(3,'2','属性上报','sys/${productKey}/${clientId}/property/post','1','1','0','',NULL,'',NULL,'设备属性上报'),(4,'2','属性上报','sys/${productKey}/${clientId}/property/post_reply','2','1','0','',NULL,'',NULL,'云端响应属性上报'),(5,'2','属性设置','sys/${productKey}/${clientId}/property/set','2','1','0','',NULL,'',NULL,'设备属性设置'),(6,'2','事件上报','sys/${productKey}/${clientId}/event/${tsl.event.identifier}/post','1','1','0','',NULL,'',NULL,'设备事件上报'),(7,'2','事件上报','sys/${productKey}/${clientId}/event/${tsl.event.identifier}/post_reply','2','1','0','',NULL,'',NULL,'云端响应事件上报'),(8,'2','服务调用','sys/${productKey}/${clientId}/service/${tsl.service.identifier}','2','1','0','',NULL,'',NULL,'设备服务调用'),(9,'2','服务调用','sys/${productKey}/${clientId}/service/${tsl.service.identifier}/reply','1','1','0','',NULL,'',NULL,'设备端响应服务调用');

/*Table structure for table `user_device` */

DROP TABLE IF EXISTS `user_device`;

CREATE TABLE `user_device` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `device_type` char(1) DEFAULT NULL COMMENT '设备类型（1：智能锁）',
  `client_id` varchar(255) DEFAULT NULL COMMENT '设备clientid',
  `icon_url` varchar(200) DEFAULT NULL COMMENT '图标url',
  `name` varchar(17) DEFAULT NULL COMMENT '设备名称',
  `run_status` char(1) DEFAULT NULL COMMENT '运行状态【0：否 1：是】',
  `position` varchar(50) DEFAULT NULL COMMENT '摆放位置',
  `last_connect_time` datetime DEFAULT NULL COMMENT '最后连接时间',
  `status` tinyint DEFAULT NULL COMMENT '状态：1为正常，0为禁止',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员设备表';

/*Data for the table `user_device` */

insert  into `user_device`(`id`,`user_id`,`device_type`,`client_id`,`icon_url`,`name`,`run_status`,`position`,`last_connect_time`,`status`,`create_time`,`create_by`,`update_time`,`update_by`,`del_flag`,`remark`) values (2,1,'1','cm32bh2si0e9zu5','http://39.98.123.211/hws.png','GuThings-Iot','0','客厅',NULL,1,'2024-06-26 11:16:14',NULL,'2024-07-24 11:21:00',NULL,'0',NULL),(3,1,'2','cm32bh2si0e9zu6','http://39.98.123.211/sxt.jpg','小谷AI摄像头云台...','1','客厅',NULL,1,'2024-07-08 09:30:41',NULL,'2024-07-12 10:32:18',NULL,'0',NULL);

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(500) DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(100) DEFAULT NULL COMMENT '昵称',
  `phone` varchar(17) DEFAULT NULL COMMENT '电话号码',
  `avatar` varchar(200) DEFAULT NULL COMMENT '头像',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `memo` varchar(100) DEFAULT NULL COMMENT '备注',
  `open_id` varchar(45) DEFAULT NULL COMMENT '微信open id',
  `union_id` varchar(45) DEFAULT NULL COMMENT '微信开放平台unionID',
  `last_login_ip` varchar(50) DEFAULT NULL COMMENT '最后一次登录ip',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `status` tinyint DEFAULT NULL COMMENT '状态：1为正常，0为禁止',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员表';

/*Data for the table `user_info` */

insert  into `user_info`(`id`,`username`,`password`,`nick_name`,`phone`,`avatar`,`sex`,`memo`,`open_id`,`union_id`,`last_login_ip`,`last_login_time`,`status`,`create_time`,`create_by`,`update_time`,`update_by`,`del_flag`,`remark`) values (1,NULL,NULL,'A',NULL,'https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg',NULL,NULL,'oqod47cM3Q0VK8iO93meK0xei_eg',NULL,'39.98.123.211','2024-07-15 00:00:00',NULL,'2024-07-12 09:46:47',NULL,'2024-07-15 13:44:40',NULL,'0',NULL),(3,NULL,NULL,'1721003480671',NULL,'https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg',NULL,NULL,'oqod47VIl9WpQrIP-_3AgyWO6Mo0',NULL,'39.98.123.211','2024-07-15 00:00:00',NULL,'2024-07-15 08:31:21',NULL,'2024-07-15 17:19:11',NULL,'0',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
