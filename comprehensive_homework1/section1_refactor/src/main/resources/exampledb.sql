drop table if exists t_user;
drop table if exists t_login_log;


create table user (
   id  integer identity primary key,
   user_name varchar(30),
   password  varchar(32),
   last_visit datetime,
   last_ip  varchar(23)
);


create table loginlog (
   id  integer identity primary key,
   user_id   integer,
   ip  varchar(23),
   login_datetime datetime
);


insert into user (user_name,password) values ('admin','123456');
