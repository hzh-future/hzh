/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.6.14-log : Database - vip
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vip` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `vip`;

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` char(32) NOT NULL DEFAULT '',
  `account` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `password` char(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */
#密码通过md5加密,password对应的是123
insert  into `sys_user`(`id`,`account`,`name`,`password`) values ('1','0001','管理员','5f329d3ac22671f7b214c461e58c27f3');

/*Table structure for table `vip_consume` */

DROP TABLE IF EXISTS `vip_consume`;

CREATE TABLE `vip_consume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` char(12) NOT NULL,
  `name` varchar(16) DEFAULT NULL,
  `x_date` varchar(24) DEFAULT NULL,
  `x_project` varchar(64) DEFAULT NULL,
  `x_je` int(12) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `demit` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `vip_consume` */


/*Table structure for table `vip_detail` */

DROP TABLE IF EXISTS `vip_detail`;

CREATE TABLE `vip_detail` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `code` char(12) NOT NULL DEFAULT '',
  `name` varchar(32) DEFAULT NULL,
  `money` int(12) DEFAULT NULL,
  `dengji` varchar(32) DEFAULT NULL,
  `xia` int(12) DEFAULT NULL,
  PRIMARY KEY (`id`,`code`),
  KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `vip_detail` */


/*Table structure for table `vip_rank` */

DROP TABLE IF EXISTS `vip_rank`;

CREATE TABLE `vip_rank` (
  `no` tinyint(1) NOT NULL DEFAULT '0',
  `name` varchar(32) DEFAULT NULL,
  `needAmount` int(11) DEFAULT NULL,
  `discount` tinyint(4) DEFAULT NULL,
  `remark` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `vip_rank` */

insert  into `vip_rank`(`no`,`name`,`needAmount`,`discount`,`remark`) values (1,'普通VIP',100,98,'消费满100即可成为普通会员'),(2,'黄金VIP',1000,95,'消费满1000即可成为黄金会员'),(3,'白金VIP',5000,90,'消费满5000即可成为白金会员'),(4,'砖石VIP',10000,88,'消费满10000即可成为砖石会员'),(5,'终身VIP',20000,85,'消费满20000即可成为终身会员');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
