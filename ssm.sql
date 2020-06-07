# Host: 127.0.0.1  (Version: 5.5.15)
# Date: 2020-06-02 12:22:20
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'测试1',NULL,'2',NULL),(10,'张三','2014-07-10','1','北京市'),(11,'李四',NULL,'1',NULL),(16,'张小明',NULL,'1','河南郑州'),(22,'陈小明',NULL,'1','河南郑州'),(24,'张三丰',NULL,'1','河南郑州'),(25,'陈小明',NULL,'1','河南郑州'),(26,'王五',NULL,NULL,NULL),(27,'李四2','2017-08-21','1','宏福苑'),(28,'李四2','2017-08-21','1','宏福苑'),(29,'李四2','2017-08-21','1','宏福苑'),(30,'dubbox',NULL,'2',NULL),(31,'dubbox2',NULL,'2',NULL),(32,'dubbox2',NULL,'2',NULL),(34,'陈阳','2018-04-18','3','动漫园'),(35,'陈阳','2018-04-18','3','动漫园'),(36,'陈阳','2018-04-18','3','动漫园');
