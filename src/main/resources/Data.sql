
CREATE TABLE Users(
  user_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  nick_name VARCHAR(20),
  email VARCHAR(50),
  social_type SMALLINT,
  PRIMARY KEY (user_id)
);

CREATE TABLE Items(
  item_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL,
  description TEXT NOT NULL,
  start_time DATE,
  end_time DATE,
  user_id INT,
  bib_user_id INT,
  bib_amount INT UNSIGNED,
  PRIMARY KEY item_id,
  FOREIGN KEY (bib_user_id) REFERENCES Users(user_id) ON UPDATE CASCADE ON DELETE RESTRICT
);