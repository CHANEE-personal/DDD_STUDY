CREATE TABLE `account_image`
(
    `idx`         int(11)      NOT NULL AUTO_INCREMENT,
    `type`        varchar(255) NOT NULL,
    `account_id` int(11)      DEFAULT NULL,
    `image_url`   longtext DEFAULT NULL,
    `visible`     boolean      DEFAULT true,
    `create_time` DATETIME,
    PRIMARY KEY (`idx`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE
    TRIGGER MySQL_Table_OnInsert
    BEFORE INSERT
    ON account_image
    FOR EACH ROW
    SET
        NEW.create_time = NOW()
;
