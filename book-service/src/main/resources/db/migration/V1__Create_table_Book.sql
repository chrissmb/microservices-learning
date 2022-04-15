create table book (
    id bigint auto_increment primary key,
    title varchar(100) not null,
    author varchar(100) not null,
    launch_date datetime not null,
    price decimal(18,2) not null
);