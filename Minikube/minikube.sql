CREATE SCHEMA `pizza`;
CREATE TABLE `pizza`.`user` (
  `id_user` bigint NOT NULL AUTO_INCREMENT,
  `user_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `login` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` char(13) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_number_UNIQUE` (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

CREATE SCHEMA `service-pizza`;
CREATE TABLE `service-pizza`.`pizza` (
  `id_pizza` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `size_cm` int unsigned NOT NULL,
  `price` decimal(5,2) unsigned NOT NULL,
  `description` varchar(400) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `time_for_cook_minutes` int unsigned NOT NULL,
  `number_of_bonus` decimal(5,2) unsigned NOT NULL,
  `discounts` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id_pizza`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

CREATE SCHEMA `service-order`;
CREATE TABLE `service-order`.`order` (
  `id_order` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `pizza_id` bigint NOT NULL,
  `amount_pizza` int NOT NULL,
  `order_date` datetime NOT NULL,
  `delivery_date` datetime NOT NULL,
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `street` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `street_number` int unsigned NOT NULL,
  `entrance_street` int unsigned DEFAULT NULL,
  `comment` varchar(400) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_order`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;