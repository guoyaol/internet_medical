drop database if exists internetmedical;
drop user if exists 'internetmedical'@'%';
-- 支持emoji：需要mysql数据库参数： character_set_server=utf8mb4
create database internetmedical default character set utf8mb4 collate utf8mb4_unicode_ci;
use internetmedical;
create user 'internetmedical'@'%' identified by 'internetmedical123456';
grant all privileges on internetmedical.* to 'internetmedical'@'%';
flush privileges;