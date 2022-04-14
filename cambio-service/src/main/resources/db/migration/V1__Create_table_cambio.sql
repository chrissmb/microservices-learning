create table cambio (
    id int auto_increment primary key,
    from_currency char(3) not null,
    to_currency char(3) not null,
    convertion_factor decimal(18,2) not null
);