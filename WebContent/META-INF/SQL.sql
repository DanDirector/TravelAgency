CREATE TABLE ta.`hotels` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '0',
  `rate` varchar(5) NOT NULL,
  `nutrition_type` enum('AL','BB','HB','FB','UALL') NOT NULL DEFAULT 'BB',
  `country` varchar(45) NOT NULL DEFAULT '0',
  `city` varchar(45) NOT NULL DEFAULT '0',
  `description` text NOT NULL,
  `photos_path` varchar(45) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
CREATE TABLE ta.`orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tour_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `status` enum('registered','payed','canceled') NOT NULL,
  `discount_step` double NOT NULL DEFAULT '0',
  `max_discount` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_idx` (`user_id`),
  KEY `tour_idx` (`tour_id`),
  CONSTRAINT `tour` FOREIGN KEY (`tour_id`) REFERENCES `tours` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
CREATE TABLE `tours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image_path` varchar(45) NOT NULL DEFAULT '0',
  `type` enum('sum_relax','win_relax','exc','shop') NOT NULL DEFAULT 'sum_relax',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `person_count` int(4) NOT NULL DEFAULT '2',
  `hotel_id` int(11) NOT NULL DEFAULT '1',
  `is_hot` tinyint(4) NOT NULL DEFAULT '1',
  `departure_date` date NOT NULL DEFAULT '0000-00-00',
  `nights` int(3) NOT NULL DEFAULT '0',
  `departure_city` varchar(45) NOT NULL DEFAULT 'Kyiv',
  PRIMARY KEY (`id`),
  KEY `hotel_idx` (`hotel_id`),
  CONSTRAINT `hotel` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` enum('client','manager','admin','blocked') NOT NULL DEFAULT 'client',
  `name` varchar(45) NOT NULL,
  `second_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

CREATE TABLE `ta`.`subscribers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `ta`.`users`
(
`role`,
`name`,
`second_name`,
`email`,
`login`,
`password`)
VALUES
(
'admin',
'Admin',
'Admin',
'admin@mail.ru',
'admin',
'admin');





