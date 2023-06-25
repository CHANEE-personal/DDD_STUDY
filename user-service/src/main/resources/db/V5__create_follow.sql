CREATE TABLE `follow`
(
    `idx`           int(11)      NOT NULL AUTO_INCREMENT,
    `follower_name` varchar(100) NOT NULL,
    `follower_idx`  int(11) DEFAULT NULL,
    `account_idx`   int(11)      NOT NULL,
    `allow`         boolean DEFAULT false,
    `create_time`   DATETIME,
    PRIMARY KEY (`idx`),
    FULLTEXT `follow_name` (`follower_name`)

) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE `follower`
(
    `idx`         int(11)      NOT NULL AUTO_INCREMENT,
    `follow_name` varchar(100) NOT NULL,
    `follow_idx`  int(11) DEFAULT NULL,
    `create_time` DATETIME,
    PRIMARY KEY (`idx`),
    FULLTEXT `follower_name` (`follow_name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

INSERT INTO `follow`
VALUES (1, 'ROSE', 10, 1, false, NOW()),
       (2, 'JISU', 11, 1, true, NOW());

INSERT INTO `follower`
VALUES (1, 'ROSE', 20, NOW());
