create schema if not exists postgres;

create table if not exists postgres.currencies
(
    id      serial primary key,
    code    varchar(255) not null,
    name    varchar(255) not null,
    sign    varchar(255)
);

insert into postgres.currencies (code, name, sign) values ('USD', 'US Dollar', '$');
insert into postgres.currencies (code, name, sign) values ('EUR', 'Euro', '€');
insert into postgres.currencies (code, name, sign) values ('RUB', 'Russian Ruble', '₽');
insert into postgres.currencies (code, name, sign) values ('UAH', 'Hryvnia', '₴');
insert into postgres.currencies (code, name, sign) values ('KZT', 'Tenge', '₸');
insert into postgres.currencies (code, name, sign) values ('GBP', 'Pound Sterling', '£');