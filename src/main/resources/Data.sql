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
  `bib_user_id` int unsigned DEFAULT NULL,
  `bib_amount` int unsigned DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `user_id` (`user_id`),
  KEY `bib_user_id` (`bib_user_id`),
  CONSTRAINT `Items_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `Users` (`user_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `Items_ibfk_2` FOREIGN KEY (`bib_user_id`) REFERENCES `Users` (`user_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;