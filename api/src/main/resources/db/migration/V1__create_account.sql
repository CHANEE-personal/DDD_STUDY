CREATE TABLE `accountEntity`
(
    `idx`              int(11)      NOT NULL AUTO_INCREMENT,
    `account_name`     varchar(255) NOT NULL,
    `hash_tag`         varchar(255) DEFAULT NULL,
    `youtube_url`      varchar(255) DEFAULT NULL,
    `post_count`       int(11)      DEFAULT 0,
    `follow_count`     int(11)      DEFAULT 0,
    `follower_count`   int(11)      DEFAULT 0,
    `create_time`      DATETIME,
    PRIMARY KEY (`idx`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
