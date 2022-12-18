-- Auction.Users definition

CREATE TABLE `Users` (
  `user_id` int unsigned NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `social_type` smallint DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `Users_UN` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Auction.Items definition

CREATE TABLE `Items` (
  `item_id` int unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `user_id` int unsigned DEFAULT NULL,
  `bid_user_id` int unsigned DEFAULT NULL,
  `bid_price` int unsigned DEFAULT NULL,
  `start_price` int unsigned NOT NULL DEFAULT '0',
  `sell_price` int unsigned DEFAULT NULL,
  `status` tinyint unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`item_id`),
  KEY `user_id` (`user_id`),
  KEY `bib_user_id` (`bid_user_id`),
  CONSTRAINT `Items_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `Users` (`user_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `Items_ibfk_2` FOREIGN KEY (`bid_user_id`) REFERENCES `Users` (`user_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Auction.Auction_History definition

CREATE TABLE `Auction_History` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `item_id` int unsigned NOT NULL,
  `bid_user_id` int unsigned DEFAULT NULL,
  `bid_price` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Auction_History_UN` (`id`,`item_id`),
  KEY `Auction_History_FK` (`item_id`),
  KEY `Auction_History_FK_1` (`bid_user_id`),
  CONSTRAINT `Auction_History_FK` FOREIGN KEY (`item_id`) REFERENCES `Items` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Auction_History_FK_1` FOREIGN KEY (`bid_user_id`) REFERENCES `Users` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Auction.Auction_History definition

CREATE TABLE `Auction_History` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `item_id` int unsigned NOT NULL,
  `bid_user_id` int unsigned DEFAULT NULL,
  `bid_price` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Auction_History_UN` (`id`,`item_id`),
  KEY `Auction_History_FK` (`item_id`),
  KEY `Auction_History_FK_1` (`bid_user_id`),
  CONSTRAINT `Auction_History_FK` FOREIGN KEY (`item_id`) REFERENCES `Items` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Auction_History_FK_1` FOREIGN KEY (`bid_user_id`) REFERENCES `Users` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Auction.Item_Info definition

CREATE TABLE `Item_Info` (
  `item_info_id` int unsigned NOT NULL AUTO_INCREMENT,
  `item_id` int unsigned NOT NULL,
  `category_name` varchar(100) NOT NULL,
  PRIMARY KEY (`item_info_id`),
  UNIQUE KEY `Item_info_UN` (`item_info_id`,`item_id`),
  KEY `Item_info_FK` (`item_id`),
  KEY `Item_info_FK_2` (`category_name`),
  CONSTRAINT `Item_info_FK` FOREIGN KEY (`item_id`) REFERENCES `Items` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Item_info_FK_2` FOREIGN KEY (`category_name`) REFERENCES `Categories` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Auction.Categories definition

CREATE TABLE `Categories` (
  `category_id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `Categories_UN` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;