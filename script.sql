create table if not exists todos
(
    id          bigint auto_increment
        primary key,
    description varchar(255) null,
    is_done     bit          not null,
    target_date datetime(6)  null,
    username    varchar(255) null,
    title       varchar(255) null
);

create table if not exists users
(
    id         int auto_increment
        primary key,
    first_name varchar(20)  null,
    last_name  varchar(20)  null,
    username   varchar(250) null,
    password   varchar(20)  null
);


