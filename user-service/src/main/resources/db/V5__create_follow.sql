CREATE TABLE `follow`
(
    `idx`         int(11)      NOT NULL AUTO_INCREMENT,
    `follow_name` varchar(100) NOT NULL,
    `account_idx` int(11)      NOT NULL,
    `allow`       boolean DEFAULT false,
    `create_time` DATETIME,
    PRIMARY KEY (`idx`),
    FULLTEXT `follow_name` (`follow_name`)

) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE `follower`
(
    `idx`           int(11)      NOT NULL AUTO_INCREMENT,
    `follower_name` varchar(100) NOT NULL,
    `account_id`    int(11) DEFAULT NULL,
    `create_time`   DATETIME,
    PRIMARY KEY (`idx`),
    FULLTEXT `follower_name` (`follower_name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

INSERT INTO `follow`
VALUES (2, 'ROSE', 3, false, NOW()),
       (1, 'JISU', 2, true, NOW());

INSERT INTO `follower`
VALUES (1, 'ROSE', 3, NOW());
