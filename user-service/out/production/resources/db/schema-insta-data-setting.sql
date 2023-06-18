create table `account`
(
    `idx`            int auto_increment
        primary key,
    `account_name`   varchar(255) not null,
    `hash_tag`       varchar(255) null,
    `youtube_url`    varchar(255) null,
    `post_count`     int default 0 null,
    `follow_count`   int default 0 null,
    `follower_count` int default 0 null,
    `create_time`    datetime null
);

-- auto-generated definition
create table account_image
(
    idx         int auto_increment
        primary key,
    type        varchar(255) not null,
    account_id  int null,
    image_url   longtext null,
    visible     tinyint(1) default 1 null,
    create_time datetime null
);


insert into account (idx, account_name, hash_tag, youtube_url, post_count, follow_count, follower_count, create_time)
values (1, 'jennierubyjane', '@lesyeuxdenini', 'https://youtu.be/JyBd-qPKqpU', 89, 0, 999, '2023-05-07 04:51:47');

insert into account_image (idx, type, account_id, image_url, visible, create_time)
values (1, 'profile', 1,
        'https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-19/71533411_449636125903525_7464596574253875200_n.jpg?stp=dst-jpg_s320x320&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=46Hei6zgefcAX_ZYID0&edm=AOQ1c0wBAAAA&ccb=7-5&oh=00_AfBDTYWtogBWVxTSXTuu1-SZpHe4C9nrPXByBa98E7ljmQ&oe=645B8991&_nc_sid=8fd12b',
        1, '2023-05-07 04:51:47');
