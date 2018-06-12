--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3;

--
-- Dumping data for table `todo_item`
--

LOCK TABLES `user` WRITE;

INSERT INTO `user` VALUES (1,'admin', 'admin');

UNLOCK TABLES;


