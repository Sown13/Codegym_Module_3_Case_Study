drop database case_study_m3;
CREATE DATABASE case_study_m3;
use case_study_m3;

CREATE TABLE users (
u_id int auto_increment primary key,
user_name varchar(50) not null unique,
password varchar(50) not null,
fullname varchar(255),
address varchar(255),
email varchar(255) not null unique
);

Create table songs (
s_id int auto_increment primary key,
song_name varchar(255) not null,
author varchar(255),
upload_date timestamp default current_timestamp,
url text not null,
listening_frequency int,
label varchar(50),
u_id int,
foreign key (u_id) references users(u_id)
);
alter table songs
add column playing boolean default false;

create table playlist (
p_id int auto_increment primary key,
p_name varchar(255) not null,
create_date timestamp default current_timestamp,
u_id int,
foreign key (u_id) references users(u_id)
);

create table likes (
u_id int,
p_id int,
foreign key(u_id) references users(u_id),
foreign key(p_id) references playlist(p_id),
primary key (u_id, p_id)
);

create table comments (
comment_id int auto_increment primary key,
content text,
s_id int,
u_id int,
foreign key (u_id) references users(u_id),
foreign key (s_id) references songs(s_id)
);

create table playlist_detail (
s_id int,
p_id int,
foreign key (s_id) references songs(s_id),
foreign key (p_id) references playlist(p_id),
primary key (s_id,p_id)
);
ALTER  table playlist add label varchar(60);
ALTER table playlist_detail add constraint UNIQUE (s_id,p_id);






