CREATE TABLE `post`
(
    `idx`            int(11)  NOT NULL AUTO_INCREMENT,
    `title`          longtext NOT NULL,
    `description`    longtext NOT NULL,
    `view_count`     int(11) DEFAULT 0,
    `favorite_count` int(11) DEFAULT 0,
    `reply_count`    int(11) DEFAULT 0,
    `parent_idx`     int(11) DEFAULT NULL,
    `visible`        boolean DEFAULT true,
    `create_time`    DATETIME,
    PRIMARY KEY (`idx`),
    FULLTEXT `post_title` (`title`),
    FULLTEXT `post_description` (`description`)

) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE `post_image`
(
    `idx`         int(11)      NOT NULL AUTO_INCREMENT,
    `name`        varchar(255) NOT NULL,
    `url`         longtext     NOT NULL,
    `sort_no`     int(11)      NOT NULL,
    `post_idx`    int(11) DEFAULT NULL,
    `visible`     boolean DEFAULT true,
    `create_time` DATETIME,
    PRIMARY KEY (`idx`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE
    TRIGGER MySQL_Table_OnInsert
    BEFORE INSERT
    ON post_image
    FOR EACH ROW
    SET
        NEW.create_time = NOW();

INSERT INTO `post`
VALUES (1,
        'My first ever Met honoring Karl Lagerfeld with @chanelofficial. Merci mon chanel family for this dream look',
        'My first ever Met honoring Karl Lagerfeld with @chanelofficial. Merci mon chanel family for this dream look',
        989000, 989000, 10000, NULL, true, NOW());

INSERT INTO `post`
VALUES (2,
        'My first ever Met honoring Karl Lagerfeld with @chanelofficial. Merci mon chanel family for this dream look',
        'My first ever Met honoring Karl Lagerfeld with @chanelofficial. Merci mon chanel family for this dream look',
        989000, 989000, 10000, 1, true, NOW());

INSERT INTO `post_image`
VALUES (1, 'image',
        'https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-15/344281307_592826875941624_3520706586042566367_n.jpg?stp=dst-jpg_e35&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=F8TuCnTHqwwAX-C-iUm&edm=ACWDqb8BAAAA&ccb=7-5&ig_cache_key=MzA5MzcwNzg0MzY4NTYxMzM1OQ%3D%3D.2-ccb7-5&oh=00_AfCrgnsqJa3AdIUjCCYrpU20610UTtUAjSD6uoxF96gWqQ&oe=645A05CA&_nc_sid=1527a3',
        1, 1, true, NOW());

INSERT INTO `post_image`
VALUES (2, 'image',
        'https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-15/344281307_592826875941624_3520706586042566367_n.jpg?stp=dst-jpg_e35&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=F8TuCnTHqwwAX-C-iUm&edm=ACWDqb8BAAAA&ccb=7-5&ig_cache_key=MzA5MzcwNzg0MzY4NTYxMzM1OQ%3D%3D.2-ccb7-5&oh=00_AfCrgnsqJa3AdIUjCCYrpU20610UTtUAjSD6uoxF96gWqQ&oe=645A05CA&_nc_sid=1527a3',
        2, 1, true, NOW());
